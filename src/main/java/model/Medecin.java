package model;

import java.io.Serializable;

abstract public class Medecin implements Serializable {
    private String nom;
    private String INPE;
    private String service;
    private String grade;

    public Medecin(String nom, String INPE, String service, String grade ) {
        this.nom = nom;
        this.INPE = INPE;
        this.service = service;
        this.grade = grade;
    }
    public Medecin(){
        this.nom="Dr x";
        this.INPE="0";
        this.service="NA";
        this.grade="NA";
    }

    public Medecin(Medecin m){
        this.nom=new String(m.nom);
        this.INPE=new String(m.INPE);;
        this.service=new String(m.service);;
        this.grade=new String(m.grade);;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return "Model.Medecin{" +
                "nom='" + nom + '\'' +
                ", INPE='" + INPE + '\'' +
                ", service='" + service + '\'' +
                ", grade='" + grade + '\'' +
                '}';
    }

    public String getNom() {
        return nom;
    }


    public String getINPE() {
        return INPE;
    }

    public String getService() {
        return service;
    }

    public String getGrade() {
        return grade;
    }

    public void setService(String service) {
        this.service = service;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

}
