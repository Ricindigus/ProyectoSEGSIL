package pe.edu.fisi.unmsm.proyectosegsil.fragments;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

import org.w3c.dom.Text;

import pe.edu.fisi.unmsm.proyectosegsil.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class UnidadesFragment extends Fragment {
    TextView txtCoordinador;
    TextView txtNombre1;
    TextView txtNombre2;
    FloatingActionButton fab;
    FirebaseFirestore db;
    String idCurso;


    public UnidadesFragment() {
        // Required empty public constructor
    }

    @SuppressLint("ValidFragment")
    public UnidadesFragment(String idCurso) {
        this.idCurso = idCurso;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_unidades, container, false);
        txtCoordinador = (TextView) rootView.findViewById(R.id.unidades_fragment_txtCoordinador);
        txtNombre1 = (TextView) rootView.findViewById(R.id.unidades_fragment_txtNombreCurso1);
        txtNombre2 = (TextView) rootView.findViewById(R.id.unidades_fragment_txtNombreCurso2);
        fab = (FloatingActionButton) rootView.findViewById(R.id.unidades_fragment_fab);
        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        db = FirebaseFirestore.getInstance();

    }
}
