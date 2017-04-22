package br.com.usp.willianerodrigues.course.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.sql.SQLException;

import br.com.usp.willianerodrigues.course.R;

public class ExerciceActivity extends AppCompatActivity implements View.OnClickListener {

    private String local;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercice);

        if (getIntent().getExtras() != null) {
            local = getIntent().getExtras().getString("exercice");
        }

        ((findViewById(R.id.close_exercice))).setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        new AlertDialog.Builder(ExerciceActivity.this)
                .setTitle(R.string.alert_close_title)
                .setMessage(R.string.alert_close_message)
                .setPositiveButton(R.string.alert_close_positive_button, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = generateIntentBack();
                        if (intent != null) {
                            startActivity(intent);
                            finish();
                        }
                    }
                })
                .setNegativeButton(R.string.alert_close_negative_button, null)
                .create().show();
    }

    private Intent generateIntentBack() {

        Intent intent = null;
        if (local.equalsIgnoreCase("advanced")) {
            intent = new Intent(this, AssitVirtualActivit.class);
            intent.putExtra("will", local);
        } else if (local.equalsIgnoreCase("apresentacao")) {
            intent = new Intent(this, AssitVirtualActivit.class);
            intent.putExtra("will", local);
        } else if (local.equalsIgnoreCase("main")) {
            intent = new Intent(this, MainActivity.class);
        }
        startActivity(intent);
        finish();
        return intent;
    }
}