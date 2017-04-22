package br.com.usp.willianerodrigues.course.database.daoclass;

import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.support.ConnectionSource;

import java.sql.SQLException;

import br.com.usp.willianerodrigues.course.model.ItemMenu;

public class ItemMenuDao extends BaseDaoImpl<ItemMenu, Integer>{

     public ItemMenuDao (ConnectionSource cs) throws SQLException {
          super(ItemMenu.class);
          setConnectionSource(cs);
          initialize();
     }

}
