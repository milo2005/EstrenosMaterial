package movil.estrenos.fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Date;

import movil.estrenos.R;
import movil.estrenos.adapters.PeliculaAdapter;
import movil.estrenos.databinding.FragmentHomeBinding;
import movil.estrenos.models.Pelicula;
import movil.estrenos.models.Promocion;
import movil.estrenos.util.L;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment implements PeliculaAdapter.OnItemClickAdapter {

    public interface OnHomeItemClick{
        void onHomeClick(int pos, int type);
    }

    PeliculaAdapter adapter;
    FragmentHomeBinding binding;
    OnHomeItemClick onHomeItemClick;

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        onHomeItemClick = (OnHomeItemClick) context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentHomeBinding
                .inflate(getLayoutInflater(savedInstanceState));
        if(savedInstanceState==null)
            L.data = new ArrayList<>();
        adapter = new PeliculaAdapter(getContext(), L.data, this);
        binding.setAdapter(adapter);
        binding.recycler.setLayoutManager(new LinearLayoutManager(getContext()));

        if(savedInstanceState == null)
            loadItems();
        return binding.getRoot();
    }

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

    @Override
    public void onClick(View v) {
        int pos = binding.recycler.getChildAdapterPosition(v);
        onHomeItemClick.onHomeClick(pos,L.data.get(pos).getType());
    }
}
