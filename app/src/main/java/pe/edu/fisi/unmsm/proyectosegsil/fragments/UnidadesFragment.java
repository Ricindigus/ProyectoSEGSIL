package pe.edu.fisi.unmsm.proyectosegsil.fragments;


import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.InputFilter;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import pe.edu.fisi.unmsm.proyectosegsil.NumericKeyBoardTransformationMethod;
import pe.edu.fisi.unmsm.proyectosegsil.R;

import pe.edu.fisi.unmsm.proyectosegsil.adapters.UnidadAdapter;
import pe.edu.fisi.unmsm.proyectosegsil.pojos.Silabus;
import pe.edu.fisi.unmsm.proyectosegsil.pojos.Unidad;

/**
 * A simple {@link Fragment} subclass.
 */
public class UnidadesFragment extends Fragment {
    TextView txtCoordinador;
    TextView txtNombre1;
    TextView txtNombre2;
    FloatingActionButton fab;
    RecyclerView recyclerView;
    FirebaseFirestore db;
    FirebaseAuth firebaseAuth;
    String idCurso;
    Context contexto;
    String TAG = "FIRESTORE";
    UnidadAdapter unidadAdapter;
    ArrayList<Unidad> unidades;


    public UnidadesFragment() {
        // Required empty public constructor
    }

    @SuppressLint("ValidFragment")
    public UnidadesFragment(String idCurso, Context contexto) {
        this.idCurso = idCurso;
        this.contexto = contexto;
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
        recyclerView = (RecyclerView) rootView.findViewById(R.id.unidades_fragment_recycler);
        return rootView;
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        firebaseAuth = FirebaseAuth.getInstance();
        db = FirebaseFirestore.getInstance();
        unidades =  new ArrayList<>();
        db.collection("silabus").document(idCurso).collection("unidades")
                .addSnapshotListener(new EventListener<QuerySnapshot>() {
                    @Override
                    public void onEvent(@Nullable QuerySnapshot value,
                                        @Nullable FirebaseFirestoreException e) {
                        if (e != null) {
                            Log.w(TAG, "Listen failed.", e);
                            return;
                        }

                        unidades.clear();
                        for (DocumentSnapshot doc : value) {
                            unidades.add(doc.toObject(Unidad.class));
                        }
                        unidadAdapter.notifyDataSetChanged();
                        Log.d(TAG, "Current cites in CA: " + unidades);
                    }
                });
        unidadAdapter = new UnidadAdapter(contexto,unidades);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(contexto);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(unidadAdapter);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alert = new AlertDialog.Builder(getActivity());
                final View dialogView = getActivity().getLayoutInflater().inflate(R.layout.dialog_unidades, null);
                final TextInputEditText edtNombreUnidad = dialogView.findViewById(R.id.dialog_unidades_edtNombreUnidad);
                final Spinner spNumeroSemanas = dialogView.findViewById(R.id.dialog_unidades_spNumeroSemanas);
                edtNombreUnidad.setFilters(new InputFilter[]{new InputFilter.AllCaps()});
                alert.setTitle("DATOS DE LA UNIDAD");
                alert.setView(dialogView);
                alert.setNegativeButton("CANCELAR",null);
                alert.setPositiveButton("ACEPTAR", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Silabus silabus =  new Silabus(idCurso);
                        Unidad unidad = new Unidad(unidades.size()+1,edtNombreUnidad.getText().toString(),spNumeroSemanas.getSelectedItemPosition()+1);
                        db.collection("silabus").document(idCurso)
                                .set(silabus)
                                .addOnSuccessListener(new OnSuccessListener<Void>() {
                                    @Override
                                    public void onSuccess(Void aVoid) {
                                        Log.d(TAG, "DocumentSnapshot successfully written!");
                                    }
                                })
                                .addOnFailureListener(new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {
                                        Log.w(TAG, "Error writing document", e);
                                    }
                                });
                        db.collection("silabus").document(idCurso).collection("unidades").document((unidades.size()+1)+"")
                                .set(unidad)
                                .addOnSuccessListener(new OnSuccessListener<Void>() {
                                    @Override
                                    public void onSuccess(Void aVoid) {
                                        Log.d(TAG, "DocumentSnapshot successfully written!");
                                    }
                                })
                                .addOnFailureListener(new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {
                                        Log.w(TAG, "Error writing document", e);
                                    }
                                });
                    }
                });
                final AlertDialog alertDialog = alert.create();

                alertDialog.setOnShowListener(new DialogInterface.OnShowListener() {
                    @Override
                    public void onShow(DialogInterface dialogInterface) {
                        int numero = 0;
                        for (int i = 0; i < unidades.size(); i++) {
                            numero = numero + unidades.get(i).getSemanas();
                        }
                        numero = 14 - numero;
                        ArrayList<String> lista =  new ArrayList<>();
                        for (int i = 1; i <= numero; i++) {
                            lista.add((i)+"");
                        }
                        ArrayAdapter<String> adapter = new ArrayAdapter<String>(contexto, android.R.layout.simple_spinner_item,lista);
                        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        spNumeroSemanas.setAdapter(adapter);
                    }
                });
                alertDialog.show();
            }
        });

    }

    public void cargaData(){
        unidades =  new ArrayList<>();
        db.collection("silabus").document(idCurso).collection("unidades").get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (DocumentSnapshot document : task.getResult()) {
                                Log.d(TAG, document.getId() + " => " + document.toObject(Unidad.class));
                                unidades.add(document.toObject(Unidad.class));
                            }
                            unidadAdapter.notifyDataSetChanged();
                        } else {
                            Log.d(TAG, "Error getting documents: ", task.getException());
                        }
                    }
                });
    }

}
