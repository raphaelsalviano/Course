package br.com.usp.willianerodrigues.course;

import android.app.Application;

import java.sql.SQLException;
import java.util.List;


import br.com.usp.willianerodrigues.course.database.DBMethods;
import br.com.usp.willianerodrigues.course.database.ORMController;
import br.com.usp.willianerodrigues.course.model.ItemMenu;
import br.com.usp.willianerodrigues.course.model.Usuario;

public class CourseApplication extends Application implements DBMethods {

    public static final String APP_VERSION = "1.1";
    private int pontuacao;

    private ORMController controller;

    @Override
    public void onCreate () {
        super.onCreate();
        controller = new ORMController(getBaseContext());
        this.pontuacao = 0;

    }

    @Override
    public void onTerminate () {
        super.onTerminate();
        controller.closeDatabase();
    }

    @Override
    public void createOrUpdateUser (Usuario usuario) throws SQLException {
        controller.createOrUpdateUser(usuario);
    }

    @Override
    public void removeUser (Usuario usuario) throws SQLException {
        controller.removeUser(usuario);
    }

    @Override
    public Usuario getUserActive () throws SQLException {
        return controller.getUserActive();
    }

    @Override
    public List<Usuario> getAllUser () throws SQLException {
        return controller.getAllUser();
    }

    @Override
    public Usuario searchUserByUser (String usuario) throws SQLException {
        return controller.searchUserByUser(usuario);
    }

    @Override
    public void createOrUpdateItemMenu(ItemMenu itemMenu) throws SQLException {
        controller.createOrUpdateItemMenu(itemMenu);
    }


    public void calcularPontuacao(int porcentagemConcluida) {
        this.pontuacao = ((50 * porcentagemConcluida) / 100) + this.pontuacao;
    }

    public void inserirPontuacaoUser() throws Exception {
        Usuario usuario = getUserActive();
        if(usuario == null){
            throw new Exception("Usuário vazio");
        }
        usuario.setPontuacao(this.pontuacao);
        createOrUpdateUser(usuario);
    }

    @Override
    public List<ItemMenu> getAllItens () throws SQLException {
        return controller.getAllItens();
    }

    public int getPontuacao() {
        return this.pontuacao;
    }

    public void resetPontuacao() {
        this.pontuacao = 0;
    }
}
