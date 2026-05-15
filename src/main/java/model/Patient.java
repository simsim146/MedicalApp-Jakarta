package model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Patient implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String nom;
    private int age;
    private float poids;
    private float taille;
    private int pressionSys;
    private int pressionDia;
    private boolean diabetique;

    //it do smtg important, with consultation
    @OneToMany(mappedBy = "patient",
    cascade = CascadeType.ALL,
            orphanRemoval = true)
    private ArrayList<Consultation> consultations = new ArrayList<Consultation>();

    public Patient(String nom, int age, float poids, float taille, int pressionSys, int pressionDia, boolean diabeeque) {
        this.nom = nom;
        this.age = age;
        this.poids = poids;
        this.taille = taille;
        this.pressionSys = pressionSys;
        this.pressionDia = pressionDia;
        this.diabetique = diabetique;
    }

    public Patient(Patient patient) {
        this.nom = new String(patient.nom);
        this.age = patient.age;
        this.poids = patient.poids;
        this.taille = patient.taille;
        this.pressionSys = patient.pressionSys;
        this.pressionDia = patient.pressionDia;
        this.diabetique = patient.diabetique;

    }
   /* public String toString() {
        return "Model.Patient{" +
                "nom='" + nom + '\'' +
                ", age=" + age +
                ", poids=" + poids +
                ", taille=" + taille +
                ", pressionSys=" + pressionSys +
                ", pressionDia=" + pressionDia +
                ", diabetique=" + diabetique +
                '}'; }*/

    public String toString() {
        String msg="Model.Patient d'identifiant:"+id;
        if (diabetique)
            msg+="Le Model.Patient" + nom + " possede" + age + " ans, il a un poids de=" + poids +" kg et une  taille de=" + taille +"cm"
                    +"il a une pression de (" + pressionSys +"," + pressionDia + ")."
                    +"Ce patient est diabetique";
        else
            msg+="Le Model.Patient" + nom + " possede" + age + " ans, il a un poids de=" + poids +" kg et une  taille de=" + taille +"cm"
                    +"il a une pression de (" + pressionSys +"," + pressionDia + ")."
                    +"Ce patient n'est pas diabetique";

        return msg;
    }

    float calculer_IMC(){
        return 100*poids/(taille*taille);
    }

    public static boolean Comparer_IMC(Patient p1, Patient p2){
        if(p1.calculer_IMC()<p2.calculer_IMC())
            return true;
        else
            return false;
    }

    public  boolean Comparer_IMC_v2(Patient p){
        if(this.calculer_IMC()<p.calculer_IMC())
            return true;
        else
            return false;
    }

    public String getNom() {
        return nom;
    }

    public int getAge() {
        return age;
    }

    public float getPoids() {
        return poids;
    }

    public float getTaille() {
        return taille;
    }

    public int getPressionSys() {
        return pressionSys;
    }

    public int getPressionDia() {
        return pressionDia;
    }

    public boolean isDiabetique() {
        return diabetique;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setPoids(float poids) {
        this.poids = poids;
    }

    public void setTaille(float taille) {
        this.taille = taille;
    }

    public void setPressionSys(int pressionSys) {
        this.pressionSys = pressionSys;
    }

    public void setPressionDia(int pressionDia) {
        this.pressionDia = pressionDia;
    }

    public void setDiabetique(boolean diabetique) {
        this.diabetique = diabetique;
    }
}
