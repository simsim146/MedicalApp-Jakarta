package model;

import java.io.Serializable;

abstract public class Consultation implements Facturation, Serializable {
    private Medecin medecin;
    private Patient patient;
    private String date;
    private String note;

    public Consultation (Medecin medecin,Patient patient, String date, String note){
        this.medecin=medecin;
        this.patient=patient;
        this.date=date;
        this.note=note;
    }

   public  Consultation (){
        this.medecin=null;
        this.patient=null;
        this.date="01/01/2001";
        this.note="";
    }

    public Consultation (Consultation c){
        this.medecin=c.medecin;
        this.patient=c.patient;
        this.date=c.date;
        this.note=c.note;
    }
    @Override
    public String toString() {
        return "Model.Consultation{" +
                "medecin=" + medecin +
                ", patient=" + patient +
                ", date='" + date + '\'' +
                ", note='" + note + '\'' +
                '}';
    }

    public Medecin getMedecin() {
        return medecin;
    }

    public Patient getPatient() {
        return patient;
    }

    public String getDate() {
        return date;
    }

    public String getNote() {
        return note;
    }

    public void setMedecin(Medecin medecin) {
        this.medecin = medecin;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setNote(String note) {
        this.note = note;
    }
}

