package br.com.usp.willianerodrigues.course.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import br.com.usp.willianerodrigues.course.R;
import br.com.usp.willianerodrigues.course.fragments.FragmentPresentAssitVirtual;

public class AssitVirtualActivit extends AppCompatActivity {

    private String startScreen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assit_virtual);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_exercice_initial);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle("");
        }

        if (getIntent().getExtras() != null) {
            startScreen = getIntent().getExtras().getString("will");
        }

        if(startScreen != null && startScreen.equalsIgnoreCase("apresentacao")){
            getSupportFragmentManager().beginTransaction().replace(R.id.content_initial_exercice,
                    new FragmentPresentAssitVirtual()).commit();
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        Intent intent = null;

        if(id == android.R.id.home){
            if(startScreen != null && startScreen.equalsIgnoreCase("apresentacao")){
                intent = new Intent(this, PresentationActivity.class);
            }
        }

        startActivity(intent);
        finish();

        return super.onOptionsItemSelected(item);
    }
}
