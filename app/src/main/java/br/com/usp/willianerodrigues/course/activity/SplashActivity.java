package br.com.usp.willianerodrigues.course.activity;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.sql.SQLException;

import br.com.usp.willianerodrigues.course.CourseApplication;
import br.com.usp.willianerodrigues.course.R;
import br.com.usp.willianerodrigues.course.model.Usuario;

public class SplashActivity extends AppCompatActivity implements Runnable{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        new Handler().postDelayed(this, 1500);

    }

    @Override
    public void run() {
        CourseApplication application = (CourseApplication) getApplicationContext();
        try {
            Usuario usuario = application.getUserActive();
            Intent intent;
            if(usuario != null){
                intent = new Intent(this, MainActivity.class);
            }else{
                intent = new Intent(this, PresentationActivity.class);
            }
            startActivity(intent);
            finish();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
