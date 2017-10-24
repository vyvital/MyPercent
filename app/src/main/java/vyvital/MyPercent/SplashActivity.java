package vyvital.MyPercent;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);
        Thread splash = new Thread() {
            public void run() {
                try {
                    sleep(3 * 1000);
                    Intent i = new Intent(getBaseContext(), MainActivity.class);
                    startActivity(i);
                    finish();
                } catch (Exception e) {
                    // Letting the activity stay for 3000ms then starting MainActivity
                }
            }
        };
        splash.start();
    }
}