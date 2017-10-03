package batch16.android.devf.com.recyclerview.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import batch16.android.devf.com.recyclerview.DescriptionActivity;
import batch16.android.devf.com.recyclerview.R;
import batch16.android.devf.com.recyclerview.models.Peso;

/**
 * Created by Dagorik on 02/10/17.
 */

//Pinta genrenal
public class PesoAdapter extends RecyclerView.Adapter<PesoAdapter.PesoViewHolder> {

    public List<Peso> pesosList = new ArrayList<>();

    public PesoAdapter(List<Peso> pesosList) {
        this.pesosList = pesosList;
    }

    //Infla la vista, el xml(list_item.xml) y retorna un nuevo objeto de la clase PesoViewHolder
    @Override
    public PesoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new PesoViewHolder(view);
    }

    //La posiscion en que se encuentra el recycler view, crea el objeto de acuerdo a su posicion y setea los textos.
    @Override
    public void onBindViewHolder(PesoViewHolder pesoHolder, int position) {
        Peso peso = pesosList.get(position);
        pesoHolder.tvFecha.setText(peso.getFecha());
        pesoHolder.tvPeso.setText(peso.getPeso());

    }

    //Devuelve las veces que va a pintar el Recycler view
    @Override
    public int getItemCount() {
        return pesosList.size();
    }

    //Pintar view individual
    public class PesoViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView tvFecha, tvPeso;

        public PesoViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            tvFecha = (TextView) itemView.findViewById(R.id.tv_fecha);
            tvPeso = (TextView) itemView.findViewById(R.id.tv_peso);
        }

        @Override
        public void onClick(View view) {
            Context context = view.getContext();
            int pos = getAdapterPosition();
            Peso peso = pesosList.get(pos);

            Intent intent = new Intent(context, DescriptionActivity.class);
            intent.putExtra("PESO",peso.getPeso());
            context.startActivity(intent);
        }
    }
}
