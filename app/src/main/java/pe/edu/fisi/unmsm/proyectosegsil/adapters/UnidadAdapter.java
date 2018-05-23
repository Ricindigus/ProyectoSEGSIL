package pe.edu.fisi.unmsm.proyectosegsil.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import pe.edu.fisi.unmsm.proyectosegsil.R;
import pe.edu.fisi.unmsm.proyectosegsil.pojos.Unidad;

public class UnidadAdapter extends RecyclerView.Adapter<UnidadAdapter.ViewHolder>{
    Context context;
    ArrayList<Unidad> unidades;

    public UnidadAdapter(Context context, ArrayList<Unidad> unidades) {
        this.context = context;
        this.unidades = unidades;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_unidad, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.txtNumero.setText(unidades.get(position).getNumero()+"");
        holder.txtNombre.setText(unidades.get(position).getNombre());
        holder.txtSemanas.setText(unidades.get(position).getSemanas()+"");
    }

    @Override
    public int getItemCount() {
        return unidades.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        CardView cv;
        TextView txtNumero;
        TextView txtNombre;
        TextView txtSemanas;

        public ViewHolder(View itemView) {
            super(itemView);

            cv =  (CardView) itemView.findViewById(R.id.item_unidad_cv);
            txtNumero =  (TextView) itemView.findViewById(R.id.item_unidad_numero);
            txtNombre =  (TextView) itemView.findViewById(R.id.item_unidad_nombre);
            txtSemanas =  (TextView) itemView.findViewById(R.id.item_unidad_semanas);

        }
    }
}
