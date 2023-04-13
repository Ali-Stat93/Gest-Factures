package org.example.model;

public class Article {
    protected int code;
    protected String Designation;
    protected float prix;
    protected Categorie categorie;

    /** Constructor **/
    /**
     * Constructeur par défaut
     */
    public Article() {
    }

    /**
     * Constructeur d'initialisation
     * @param code
     * @param designation
     * @param prix
     * @param categorie choix entre Informatique et Bureautique
     */
    public Article(int code, String designation, float prix, Categorie categorie) {
        this.code = code;
        Designation = designation;
        this.prix = prix;
        this.categorie = categorie;
    }

    /** Getters & Setters **/
    public String getDesignation() {
        return Designation;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    /**
     * Prix de l'article
     * @return
     */
    public float getPrix() {
        return prix;
    }

    /**
     * Changer le prix de l'article
     * @param prix
     */
    public void setPrix(float prix) {
        this.prix = prix;
    }

    @Override
    public String toString() {
        return "Article:" + code +
                "; Designation='" + Designation + '\'' +
                "; prix=" + prix +
                "; categorie=" + categorie ;
    }
}
