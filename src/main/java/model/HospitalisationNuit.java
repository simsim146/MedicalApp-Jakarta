package model;

public class HospitalisationNuit extends Hospitalisation {
    public HospitalisationNuit(Medecin medecin, Patient patient, String date_entree, String motif, String description) {
        super(medecin, patient, date_entree, motif, description);
    }

    public HospitalisationNuit(Hospitalisation hp) {
        super(hp);
    }

    @Override
    public String toString() {
        return super.toString()+ " Il s'agit d'une hospitalisation de nuit";
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
