package pe.edu.fisi.unmsm.proyectosegsil;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

import pe.edu.fisi.unmsm.proyectosegsil.R;
import pe.edu.fisi.unmsm.proyectosegsil.pojos.Curso;

public class DirectorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_director);

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
