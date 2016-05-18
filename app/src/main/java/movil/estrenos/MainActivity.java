package movil.estrenos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import movil.estrenos.databinding.ActivityMainBinding;
import movil.estrenos.databinding.HeaderNavBinding;
import movil.estrenos.models.Usuario;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //Configuracion Header
        HeaderNavBinding header =  HeaderNavBinding.inflate(getLayoutInflater());
        Usuario u =  new Usuario();
        u.setNombre("Dario Chamorro ");
        u.setImagenBanner("http://i2.wp.com/hipertextual.com/files/2014/10/universo.jpg?resize=610%2C343");
        u.setImagen("https://media.licdn.com/mpr/mpr/shrinknp_200_200/AAEAAQAAAAAAAANJAAAAJDBiOTY0ZjQ1LWEzNjItNDE1Zi1hN2FhLWY3NDE4YjYyNWIzNQ.jpg");
        header.setUsuario(u);
        binding.nav.addHeaderView(header.getRoot());


    }
}
