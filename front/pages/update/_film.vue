<template>
    <div class="main-container">
        <form>
            <label for="filmName">Ingrese el nombre de la pelicula</label>
            <input type="text" id="filmName" v-model="film.titulo">

                
            <label for="filmCategory">Ingrese la categoría de la pelicula</label>
            <input type="number" id="filmCategory" v-model="film.duracion">

            
            <label for="filmLength">Ingrese la duración de la pelicula</label>
            <input type="text" id="filmLength" v-model="film.categoria">
            
            <!-- <button type="button" id="send" @click="send" class="main">Ingresar Pelicula</button> -->
            
        </form>
        <nuxt-link to="/">Volver</nuxt-link>
    </div>
</template>

<script>
export default ({
    data(){
        return {
            film: {},
        }
    },

    methods: {
    async getFilm() {
    //    try {
    //     console.log(this.items)
    //     let response = await this.$axios.get('http://localhost:8080/film');
    //     this.peliculas = response.data;
    //     console.log(this.peliculas)
    //     console.log(response) 
    //   } catch (error) {
    //     console.log('error', error);
    //   }
    },
  },

  //Función que se ejecuta al cargar el componente
  mounted: async function() {
      let filmId = this.$route.params.film;
      try {
        let response = await this.$axios.get('film/' + filmId);
        this.film = response.data;
      } catch (error) {
        console.log(error);
      }
  },
})
</script>

<style>
    .main-container{
        display: flex;
        justify-content: center;
        align-items: center;
    }
</style>