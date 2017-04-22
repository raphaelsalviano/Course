package br.com.usp.willianerodrigues.course.database.daoclass;

import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.support.ConnectionSource;

import java.sql.SQLException;

import br.com.usp.willianerodrigues.course.model.Usuario;

public class UsuarioDao extends BaseDaoImpl<Usuario, Long> {

     public UsuarioDao (ConnectionSource cs) throws SQLException {
          super(Usuario.class);
          setConnectionSource(cs);
          initialize();
     }

}
