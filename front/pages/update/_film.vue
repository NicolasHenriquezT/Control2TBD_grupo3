<template>
    <div class="main-container">
        <form class="update-container">
            <label for="filmName">Ingrese el nombre de la pelicula</label>
            <input type="text" id="filmName" v-model="film.titulo">

                    
            <label for="filmCategory">Ingrese la categoría de la pelicula</label>
            <input type="text" id="filmCategory" v-model="film.categoria">
                
            <button type="button" @click="updateFilm" class="edit-btn">Actualizar Pelicula</button>
                
        </form>

        <button class="back-btn">
            <nuxt-link to="/">Volver</nuxt-link>
        </button>
    </div>
</template>

<script>
export default ({
    data(){
        return {
            oldFilm: {},
            film: {},
        }
    },

    methods: {
        async updateFilm() {
            let old = this.oldFilm;
            let update = this.film;

            if( old.titulo === update.titulo &&
                old.duracion === update.duracion){
                    alert("No existen cambios. Inténtelo de nuevo.");
                    return;
            }
            
            try {
                let response = await this.$axios.put('http://localhost:8080/film/actualizar', update);
            } catch (error) {
                console.log('error: ', error);
            }
        },
  },

  //Función que se ejecuta al cargar el componente
  mounted: async function() {
      let filmId = this.$route.params.film;
      try {
        let response = await this.$axios.get('http://localhost:8080/film/' + filmId);
        this.oldFilm = {...response.data};
        this.film = response.data;
      } catch (error) {
        console.log(error);
      }
  },


})
</script>

<style>
button {
    cursor: pointer;
    padding: .5rem;
    border-radius: 0.125rem;
    background-color: white;
    transition: background-color 150ms ease-in-out;
    border: 0;
    border-bottom: 2px solid black;
}

button:hover {
    background-color: rgb(144, 209, 255);
}


button > a {
    color: black;
    text-decoration: none;
}
.main-container{
    margin-top: 2rem;
    display:flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
    gap: 1rem;
}
.update-container{
    display: flex;
    flex-direction: column;
    justify-content: center;
    font-size: 1rem;
    width: 60%;
}

.update-container > label{
    margin-bottom: .5rem;
}

.update-container > input{
    padding-left: .5rem;
    margin-bottom: 1rem;
    height: 25px;
}

.back-btn{
    display: block;
}
</style>