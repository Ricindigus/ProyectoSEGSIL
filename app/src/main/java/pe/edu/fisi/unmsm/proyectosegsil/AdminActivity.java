package pe.edu.fisi.unmsm.proyectosegsil;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;

import pe.edu.fisi.unmsm.proyectosegsil.pojos.Curso;
import pe.edu.fisi.unmsm.proyectosegsil.pojos.NombreCurso;
import pe.edu.fisi.unmsm.proyectosegsil.pojos.Perfil;
import pe.edu.fisi.unmsm.proyectosegsil.pojos.Persona;
import pe.edu.fisi.unmsm.proyectosegsil.pojos.Usuario;

public class AdminActivity extends AppCompatActivity {
    FirebaseAuth firebaseAuth;
    FirebaseFirestore db;
    TextView txtNombre;
    TextView txtApellido;
    FloatingActionButton fab;
    RecyclerView recyclerView;
    String TAG = "FIRESTORE";
    FirestoreRecyclerOptions<Usuario> opciones;
    FirestoreRecyclerAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        firebaseAuth = FirebaseAuth.getInstance();
        db = FirebaseFirestore.getInstance();

        txtNombre = (TextView) findViewById(R.id.admin_txtNombre);
        txtApellido = (TextView) findViewById(R.id.admin_txtApellido);
        fab = (FloatingActionButton) findViewById(R.id.admin_fab);
        recyclerView = (RecyclerView) findViewById(R.id.admin_recycler);

        Bundle bundle = getIntent().getExtras();
        txtNombre.setText(bundle.getString("nombre"));
        txtApellido.setText(bundle.getString("apellido"));


        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        getSupportActionBar().setTitle("GESTIONAR USUARIOS");
        myToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        Query query = db.collection("usuarios");
        query.get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (DocumentSnapshot document : task.getResult()) {
                                Log.d(TAG, document.getId() + " => " + document.getData());
                            }
                        } else {
                            Log.d(TAG, "Error getting documents: ", task.getException());
                        }
                    }
                });

        opciones = new FirestoreRecyclerOptions.Builder<Usuario>().setQuery(query, Usuario.class).build();
        adapter =  new  FirestoreRecyclerAdapter < Usuario , UsuarioHolder > (opciones) {
            @Override
            public void onBindViewHolder(UsuarioHolder holder, int position, Usuario model) {
                holder.txtId.setText(model.getId().toString());
                holder.txtNombre.setText(model.getNombres().toString() + " "+ model.getApellidos().toString());
                holder.txtPerfil.setText(model.getPerfil().toString());
            }

            @Override
            public UsuarioHolder onCreateViewHolder(ViewGroup group, int i) {
                View view = LayoutInflater.from(group.getContext()).inflate(R.layout.item_usuario, group, false);
                return new UsuarioHolder(view);
            }
        };

        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cargaUsuarios();
                cargaCursos();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_app, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.menu_cerrar_sesion:
                cerrarSesion();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


    @Override
    protected void onStart() {
        super.onStart();
        adapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        adapter.stopListening();
    }

    public void mostrarMensaje(String m){
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(m);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                dialog.dismiss();
            }
        });
        final AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    public void cerrarSesion(){
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("¿DESEA CERRAR SESIÓN?");
        builder.setNegativeButton("CANCELAR", null);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                firebaseAuth.getInstance().signOut();
                Intent intent = new Intent(AdminActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
                dialog.dismiss();
            }
        });
        final AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    public void cargaUsuarios(){
        db.collection("usuarios").document("jgonzales").set(new Usuario("jgonzales","Juan Alberto","Gonzales Gutierrez", "123456", new Perfil(false,true,false,false,false,false,false)));
        db.collection("personas").document("jgonzales").set(new Persona("jgonzales", "Juan Alberto","Gonzales Gutierrez", "jgonzales@sistemas.edu.pe", "974654321"));
        db.collection("usuarios").document("hvega").set(new Usuario("hvega", "Hugo Alonso","Vega Alfaro", "123456", new Perfil(false,true,false,false,false,false,false)));
        db.collection("personas").document("hvega").set(new Persona("hvega", "Hugo Alonso","Vega Alfaro", "hvega@sistemas.edu.pe", "974653321"));
        db.collection("usuarios").document("acortez").set(new Usuario("acortez", "Alberto Alonso","Cortez Suarez", "123456", new Perfil(false,false,false,true,false,false,false)));
        db.collection("personas").document("acortez").set(new Persona("acortez", "Alberto Alonso","Cortez Suarez", "acortez@sistemas.edu.pe", "978937421"));
        db.collection("usuarios").document("cnavarro").set(new Usuario("cnavarro", "Carlos Benito","Navarro Cabezas", "123456", new Perfil(false,false,false,true,false,false,false)));
        db.collection("personas").document("cnavarro").set(new Persona("cnavarro", "Carlos Benito","Navarro Cabezas", "cnavarro@sistemas.edu.pe", "978937333"));
        db.collection("usuarios").document("lmota").set(new Usuario("lmota", "Luis Angel","Mota Meza", "123456", new Perfil(false,false,false,false,true,false,false)));
        db.collection("personas").document("lmota").set(new Persona("lmota", "Luis Angel","Mota Meza", "lmota@sistemas.edu.pe", "978447333"));
        db.collection("usuarios").document("promero").set(new Usuario("promero", "Pablo Agustin","Romero Beltran", "123456", new Perfil(false,false,false,false,false,true,false)));
        db.collection("personas").document("promero").set(new Persona("promero", "Pablo Agustin","Romero Beltran", "promero@sistemas.edu.pe", "978441234"));
        db.collection("usuarios").document("dmorales").set(new Usuario("dmorales", "Denis Ricardo","Morales Retamozo", "123456", new Perfil(false,false,false,false,false,false,true)));
        db.collection("personas").document("dmorales").set(new Persona("dmorales", "Denis Ricardo","Morales Retamozo", "dmorales@sistemas.edu.pe", "978447662"));

        db.collection("usuarios").document("smurakami").set(new Usuario("smurakami", "Sumiko","Murakami Cruz", "123456", new Perfil(false,false,false,false,true,true,false)));
        db.collection("personas").document("smurakami").set(new Persona("smurakami", "Sumiko","Murakami Cruz", "smurakami@sistemas.edu.pe", "978447662"));
        db.collection("usuarios").document("fescobedo").set(new Usuario("fescobedo", "Frank Edmundo","Escobedo Bailon", "123456", new Perfil(false,false,false,false,true,true,false)));
        db.collection("personas").document("fescobedo").set(new Persona("fescobedo", "Frank Edmundo","Escobedo Bailon", "fescobedo@sistemas.edu.pe", "978447662"));
        db.collection("usuarios").document("wchalco").set(new Usuario("wchalco", "walter","Chalco Arangonita", "123456", new Perfil(false,false,false,false,true,true,false)));
        db.collection("personas").document("wchalco").set(new Persona("wchalco", "walter","Chalco Arangonita","wchalco@sistemas.edu.pe", "978447662"));
        db.collection("usuarios").document("rsolis").set(new Usuario("rsolis", "Rolando","Solis Narro", "123456", new Perfil(false,false,false,false,true,true,false)));
        db.collection("personas").document("rsolis").set(new Persona("rsolis", "Rolando","Solis Narro", "rsolis@sistemas.edu.pe", "978447662"));
        db.collection("usuarios").document("wacuna").set(new Usuario("wacuna", "Walter","Acuña Montañez", "123456", new Perfil(false,false,false,false,true,true,false)));
        db.collection("personas").document("wacuna").set(new Persona("wacuna", "Walter","Acuña Montañez", "wacuna@sistemas.edu.pe", "978447662"));
        db.collection("usuarios").document("lcachi").set(new Usuario("lcachi", "Luis","Cachi Montoya", "123456", new Perfil(false,false,false,false,true,true,false)));
        db.collection("personas").document("lcachi").set(new Persona("lcachi", "Luis","Cachi Montoya",  "lcachi@sistemas.edu.pe", "978447662"));
        db.collection("usuarios").document("cmora").set(new Usuario("cmora", "Carlos Abel","Mora Zavala", "123456", new Perfil(false,false,false,false,true,true,false)));
        db.collection("personas").document("cmora").set(new Persona("cmora", "Carlos Abel","Mora Zavala", "cmora@sistemas.edu.pe", "978447662"));


    }

    public void cargaCursos(){
        db.collection("cursos").document("sscompinf").set(new Curso("sscompinf","SS",new NombreCurso("(2014)INTRODUCCIÓN A LA  COMPUTACION","(2009)COMPUTACION E INFORMATICA"),"smurakami","MURAKAMI CRUZ SUMIKO"));
        db.collection("cursos").document("ssteosis").set(new Curso("ssteosis","SS",new NombreCurso("(2014)TEORIA DE SISTEMAS","(2009)TEORÍA GENERAL DE SISTEMAS"),"fescobedo","ESCOBEDO BAILON FRANK EDMUNDO"));
        db.collection("cursos").document("sscomdin").set(new Curso("sscomdin","SS",new NombreCurso("(2014)COMUNICACIÓN Y DINÁMICA DE GRUPO","(2009)TALLER DE TÉCNICAS DE ESTUDIO"),"wchalco","CHALCO ARANGONITA WALTER"));
        db.collection("cursos").document("ssestapinv").set(new Curso("ssestapinv","SS",new NombreCurso("(2014) ESTRATÉGIAS DE APRENDIZAJE E INVESTIGACIÓN",""),"rsolis","SOLIS NARRO ROLANDO"));
        db.collection("cursos").document("sscalc1").set(new Curso("sscalc1","SS",new NombreCurso("(2014)CÁLCULO I","(2009)CÁLCULO I"),"wacuna","ACUÑA MONTAÑEZ, WALTER"));
        db.collection("cursos").document("ssmatbas1").set(new Curso("ssmatbas1","SS",new NombreCurso("(2014)MATEMÁTICA BÁSICA I","(2009)MATEMÁTICA BÁSICA I"),"lcachi","CACHI MONTOYA LUIS"));
        db.collection("cursos").document("sseticpro").set(new Curso("sseticpro","SS",new NombreCurso("(2014) ÉTICA DE LA PROFESIÓN",""),"cmora","CARLOS ABEL MORA ZAVALA"));
    }
}
