package br.maratonainterfatecs.Domain;

import java.util.List;

/**
 * Created by Falcao on 18/05/2016.
 */
public class Unidades {

    private String nameFatec;
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
