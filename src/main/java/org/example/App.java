package org.example;

import org.example.model.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        /** Liste des articles **/
        Article article1 = new Article(1,"USB",60, Categorie.INFORMATIQUE);
        Article article2 = new Article(2,"Chaise",450, Categorie.BUREAUTIQUE);
        ArticleEnSolde article3 = new ArticleEnSolde(3,"Clavier",120, Categorie.INFORMATIQUE,10);
        ArticleEnSolde article4 = new ArticleEnSolde(4,"Bureau",1000, Categorie.BUREAUTIQUE,20);
        Article article5 = new Article(5,"Souris",150, Categorie.INFORMATIQUE);

        List<Article> articles = new ArrayList<>();
        articles.add(article1);
        articles.add(article2);
        articles.add(article3);
        articles.add(article4);
        articles.add(article5);

        /** Liste des achats **/
        List<Achat>   achats = new ArrayList<>();
        int j=0;
        for (Article article:articles){
            int i = (int)Math.floor(Math.random()*5)+1;
            achats.add(new Achat(++j,article,i));
        }
        Facture facture = new Facture(LocalDate.now(),achats);

        try {
            facture.addAchat(new Achat(1,article3,4));
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        System.out.println(facture.toString());
    }
}
