package br.maratonainterfatecs.Domain;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Falcao on 18/05/2016.
 */
public class Unidades {

    @SerializedName("nome")
    private String nameFatec;
    @SerializedName("equipes")
    private List<Equipes> equipesList;

    public Unidades(String nameFatec, List<Equipes> equipesList) {
        this.nameFatec = nameFatec;
        this.equipesList = equipesList;
    }

    public String getNameFatec() {
        return nameFatec;
    }

    public void setNameFatec(String nameFatec) {
        this.nameFatec = nameFatec;
    }

    public List<Equipes> getEquipesList() {
        return equipesList;
    }

    public void setEquipesList(List<Equipes> equipesList) {
        this.equipesList = equipesList;
    }
}
