package movil.estrenos.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import movil.estrenos.R;
import movil.estrenos.databinding.TemplatePeliculaBinding;
import movil.estrenos.databinding.TemplatePromocionBinding;
import movil.estrenos.models.Item;
import movil.estrenos.models.Pelicula;
import movil.estrenos.models.Promocion;

/**
 * Created by Dario Chamorro on 11/05/2016.
 */
public class PeliculaAdapter
        extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    Context context;
    List<Item> data;

    public PeliculaAdapter(Context context, List<Item> data) {
        this.context = context;
        this.data = data;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        RecyclerView.ViewHolder viewHolder = null;

        if(viewType == Item.TYPE_PELICULA){
            View v = View.inflate(context, R.layout.template_pelicula, null);
            viewHolder = new PeliculaViewHolder(v);
        }else{
            View v = View.inflate(context, R.layout.template_promocion, null);
            viewHolder = new PromocionViewHolder(v);
        }

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        Item i = data.get(position);
        if(i.getType() == Item.TYPE_PELICULA){
            Pelicula p = (Pelicula) i;
            ((PeliculaViewHolder) holder).binding.setPelicula(p);
        }else{
            Promocion p = (Promocion) i;
            ((PromocionViewHolder)holder).binding.setPromo(p);
        }

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    @Override
    public int getItemViewType(int position) {
        return data.get(position).getType();
    }

    //region View Holder
    static class PeliculaViewHolder extends RecyclerView.ViewHolder{

        TemplatePeliculaBinding binding;

        public PeliculaViewHolder(View itemView) {
            super(itemView);
            binding = TemplatePeliculaBinding.bind(itemView);
        }
    }
    static class PromocionViewHolder extends RecyclerView.ViewHolder{

        TemplatePromocionBinding binding;

        public PromocionViewHolder(View itemView) {
            super(itemView);
            binding = TemplatePromocionBinding.bind(itemView);
        }
    }
    //endregion

}
