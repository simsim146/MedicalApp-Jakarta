package model;

import java.io.Serializable;

abstract public class Hospitalisation implements Facturation, Serializable {

    private Medecin medecin;
    private Patient patient;
    private String date_entree;
    private String motif;
    private String description;

    public Hospitalisation(Medecin medecin, Patient patient, String date_entree, String motif,String description){
        this.medecin=medecin;
        this.patient=patient;
        this.date_entree=new String (date_entree);
        this.motif= new String(motif);
        this.description= new String(description);
    }

    public Hospitalisation(Hospitalisation hp){
        this.medecin=hp.medecin;
        this.patient=hp.patient;
        this.date_entree=new String (hp.date_entree);
        this.motif= new String(hp.motif);
        this.description= new String(hp.description);
    }

    @Override
    public String toString() {
        return "Model.Hospitalisation{" +
                "medecin=" + medecin +
                ", patient=" + patient +
                ", date_entree='" + date_entree + '\'' +
                ", motif='" + motif + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    public Medecin getMedecin() {
        return medecin;
    }

    public Patient getPatient() {
        return patient;
    }

    public String getDate_entree() {
        return date_entree;
    }

    public String getMotif() {
        return motif;
    }

    public String getDescription() {
        return description;
    }
}

