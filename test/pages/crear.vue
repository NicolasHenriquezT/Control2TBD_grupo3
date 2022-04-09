<template>
    <div class="Contenedora">
        <h1>Ingresar una nueva pelicula</h1>
        <form>
            <div class="IngresoNombrePelicula">
            <label for="nombrePelicula">Ingrese el nombre de la pelicula</label>
            <input type="text" id="nombrePelicula1" v-model="nuevaPelicula.titulo">
            </div>
            <div class="IngresoDescripcionPelicula">
                <label for="descripcionPelicula">Ingrese la categoria de la pelicula</label>
                <input type="text" id="descripcionPelicula2" v-model="nuevaPelicula.categoria">
                
            </div>
            <div class="IngresoDuracionPelicula">
                <label for="duracionPelicula">Ingrese la duracion de la pelicula</label>
                <input type="number" id="duracionPelicula1" v-model="nuevaPelicula.duracion">
            </div>
            <div>
            <button type="button" id="send" @click="send" class="main">Ingresar Pelicula</button>
            </div>
            <button type="button" id="send" @click="getFilm" class="main">Ingresar Pelicula</button>
            <table>
                <tr>
                    
                </tr>
                <tr v-for="p in peliculas" :key="p.id">
                    <td>{{ p.titulo }}</td>
                    <td>{{ p.categoria }}</td>
                    <td>{{ p.duracion }}</td>
                </tr>
            </table>


        </form>
        
    </div>
</template>
<script>
import axios from 'axios';
export default ({
   data(){
        return {
            message: '',
            nuevaPelicula: {},
            peliculas: [],
            atributos: ['titulo', "categoria", "duracion"],
        }
    },

    methods: {
    async getFilm() {
       try {
        console.log(this.items)
        let response = await axios.get('http://localhost:8080/film');
        this.peliculas = response.data;
        console.log(this.peliculas)
        console.log(response) 
      } catch (error) {
        console.log('error', error);
      }
    },

    async send() {
        console.log(this.nuevaPelicula);
       try {
        let response = await axios.post('http://localhost:8080/newfilm',this.nuevaPelicula);
      } catch (error) {
        console.log('error', error);
      }
    },
  },
  //Función que se ejecuta al cargar el componente
  created: function() {
      
  },
})
</script>

<style>
.Contenedora{
    padding: .5rem 1rem;
    color:rgb(0, 0, 0);
    background:rgb(255, 255, 255);
    font-size: 1rem;
    text-align: center;
    width: 100%;
    display:inline-block;
}
.IngresoNombrePelicula{
    color:rgb(0, 0, 0)

}
#nombrePelicula1{
    width: 20%;
    padding: 1px;
    color: rgb(0, 0, 0);
    border: rgb(0, 0, 0) 1px solid;
    background: rgb(230, 230, 230);
    margin: 10px;
    text-align: center;
}
#descripcionPelicula2{
    width: 20%;
    padding: 1px;
    background: rgb(230, 230, 230);
    color: black;
    border: rgb(0, 0, 0) 1px solid;
    margin: 10px;
    text-align: center;
}
#duracionPelicula1{
    width: 20%;
    padding: 1px;
    background: rgb(230, 230, 230);
    color: black;
    border: black 1px solid;
    margin: 10px;
    text-align: center;
}
#send{
    border: rgb(0, 0, 0) 1px solid;
    border-radius: 10px;
    color: rgb(0, 0, 0);
    background: rgb(209, 210, 248);
    margin: 20px;
    text-align: center;
    width: 20%;

}
</style>