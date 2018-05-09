package pe.edu.fisi.unmsm.proyectosegsil.administrador;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

import pe.edu.fisi.unmsm.proyectosegsil.LoginActivity;
import pe.edu.fisi.unmsm.proyectosegsil.R;
import pe.edu.fisi.unmsm.proyectosegsil.pojos.Curso;
import pe.edu.fisi.unmsm.proyectosegsil.pojos.Eap;
import pe.edu.fisi.unmsm.proyectosegsil.pojos.Grupo;
import pe.edu.fisi.unmsm.proyectosegsil.pojos.Persona;
import pe.edu.fisi.unmsm.proyectosegsil.pojos.Plan;
import pe.edu.fisi.unmsm.proyectosegsil.pojos.TipoCurso;
import pe.edu.fisi.unmsm.proyectosegsil.pojos.Usuario;

public class AdminActivity extends AppCompatActivity {

    Button btnCerrarSesion;
    Button btnCargaAcademica;
    Button btnGestionUsuarios;
    FirebaseAuth firebaseAuth;
    FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
        btnCerrarSesion = (Button) findViewById(R.id.admin_btnCerrarSesion);
        btnCargaAcademica = (Button) findViewById(R.id.admin_btnCargaAcademica);
        btnGestionUsuarios = (Button) findViewById(R.id.admin_btnGestion);


        firebaseAuth = FirebaseAuth.getInstance();
        db = FirebaseFirestore.getInstance();


        btnCerrarSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firebaseAuth.getInstance().signOut();
                Intent intent = new Intent(AdminActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });

        btnCargaAcademica.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //CARGA EAPS (***)
                db.collection("eaps").document("SS").set(new Eap("SS","Ingeniería de Sistemas"));
                db.collection("eaps").document("SW").set(new Eap("SW","Ingeniería de Software"));

                //CARGA DE TIPO DE CURSO (***)
                db.collection("tipos").document("T").set(new TipoCurso("T","Teoría"));
                db.collection("tipos").document("P").set(new TipoCurso("P","Practica"));
                db.collection("tipos").document("L").set(new TipoCurso("L","Laboratorio"));


                //CARGA ACADEMICA


                //PLANES
                db.collection("planes").document("SS2009").set(new Plan("2009","SS2009","SS"));
                db.collection("planes").document("SS2014").set(new Plan("2014","SS2014","SS"));
                db.collection("planes").document("SW2009").set(new Plan("2009","SW2009","SW"));
                db.collection("planes").document("SW2015").set(new Plan("2015","SW2015","SW"));

                //PERSONAS
                db.collection("personas").document("dmorales").set(new Persona("dmorales","Denis Morales","ricindigus@gmail.com","984763597"));
                db.collection("personas").document("jgonzales").set(new Persona("jgonzales","Juan Gonzales","jgonzales@gmail.com","999666585"));
                db.collection("personas").document("hvega").set(new Persona("hvega","Hugo Vega","hvega@gmail.com","984763597"));
                db.collection("personas").document("acortez").set(new Persona("acortez","Alberto Cortez","acortez@gmail.com","989685421"));
                db.collection("personas").document("cnavarro").set(new Persona("cnavarro","Carlos Navarro","cnavarro@gmail.com","963525854"));
                db.collection("personas").document("lmota").set(new Persona("lmota","Luis Mota","lmota@gmail.com","985742156"));
                db.collection("personas").document("promero").set(new Persona("promero","Pablo Romero","promero@gmail.com","982547632"));


                //CURSOS
                db.collection("cursos").document("SSAL1").set(new Curso("Algoritmica I","SS","2009","lmota"));
                db.collection("cursos").document("SSAL2").set(new Curso("Algoritmica II","SS","2009","lmota"));
                db.collection("cursos").document("SWBD2").set(new Curso("Base de Datos II","SW","2015","lmota"));

                //GRUPOS
                db.collection("grupos").document("SSAL1G1T").set(new Grupo(1,"SS","2009","Algoritmica I","T","lmota","dmorales"));
                db.collection("grupos").document("SSAL1G1P").set(new Grupo(1,"SS","2009","Algoritmica I","P","lmota","dmorales"));
                db.collection("grupos").document("SSAL1G1L").set(new Grupo(1,"SS","2009","Algoritmica I","L","promero","dmorales"));
                db.collection("grupos").document("SSAL1G2T").set(new Grupo(2,"SS","2009","Algoritmica I","T","promero","bromero"));
                db.collection("grupos").document("SSAL1G2P").set(new Grupo(2,"SS","2009","Algoritmica I","P","promero","bromero"));
                db.collection("grupos").document("SSAL1G2L").set(new Grupo(2,"SS","2009","Algoritmica I","L","lmota","bromero"));
            }
        });


        btnGestionUsuarios.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //CARGA USUARIOS (esto se hace en gestion de usuarios)
                db.collection("usuarios").document("jgonzales").set(new Usuario("jgonzales",2));
                db.collection("usuarios").document("hvega").set(new Usuario("hvega",2));
                db.collection("usuarios").document("acortez").set(new Usuario("acortez",3));
                db.collection("usuarios").document("cnavarro").set(new Usuario("cnavarro",4));
                db.collection("usuarios").document("lmota").set(new Usuario("lmota",5));
                db.collection("usuarios").document("promero").set(new Usuario("promero",6));
                db.collection("usuarios").document("dmorales").set(new Usuario("dmorales",7));
            }
        });

    }


}
