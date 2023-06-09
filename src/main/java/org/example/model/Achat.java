package org.example.model;

import java.math.BigDecimal;
import java.util.Arrays;

public class Achat {
    private int numAchat;
    private Article article;
    private  int quantite;

    /** Constructors **/

    /**
     * Constructeur par défaut
     * @param numAchat
     * @param article
     * @param quantite
     */
    public Achat(int numAchat, Article article, int quantite) {
        this.numAchat = numAchat;
        this.article = article;
        this.quantite = quantite;
    }

    /** Methodes **/

    /**
     * Prix total de l'achat
     * @return prix total selon la quantite de l'article
     */
    public double getPrixTotal(){
        return this.article.getPrix()*this.quantite;
    }

    /**
     * Remise pour l'article valeur entre 0% et 100%
     * @return si l'article n'a pas de remise renvoie 0%
     */
    private String getRemise(){
        return (article instanceof ArticleEnSolde)?((ArticleEnSolde)article).getRemise()+"%":"0%";
    }

    /**
     * Format String to n size
     * @param taille size to format
     * @param champ
     * @return
     */
    private static String formatField(int taille, String champ){
        char[] field = new char[taille];
        for(int i=0;i<field.length;i++)
            field[i]=(i<champ.length())?champ.charAt(i):' ';
         return String.valueOf(field);

    }
    @Override
    public String toString() {

        return formatField(20,this.article.getDesignation()) +
                '\t' + formatField(6,getRemise()) +
                '\t' + formatField(11, (new BigDecimal(this.article.getPrix())).setScale(2,BigDecimal.ROUND_CEILING)+" DH") +
                '\t' + formatField(8,this.quantite+"") +
                '\t' + formatField(10,(new BigDecimal(this.getPrixTotal()).setScale(2,BigDecimal.ROUND_CEILING))+" DH") ;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof  Achat){
            Achat achat = (Achat)obj;
            return (achat.numAchat==this.numAchat) ? true : false;
        }
        return false;
    }
}
