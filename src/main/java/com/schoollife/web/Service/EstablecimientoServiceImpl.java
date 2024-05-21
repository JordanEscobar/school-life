package com.schoollife.web.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.schoollife.web.Entities.Establecimiento;
import com.schoollife.web.Repository.EstablecimientoRepository;

import jakarta.transaction.Transactional;

@Service
public class EstablecimientoServiceImpl implements EstablecimientoService{
	@Autowired
	private final EstablecimientoRepository establecimientoR;

	public EstablecimientoServiceImpl(EstablecimientoRepository establecimientoR) {
		super();
		this.establecimientoR = establecimientoR;
	}

	@Override
	@Transactional
	public List<Establecimiento> getAll() {
		return establecimientoR.findAll();
	}

	@Override
	@Transactional
	public void updateEstablecimiento(Establecimiento establecimiento, Integer rbd) {
		Optional<Establecimiento> establecimientoId = establecimientoR.findById(rbd);
		Establecimiento e = establecimientoId.get();
		e.setComuna(establecimiento.getComuna());
		e.setCorreo_electronico(establecimiento.getCorreo_electronico());
		e.setDireccion(establecimiento.getDireccion());
		e.setFecha_aniversario(establecimiento.getFecha_aniversario());
		e.setNombre(establecimiento.getNombre());
		e.setNumero_telefonico(establecimiento.getNumero_telefonico());
		e.setPagina_web(establecimiento.getPagina_web());
		e.setRbd(establecimiento.getRbd());
		e.setRegion(establecimiento.getRegion());
		e.setZona_horaria(establecimiento.getZona_horaria());
		establecimientoR.save(e);
		
	}

	@Override
	@Transactional
	public Establecimiento findEstablecimiento(Establecimiento establecimiento) {
		return establecimientoR.findById(establecimiento.getRbd()).orElse(null);
	}

	@Override
	@Transactional
	public Establecimiento createEstablecimiento(Establecimiento establecimiento) {
		return establecimientoR.save(establecimiento);
	}

	@Override
	@Transactional
	public List<String> comunas() {
		String[] c = { "Arica", "Camarones", "Putre", "General Lagos", "Iquique", "Alto Hospicio", "Pozo Almonte", "Camiña", "Colchane", "Huara", "Pica",
				"Antofagasta", "Mejillones", "Sierra Gorda", "Taltal", "Calama", "Ollagüe", "San Pedro de Atacama", "Tocopilla", "María Elena",
			 "Copiapó", "Caldera", "Tierra Amarilla", "Chañaral", "Diego de Almagro", "Vallenar", "Alto del Carmen", "Freirina", "Huasco",
			"La Serena", "Coquimbo", "Andacollo", "La Higuera", "Paiguano", "Vicuña", "Illapel", "Canela", "Los Vilos", "Salamanca", "Ovalle", "Combarbalá", "Monte Patria",
			"Punitaqui", "Río Hurtado" ,"Valparaíso", "Casablanca", "Concón", "Juan Fernández", "Puchuncaví", "Quintero", "Viña del Mar", "Isla de Pascua", "Los Andes", "Calle Larga",
			"Rinconada", "San Esteban", "La Ligua", "Cabildo", "Papudo", "Petorca", "Zapallar", "Quillota", "Calera", "Hijuelas", "La Cruz", "Nogales", "San Antonio", "Algarrobo", "Cartagena",
			"El Quisco", "El Tabo", "Santo Domingo", "San Felipe", "Catemu", "Llaillay", "Panquehue", "Putaendo", "Santa María", "Quilpué", "Limache", "Olmué", "Villa Alemana","Rancagua", "Codegua",
			"Coinco", "Coltauco", "Doñihue", "Graneros", "Las Cabras", "Machalí", "Malloa", "Mostazal", "Olivar", "Peumo", "Pichidegua", "Quinta de Tilcoco", "Rengo", "Requínoa", "San Vicente", "Pichilemu",
			"La Estrella", "Litueche", "Marchihue", "Navidad", "Paredones", "San Fernando", "Chépica", "Chimbarongo", "Lolol", "Nancagua", "Palmilla", "Peralillo", "Placilla", "Pumanque", "Santa Cruz","Talca",
			"Constitución", "Curepto", "Empedrado", "Maule", "Pelarco", "Pencahue", "Río Claro", "San Clemente", "San Rafael", "Cauquenes", "Chanco", "Pelluhue", "Curicó", "Hualañé", "Licantén", "Molina", "Rauco",
			"Romeral", "Sagrada Familia", "Teno", "Vichuquén", "Linares", "Colbún", "Longaví", "Parral", "Retiro", "San Javier", "Villa Alegre", "Yerbas Buenas","Cobquecura", "Coelemu", "Ninhue", "Portezuelo", "Quirihue",
			"Ránquil", "Treguaco", "Bulnes", "Chillán Viejo", "Chillán", "El Carmen", "Pemuco", "Pinto", "Quillón", "San Ignacio", "Yungay", "Coihueco", "Ñiquén", "San Carlos", "San Fabián", "San Nicolás","Concepción", "Coronel", 
			"Chiguayante", "Florida", "Hualqui", "Lota", "Penco", "San Pedro de la Paz", "Santa Juana", "Talcahuano", "Tomé", "Hualpén", "Lebu", "Arauco", "Cañete", "Contulmo", "Curanilahue", "Los Álamos", "Tirúa", "Los Ángeles",
			"Antuco", "Cabrero", "Laja", "Mulchén", "Nacimiento", "Negrete", "Quilaco", "Quilleco", "San Rosendo", "Santa Bárbara", "Tucapel", "Yumbel", "Alto Biobío", "Temuco", "Carahue", "Cunco", "Curarrehue", "Freire", "Galvarino",
			"Gorbea", "Lautaro", "Loncoche", "Melipeuco", "Nueva Imperial", "Padre las Casas", "Perquenco", "Pitrufquén", "Pucón", "Saavedra", "Teodoro Schmidt", "Toltén", "Vilcún", "Villarrica", "Cholchol", "Angol", "Collipulli",
			"Curacautín", "Ercilla", "Lonquimay", "Los Sauces", "Lumaco", "Purén", "Renaico", "Traiguén", "Victoria","Valdivia", "Corral", "Lanco", "Los Lagos", "Máfil", "Mariquina", "Paillaco", "Panguipulli", "La Unión", "Futrono", 
			"Lago Ranco", "Río Bueno", "Puerto Montt", "Calbuco", "Cochamó", "Fresia", "Frutillar", "Los Muermos", "Llanquihue", "Maullín", "Puerto Varas", "Castro", "Ancud", "Chonchi", "Curaco de Vélez", "Dalcahue", "Puqueldón",
			"Queilén", "Quellón", "Quemchi", "Quinchao", "Osorno", "Puerto Octay", "Purranque", "Puyehue", "Río Negro", "San Juan de la Costa", "San Pablo", "Chaitén", "Futaleufú", "Hualaihué", "Palena", "Coihaique", "Lago Verde",
			"Aisén", "Cisnes", "Guaitecas", "Cochrane", "O’Higgins", "Tortel", "Chile Chico", "Río Ibáñez", "Punta Arenas", "Laguna Blanca", "Río Verde", "San Gregorio", "Cabo de Hornos (Ex Navarino)", "Antártica", "Porvenir", "Primavera",
			"Timaukel", "Natales", "Torres del Paine", "Cerrillos", "Cerro Navia", "Conchalí", "El Bosque", "Estación Central", "Huechuraba", "Independencia", "La Cisterna", "La Florida", "La Granja", "La Pintana", "La Reina", "Las Condes",
			"Lo Barnechea", "Lo Espejo", "Lo Prado", "Macul", "Maipú", "Ñuñoa", "Pedro Aguirre Cerda", "Peñalolén", "Providencia", "Pudahuel", "Quilicura", "Quinta Normal", "Recoleta", "Renca", "Santiago", "San Joaquín", "San Miguel", "San Ramón",
			"Vitacura", "Puente Alto", "Pirque", "San José de Maipo", "Colina", "Lampa", "Tiltil", "San Bernardo", "Buin", "Calera de Tango", "Paine", "Melipilla", "Alhué", "Curacaví", "María Pinto", "San Pedro", "Talagante", "El Monte",
			"Isla de Maipo", "Padre Hurtado", "Peñaflor" };
		List<String> comunas = new ArrayList<String>();
		for (String string : c) {
			comunas.add(string);
		}
		return comunas;
	}

	@Override
	@Transactional
	public List<String> regiones() {
		String[] r = {"Arica y Parinacota","Tarapacá","Antofagasta", "Atacama", "Coquimbo","Valparaíso",
				"Región del Libertador Gral. Bernardo O’Higgins",
				"Región del Maule","Región de Ñuble","Región del Biobío","Región de la Araucanía","Región de Los Ríos","Región de Los Lagos",
				"Región Aisén del Gral. Carlos Ibáñez del Campo",
				"Región de Magallanes y de la Antártica Chilena","Región Metropolitana de Santiago" };
		List<String> regiones = new ArrayList<String>();
		for (String string : r) {
			regiones.add(string);
		}
		return regiones;
	}
	
	

}
