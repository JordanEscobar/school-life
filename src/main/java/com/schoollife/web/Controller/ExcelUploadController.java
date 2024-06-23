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
                // Guarda los datos en la base de datos
                saveExcelDataToDatabase(excelDataMap);
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
    
    private void saveExcelDataToDatabase(Map<String, List<List<String>>> excelDataMap) {
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
                
                // Número de matrícula
                String numeroMatriculaStr = rowData.get(4);
                if (StringUtils.isNumeric(numeroMatriculaStr)) {
                    try {
                        e.setNumero_matricula(Integer.parseInt(numeroMatriculaStr));
                    } catch (NumberFormatException nfe) {
                        System.err.println("Error al convertir número de matrícula: " + numeroMatriculaStr);
                        nfe.printStackTrace();
                    }
                } else {
                    System.err.println("Valor no numérico encontrado para número de matrícula: " + numeroMatriculaStr);
                }

                // Cantidad de computadores
                String cantidadComputadoresStr = rowData.get(18);
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
                    Date fechaMatricula = dateFormat.parse(rowData.get(5));
                    Date fechaNacimiento = dateFormat.parse(rowData.get(6));
                    Date fechaUltimaVacuna = dateFormat.parse(rowData.get(32));
                    e.setFecha_matricula(fechaMatricula);
                    e.setFecha_nacimiento(fechaNacimiento);
                    e.setFecha_ultima_vacuna_COVID(fechaUltimaVacuna);
                } catch (Exception ex) {
                    System.err.println("Error al parsear fecha: " + ex.getMessage());
                    ex.printStackTrace();
                }

                // Asignar el resto de los datos
                e.setPais_nacimiento(rowData.get(7));
                e.setGenero(rowData.get(8));
                e.setDireccion(rowData.get(9));
                e.setComuna(rowData.get(10));
                e.setCorreo_electronico(rowData.get(11));
                e.setTelefono(rowData.get(12));
                e.setCelular(rowData.get(13));
                e.setColegio_procedencia(rowData.get(14));
                e.setNombre_contacto_emergencia(rowData.get(15));
                e.setTelefono_emergencia(rowData.get(16));
                e.setVive_con(rowData.get(17));
                e.setReligion(rowData.get(19));
                e.setAcepta_clases_religion("si".equalsIgnoreCase(rowData.get(20)));
                e.setBeca(rowData.get(21));

                // Estatura
                String estaturaStr = rowData.get(22);
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
                String pesoStr = rowData.get(23);
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

                e.setGrupo_sanguineo(rowData.get(24));
                e.setAlergias_alimentos(rowData.get(25));
                e.setAlergias_medicamentos(rowData.get(26));
                e.setMedicamentos_contraindicados(rowData.get(27));
                e.setEnfermedades_cronicas(rowData.get(28));
                e.setVacuna_covid("si".equalsIgnoreCase(rowData.get(29)));

                // Cantidad de vacunas COVID
                String cantidadVacunasCovidStr = rowData.get(30);
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

                e.setEsquema_completo_vacunacion_covid("si".equalsIgnoreCase(rowData.get(31)));
                e.setApto_educacion_fisica("si".equalsIgnoreCase(rowData.get(33)));
                e.setSeguro_escolar_privado("si".equalsIgnoreCase(rowData.get(35)));
                e.setSistema_prevision(rowData.get(34));
                e.setNacionalidad(rowData.get(36));
                e.setEtnia(rowData.get(37));
                e.setConsultorio_clinica(rowData.get(38));
                e.setObservaciones(rowData.get(39));
                e.setEstado("MATRICULADO".equalsIgnoreCase(rowData.get(40)));

                // Establecimiento ID
                String establecimientoIdStr = rowData.get(41);
                if (StringUtils.isNumeric(establecimientoIdStr)) {
                    try {
                        e.setEstablecimientoId(Integer.parseInt(establecimientoIdStr));
                    } catch (NumberFormatException nfe) {
                        System.err.println("Error al convertir establecimiento ID: " + establecimientoIdStr);
                        nfe.printStackTrace();
                    }
                } else {
                    System.err.println("Valor no numérico encontrado para establecimiento ID: " + establecimientoIdStr);
                }

                // Curso ID
                String cursoIdStr = rowData.get(42);
                if (StringUtils.isNumeric(cursoIdStr)) {
                    try {
                        e.setCurso_id(Integer.parseInt(cursoIdStr));
                    } catch (NumberFormatException nfe) {
                        System.err.println("Error al convertir curso ID: " + cursoIdStr);
                        nfe.printStackTrace();
                    }
                } else {
                    System.err.println("Valor no numérico encontrado para curso ID: " + cursoIdStr);
                }

                e.setEs_pie("si".equalsIgnoreCase(rowData.get(43)));

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
    
