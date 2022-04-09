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
            <button type="button" id="send" @click="getFilm" class="main">Mostrar Peliculas</button>
        </form>

        <div class="table-container">
            <table class="main-table">
                    <tr>
                        <th v-for="att in atributos" :key="att">
                            {{ att }}
                        </th>
                    </tr>
                    <tr v-for="(p, index) in peliculas" :key="index">
                        <td>{{ p.titulo }}</td>
                        <td>{{ p.categoria }}</td>
                        <td>{{ p.duracion }}</td>
                        <td>
                            <nuxt-link :to="{ name: 'update-film', 
                                              params: { film: p.id }}">
                                <img width="25" height="25" :src="editLogo" />
                            </nuxt-link>
                        </td>
                        <td>
                            <img style="fill: red" width="25" height="25" :src="deleteLogo" />
                        </td>
                    </tr>
            </table>
        </div>
        
    </div>
</template>
<script>
import editLogo from '../static/edit_icon.svg'
import deleteLogo from '../static/delete_icon.svg'

export default ({
    
    data(){
        return {
            message: '',
            nuevaPelicula: {},
            peliculas: [],
            temp: {},
            atributos: ["Título", "Categoría", "Duración", "Editar", "Eliminar"],
            editLogo,
            deleteLogo,
        }
    },

    methods: {
    async getFilm() {
       try {
        console.log(this.items)
        let response = await this.$axios.get('http://localhost:8080/film');
        this.peliculas = response.data;
        console.log(this.peliculas)
        console.log(response) 
      } catch (error) {
        console.log('error', error);
      }
    },

    async send() {
      try {
        let response = await this.$axios.get("http://localhost:8080/film");
        this.temp = response.data;
        var flag = 0;
        for (var i = 0; i < this.temp.length; i++) {
          if (this.temp[i].titulo === this.nuevaPelicula.titulo) {
            alert("Ya existe la pelicula con ese nombre en la base de datos");
            i = this.temp.length;
            flag = 1;
          }
        }
        if(this.nuevaPelicula.titulo == null ){
            alert("Debe ingresar un titulo");
        }
        else if(this.nuevaPelicula.categoria == null){
            alert("Debe ingresar una categotoria");
        }
        else{
        if (flag == 0) {
           
          try {
            await this.$axios
              .post("http://localhost:8080/newfilm", this.nuevaPelicula)
              .then((res) => res.data)
              .catch((res) => res);
          } catch (error) {
            console.log("error", error);
          }
        }
        }
      } catch (error) {
        console.log("error", error);
      }
    },
  },
  //Función que se ejecuta al cargar el componente
  created: function() {
      this.getFilm();
  },
})
</script>

<style>

body {
    font-family: Arial, Helvetica, sans-serif;
    font-size: 12px;
}

/* Estilizar tablas */

table {
    border-collapse: collapse;
}

tr {
    border-bottom: 1px solid black;
    line-height: 20px;
}

th, td {
    padding: 5px;
}


.table-container{
    display: flex;
    justify-content: center;
}

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