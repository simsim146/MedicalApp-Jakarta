package model;

public interface Facturation {
    float calculer_montant();
    float appliquer_reduction();
    void generer_facture();
}
