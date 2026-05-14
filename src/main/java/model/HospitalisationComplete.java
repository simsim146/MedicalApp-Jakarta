package model;

public class HospitalisationComplete extends Hospitalisation{
    int duree_estimsative;
    int duree_reelle;


    public HospitalisationComplete(Medecin medecin,
                                   Patient patient,
                                   String date_entree,
                                   String motif,
                                   String description,
                                   int duree_estimsarive,
                                   int duree_reelle
    ) {
        super(medecin, patient, date_entree, motif, description);
        this.duree_estimsative=duree_estimsarive;
        this.duree_reelle=duree_reelle;
    }

    public HospitalisationComplete(HospitalisationComplete hp) {
        super(hp);
        this.duree_estimsative=hp.duree_estimsative;
        this.duree_reelle=hp.duree_reelle;
    }

    @Override
    public String toString() {
        return super.toString()+
                " Il s'agit d'une hospitalisation complete d'une duree estimative de "+
                duree_estimsative+ " jours et d'une duree reele de " +duree_reelle+ "jours";
    }

    public int getDuree_estimsarive() {
        return duree_estimsative;
    }

    public void setDuree_estimsarive(int duree_estimsarive) {
        this.duree_estimsative = duree_estimsarive;
    }

    public int getDuree_reelle() {
        return duree_reelle;
    }

    public void setDuree_reelle(int duree_reele) {
        this.duree_reelle = duree_reele;
    }

    @Override
    public float calculer_montant() {
        return duree_reelle*2000;
    }

    @Override
    public float appliquer_reduction() {
        if (duree_reelle>=0 && duree_reelle<=5)
            return 0;
        else if (duree_reelle>=6 && duree_reelle<=10)
            return 0.10f;
        else
            return 0.20f;
    }

    @Override
    public void generer_facture() {
        System.out.println(getPatient());
        System.out.println(getMedecin());
        System.out.println("Le montant facturé est :"+ calculer_montant());
        System.out.println("Taux de reduction :"+ appliquer_reduction());
        System.out.println("Toyal à payer :"+ calculer_montant()*(1-appliquer_reduction()));
    }
}
