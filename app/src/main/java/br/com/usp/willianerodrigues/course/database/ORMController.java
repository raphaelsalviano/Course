package br.com.usp.willianerodrigues.course.database;

import android.content.Context;

import com.j256.ormlite.stmt.PreparedQuery;
import com.j256.ormlite.stmt.QueryBuilder;

import java.sql.SQLException;
import java.util.List;

import br.com.usp.willianerodrigues.course.R;
import br.com.usp.willianerodrigues.course.database.daoclass.ItemMenuDao;
import br.com.usp.willianerodrigues.course.database.daoclass.UsuarioDao;
import br.com.usp.willianerodrigues.course.model.ItemMenu;
import br.com.usp.willianerodrigues.course.model.Usuario;

public class ORMController implements DBMethods {

     private ORMCore ormCore;
     private Context context;

     private UsuarioDao usuarioDao;
     private ItemMenuDao menuDao;

     public ORMController (Context context) {
          ormCore = new ORMCore(context);
          this.context = context;
          initializeDatabase();
          initializeMenuItens();
     }

     public void closeDatabase () {
          ormCore.close();
     }


     // Usuario
     @Override
     public void createOrUpdateUser (Usuario usuario) throws SQLException {
          usuarioDao.createOrUpdate(usuario);
          usuarioDao.refresh(usuario);
     }

     @Override
     public void removeUser (Usuario usuario) throws SQLException {
          usuarioDao.delete(usuario);
     }

     @Override
     public Usuario getUserActive () throws SQLException {
          QueryBuilder<Usuario, Long> builder = usuarioDao.queryBuilder();
          builder.where().like("active", true);
          PreparedQuery<Usuario> query = builder.prepare();
          if (usuarioDao.query(query).size() == 1) {
               return usuarioDao.queryForFirst(query);
          }
          return null;
     }

     @Override
     public List<Usuario> getAllUser () throws SQLException {
          return usuarioDao.queryForAll();
     }

     @Override
     public Usuario searchUserByUser (String username) throws SQLException {
          QueryBuilder<Usuario, Long> builder = usuarioDao.queryBuilder();
          builder.where().like("username", username);
          PreparedQuery<Usuario> query = builder.prepare();
          if ((usuarioDao.query(query).size() == 1)) {
               return usuarioDao.queryForFirst(query);
          }
          return null;
     }

     @Override
     public List<ItemMenu> getAllItens () throws SQLException {
          return menuDao.queryForAll();
     }

     // Inicializa o DAO
     private void initializeDatabase () {
          try {
               usuarioDao = new UsuarioDao(ormCore.getConnectionSource());
               menuDao = new ItemMenuDao(ormCore.getConnectionSource());
          } catch (SQLException e) {
               e.getMessage();
          }
     }

     //Inicializa no banco os itens de menu
     private void initializeMenuItens () {
          try {
               if(menuDao.queryForAll().size() == 0 && menuDao.queryForAll() != null){
                    menuDao.createOrUpdate(new ItemMenu((context.getString(R.string.know_computer)), R.drawable.ico_pc, R.drawable.ico_pc_grey, false));
                    menuDao.createOrUpdate(new ItemMenu((context.getString(R.string.operational_systems)), R.drawable.ico_windows, R.drawable.ico_windows_grey, true));
                    menuDao.createOrUpdate(new ItemMenu((context.getString(R.string.text_editors)), R.drawable.ico_notepad, R.drawable.ico_notepad_disable, true));
                    menuDao.createOrUpdate(new ItemMenu((context.getString(R.string.sheet_editors)), R.drawable.ico_sheet, R.drawable.ico_sheet_disable, true));
                    menuDao.createOrUpdate(new ItemMenu((context.getString(R.string.publishers_presentations)), R.drawable.ico_presentation, R.drawable.ico_presentation_disable, true));
                    menuDao.createOrUpdate(new ItemMenu((context.getString(R.string.internet)), R.drawable.ico_web, R.drawable.ico_web_grey, true));
               }
          } catch (SQLException e) {
               e.getMessage();
          }
     }

}
