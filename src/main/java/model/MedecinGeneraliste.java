package model;

import jakarta.persistence.Entity;

@Entity
public class MedecinGeneraliste extends Medecin {

    public MedecinGeneraliste(String nom, String INPE, String service, String grade ) {
        super(nom,INPE,service,grade);
    }
    public MedecinGeneraliste(){
        super();
    }

    public MedecinGeneraliste(MedecinGeneraliste m){
        super(m);
    }

    public String toString() {
        return super.toString()+
                " Il s'agit d'un medecin generaliste";
    }
}
