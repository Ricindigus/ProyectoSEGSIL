package pe.edu.fisi.unmsm.proyectosegsil;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class CursoHolder extends RecyclerView.ViewHolder{
    CardView cardView;
    TextView txtEap;
    TextView txtNombre1;
    TextView txtNombre2;
    TextView txtCoordinador;

    public CursoHolder(View itemView) {
        super(itemView);
        cardView = (CardView) itemView.findViewById(R.id.item_curso_cv);
        txtEap = (TextView) itemView.findViewById(R.id.item_curso_eap);
        txtNombre1 = (TextView) itemView.findViewById(R.id.item_curso_nombre1);
        txtNombre2 = (TextView) itemView.findViewById(R.id.item_curso_nombre2);
        txtCoordinador = (TextView) itemView.findViewById(R.id.item_curso_coordinador);

    }

    public CardView getCardView() {
        return cardView;
    }

    public void setCardView(CardView cardView) {
        this.cardView = cardView;
    }

    public TextView getTxtEap() {
        return txtEap;
    }

    public void setTxtEap(TextView txtEap) {
        this.txtEap = txtEap;
    }

    public TextView getTxtNombre1() {
        return txtNombre1;
    }

    public void setTxtNombre1(TextView txtNombre1) {
        this.txtNombre1 = txtNombre1;
    }

    public TextView getTxtNombre2() {
        return txtNombre2;
    }

    public void setTxtNombre2(TextView txtNombre2) {
        this.txtNombre2 = txtNombre2;
    }

    public TextView getTxtCoordinador() {
        return txtCoordinador;
    }

    public void setTxtCoordinador(TextView txtCoordinador) {
        this.txtCoordinador = txtCoordinador;
    }
}
