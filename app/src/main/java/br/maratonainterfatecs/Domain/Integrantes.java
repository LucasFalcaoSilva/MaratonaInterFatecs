package br.maratonainterfatecs.Domain;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Falcao on 18/05/2016.
 */
public class Integrantes  implements Parcelable {

    @SerializedName("name")
    private String name;

    public Integrantes(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public Integrantes(Parcel parcel){
        setName(parcel.readString());
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(getName());
    }

    public static final Parcelable.Creator<Integrantes> CREATOR = new Parcelable.Creator<Integrantes>(){

        @Override
        public Integrantes createFromParcel(Parcel source) {
            return new Integrantes(source);
        }

        @Override
        public Integrantes[] newArray(int size) {
            return new Integrantes[size];
        }
    };
}
