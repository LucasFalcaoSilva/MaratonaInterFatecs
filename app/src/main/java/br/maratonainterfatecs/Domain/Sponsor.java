package br.maratonainterfatecs.Domain;

/**
 * Created by Luan on 15/03/2016.
 */
public class Sponsor {

    private String nome;
    private int logo;

    public Sponsor(){}
    public Sponsor(String n, int l){
        nome = n;
        logo = l;
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
}
