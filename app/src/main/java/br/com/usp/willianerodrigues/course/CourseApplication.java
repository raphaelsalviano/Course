package br.com.usp.willianerodrigues.course;

import android.app.Application;
import android.util.Log;

import java.sql.SQLException;
import java.util.List;


import br.com.usp.willianerodrigues.course.database.DBMethods;
import br.com.usp.willianerodrigues.course.database.ORMController;
import br.com.usp.willianerodrigues.course.model.ItemMenu;
import br.com.usp.willianerodrigues.course.model.Usuario;

public class CourseApplication extends Application implements DBMethods {

    private ORMController controller;

    private Usuario usuario;

    @Override
    public void onCreate () {
        super.onCreate();
        controller = new ORMController(getBaseContext());
        try {
            this.usuario = this.controller.getUserActive();
        } catch (SQLException e) {
            e.printStackTrace();
            usuario = null;
        }

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
    public Usuario getUserActive() {
        return this.usuario;
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

    public void inserirPontuacaoUser(int porcentagemConcluida) throws Exception {
        Usuario usuario = getUserActive();
        int pontuacao = ((50 * porcentagemConcluida) / 100) + usuario.getPontuacao();
        usuario.setPontuacao(pontuacao);
        createOrUpdateUser(usuario);
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
        Log.i("TAG", "Criou um usuario");
    }

    public void initializeMenuItens(Usuario usuario){
        this.controller.initializeMenuItens(usuario);
    }

    @Override
    public List<ItemMenu> getAllItens() throws SQLException {
        return controller.getAllItens();
    }

    @Override
    public List<ItemMenu> getItensUsuario(Usuario usuario) throws SQLException {
        return controller.getItensUsuario(usuario);
    }
}
