package br.com.usp.willianerodrigues.course.model;

import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.io.Serializable;

@DatabaseTable(tableName = "itemmenu")
public class ItemMenu implements Serializable {

    @DatabaseField(generatedId = true, dataType = DataType.LONG)
    private long id;
    @DatabaseField(dataType = DataType.STRING)
    private String name;
    @DatabaseField(dataType = DataType.INTEGER)
    private int drawableEnableId;
    @DatabaseField(dataType = DataType.INTEGER)
    private int drawableDisableId;
    @DatabaseField(dataType = DataType.BOOLEAN)
    private boolean disable;
    @DatabaseField(dataType = DataType.INTEGER)
    private int pontuacao;
    @DatabaseField(foreign = true, foreignAutoCreate = true, foreignAutoRefresh = true)
    private Usuario usuario;


    public ItemMenu() {
    }

    public ItemMenu(String name, int drawableEnableId, int drawableDisableId, boolean disable) {
        this.name = name;
        this.drawableEnableId = drawableEnableId;
        this.drawableDisableId = drawableDisableId;
        this.disable = disable;
        this.pontuacao = 0;
    }

    public ItemMenu(String name, int drawableEnableId, int drawableDisableId, boolean disable, Usuario usuario) {
        this.name = name;
        this.drawableEnableId = drawableEnableId;
        this.drawableDisableId = drawableDisableId;
        this.disable = disable;
        this.usuario = usuario;
        this.pontuacao = 0;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDrawableEnableId() {
        return drawableEnableId;
    }

    public void setDrawableEnableId(int drawableEnableId) {
        this.drawableEnableId = drawableEnableId;
    }

    public int getDrawableDisableId() {
        return drawableDisableId;
    }

    public void setDrawableDisableId(int drawableDisableId) {
        this.drawableDisableId = drawableDisableId;
    }

    public boolean isDisable() {
        return disable;
    }

    public void setDisable(boolean disable) {
        this.disable = disable;
    }

    public int getPontuacaoMax() {
        return 100;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public int getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(int pontuacao) {
        this.pontuacao = pontuacao;
    }
}
