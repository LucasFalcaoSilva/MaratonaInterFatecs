package br.maratonainterfatecs.Domain;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Falcao on 18/05/2016.
 */
public class Equipes {

    @SerializedName("nome_equipe")
    private String name_equipe;
    @SerializedName("coach")
    private String name_coach;
    @SerializedName("integrantes")
    private List<Integrantes> integrantes;

    public Equipes(String name_equipe, String name_coach, List<Integrantes> integrantes) {
        this.name_equipe = name_equipe;
        this.name_coach  = name_coach;
        this.integrantes = integrantes;
    }

    public String getName_equipe() {
        return name_equipe;
    }

    public void setName_equipe(String name_equipe) {
        this.name_equipe = name_equipe;
    }

    public String getName_coach() {
        return name_coach;
    }

    public void setName_coach(String name_coach) {
        this.name_coach = name_coach;
    }

    public List<Integrantes> getIntegrantes() {
        return integrantes;
    }

    public void setIntegrantes(List<Integrantes> integrantes) {
        this.integrantes = integrantes;
    }
}
