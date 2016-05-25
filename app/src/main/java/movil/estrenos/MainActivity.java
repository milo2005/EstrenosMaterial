package movil.estrenos;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
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
import movil.estrenos.fragments.CinemasFragment;
import movil.estrenos.fragments.HomeFragment;
import movil.estrenos.models.Item;
import movil.estrenos.models.Pelicula;
import movil.estrenos.models.Promocion;
import movil.estrenos.models.Usuario;
import movil.estrenos.util.L;

public class MainActivity extends AppCompatActivity implements DrawerLayout.DrawerListener, NavigationView.OnNavigationItemSelectedListener, HomeFragment.OnHomeItemClick {

    ActivityMainBinding binding;
    ActionBarDrawerToggle toggle;

    HomeFragment home;
    CinemasFragment cinemas;


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

        //Fragments
        home = new HomeFragment();
        cinemas = new CinemasFragment();

        putFragment(R.id.container, home);
        binding.nav.setNavigationItemSelectedListener(this);
        getSupportActionBar().setTitle(R.string.nav_home);


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

    private void putFragment(int container, Fragment fragment){
        FragmentTransaction ft = getSupportFragmentManager()
                .beginTransaction();

        ft.replace(container, fragment);
        ft.commit();
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.nav_home:
                getSupportActionBar().setTitle(R.string.nav_home);
                putFragment(R.id.container, home);
                break;
            case R.id.nav_cinemas:
                getSupportActionBar().setTitle(R.string.nav_cinemas);
                putFragment(R.id.container, cinemas);
                break;
        }

        binding.drawer.closeDrawers();

        return false;
    }

    @Override
    public void onHomeClick(int pos, int type) {
        if(type == Item.TYPE_PELICULA){
            Intent intent = new Intent(this, DetailActivity.class);
            intent.putExtra(DetailActivity.EXTRA_POS, pos);
            startActivity(intent);
        }
    }
}

