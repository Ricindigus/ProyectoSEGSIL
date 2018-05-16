package pe.edu.fisi.unmsm.proyectosegsil;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

import pe.edu.fisi.unmsm.proyectosegsil.R;
import pe.edu.fisi.unmsm.proyectosegsil.pojos.Usuario;

public class SilabusMenuActivity extends AppCompatActivity {
    FirebaseAuth firebaseAuth;
    FirebaseFirestore db;
    TextView txtNombre;
    TextView txtApellido;
    RecyclerView recyclerView;
    String TAG = "FIRESTORE";
    Toolbar myToolbar;
    FirestoreRecyclerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_silabus_menu);

        firebaseAuth = FirebaseAuth.getInstance();
        db = FirebaseFirestore.getInstance();

        myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        recyclerView = (RecyclerView) findViewById(R.id.silabus_recycler);
        txtNombre = (TextView)findViewById(R.id.silabus_txtNombre);
        txtApellido = (TextView)findViewById(R.id.silabus_txtApellido);


        Bundle bundle = getIntent().getExtras();
        txtNombre.setText(bundle.getString("nombre"));
        txtApellido.setText(bundle.getString("apellido"));

        setSupportActionBar(myToolbar);
        getSupportActionBar().setTitle("REGISTRAR SILABUS");
        myToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
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

    public void cerrarSesion(){
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("¿DESEA CERRAR SESIÓN?");
        builder.setNegativeButton("CANCELAR", null);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                firebaseAuth.getInstance().signOut();
                Intent intent = new Intent(SilabusMenuActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
                dialog.dismiss();
            }
        });
        final AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
}
