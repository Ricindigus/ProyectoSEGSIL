package pe.edu.fisi.unmsm.proyectosegsil.fragments;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

import pe.edu.fisi.unmsm.proyectosegsil.CursoHolder;
import pe.edu.fisi.unmsm.proyectosegsil.R;
import pe.edu.fisi.unmsm.proyectosegsil.pojos.Curso;

/**
 * A simple {@link Fragment} subclass.
 */
public class SemanasFragment extends Fragment {


    public SemanasFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        return inflater.inflate(R.layout.fragment_semanas, container, false);


    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Query query = FirebaseFirestore.getInstance().collection("unidades");

        FirestoreRecyclerOptions<Curso> options = new FirestoreRecyclerOptions.Builder<Curso>()
                .setQuery(query, Curso.class)
                .build();

        FirestoreRecyclerAdapter adapter = new FirestoreRecyclerAdapter<Curso, CursoHolder>(options) {
            @Override
            public void onBindViewHolder(@NonNull CursoHolder holder, int position, Curso model) {
                // Bind the Chat object to the ChatHolder
                // ...

            }

            @Override
            public CursoHolder onCreateViewHolder(ViewGroup group, int i) {
                View view = LayoutInflater.from(group.getContext()).inflate(R.layout.item_unidad, group, false);
                return new CursoHolder(view);
            }
        };
    }
}
