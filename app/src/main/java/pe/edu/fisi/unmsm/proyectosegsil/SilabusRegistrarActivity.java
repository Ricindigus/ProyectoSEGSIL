package pe.edu.fisi.unmsm.proyectosegsil;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

import de.hdodenhof.circleimageview.CircleImageView;
import pe.edu.fisi.unmsm.proyectosegsil.R;
import pe.edu.fisi.unmsm.proyectosegsil.fragments.UnidadesFragment;

public class SilabusRegistrarActivity extends AppCompatActivity {
    FirebaseAuth firebaseAuth;
    FirebaseFirestore db;

    ImageView btnVolver;
    ImageView btnAnterior;
    ImageView btnSiguiente;
    ImageView btnSalir;

    TextView txtTituloFragment;
    TextView txtNombreCurso;
    String idCurso;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_silabus_registro);

        btnAnterior = (ImageView) findViewById(R.id.registro_silabus_btnAnterior);
        btnSiguiente = (ImageView) findViewById(R.id.registro_silabus_btnSiguiente);
        btnSalir = (ImageView) findViewById(R.id.registro_silabus_btnSalir);
        btnVolver = (ImageView) findViewById(R.id.registro_silabus_btnVolver);
        txtTituloFragment = (TextView) findViewById(R.id.registro_silabus_txtTituloFragment);
        txtNombreCurso = (TextView) findViewById(R.id.registro_silabus_nombre_curso);


        firebaseAuth = FirebaseAuth.getInstance();
        db = FirebaseFirestore.getInstance();

        Bundle bundle = getIntent().getExtras();
        txtNombreCurso.setText(bundle.getString("nombre_curso"));
        idCurso = bundle.getString("id_curso");

        btnSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cerrarSesion();
            }
        });

        btnVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        setFragment(0);
    }


    public void cerrarSesion(){
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("¿DESEA CERRAR SESIÓN?");
        builder.setNegativeButton("CANCELAR", null);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                firebaseAuth.getInstance().signOut();
                Intent intent = new Intent(SilabusRegistrarActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
                dialog.dismiss();
            }
        });
        final AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }


    public void setFragment(int numFragment){
        FragmentManager fragmentManager =  getSupportFragmentManager();
        FragmentTransaction fragmentTransaction =  fragmentManager.beginTransaction();
        switch (numFragment){
            case 0:
                UnidadesFragment unidadesFragment =  new UnidadesFragment(idCurso,SilabusRegistrarActivity.this);
                fragmentTransaction.replace(R.id.layout_fragment,unidadesFragment);
                break;
            case 1:break;
            case 2:break;
        }
        fragmentTransaction.commit();
    }

}
