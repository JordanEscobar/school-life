package com.schoollife.web.Controller;

import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.schoollife.web.Entities.Apoderado;
import com.schoollife.web.Entities.Estudiante;
import com.schoollife.web.Entities.Programa_Integracion;
import com.schoollife.web.Entities.Usuario;
import com.schoollife.web.Service.ApoderadoService;
import com.schoollife.web.Service.EstablecimientoService;
import com.schoollife.web.Service.EstudianteService;
import com.schoollife.web.Service.Programa_IntegracionService;

import jakarta.servlet.http.HttpSession;


@Controller
public class ExcelUploadController {
	
	@Autowired
	private final EstudianteService estudianteS;
	@Autowired
	private final ApoderadoService apoderadoS;
	@Autowired
	private final Programa_IntegracionService programaS;
	@Autowired
	private final EstablecimientoService establecimientoS;
		
    public ExcelUploadController(EstudianteService estudianteS, EstablecimientoService establecimientoS,
    		ApoderadoService apoderadoS, Programa_IntegracionService programaS) {
		super();
		this.estudianteS = estudianteS;
		this.establecimientoS = establecimientoS;
		this.apoderadoS = apoderadoS;
		this.programaS =programaS;
	}

    @GetMapping("/upload")
    public String uploadForm(Model model, HttpSession sesion) {
        if (sesion.getAttribute("user") != null) {
            List<Usuario> uSesion = (List<Usuario>) sesion.getAttribute("user");
            model.addAttribute("uSesion", uSesion.get(0));
            model.addAttribute("establecimientoSesion", establecimientoS.findById(uSesion.get(0).getEstablecimientoId()));    
            model.addAttribute("excelData", new ArrayList<List<String>>());
            return "Import";
        }
        return "Login";
    }
	
    @PostMapping("/preview")
    public String previewFile(@RequestParam("file") MultipartFile file, Model model, HttpSession sesion) {
        if (sesion.getAttribute("user") != null) {
            List<Usuario> uSesion = (List<Usuario>) sesion.getAttribute("user");
            model.addAttribute("uSesion", uSesion.get(0));
            model.addAttribute("establecimientoSesion", establecimientoS.findById(uSesion.get(0).getEstablecimientoId()));

            if (file.isEmpty()) {
                model.addAttribute("message", "Por favor selecciona un archivo para subir.");
                model.addAttribute("excelData", new HashMap<String, List<List<String>>>());
                return "Import";
            }
            try {
                Map<String, List<List<String>>> excelDataMap = processExcelFile(file.getInputStream());
                model.addAttribute("excelData", excelDataMap);

                List<List<String>> estudiantesData = excelDataMap.get("Estudiantes");
                model.addAttribute("estudiantes", estudiantesData);  
                List<List<String>> apoderadosData = excelDataMap.get("Apoderados");
                model.addAttribute("apoderados", apoderadosData); 
                List<List<String>> programaData = excelDataMap.get("Programa_Integracion");
                model.addAttribute("programa", programaData); 

                sesion.setAttribute("excelData", excelDataMap);
                model.addAttribute("message", "Vista previa del archivo: " + file.getOriginalFilename());
            } catch (IOException e) {
                e.printStackTrace();
                model.addAttribute("message", "Error al procesar el archivo.");
            }

            return "Import";
        }
        return "Login";
    }

	
    @PostMapping("/upload")
    public String uploadFile(HttpSession sesion, Model model) {
        if (sesion.getAttribute("user") != null) {
            List<Usuario> uSesion = (List<Usuario>) sesion.getAttribute("user");
            model.addAttribute("uSesion", uSesion.get(0));
            model.addAttribute("establecimientoSesion", establecimientoS.findById(uSesion.get(0).getEstablecimientoId()));

            Map<String, List<List<String>>> excelDataMap = (Map<String, List<List<String>>>) sesion.getAttribute("excelData");
            if (excelDataMap == null) {
                model.addAttribute("message", "No hay datos para subir.");
                return "Import";
            }

            try {
                // Guarda los datos en la base de datos - LE AÑADIMOS LA SESION PARA SACAR EL ID DEL ESTABLECIMIENTO
                saveExcelDataToDatabase(excelDataMap, sesion);
                model.addAttribute("message", "Datos subidos correctamente.");
                sesion.removeAttribute("excelData");
            } catch (Exception e) {
                e.printStackTrace();
                model.addAttribute("message", "Error al subir los datos.");
            }

            return "Import";
        }
        return "Login";
    }
    
    public Map<String, List<List<String>>> processExcelFile(InputStream inputStream) throws IOException {
        Map<String, List<List<String>>> excelDataMap = new HashMap<>();
        Workbook workbook = WorkbookFactory.create(inputStream);

        for (int i = 0; i < workbook.getNumberOfSheets(); i++) {
            Sheet sheet = workbook.getSheetAt(i);
            Iterator<Row> rowIterator = sheet.iterator();

            if (rowIterator.hasNext()) {
                rowIterator.next(); // Saltar la primera fila (encabezados)
            }

            List<List<String>> sheetData = new ArrayList<>();

            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                Iterator<Cell> cellIterator = row.cellIterator();
                List<String> rowData = new ArrayList<>();

                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();
                    switch (cell.getCellType()) {
                        case STRING:
                            rowData.add(cell.getStringCellValue());
                            break;
                        case NUMERIC:
                        	if (DateUtil.isCellDateFormatted(cell)) {
                                Date date = cell.getDateCellValue();
                                rowData.add(date.toString()); // Aquí puedes ajustar cómo se almacena la fecha
                            } else {
                                // Convertir el valor numérico a String y eliminar .0 si está presente
                                String numericValue = getNumericCellValueAsString(cell);
                                rowData.add(numericValue);
                            }
                            break;
                        case BOOLEAN:
                            rowData.add(String.valueOf(cell.getBooleanCellValue()));
                            break;
                        default:
                            rowData.add("");
                    }
                }
                sheetData.add(rowData);
            }
            excelDataMap.put(sheet.getSheetName(), sheetData);
        }
        workbook.close();
        return excelDataMap;
    }


    private String getNumericCellValueAsString(Cell cell) {
        if (cell.getCellType() == CellType.NUMERIC) {
            if (DateUtil.isCellDateFormatted(cell)) {
                Date date = cell.getDateCellValue();
                return date.toString(); // Aquí puedes ajustar cómo se almacena la fecha
            } else {
                double numericValue = cell.getNumericCellValue();
                if (numericValue == (long) numericValue) {
                    return String.valueOf((long) numericValue); // Elimina .0 de los enteros
                } else {
                    return String.valueOf(numericValue); // Elimina .0 de los decimales
                }
            }
        } else {
            return ""; // Manejar otros tipos de celdas si es necesario
        }
    }
    
    private void saveExcelDataToDatabase(Map<String, List<List<String>>> excelDataMap, HttpSession sesion) {
    	List<Usuario> uSesion = (List<Usuario>) sesion.getAttribute("user");

    	
    	SimpleDateFormat dateFormat = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", Locale.ENGLISH);

        // Procesar datos de la hoja de Estudiantes
        if (excelDataMap.containsKey("Estudiantes")) {
            List<List<String>> estudianteData = excelDataMap.get("Estudiantes");
            for (List<String> rowData : estudianteData) {
                Estudiante e = new Estudiante();
                // Imprimir fila para depuración
                System.out.println("Procesando fila de estudiante: " + rowData);

                // Asignar datos a la entidad Estudiante según tu estructura
                e.setRunEstudiante(rowData.get(0));
                e.setNombre(rowData.get(1));
                e.setApaterno(rowData.get(2));
                e.setAmaterno(rowData.get(3));

                // Cantidad de computadores
                String cantidadComputadoresStr = rowData.get(17);
                if (StringUtils.isNumeric(cantidadComputadoresStr)) {
                    try {
                        e.setCantidad_computadores_casa(Integer.parseInt(cantidadComputadoresStr));
                    } catch (NumberFormatException nfe) {
                        System.err.println("Error al convertir cantidad de computadores: " + cantidadComputadoresStr);
                        nfe.printStackTrace();
                    }
                } else {
                    System.err.println("Valor no numérico encontrado para cantidad de computadores: " + cantidadComputadoresStr);
                }

                // Fechas
                try {
                    Date fechaMatricula = dateFormat.parse(rowData.get(4));
                    Date fechaNacimiento = dateFormat.parse(rowData.get(5));
                    Date fechaUltimaVacuna = dateFormat.parse(rowData.get(31));
                    e.setFecha_matricula(fechaMatricula);
                    e.setFecha_nacimiento(fechaNacimiento);
                    e.setFecha_ultima_vacuna_COVID(fechaUltimaVacuna);
                } catch (Exception ex) {
                    System.err.println("Error al parsear fecha: " + ex.getMessage());
                    ex.printStackTrace();
                }

                // Asignar el resto de los datos
                e.setPais_nacimiento(rowData.get(6));
                e.setGenero(rowData.get(7));
                e.setDireccion(rowData.get(8));
                e.setComuna(rowData.get(9));
                e.setCorreo_electronico(rowData.get(10));
                e.setTelefono(rowData.get(11));
                e.setCelular(rowData.get(12));
                e.setColegio_procedencia(rowData.get(13));
                e.setNombre_contacto_emergencia(rowData.get(14));
                e.setTelefono_emergencia(rowData.get(15));
                e.setVive_con(rowData.get(16));
                e.setReligion(rowData.get(18));
                e.setAcepta_clases_religion("si".equalsIgnoreCase(rowData.get(19)));
                e.setBeca(rowData.get(20));

                // Estatura
                String estaturaStr = rowData.get(21);
                if (StringUtils.isNumeric(estaturaStr)) {
                    try {
                        e.setEstatura(Integer.parseInt(estaturaStr));
                    } catch (NumberFormatException nfe) {
                        System.err.println("Error al convertir estatura: " + estaturaStr);
                        nfe.printStackTrace();
                    }
                } else {
                    System.err.println("Valor no numérico encontrado para estatura: " + estaturaStr);
                }

                // Peso
                String pesoStr = rowData.get(22);
                if (StringUtils.isNumeric(pesoStr)) {
                    try {
                        e.setPeso(Double.parseDouble(pesoStr));
                    } catch (NumberFormatException nfe) {
                        System.err.println("Error al convertir peso: " + pesoStr);
                        nfe.printStackTrace();
                    }
                } else {
                    System.err.println("Valor no numérico encontrado para peso: " + pesoStr);
                }

                e.setGrupo_sanguineo(rowData.get(23));
                e.setAlergias_alimentos(rowData.get(24));
                e.setAlergias_medicamentos(rowData.get(25));
                e.setMedicamentos_contraindicados(rowData.get(26));
                e.setEnfermedades_cronicas(rowData.get(27));
                e.setVacuna_covid("si".equalsIgnoreCase(rowData.get(28)));

                // Cantidad de vacunas COVID
                String cantidadVacunasCovidStr = rowData.get(29);
                if (StringUtils.isNumeric(cantidadVacunasCovidStr)) {
                    try {
                        e.setCantidad_vacunas_covid(Integer.parseInt(cantidadVacunasCovidStr));
                    } catch (NumberFormatException nfe) {
                        System.err.println("Error al convertir cantidad de vacunas COVID: " + cantidadVacunasCovidStr);
                        nfe.printStackTrace();
                    }
                } else {
                    System.err.println("Valor no numérico encontrado para cantidad de vacunas COVID: " + cantidadVacunasCovidStr);
                }

                e.setEsquema_completo_vacunacion_covid("si".equalsIgnoreCase(rowData.get(30)));
                e.setApto_educacion_fisica("si".equalsIgnoreCase(rowData.get(32)));
                e.setSeguro_escolar_privado("si".equalsIgnoreCase(rowData.get(34)));
                e.setSistema_prevision(rowData.get(33));
                e.setNacionalidad(rowData.get(35));
                e.setEtnia(rowData.get(36));
                e.setConsultorio_clinica(rowData.get(37));
                e.setObservaciones(rowData.get(38));
                //ingresan en estado matriculado
                e.setEstado(true);

                //tomamos el id del establecimiento de la sesion iniciada
                e.setEstablecimientoId(uSesion.get(0).getEstablecimientoId());
                
                // Curso ID se debe modificar al nombre de curso y validar.
                /*String cursoIdStr = rowData.get(39);
                if (StringUtils.isNumeric(cursoIdStr)) {
                    try {
                    	if(cursoIdStr.equalsIgnoreCase("PRIMERO A"))
                    	{
                    		e.setCurso_id(1);
                    	}
                    	if(cursoIdStr.equalsIgnoreCase("PRIMERO B"))
                    	{
                    		e.setCurso_id(2);
                    	} 
                        
                      //número de matrícula  
                        Integer numeroEstudiantesCurso = estudianteS.findEstudiantePorCurso(Integer.parseInt(cursoIdStr)).size();
                        Integer numeroEstudiantesEstablecimiento = estudianteS.getAll(uSesion.get(0).getEstablecimientoId()).size();
                        if(numeroEstudiantesCurso < 45) {
                        	e.setNumero_matricula(numeroEstudiantesEstablecimiento + 1);
                        	System.out.println("se a agregado la matricula n°: " + numeroEstudiantesEstablecimiento + 1);                 	
                        }else {
                        	System.out.println("se a llegado al limite de estudiantes del curso");
                        }
                        
                    } catch (NumberFormatException nfe) {
                        System.err.println("Error al convertir curso ID: " + cursoIdStr);
                        nfe.printStackTrace();
                    }
                } else {
                    System.err.println("Valor no numérico encontrado para curso ID: " + cursoIdStr);
                }    */   
        
     // Mapa de nombres de curso a IDs
        Map<String, Integer> cursoMap = new HashMap<>();
        cursoMap.put("PRIMERO A", 1);
        cursoMap.put("PRIMERO B", 2);
        cursoMap.put("SEGUNDO A", 3);
        cursoMap.put("SEGUNDO B", 4);
        cursoMap.put("TERCERO A", 5);
        cursoMap.put("TERCERO B", 6);
        cursoMap.put("CUARTO A", 7);
        cursoMap.put("CUARTO B", 8);
        // Agrega aquí otros cursos según sea necesario

        // Obteniendo el nombre del curso
        String cursoNombre = rowData.get(39);

        // Verifica si el nombre del curso está en el mapa
        if (cursoMap.containsKey(cursoNombre)) {
            try {
                int cursoId = cursoMap.get(cursoNombre);
                e.setCurso_id(cursoId);

                // Número de matrícula
                Integer numeroEstudiantesCurso = estudianteS.findEstudiantePorCurso(cursoId).size();
                Integer numeroEstudiantesEstablecimiento = estudianteS.getAll(uSesion.get(0).getEstablecimientoId()).size();
                if (numeroEstudiantesCurso < 45) {
                    e.setNumero_matricula(numeroEstudiantesEstablecimiento + 1);
                    System.out.println("Se ha agregado la matrícula n°: " + (numeroEstudiantesEstablecimiento + 1));
                } else {
                    System.out.println("Se ha llegado al límite de estudiantes del curso");
                }
            } catch (Exception ex) {
                System.err.println("Error al procesar el curso: " + cursoNombre);
                ex.printStackTrace();
            }
        } else {
            System.err.println("Nombre del curso no encontrado: " + cursoNombre);
        }


                e.setEs_pie("si".equalsIgnoreCase(rowData.get(40)));

                // Guardar en la base de datos
                estudianteS.createEstudiante(e);
            }
        }

        // Procesar datos de la hoja de Apoderados
        if (excelDataMap.containsKey("Apoderados")) {
            List<List<String>> apoderadoData = excelDataMap.get("Apoderados");
            for (List<String> rowData : apoderadoData) {
                Apoderado a = new Apoderado();
                // Imprimir fila para depuración
                System.out.println("Procesando fila de apoderado: " + rowData);

                // Asignar datos a la entidad Apoderado según tu estructura
                a.setRun_apoderado(rowData.get(0));
                a.setEstudiante_id(rowData.get(1));

                // Número de documento
                String numerodocumentoStr = rowData.get(2);
                if (StringUtils.isNumeric(numerodocumentoStr)) {
                    try {
                        a.setNumero_documento(Integer.parseInt(numerodocumentoStr));
                    } catch (NumberFormatException nfe) {
                        System.err.println("Error al convertir número de documento: " + numerodocumentoStr);
                        nfe.printStackTrace();
                    }
                } else {
                    System.err.println("Valor no numérico encontrado para número de documento: " + numerodocumentoStr);
                }

                a.setNombres(rowData.get(3));
                a.setApaterno_apoderado(rowData.get(4));
                a.setAmaterno_apoderado(rowData.get(5));
                a.setPasaporte(rowData.get(6));
                a.setParentesco(rowData.get(7));
                a.setTipo_apoderado(rowData.get(8));

                // Fecha de nacimiento
                try {
                    Date fechanacimientoApoderado = dateFormat.parse(rowData.get(9));
                    a.setFecha_nacimiento_apoderado(fechanacimientoApoderado);
                } catch (Exception ex) {
                    System.err.println("Error al parsear fecha de nacimiento: " + ex.getMessage());
                    ex.printStackTrace();
                }

                a.setDomicilio_apoderado(rowData.get(10));
                a.setComuna_apoderado(rowData.get(11));
                a.setNivel_educacion(rowData.get(12));
                a.setOcupacion(rowData.get(13));
                a.setTelefono_apoderado(rowData.get(14));
                a.setCelular_apoderado(rowData.get(15));
                a.setCorreo_electronico_apoderado(rowData.get(16));
                a.setEs_tutor("SI".equalsIgnoreCase(rowData.get(17)));
                a.setAcepta_manual_convivencia_escolar("SI".equalsIgnoreCase(rowData.get(18)));
                a.setAutorizacion_fotografia_grabacion("SI".equalsIgnoreCase(rowData.get(19)));
                a.setAutorizado_retirar_establecimiento("SI".equalsIgnoreCase(rowData.get(20)));
                a.setEstado_civil(rowData.get(21));

                // Guardar en la base de datos
                apoderadoS.createApoderado(a);
            }
        }

        // Procesar datos de la hoja de Programa_Integracion
        if (excelDataMap.containsKey("Programa_Integracion")) {
            List<List<String>> programaData = excelDataMap.get("Programa_Integracion");
            for (List<String> rowData : programaData) {
                Programa_Integracion p = new Programa_Integracion();
                // Imprimir fila para depuración
                System.out.println("Procesando fila de programa de integración: " + rowData);

                // Asignar datos a la entidad Programa_Integracion según tu estructura
                String idProgramaStr = rowData.get(0);
                if (StringUtils.isNumeric(idProgramaStr)) {
                    try {
                        p.setId_Programa(Integer.parseInt(idProgramaStr));
                    } catch (NumberFormatException nfe) {
                        System.err.println("Error al convertir id programa: " + idProgramaStr);
                        nfe.printStackTrace();
                    }
                } else {
                    System.err.println("Valor no numérico encontrado para id programa: " + idProgramaStr);
                }

                p.setEstudiante_id(rowData.get(1));
                p.setPermanencia_pie("PERMANENTE".equalsIgnoreCase(rowData.get(2)));
                p.setTipo_permanencia(rowData.get(3));
                p.setIndicaciones_generales(rowData.get(4));

                // Guardar en la base de datos
                programaS.CreatePrograma(p);
            }
        }
    }
}
    
