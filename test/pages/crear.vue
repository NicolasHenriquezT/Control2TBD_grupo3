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

        </form>
        
    </div>
</template>
<script>
export default ({
   data(){
        return{
            message:'',
            nuevaPelicula:{}
        }
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