package movil.estrenos;

import android.support.annotation.Nullable;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;
import java.util.Date;

import movil.estrenos.adapters.PeliculaAdapter;
import movil.estrenos.databinding.ActivityMainBinding;
import movil.estrenos.databinding.HeaderNavBinding;
import movil.estrenos.models.Pelicula;
import movil.estrenos.models.Promocion;
import movil.estrenos.models.Usuario;
import movil.estrenos.util.L;

public class MainActivity extends AppCompatActivity implements DrawerLayout.DrawerListener {

    ActivityMainBinding binding;
    ActionBarDrawerToggle toggle;

    PeliculaAdapter adapter;

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

        //Configuracion Toggle
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toggle = new ActionBarDrawerToggle(this, binding.drawer
                ,R.string.open_menu, R.string.close_menu);
        binding.drawer.addDrawerListener(this);

        //Configuracion RecyclerView

        L.data = new ArrayList<>();
        adapter = new PeliculaAdapter(this, L.data);
        binding.recycler.setAdapter(adapter);
        binding.recycler.setLayoutManager(new LinearLayoutManager(this));

        loadItems();
    }

    //region Configuracion Toggle
    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        toggle.syncState();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(toggle.onOptionsItemSelected(item))
            return  true;
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onDrawerSlide(View drawerView, float slideOffset) {
        toggle.onDrawerSlide(drawerView,slideOffset);
    }

    @Override
    public void onDrawerOpened(View drawerView) {
        toggle.onDrawerOpened(drawerView);
    }

    @Override
    public void onDrawerClosed(View drawerView) {
        toggle.onDrawerClosed(drawerView);
    }

    @Override
    public void onDrawerStateChanged(int newState) {
        toggle.onDrawerStateChanged(newState);
    }
    //endregion

    private void loadItems(){
        Pelicula p1 = new Pelicula();
        p1.setNombre("Xmen Apocalipsis");
        p1.setSinopsis("El regreso de Xmen en la lucha contra Apocalipsis");
        p1.setDuracion("3:00 h");
        p1.setFechaEstreno(new Date());
        p1.setImagen("http://www.fotogramas.es/var/ezflow_site/storage/images/noticias-cine/magneto-tendra-mas-poder-en-x-men-apocalipsis/91263793-1-esl-ES/Magneto-tendra-mas-poder-en-X-Men-Apocalipsis_landscape.jpg");

        Pelicula p2 = new Pelicula();
        p2.setNombre("Sucide Squad");
        p2.setDuracion("2:30 h");
        p2.setFechaEstreno(new Date());
        p2.setImagen("http://nerdist.com/wp-content/uploads/2016/01/Suicide-Squad-Logo-Wallpaper-suicide-squad-38660575-1440-900.jpg");

        Promocion pr1 = new Promocion();
        pr1.setEntidad("Royal Films");
        pr1.setFecha(new Date());
        pr1.setTitulo("2 X 1");
        pr1.setImagenEntidad("http://www.apkfree.com/images/app-icon/royal-films-colombia.png");
        pr1.setImagenPromo("https://pbs.twimg.com/media/BsrI_ZgIYAAJpFL.jpg");

        Pelicula p3 = new Pelicula();
        p3.setNombre("Conjuro 2");
        p3.setSinopsis("Revive el terror de la familia Warren");
        p3.setDuracion("2:45 h");
        p3.setImagen("http://cdn.colombia.com/sdi/2016/01/08/3fca19db9fa64de1b3f8517b80dbfd38.jpg");

        Promocion pr2 = new Promocion();
        pr2.setEntidad("Presto");
        pr2.setFecha(new Date());
        pr2.setTitulo("Combo Cinema");
        pr2.setImagenEntidad("http://www.creadictos.com/wp-content/uploads/2015/07/antiguo-logo-presto.jpg?07ce96");
        pr2.setImagenPromo("http://www.vive.in/recomendados/bogota/articulos/julio2015/IMAGEN/IMAGEN-16161995-2.jpg");

        L.data.add(p1);
        L.data.add(p2);
        L.data.add(pr1);
        L.data.add(p3);
        L.data.add(pr2);

        adapter.notifyDataSetChanged();

    }

}

