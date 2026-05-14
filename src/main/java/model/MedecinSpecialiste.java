package model;

public class MedecinSpecialiste extends Medecin {
    private String specialite;
    private boolean chirurgien;
    public MedecinSpecialiste(String nom, String INPE, String service, String grade, String specialite, boolean chirurgien) {
        super(nom,INPE,service,grade); //appel du constrcuteur de la classe mere
        this.specialite=new String(specialite);
        this.chirurgien=chirurgien;
    }
    public MedecinSpecialiste(){
        super(); //appel du constrcuteur par defaut de la classe mere
        specialite="NA";
        chirurgien=false;
    }

    public MedecinSpecialiste(MedecinSpecialiste m){
        super(m);
        this.specialite= new String(m.specialite);
        this.chirurgien= m.chirurgien;
    }

    public String toString(){
        if (chirurgien==true)
            return super.toString()+
                    " Il s'agit d'un medecin chiruregien de specialité "+specialite;
        else
            return super.toString()+
                    " Il s'agit d'un medecin non chiruregien de specialité "+specialite;
    }

    public String getSpecialite() {
        return specialite;
    }

    public boolean isChirurgien() {
        return chirurgien;
    }

    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }

    public void setChirurgien(boolean chirurgien) {
        this.chirurgien = chirurgien;
    }
}
