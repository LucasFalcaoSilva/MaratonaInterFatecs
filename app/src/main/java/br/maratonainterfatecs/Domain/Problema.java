package br.maratonainterfatecs.Domain;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by CASA on 25/06/2016.
 */
public class Problema implements Parcelable {

    private String nome;
    private int logo;
    private String tentativas;
    private String acertos;
    private String erros;

    public Problema(){}

    public Problema(String nome, int logo,String tentativas,String acertos,String erros){
        this.nome = nome;
        this.logo = logo;
        this.tentativas = tentativas;
        this.acertos = acertos;
        this.erros = erros;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getLogo() {
        return logo;
    }

    public void setLogo(int logo) {
        this.logo = logo;
    }

    public String getTentativas() {
        return tentativas;
    }

    public void setTentativas(String tentativas) {
        this.tentativas = tentativas;
    }

    public String getAcertos() {
        return acertos;
    }

    public void setAcertos(String acertos) {
        this.acertos = acertos;
    }

    public String getErros() {
        return erros;
    }

    public void setErros(String erros) {
        this.erros = erros;
    }

    //PARCELABLE
    public Problema(Parcel parcel){
        setNome(parcel.readString());
        setLogo(parcel.readInt());
        setTentativas(parcel.readString());
        setAcertos(parcel.readString());
        setErros(parcel.readString());
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(getNome());
        dest.writeInt(getLogo());
        dest.writeString(getTentativas());
        dest.writeString(getAcertos());
        dest.writeString(getErros());
    }

    public static final Parcelable.Creator<Problema> CREATOR = new Parcelable.Creator<Problema>(){

        @Override
        public Problema createFromParcel(Parcel source) {
            return new Problema(source);
        }

        @Override
        public Problema[] newArray(int size) {
            return new Problema[size];
        }
    };

}
