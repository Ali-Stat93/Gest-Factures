package org.example.model;

public class ArticleEnSolde extends Article {
    private float remise;

    /** Constructors **/

    /**
     * Constructeur par default
     * @param remise chiffre entre 0 et 100
     */
    public ArticleEnSolde(float remise) {
        this.remise=remise;
    }

    /**
     * Constructeur d'initialisation
     * @param code
     * @param designation
     * @param prix
     * @param categorie
     * @param remise chiffre entre 0 et 100
     */
    public ArticleEnSolde(int code, String designation, float prix, Categorie categorie, float remise) {
        super(code, designation, prix, categorie);
        this.remise = remise;
    }

    /** Getters & Setters **/

    /**
     * Remise
     * @return chiffre entre 0 et 100
     */
    public float getRemise() {
        return remise;
    }

    /**
     * Prix de l'article aprés la remise
     * @return Nouveau prix
     */
    @Override
    public double getPrix() {
        return super.getPrix()*(1-this.remise/100);
    }
}
