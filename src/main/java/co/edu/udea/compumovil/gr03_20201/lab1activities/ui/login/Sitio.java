package co.edu.udea.compumovil.gr03_20201.lab1activities.ui.login;

public class Sitio {
    int id;
    String foto;
    String nombre;
    String descripcion;
    String puntuacion;
    String informacion;
    String ubicacion;
    String temperatura;
    String recomendados;
    String aux;

    public Sitio() {
    }

    public Sitio(String foto, String nombre, String descripcion, String puntuacion, String informacion, String ubicacion, String temperatura, String recomendados, String aux) {
        this.foto = foto;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.puntuacion = puntuacion;
        this.informacion = informacion;
        this.ubicacion = ubicacion;
        this.temperatura = temperatura;
        this.recomendados = recomendados;
        this.aux = aux;
    }

    public Sitio(int id, String foto, String nombre, String descripcion, String puntuacion, String informacion, String ubicacion, String temperatura, String recomendados, String aux) {
        this.id = id;
        this.foto = foto;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.puntuacion = puntuacion;
        this.informacion = informacion;
        this.ubicacion = ubicacion;
        this.temperatura = temperatura;
        this.recomendados = recomendados;
        this.aux = aux;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(String puntuacion) {
        this.puntuacion = puntuacion;
    }

    public String getInformacion() {
        return informacion;
    }

    public void setInformacion(String informacion) {
        this.informacion = informacion;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(String temperatura) {
        this.temperatura = temperatura;
    }

    public String getRecomendados() {
        return recomendados;
    }

    public void setRecomendados(String recomendados) {
        this.recomendados = recomendados;
    }

    public String getAux() {
        return aux;
    }

    public void setAux(String aux) {
        this.aux = aux;
    }
}