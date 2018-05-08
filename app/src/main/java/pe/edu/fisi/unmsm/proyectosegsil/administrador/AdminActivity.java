package pe.edu.fisi.unmsm.proyectosegsil.administrador;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

import pe.edu.fisi.unmsm.proyectosegsil.LoginActivity;
import pe.edu.fisi.unmsm.proyectosegsil.R;

public class AdminActivity extends AppCompatActivity {

    Button btnCerrarSesion;
    FirebaseAuth firebaseAuth;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
        btnCerrarSesion = (Button) findViewById(R.id.admin_btnCerrarSesion);
        textView = (TextView) findViewById(R.id.admin_texto_info);

        firebaseAuth = FirebaseAuth.getInstance();
        String email = firebaseAuth.getCurrentUser().getEmail();
        textView.setText(email.substring(0,email.indexOf("@")));

        btnCerrarSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firebaseAuth.getInstance().signOut();
                Intent intent = new Intent(AdminActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }


}
