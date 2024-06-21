package com.schoollife.web.Controller;

import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import com.schoollife.web.Entities.Estudiante;
import com.schoollife.web.Entities.Usuario;
import com.schoollife.web.Service.EstablecimientoService;
import com.schoollife.web.Service.EstudianteService;

import jakarta.servlet.http.HttpSession;


@Controller
public class ExcelUploadController {
	
	@Autowired
	private final EstudianteService estudianteS;
	@Autowired
	private final EstablecimientoService establecimientoS;
		
    public ExcelUploadController(EstudianteService estudianteS, EstablecimientoService establecimientoS) {
		super();
		this.estudianteS = estudianteS;
		this.establecimientoS = establecimientoS;
	}

	@GetMapping("/upload")
    public String uploadForm(Model model,HttpSession sesion) {
	if(sesion.getAttribute("user") != null) {
				
				List<Usuario> uSesion =  (List<Usuario>) sesion.getAttribute("user");
				model.addAttribute("uSesion",uSesion.get(0));
				model.addAttribute("establecimientoSesion", establecimientoS.findById(uSesion.get(0).getEstablecimientoId()));	
				
		    	model.addAttribute("excelData", new ArrayList<List<String>>());
		        return "Import";
		}
		return "Login";
	 
	    }
    
    @PostMapping("/upload")
    public String uploadFile(@RequestParam("file") MultipartFile file, Model model,HttpSession sesion) {
    	if(sesion.getAttribute("user") != null) {
			
			List<Usuario> uSesion =  (List<Usuario>) sesion.getAttribute("user");
			model.addAttribute("uSesion",uSesion.get(0));
			model.addAttribute("establecimientoSesion", establecimientoS.findById(uSesion.get(0).getEstablecimientoId()));	
			
			if (file.isEmpty()) {
	            model.addAttribute("message", "Por favor selecciona un archivo para subir.");
	            model.addAttribute("excelData", new ArrayList<List<String>>()); // Inicializa excelData como una lista vacía
	            return "Import";
	        }
	        try {
	            List<List<String>> excelData = processExcelFile(file.getInputStream());
	            model.addAttribute("excelData", excelData);
	            saveExcelDataToDatabase(excelData);
	            model.addAttribute("message", "Archivo subido correctamente: " + file.getOriginalFilename());
	        } catch (IOException e) {
	            e.printStackTrace();
	            model.addAttribute("message", "Error al subir el archivo.");
	        }

	        return "Import";	
    	}
    	return "Login"; 
    }
    
    public List<List<String>> processExcelFile(InputStream inputStream) throws IOException {
        List<List<String>> excelData = new ArrayList<>();

        Workbook workbook = WorkbookFactory.create(inputStream);
        Sheet sheet = workbook.getSheetAt(0);
        Iterator<Row> rowIterator = sheet.iterator();

        // Salta la primera fila que contiene los encabezados
        if (rowIterator.hasNext()) {
            rowIterator.next(); // Salta la primera fila
        }

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
                        rowData.add(Boolean.toString(cell.getBooleanCellValue()));
                        break;
                    default:
                        rowData.add("");
                }
            }
            excelData.add(rowData);
        }

        workbook.close();
        return excelData;
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

    
    
    private void saveExcelDataToDatabase(List<List<String>> excelData) {
    	
    	SimpleDateFormat dateFormat = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", Locale.ENGLISH);
    	
        for (List<String> rowData : excelData) {
        	
            if (rowData.size() < 7) {
                // Asegúrate de que haya al menos 7 elementos en rowData
                System.err.println("Error: La fila no tiene suficientes datos.");
                continue; // O manejo de error según tu lógica de negocio
            }
        	
            Estudiante e = new Estudiante();
            // Asigna los valores a la entidad según tus columnas y estructura de datos
            e.setRunEstudiante(rowData.get(0));
            e.setNombre(rowData.get(1));
            e.setApaterno(rowData.get(2));
            e.setAmaterno(rowData.get(3));         
            String numeroMatriculaStr = rowData.get(4); // Suponiendo que el número de matrícula está en la posición 4
            
            // Validación y conversión segura
            if (StringUtils.isNumeric(numeroMatriculaStr)) {
                try {
                    e.setNumero_matricula(Integer.parseInt(numeroMatriculaStr));
                } catch (NumberFormatException ese) {
                    // Manejo de error si no se puede convertir a número (aunque isNumeric debería prevenir esto)
                    System.err.println("Error al convertir número de matrícula: " + numeroMatriculaStr);
                    ese.printStackTrace();
                }
            } else {
                System.err.println("Valor no numérico encontrado para número de matrícula: " + numeroMatriculaStr);
            }
            String cantidadComputadoresStr = rowData.get(18);
            if (StringUtils.isNumeric(cantidadComputadoresStr)) {
                try {
                    e.setCantidad_computadores_casa(Integer.parseInt(cantidadComputadoresStr));
                } catch (NumberFormatException ese) {
                    System.err.println("Error al convertir número de matrícula: " + numeroMatriculaStr);
                    ese.printStackTrace();
                }
            } else {
                System.err.println("Valor no numérico encontrado para número de matrícula: " + numeroMatriculaStr);
            }
            
            try {
                // Transforma rowData.get(6) (fecha como String) a Date
                Date fechaMatricula = dateFormat.parse(rowData.get(5));
                System.out.println("la fecha de nacimiento es : "+ rowData.get(5).toString());
                Date fechaNacimiento = dateFormat.parse(rowData.get(6));
                Date fechaUltimaVacuna = dateFormat.parse(rowData.get(32));
                e.setFecha_matricula(fechaMatricula);
                e.setFecha_nacimiento(fechaNacimiento);
                e.setFecha_ultima_vacuna_COVID(fechaUltimaVacuna);
            } catch (Exception ex) {
            	ex.printStackTrace(); // Manejo de error si no se puede parsear la fecha
            }
    
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
            if(rowData.get(20).equalsIgnoreCase("si")){
            	e.setAcepta_clases_religion(true);
            }else {
            	e.setAcepta_clases_religion(false);
            }
            e.setBeca(rowData.get(21));
            String estaturaStr = rowData.get(22);
            if (StringUtils.isNumeric(estaturaStr)) {
                try {
                    e.setEstatura(Integer.parseInt(estaturaStr));
                } catch (NumberFormatException ese) {
                    System.err.println("Error al convertir número de matrícula: " + numeroMatriculaStr);
                    ese.printStackTrace();
                }
            } else {
                System.err.println("Valor no numérico encontrado para número de matrícula: " + numeroMatriculaStr);
            }
            
            String pesoStr = rowData.get(23);
            if (StringUtils.isNumeric(pesoStr)) {
                try {
                    e.setPeso(Double.parseDouble(pesoStr));
                } catch (NumberFormatException ese) {
                    System.err.println("Error al convertir número de matrícula: " + numeroMatriculaStr);
                    ese.printStackTrace();
                }
            } else {
                System.err.println("Valor no numérico encontrado para número de matrícula: " + numeroMatriculaStr);
            }

            e.setGrupo_sanguineo(rowData.get(24));
            e.setAlergias_alimentos(rowData.get(25));
            e.setAlergias_medicamentos(rowData.get(26));
            e.setMedicamentos_contraindicados(rowData.get(27));
            e.setEnfermedades_cronicas(rowData.get(28));        
            if(rowData.get(29).equalsIgnoreCase("si")){
            	e.setVacuna_covid(true);
            }else {
            	e.setVacuna_covid(false);
            }
            
            String cantidadVacunasCovidStr = rowData.get(30);
            if (StringUtils.isNumeric(estaturaStr)) {
                try {
                	e.setCantidad_vacunas_covid(Integer.parseInt(cantidadVacunasCovidStr));
                } catch (NumberFormatException ese) {
                    System.err.println("Error al convertir número de matrícula: " + numeroMatriculaStr);
                    ese.printStackTrace();
                }
            } else {
                System.err.println("Valor no numérico encontrado para número de matrícula: " + numeroMatriculaStr);
            }            
            
            if(rowData.get(31).equalsIgnoreCase("si")){
            	e.setEsquema_completo_vacunacion_covid(true);
            }else {
            	e.setEsquema_completo_vacunacion_covid(false);
            }
            
            if(rowData.get(33).equalsIgnoreCase("si")){
            	e.setApto_educacion_fisica(true);
            }else {
            	e.setApto_educacion_fisica(false);
            }
            
            if(rowData.get(35).equalsIgnoreCase("si")){
            	e.setSeguro_escolar_privado(true);
            }else {
            	e.setSeguro_escolar_privado(false);
            }
            e.setSistema_prevision(rowData.get(34));
            e.setNacionalidad(rowData.get(36));
            e.setEtnia(rowData.get(37));
            e.setConsultorio_clinica(rowData.get(38));
            e.setObservaciones(rowData.get(39));
            if(rowData.get(40).equalsIgnoreCase("MATRICULADO")){
            	e.setEstado(true);
            }else {
            	e.setEstado(false);
            }           
            
            String establecimientoIdStr = rowData.get(41);
            if (StringUtils.isNumeric(establecimientoIdStr)) {
                try {
                    e.setEstablecimientoId(Integer.parseInt(establecimientoIdStr));
                } catch (NumberFormatException ese) {
                    System.err.println("Error al convertir número de matrícula: " + numeroMatriculaStr);
                    ese.printStackTrace();
                }
            } else {
                System.err.println("Valor no numérico encontrado para número de matrícula: " + numeroMatriculaStr);
            }
            
            String cursoIdStr = rowData.get(42);
            System.out.println("curso id: " + rowData.get(42));
            if (StringUtils.isNumeric(cursoIdStr)) {
                try {
                    e.setCurso_id(Integer.parseInt(cursoIdStr));
                } catch (NumberFormatException ese) {
                    System.err.println("Error al convertir número de matrícula: " + numeroMatriculaStr);
                    ese.printStackTrace();
                }
            } else {
                System.err.println("Valor no numérico encontrado para número de matrícula: " + numeroMatriculaStr);
            }
            
            if(rowData.get(43).equalsIgnoreCase("si")){
            	e.setEs_pie(true);
            }else {
            	e.setEs_pie(false);
            }
            estudianteS.createEstudiante(e);
        }
    }
    
    

}
