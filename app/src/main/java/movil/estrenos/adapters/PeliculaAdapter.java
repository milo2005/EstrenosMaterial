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
        extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements View.OnClickListener {

    public interface OnItemClickAdapter{
        void onClick(View v);
    }

    Context context;
    List<Item> data;
    OnItemClickAdapter onItemClickAdapter;

    public PeliculaAdapter(Context context, List<Item> data
            , OnItemClickAdapter onItemClickAdapter) {
        this.context = context;
        this.data = data;
        this.onItemClickAdapter = onItemClickAdapter;
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
            PeliculaViewHolder h = (PeliculaViewHolder) holder;
            h.binding.setPelicula(p);
            h.binding.getRoot().setOnClickListener(this);

        }else{
            Promocion p = (Promocion) i;
            PromocionViewHolder h = (PromocionViewHolder) holder;
            h.binding.setPromo(p);
            h.binding.getRoot().setOnClickListener(this);
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

    @Override
    public void onClick(View v) {
        onItemClickAdapter.onClick(v);
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
