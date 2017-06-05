package br.com.usp.willianerodrigues.course.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.github.lzyzsd.circleprogress.DonutProgress;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.usp.willianerodrigues.course.CourseApplication;
import br.com.usp.willianerodrigues.course.R;
import br.com.usp.willianerodrigues.course.model.ItemMenu;
import br.com.usp.willianerodrigues.course.model.Usuario;

public class FinishExerciceActivity extends AppCompatActivity {

    private CourseApplication application;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finish_exercice);

        application = (CourseApplication) getApplicationContext();
        Usuario usuario;

        DonutProgress progress = (DonutProgress) findViewById(R.id.donut_progress);
        progress.setMax(30);
        TextView pontuacao = (TextView) findViewById(R.id.text_pontuacao);

        List<ItemMenu> itemMenus = new ArrayList<>();
        try {
            itemMenus = application.getItensUsuario(application.getUserActive());
        } catch (SQLException e) {
            e.printStackTrace();
        }

        usuario = application.getUsuario();

        try {
            if (usuario != null) {
                Log.i("TAG", "Usuario é nulo");
                Log.i("TAG", "" + application.getUsuario().getPontuacao());
                pontuacao.setText("+ " + usuario.getPontuacao() + " PE");
                progress.setDonut_progress("" + (usuario.getPontuacao() * 100) / 50);
                progress.setProgress((usuario.getPontuacao() * 100) / 50);
            } else {
                Log.i("TAG", "Usuario nao e nulo");
                usuario = application.getUserActive();
                pontuacao.setText(usuario.getPontuacao());
                progress.setDonut_progress("" + (usuario.getPontuacao() * 100) / 50);
                progress.setProgress(usuario.getPontuacao());
            }
        } catch (Exception e) {
            Log.i("TAG", e.getMessage());
            e.printStackTrace();
        }

        if (getIntent().getExtras() != null) {
            String passou = getIntent().getExtras().getString("passou");

            if (passou != null && passou.equalsIgnoreCase(getResources().getString(R.string.know_computer))) {
                ItemMenu itemMenu = itemMenus.get(0);
                itemMenu.setDisable(false);
                ItemMenu itemMenu2 = itemMenus.get(1);
                itemMenu2.setDisable(false);
                try {
                    itemMenu.setPontuacao(application.getUserActive().getPontuacao());
                    application.createOrUpdateItemMenu(itemMenu);
                    application.createOrUpdateItemMenu(itemMenu2);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            } else if (passou != null && passou.equalsIgnoreCase(getResources().getString(R.string.internet))) {
                ItemMenu itemMenu = itemMenus.get(5);
                itemMenu.setDisable(false);
                itemMenu.setPontuacao(application.getUserActive().getPontuacao());
                try {
                    application.createOrUpdateItemMenu(itemMenu);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            } else if (passou != null && passou.equalsIgnoreCase(getResources().getString(R.string.operational_systems))) {
                ItemMenu itemMenu = itemMenus.get(0);
                itemMenu.setDisable(false);
                ItemMenu itemMenu2 = itemMenus.get(1);
                itemMenu2.setDisable(false);
                ItemMenu itemMenu3 = itemMenus.get(2);
                itemMenu3.setDisable(false);
                itemMenu2.setPontuacao(application.getUserActive().getPontuacao());
                try {
                    application.createOrUpdateItemMenu(itemMenu);
                    application.createOrUpdateItemMenu(itemMenu2);
                    application.createOrUpdateItemMenu(itemMenu3);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            } else if (passou != null && passou.equalsIgnoreCase(getResources().getString(R.string.text_editors))) {
                ItemMenu itemMenu = itemMenus.get(0);
                itemMenu.setDisable(false);
                ItemMenu itemMenu2 = itemMenus.get(1);
                itemMenu2.setDisable(false);
                ItemMenu itemMenu3 = itemMenus.get(2);
                itemMenu3.setDisable(false);
                itemMenu3.setPontuacao(application.getUserActive().getPontuacao());
                ItemMenu itemMenu4 = itemMenus.get(3);
                itemMenu4.setDisable(false);
                try {
                    application.createOrUpdateItemMenu(itemMenu);
                    application.createOrUpdateItemMenu(itemMenu2);
                    application.createOrUpdateItemMenu(itemMenu3);
                    application.createOrUpdateItemMenu(itemMenu4);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            } else if (passou != null && passou.equalsIgnoreCase(getResources().getString(R.string.sheet_editors))) {
                ItemMenu itemMenu = itemMenus.get(3);
                itemMenu.setPontuacao(application.getUserActive().getPontuacao());
                itemMenu.setDisable(false);
                try {
                    application.createOrUpdateItemMenu(itemMenu);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            } else if (passou != null && passou.equalsIgnoreCase(getResources().getString(R.string.publishers_presentations))) {
                ItemMenu itemMenu = itemMenus.get(4);
                itemMenu.setPontuacao(application.getUserActive().getPontuacao());
                itemMenu.setDisable(false);
                try {
                    application.createOrUpdateItemMenu(itemMenu);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_finish_exercice);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(false);
            getSupportActionBar().setTitle("");
        }

        TextView textoMeta = (TextView) findViewById(R.id.texto_de_meta);
        TextView MenssagemMeta = (TextView) findViewById(R.id.messagem_texto_de_meta);

        assert usuario != null;
        if (usuario.getPontuacao() >= 75) {
            textoMeta.setText("Você foi acima da meta! Parabéns");
            MenssagemMeta.setText("Agora você é capaz de entender um pouco mais sobre as funções do computador. Agora você poderá ir para o próximo nível.");

        } else {
            textoMeta.setText("Você nao atingiu a meta!");
            MenssagemMeta.setText("Por favor, refaça o nível e tente novamente.");
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.finish_exerccie, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if(id == R.id.action_done){
            Usuario usuario = application.getUserActive();
            if (usuario.getUsername() == null) {
                Intent intent = new Intent(this, RegistroActivity.class);
                startActivity(intent);
                finish();
            } else {
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        }

        return super.onOptionsItemSelected(item);
    }
}
