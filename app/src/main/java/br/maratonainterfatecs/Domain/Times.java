package br.maratonainterfatecs.Domain;

/**
 * Created by Lucas Falcao on 28/06/2016.
 */
public class Times {

    private Integer posicaoEquipe;
    private String nomeEquipe;
    private String problemasAcertados;
    private String nomeFatec;
    private Integer tempo;
    private boolean classificado;

    public Times(Integer posicaoEquipe, String nomeEquipe, String problemasAcertados, String nomeFatec, Integer tempo, boolean classificado) {
        this.posicaoEquipe = posicaoEquipe;
        this.nomeEquipe = nomeEquipe;
        this.problemasAcertados = problemasAcertados;
        this.nomeFatec = nomeFatec;
        this.tempo = tempo;
        this.classificado = classificado;
    }
    public Integer getTempo() {
        return tempo;
    }

    public void setTempo(Integer tempo) {
        this.tempo = tempo;
    }
    public String getNomeFatec() {
        return nomeFatec;
    }

    public void setNomeFatec(String nomeFatec) {
        this.nomeFatec = nomeFatec;
    }

    public boolean isClassificado() {
        return classificado;
    }

    public void setClassificado(boolean classificado) {
        this.classificado = classificado;
    }

    public Integer getPosicaoEquipe() {
        return posicaoEquipe;
    }

    public void setPosicaoEquipe(Integer posicaoEquipe) {
        this.posicaoEquipe = posicaoEquipe;
    }

    public String getNomeEquipe() {
        return nomeEquipe;
    }

    public void setNomeEquipe(String nomeEquipe) {
        this.nomeEquipe = nomeEquipe;
    }

    public String getProblemasAcertados() {
        return problemasAcertados;
    }

    public void setProblemasAcertados(String problemasAcertados) {
        this.problemasAcertados = problemasAcertados;
    }
}
