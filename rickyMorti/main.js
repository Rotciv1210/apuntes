const resultados = document.querySelector('.resultados')
const url = 'https://rickandmortyapi.com/api/character'

fetch(url)
    .then(res => res.json())
    .then(data => {

        console.log(data.info.count)

        const numeroPersonajes = data.info.count
//cargar los resultados en el html `` con estas comillas puedes meter variables de JS
        resultados.innerHTML= `<p>Numero de personajes ${numeroPersonajes}</p>
                                <div class="personajes-container"></div>
        `

        const contenedor = document.querySelector('.personajes-container')

        //iteramos los resultados
        data.results.forEach(personaje => {
            
            contenedor.innerHTML += `
                <div class="personaje">
                    <img src="${personaje.image}" alt="${personaje.name}"/>
                    <h3>${personaje.name}</h3>
                    <p>Especie:${personaje.species}</p>
                    <p>Status:${personaje.status}</p>
                </div>
            `

        });


    })