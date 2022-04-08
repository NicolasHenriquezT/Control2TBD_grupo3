<template>
    <div class="Contenedora">
        <h1>Ingresar una nueva pelicula</h1>
        <form>
            <div class="IngresoNombrePelicula">
            <label for="nombrePelicula">Ingrese el nombre de la pelicula</label>
            <input type="text" id="nombrePelicula1" v-model="nuevaPelicula.nombre">
            </div>
            <div class="IngresoDescripcionPelicula">
                <label for="descripcionPelicula">Ingrese la categoria de la pelicula</label>
                <input type="text" id="descripcionPelicula2" v-model="nuevaPelicula.descripcion">
                
            </div>
            <div class="IngresoDuracionPelicula">
                <label for="duracionPelicula">Ingrese la duracion de la pelicula</label>
                <input type="number" id="duracionPelicula1" v-model="nuevaPelicula.duracion">
            </div>
            <div>
            <button type="button" id="send" class="main">Ingresar Pelicula</button>
            </div>

            <table>
                <tr>
                    <th v-for="atr in atributos">
                        {{ atr }}
                    </th>
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
export default ({
   data(){
        return {
            message: '',
            nuevaPelicula: {},
            peliculas: [{"id":1,"titulo":"titulo1","categoria":"categoria1","duracion":1000},{"id":2,"titulo":"titulo2","categoria":"categoria2","duracion":2000},{"id":3,"titulo":"titulo3","categoria":"categoria3","duracion":3000},{"id":4,"titulo":"titulo4","categoria":"categoria4","duracion":4000},{"id":5,"titulo":"titulo5","categoria":"categoria5","duracion":5000},{"id":6,"titulo":"titulo6","categoria":"categoria6","duracion":6000}],
            atributos: ['titulo', "categoria", "duracion"],
        }
    },

    methods: {
    async getFilm() {
    //   const respuesta = await this.$axios.$get("localhost:8080/film");
    //   this.peliculas = respuesta;
      console.log(0);
    },
  },
  //Función que se ejecuta al cargar el componente
  created: function() {
    this.getFilm();
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