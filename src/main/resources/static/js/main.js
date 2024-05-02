const url = 'https://www.chileatiende.gob.cl/api/fichas';

const respuesta = document.querySelector("#respuesta");
document.addEventListener("DOMContentLoaded", llamarApi);



function llamarApi(){
fetch(url)
.then(Resp=>Resp.json())
.then( (data) => mostrarHTML(data))
}

function mostrarHTML(datos){
	datos.forEach(item => {
		const opt = document.createElement('option');
		opt.innerHTML = `<option >${item.titulo}</option>`
		respuesta.appendChild(opt);
	});
}
