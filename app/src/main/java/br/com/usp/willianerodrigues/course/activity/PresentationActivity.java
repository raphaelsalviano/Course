package br.com.usp.willianerodrigues.course.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import br.com.usp.willianerodrigues.course.R;

public class PresentationActivity extends AppCompatActivity {

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_presentation);

        (findViewById(R.id.button_start)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v) {
                Intent intent = new Intent(PresentationActivity.this, AssitVirtualActivit.class);
                intent.putExtra("will", "apresentacao");
                startActivity(intent);
                finish();
            }
        });

        (findViewById(R.id.button_already_have_account)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v) {
                Intent intent = new Intent(PresentationActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }
}
