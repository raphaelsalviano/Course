package br.com.usp.willianerodrigues.course.database;

import java.sql.SQLException;
import java.util.List;

import br.com.usp.willianerodrigues.course.model.ItemMenu;
import br.com.usp.willianerodrigues.course.model.Usuario;

public interface DBMethods {

     void createOrUpdateUser(Usuario usuario) throws SQLException;

     void removeUser(Usuario usuario) throws SQLException;

     Usuario getUserActive() throws SQLException;

     List<Usuario> getAllUser() throws SQLException;

     Usuario searchUserByUser(String usuario) throws SQLException;

    void createOrUpdateItemMenu(ItemMenu itemMenu) throws SQLException;

     List<ItemMenu> getAllItens() throws SQLException;


}
