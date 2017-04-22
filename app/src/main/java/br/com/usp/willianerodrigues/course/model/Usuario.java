package br.com.usp.willianerodrigues.course.model;

import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.io.Serializable;

@DatabaseTable(tableName = "usuario")
public class Usuario implements Serializable {

     @DatabaseField(generatedId = true, dataType = DataType.LONG)
     private long id;
     @DatabaseField(dataType = DataType.STRING)
     private String name;
     @DatabaseField(dataType = DataType.STRING)
     private String lastname;
     @DatabaseField(dataType = DataType.STRING)
     private String username;
     @DatabaseField(dataType = DataType.STRING)
     private String password;
     @DatabaseField(dataType = DataType.BOOLEAN)
     private boolean active;

     public Usuario () {
     }

     public Usuario (String name, String lastname, String username, String password) {
          this.name = name;
          this.lastname = lastname;
          this.username = username;
          this.password = password;
          this.active = false;
     }

     public long getId () {
          return id;
     }

     public void setId (long id) {
          this.id = id;
     }

     public String getName () {
          return name;
     }

     public void setName (String name) {
          this.name = name;
     }

     public String getLastname () {
          return lastname;
     }

     public void setLastname (String lastname) {
          this.lastname = lastname;
     }

     public String getUsername () {
          return username;
     }

     public void setUsername (String username) {
          this.username = username;
     }

     public String getPassword () {
          return password;
     }

     public void setPassword (String password) {
          this.password = password;
     }

     public boolean isActive () {
          return active;
     }

     public void setActive (boolean active) {
          this.active = active;
     }
}
