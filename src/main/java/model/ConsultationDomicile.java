package model;

public class ConsultationDomicile extends Consultation{
    private String adresse;


    public ConsultationDomicile(Medecin medecin,
                         Patient patient,
                         String date,
                         String note,
                         String adresse){
        super(medecin,patient,date,note);
        this.adresse= new String (adresse);
    }

    public ConsultationDomicile(){
        super();
        this.adresse= "";}

    public ConsultationDomicile(ConsultationDomicile cd){
        super(cd);
        this.adresse= new String (cd.adresse);}

    public String toString(){
        return super.toString()+" La consultation est faite à domicile"+
                "à l'adresse "+adresse;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    @Override
    public float calculer_montant() {
        return 600;
    }

    @Override
    public float appliquer_reduction() {
        if (getPatient().getAge()>60 || getPatient().getAge()<16){
            return 0.2f;
        }
        else
            return 0;
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

