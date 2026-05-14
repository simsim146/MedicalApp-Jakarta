package model;

public class Reanimation  extends Hospitalisation{
    int duree_estimative;
    int duree_reelle;


    public Reanimation(Medecin medecin,
                       Patient patient,
                       String date_entree,
                       String motif,
                       String description,
                       int duree_estimsative,
                       int duree_reelle) {
        super(medecin, patient, date_entree, motif, description);
        this.duree_reelle=duree_reelle;
        this.duree_estimative=duree_estimsative;
    }

    public Reanimation(Reanimation rn) {
        super(rn);
        this.duree_reelle=rn.duree_reelle;
        this.duree_estimative=rn.duree_estimative;
    }
    @Override
    public String toString() {
        return super.toString()+
                " Il s'agit d'une reanimation  d'une duree estimative de "+
                duree_estimative+ " jours et d'une duree reele de " +duree_reelle+ "jours";
    }
    public int getDuree_estimsarive() {
        return duree_estimative;
    }

    public void setDuree_estimsarive(int duree_estimsarive) {
        this.duree_estimative = duree_estimsarive;
    }

    public int getDuree_reelle() {
        return duree_reelle;
    }

    public void setDuree_reelle(int duree_reele) {
        this.duree_reelle = duree_reele;
    }

    @Override
    public float calculer_montant() {
        return 0;
    }

    @Override
    public float appliquer_reduction() {
        return 0;
    }

    @Override
    public void generer_facture() {

    }
}
