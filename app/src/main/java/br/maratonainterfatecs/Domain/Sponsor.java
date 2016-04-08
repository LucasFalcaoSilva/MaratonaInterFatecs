package br.maratonainterfatecs.Domain;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Luan on 15/03/2016.
 */
public class Sponsor{ //implements Parcelable {

    private String nome;
    private int logo;
    private String description;
    private String url;

    public Sponsor(){}

    public Sponsor(String nome, int logo,String url,String description){
        this.nome = nome ;
        this.logo = logo;
        this.url = url;
        this.description = description;
    }

    public String getNome() { return nome; }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getLogo() {
        return logo;
    }

    public void setLogo(int logo) {
        this.logo = logo;
    }

    public String getDescription() { return description; }

    public void setDescription(String description) { this.description = description; }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    //PARCELABLE
   /* public Sponsor(Parcel parcel){
        setLogo(parcel.readInt());
        setNome(parcel.readString());
        //setDescription(parcel.readString());
    }

    @Override
    public int describeContents() {
        return 0;
    }


    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt( getLogo() );
        parcel.writeString( getNome() );
        //parcel.writeString( getDescription() );
    }

    public static final Parcelable.Creator<Sponsor> CREATOR = new Parcelable.Creator<Sponsor>(){

        @Override
        public Sponsor createFromParcel(Parcel source) {
            return new Sponsor(source);
        }

        @Override
        public Sponsor[] newArray(int size) {
            return new Sponsor[size];
        }
    };*/
}
