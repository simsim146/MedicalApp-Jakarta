package model;

public class ConsultationHopital extends Consultation {
    private String service;

    public ConsultationHopital(Medecin medecin,
                        Patient patient,
                        String date,
                        String note,
                        String service){
        super(medecin,patient,date,note);
        this.service=new String(service);
    }

    public ConsultationHopital(){
        super();
        service="";
    }

    public ConsultationHopital(ConsultationHopital ch){
        super(ch);
        service=ch.service;
    }

    public String tostring(){
        return super.toString()+ " La consultation est faites au" +
                " service de "+ service;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    @Override
    public float calculer_montant() {
        return 300;
    }

    @Override
    public float appliquer_reduction() {
        if (getPatient().getAge()<16){
            return 0.1f;
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

