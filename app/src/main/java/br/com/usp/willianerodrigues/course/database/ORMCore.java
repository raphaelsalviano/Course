package br.com.usp.willianerodrigues.course.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import br.com.usp.willianerodrigues.course.model.ItemMenu;
import br.com.usp.willianerodrigues.course.model.Usuario;

class ORMCore extends OrmLiteSqliteOpenHelper {

     private static final String DB_NAME = "couse_db";
    private static final int DB_VERSION = 3;

     ORMCore (Context context) {
          super(context, DB_NAME, null, DB_VERSION);
     }

     @Override
     public void onCreate (SQLiteDatabase sqLiteDatabase, ConnectionSource connectionSource) {
          try {
               TableUtils.createTable(connectionSource, Usuario.class);
               TableUtils.createTable(connectionSource, ItemMenu.class);
          } catch (java.sql.SQLException e) {
               e.getMessage();
          }
     }

     @Override
     public void onUpgrade (SQLiteDatabase sqLiteDatabase, ConnectionSource connectionSource, int i, int i1) {
          try {
               TableUtils.dropTable(connectionSource, Usuario.class, true);
               TableUtils.dropTable(connectionSource, ItemMenu.class, true);
               onCreate(sqLiteDatabase, connectionSource);
          } catch (java.sql.SQLException e) {
               e.getMessage();
          }
     }

     @Override
     public void close () {
          super.close();
     }
}
