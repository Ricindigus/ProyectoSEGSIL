package pe.edu.fisi.unmsm.proyectosegsil;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class UsuarioHolder extends RecyclerView.ViewHolder{
    CardView cardView;
    TextView txtId;
    TextView txtNombre;
    TextView txtPerfil;
    public UsuarioHolder(View itemView) {
        super(itemView);

        cardView = (CardView) itemView.findViewById(R.id.item_usuario_cv);
        txtId = (TextView) itemView.findViewById(R.id.item_usuario_id);
        txtNombre = (TextView) itemView.findViewById(R.id.item_usuario_nombre);
        txtPerfil = (TextView) itemView.findViewById(R.id.item_usuario_perfil);

    }
}
