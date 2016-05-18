package movil.estrenos.models;

import java.util.Date;

/**
 * Created by Dario Chamorro on 13/05/2016.
 */
public class Promocion {

    String descripcion, titulo, entidad, imagenPromo, imagenEntidad;
    Date fecha;

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getEntidad() {
        return entidad;
    }

    public void setEntidad(String entidad) {
        this.entidad = entidad;
    }

    public String getImagenPromo() {
        return imagenPromo;
    }

    public void setImagenPromo(String imagenPromo) {
        this.imagenPromo = imagenPromo;
    }

    public String getImagenEntidad() {
        return imagenEntidad;
    }

    public void setImagenEntidad(String imagenEntidad) {
        this.imagenEntidad = imagenEntidad;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
}
