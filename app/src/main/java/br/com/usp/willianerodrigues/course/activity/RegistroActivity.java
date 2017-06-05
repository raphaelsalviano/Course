package br.com.usp.willianerodrigues.course.activity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.AsyncTask;
import android.os.Build;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.sql.SQLException;

import br.com.usp.willianerodrigues.course.CourseApplication;
import br.com.usp.willianerodrigues.course.R;
import br.com.usp.willianerodrigues.course.model.Usuario;

public class RegistroActivity extends AppCompatActivity implements View.OnClickListener, TextView.OnEditorActionListener {

    private RegisterAsyncTask mAuth = null;

    private EditText mName;
    private EditText mLastname;
    private EditText mLogin;
    private EditText mPassword;

    private View mProgress;
    private View mLayout;

    private CourseApplication application;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_register);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        application = (CourseApplication) getApplicationContext();

        ((TextInputLayout) findViewById(R.id.textInputName)).setTypeface(createRobotoRegular());
        ((TextInputLayout) findViewById(R.id.textInputLastName)).setTypeface(createRobotoRegular());
        ((TextInputLayout) findViewById(R.id.textInputMail)).setTypeface(createRobotoRegular());
        ((TextInputLayout) findViewById(R.id.textInputSenha)).setTypeface(createRobotoRegular());

        mName = (EditText) findViewById(R.id.textName);
        mLastname = (EditText) findViewById(R.id.textSobrenome);
        mLogin = (EditText) findViewById(R.id.textMail);
        mLogin.setTypeface(createRobotoRegular());

        mPassword = (EditText) findViewById(R.id.senha_text);
        mPassword.setTypeface(createRobotoRegular());
        mPassword.setOnEditorActionListener(this);

        Button mButtonLogin = (Button) findViewById(R.id.email_register_button);
        mButtonLogin.setTypeface(createRobotoRegular());
        mButtonLogin.setOnClickListener(this);

        mProgress = findViewById(R.id.progress_register);
        mLayout = findViewById(R.id.register_form);
    }

    private Typeface createRobotoRegular() {
        return Typeface.createFromAsset(getAssets(), "fonts/roboto_regular.ttf");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == android.R.id.home) {
            Intent intent = new Intent(this, PresentationActivity.class);
            startActivity(intent);
            finish();
        }

        return super.onOptionsItemSelected(item);
    }

    private void attemptRegister() {

        if (mAuth != null) {
            mAuth = null;
        }

        mName.setError(null);
        mLastname.setError(null);
        mLogin.setError(null);
        mPassword.setError(null);

        String nome = mName.getText().toString();
        String sobrenome = mLastname.getText().toString();
        String email = mLogin.getText().toString();
        String senha = mPassword.getText().toString();

        View focusView = null;
        boolean cancel = false;

        if (TextUtils.isEmpty(nome)) {
            mName.setError(getString(R.string.error_field_required));
            focusView = mLogin;
            cancel = true;
        }

        if (TextUtils.isEmpty(sobrenome)) {
            mLastname.setError(getString(R.string.error_field_required));
            focusView = mLogin;
            cancel = true;
        }

        if (TextUtils.isEmpty(email)) {
            mLogin.setError(getString(R.string.error_field_required));
            focusView = mLogin;
            cancel = true;
        }

        if (TextUtils.isEmpty(senha)) {
            mPassword.setError(getString(R.string.error_field_required));
            focusView = mPassword;
            cancel = true;
        } else if (!isValidPassword(senha)) {
            mPassword.setError(getString(R.string.error_invalid_password));
            focusView = mPassword;
            cancel = true;
        }

        if (cancel) {
            focusView.requestFocus();
        } else {
            showProgress(true);
            mAuth = new RegisterAsyncTask(nome, sobrenome, email, senha);
            mAuth.execute((Void) null);
        }

    }

    private boolean isValidPassword(String password) {
        return password.length() >= 4 && password.length() <= 16;
    }

    @Override
    public void onClick(View view) {
        attemptRegister();
    }

    @Override
    public boolean onEditorAction(TextView textView, int id, KeyEvent keyEvent) {
        if (id == R.id.register || id == EditorInfo.IME_NULL) {
            attemptRegister();
            return true;
        }
        return false;
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB_MR2)
    private void showProgress(final boolean show) {

        int shortAnimTime = getResources().getInteger(android.R.integer.config_shortAnimTime);

        mLayout.setVisibility(show ? View.GONE : View.VISIBLE);
        mLayout.animate().setDuration(shortAnimTime).alpha(
                show ? 0 : 1).setListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                mLayout.setVisibility(show ? View.GONE : View.VISIBLE);
            }
        });

        mProgress.setVisibility(show ? View.VISIBLE : View.GONE);
        mProgress.animate().setDuration(shortAnimTime).alpha(
                show ? 1 : 0).setListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                mProgress.setVisibility(show ? View.VISIBLE : View.GONE);
            }
        });
    }

    private class RegisterAsyncTask extends AsyncTask<Void, Void, Boolean> {

        private final int TIME = 1500;

        private String nome;
        private String sobrenome;
        private String username;
        private String senha;
        private Usuario temp;

        RegisterAsyncTask(String nome, String sobrenome, String username, String senha) {
            this.nome = nome;
            this.sobrenome = sobrenome;
            this.username = username;
            this.senha = senha;
            this.temp = null;
        }

        @Override
        protected Boolean doInBackground(Void... voids) {
            try {
                Thread.sleep(TIME);
                temp = application.searchUserByUser(username);
                return temp == null;
            } catch (InterruptedException | SQLException e) {
                e.printStackTrace();
                return false;
            }

        }

        @Override
        protected void onPostExecute(Boolean sucess) {

            if (sucess) {
                temp = new Usuario();
                temp.setName(nome);
                temp.setLastname(sobrenome);
                temp.setUsername(username);
                temp.setPassword(senha);
                temp.setActive(true);
                if (application.getUsuario().getPontuacao() > 0) {
                    temp.setPontuacao(application.getUsuario().getPontuacao());
                    application.setUsuario(null);
                }

                try {
                    application.createOrUpdateUser(temp);
                    application.initializeMenuItens(application.getUserActive());
                } catch (SQLException e) {
                    e.printStackTrace();
                }

                Intent intent = new Intent(RegistroActivity.this, MainActivity.class);
                startActivity(intent);
                onCancelled();
                finish();
            } else {
                if (temp == null) {
                    mLogin.setError(getString(R.string.no_register_email));
                    mLogin.requestFocus();
                } else {
                    mPassword.setError(getString(R.string.error_incorrect_password));
                    mPassword.requestFocus();
                }
            }
        }

        @Override
        protected void onCancelled() {
            mAuth = null;
            showProgress(false);
        }
    }

}
