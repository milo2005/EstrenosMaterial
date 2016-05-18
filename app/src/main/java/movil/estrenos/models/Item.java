package movil.estrenos.models;

/**
 * Created by Dario Chamorro on 18/05/2016.
 */
public interface Item {
    int TYPE_PELICULA = 0;
    int TYPE_PROMOCION = 1;

    int getType();
}
