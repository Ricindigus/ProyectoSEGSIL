package pe.edu.fisi.unmsm.proyectosegsil;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

import pe.edu.fisi.unmsm.proyectosegsil.LoginActivity;
import pe.edu.fisi.unmsm.proyectosegsil.R;
import pe.edu.fisi.unmsm.proyectosegsil.pojos.NombrePersona;
import pe.edu.fisi.unmsm.proyectosegsil.pojos.Perfil;
import pe.edu.fisi.unmsm.proyectosegsil.pojos.Persona;
import pe.edu.fisi.unmsm.proyectosegsil.pojos.Usuario;

public class AdminActivity extends AppCompatActivity {
    FirebaseAuth firebaseAuth;
    FirebaseFirestore db;
    TextView txtUsuario;
    FloatingActionButton fab;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
        txtUsuario = (TextView) findViewById(R.id.admin_txtUsuario);
        fab = (FloatingActionButton) findViewById(R.id.admin_fab);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        getSupportActionBar().setTitle("CONTROL DE USUARIOS");

        myToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        Bundle bundle = getIntent().getExtras();
        txtUsuario.setText(bundle.getString("usuario"));

        firebaseAuth = FirebaseAuth.getInstance();
        db = FirebaseFirestore.getInstance();

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db.collection("usuarios").document("jgonzales").set(
                        new Usuario(
                                "jgonzales",
                                new NombrePersona("Juan","Gonzales"),
                                "123456",
                                new Perfil(false,true,false,false,false,false,false)
                        )
                );
                db.collection("personas").document("jgonzales").set(
                        new Persona(
                                "jgonzales",
                                new NombrePersona("Juan Alberto","Gonzales Gutierrez"),
                                "jgonzales@sistemas.edu.pe",
                                "974654321"
                        )
                );
                db.collection("usuarios").document("hvega").set(
                        new Usuario(
                                "hvega",
                                new NombrePersona("Hugo","Vega"),
                                "123456",
                                new Perfil(false,true,false,false,false,false,false)
                        )
                );
                db.collection("personas").document("hvega").set(
                        new Persona(
                                "hvega",
                                new NombrePersona("Hugo Alonso","Vega Alfaro"),
                                "hvega@sistemas.edu.pe",
                                "974653321"
                        )
                );
                db.collection("usuarios").document("acortez").set(
                        new Usuario(
                                "acortez",
                                new NombrePersona("Alberto","Cortez"),
                                "123456",
                                new Perfil(false,false,false,true,false,false,false)
                        )
                );
                db.collection("personas").document("acortez").set(
                        new Persona(
                                "acortez",
                                new NombrePersona("Alberto Alonso","Cortez Suarez"),
                                "acortez@sistemas.edu.pe",
                                "978937421"
                        )
                );
                db.collection("usuarios").document("cnavarro").set(
                        new Usuario(
                                "cnavarro",
                                new NombrePersona("Carlos","Navarro"),
                                "123456",
                                new Perfil(false,false,false,true,false,false,false)
                        )
                );
                db.collection("personas").document("cnavarro").set(
                        new Persona(
                                "cnavarro",
                                new NombrePersona("Carlos Benito","Navarro Cabezas"),
                                "cnavarro@sistemas.edu.pe",
                                "978937333"
                        )
                );
                db.collection("usuarios").document("lmota").set(
                        new Usuario(
                                "lmota",
                                new NombrePersona("Luis","Mota"),
                                "123456",
                                new Perfil(false,false,false,false,true,false,false)
                        )
                );
                db.collection("personas").document("lmota").set(
                        new Persona(
                                "lmota",
                                new NombrePersona("Luis Angel","Mota Meza"),
                                "lmota@sistemas.edu.pe",
                                "978447333"
                        )
                );
                db.collection("usuarios").document("promero").set(
                        new Usuario(
                                "promero",
                                new NombrePersona("Pablo","Romero"),
                                "123456",
                                new Perfil(false,false,false,false,false,true,false)
                        )
                );
                db.collection("personas").document("promero").set(
                        new Persona(
                                "promero",
                                new NombrePersona("Pablo Agustin","Romero Beltran"),
                                "promero@sistemas.edu.pe",
                                "978441234"
                        )
                );
                db.collection("usuarios").document("dmorales").set(
                        new Usuario(
                                "dmorales",
                                new NombrePersona("Denis","Morales"),
                                "123456",
                                new Perfil(false,false,false,false,false,false,true)
                        )
                );
                db.collection("personas").document("dmorales").set(
                        new Persona(
                                "dmorales",
                                new NombrePersona("Denis Ricardo","Morales Retamozo"),
                                "dmorales@sistemas.edu.pe",
                                "978447662"
                        )
                );
            }
        });

//        btnCerrarSesion.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                firebaseAuth.getInstance().signOut();
//                Intent intent = new Intent(AdminActivity.this, LoginActivity.class);
//                startActivity(intent);
//                finish();
//            }
//        });

//        btnCargaAcademica.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //CARGA EAPS (***)
//                db.collection("eaps").document("SS").set(new Eap("SS","Ingeniería de Sistemas"));
//                db.collection("eaps").document("SW").set(new Eap("SW","Ingeniería de Software"));
//
//                //CARGA DE TIPO DE CURSO (***)
//                db.collection("tipos").document("T").set(new TipoCurso("T","Teoría"));
//                db.collection("tipos").document("P").set(new TipoCurso("P","Practica"));
//                db.collection("tipos").document("L").set(new TipoCurso("L","Laboratorio"));
//
//                //CARGA PERFILES (***)
//                db.collection("perfiles").document("1").set(new Perfil(1,"administrador"));
//                db.collection("perfiles").document("2").set(new Perfil(2,"decanato"));
//                db.collection("perfiles").document("3").set(new Perfil(3,"director_ss"));
//                db.collection("perfiles").document("4").set(new Perfil(4,"director_sw"));
//                db.collection("perfiles").document("5").set(new Perfil(5,"coordinador"));
//                db.collection("perfiles").document("6").set(new Perfil(6,"profesor"));
//                db.collection("perfiles").document("7").set(new Perfil(7,"delegado"));
//
//                //PLANES (***)
//                db.collection("planes").document("ss2009").set(new Plan("2009","ss2009","SS"));
//                db.collection("planes").document("ss2014").set(new Plan("2014","ss2014","SS"));
//                db.collection("planes").document("sw2009").set(new Plan("2009","sw2009","SW"));
//                db.collection("planes").document("sw2015").set(new Plan("2015","sw2015","SW"));


                //CARGA ACADEMICA

                //CURSOS
//                db.collection("cursos").add(
//                        new Curso(
//                                new Eaps(true,false),
//                                new Planes(true,false,false,false),
//                                new String[]{"Algoritmica I"},new Coordinador("lmota","Luis Mota")));
//                db.collection("cursos").add(new Curso("SS","2009","Algoritmica II",new Coordinador("nmunoz","Nehil Muñoz")));
//                db.collection("cursos").add(new Curso("SS","2009","Algoritmica III",new Coordinador("lmota","Luis Mota")));
//                db.collection("cursos").add(new Curso("SW","2015","Base de Datos I",new Coordinador("nmunoz","Nehil Muñoz")));
//                db.collection("cursos").add(new Curso("SW","2015","Base de Datos II",new Coordinador("lmota","Luis Mota")));
//
//
//                //GRUPOS
//                db.collection("grupos").whereEqualTo("eap","SS")
//
//                        add(new Grupo(1,"T",new Profesor("lmota","Luis Mota"),new Delegado("dmorales","Denis Morales")));
//                db.collection("grupos").add(new Grupo(1,"T",new Profesor("lmota","Luis Mota"),new Delegado("dmorales","Denis Morales")));
//                db.collection("grupos").add(new Grupo(1,"T",new Profesor("lmota","Luis Mota"),new Delegado("dmorales","Denis Morales")));
//                db.collection("grupos").add(new Grupo(1,"T",new Profesor("lmota","Luis Mota"),new Delegado("dmorales","Denis Morales")));
//                db.collection("grupos").add(new Grupo(1,"T",new Profesor("lmota","Luis Mota"),new Delegado("dmorales","Denis Morales")));
//                db.collection("grupos").add(new Grupo(1,"T",new Profesor("lmota","Luis Mota"),new Delegado("dmorales","Denis Morales")));
//
//                db.collection("grupos").add(new Grupo(1,"SS","2009","Algoritmica I","P","lmota","dmorales"));
//                db.collection("grupos").add(new Grupo(1,"SS","2009","Algoritmica I","L","promero","dmorales"));
//                db.collection("grupos").add(new Grupo(2,"SS","2009","Algoritmica I","T","promero","bromero"));
//                db.collection("grupos").add(new Grupo(2,"SS","2009","Algoritmica I","P","promero","bromero"));
//                db.collection("grupos").add(new Grupo(2,"SS","2009","Algoritmica I","L","lmota","bromero"));
//            }
//        });


//        btnGestionUsuarios.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                Perfil p1 =  new Perfil(true,false,false,false,false,false,false);
//                Perfil p2 =  new Perfil(false,true,false,false,false,false,false);
//                Perfil p3 =  new Perfil(false,false,true,false,false,false,false);
//                Perfil p4 =  new Perfil(false,false,false,true,false,false,false);
//                Perfil p5 =  new Perfil(false,false,false,false,true,true,false);
//                Perfil p6 =  new Perfil(false,false,false,false,false,true,false);
//                Perfil p7 =  new Perfil(false,false,false,false,false,false,true);
//

//                //USUARIOS
//                db.collection("usuarios").document("dmorales").set(new Usuario("dmorales","Denis", "Morales","ricindigus@gmail.com","984763597",p7));
//                db.collection("usuarios").document("jgonzales").set(new Usuario("jgonzales","Juan","Gonzales","jgonzales@gmail.com","999666585",p2));
//                db.collection("usuarios").document("hvega").set(new Usuario("hvega","Hugo" ,"Vega","hvega@gmail.com","984763597",p2));
//                db.collection("usuarios").document("acortez").set(new Usuario("acortez","Alberto","Cortez","acortez@gmail.com","989685421",p3));
//                db.collection("usuarios").document("cnavarro").set(new Usuario("cnavarro","Carlos", "Navarro","cnavarro@gmail.com","963525854",p4));
//                db.collection("usuarios").document("lmota").set(new Usuario("lmota","Luis", "Mota","lmota@gmail.com","985742156",p5));
//                db.collection("usuarios").document("promero").set(new Usuario("promero","Pablo","Romero","promero@gmail.com","982547632",p6));

//            }
//        });

    }


}
