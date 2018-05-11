package pe.edu.fisi.unmsm.proyectosegsil;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.firebase.auth.FirebaseAuth;

import java.util.Timer;
import java.util.TimerTask;

import pe.edu.fisi.unmsm.proyectosegsil.administrador.AdminActivity;
import pe.edu.fisi.unmsm.proyectosegsil.administrador.GestionUsuariosActivity;

public class SplashActivity extends AppCompatActivity {
    private final int tiempoEspera = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
        if (firebaseAuth.getCurrentUser() != null){
            Intent intent = new Intent(getApplicationContext(),BienvenidoActivity.class);
            startActivity(intent);
            finish();
        }else{
            TimerTask timerTask = new TimerTask() {
                @Override
                public void run() {
                    Intent intent = new Intent(getApplicationContext(),LoginActivity.class);
                    startActivity(intent);
                    finish();
                }
            };
            Timer timer = new Timer();
            timer.schedule(timerTask, tiempoEspera);
        }


    }
}
