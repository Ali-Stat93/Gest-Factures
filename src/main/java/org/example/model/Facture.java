package org.example.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Facture {
    private static int numFacture =0;
    private LocalDate date;
    private List<Achat> achats;

    /** Constructors **/
    /**
     * Constructeur par defaut
     */
    public Facture() {
        numFacture++;
        date=LocalDate.now();
        achats=new ArrayList<>();
    }

    /**
     *
     * @param date
     * @param achats
     */
    public Facture(LocalDate date, List<Achat> achats) {
        numFacture++;
        this.date = date;
        this.achats = achats;
    }

    /** Methodes **/

    /**
     * Ajouter un nouveau achat
     * @param achat mon achat
     * @throws Exception si l'echat exise deja une erreur va être renvoye
     */
    public void addAchat(Achat achat) throws  Exception{
        if(achats.contains(achat)){
            throw new Exception("Achat existe déja");
        }else
            achats.add(achat);
    }

    /**
     * Le prix total de la facture
     * @return
     */
    public double montantFacture(){
        //Init somme
        double facture = 0;

        //Boucle sur les achats pr ajouter le prix total de chaque achat dans la facture total
        for (Achat achat : achats)
            facture+=achat.getPrixTotal();

        return facture;

    }

    @Override
    public String toString() {
        DateTimeFormatter formatters = DateTimeFormatter.ofPattern("d/MM/uuuu");

        String text  = "Numéro facture" + numFacture + "date facture " + this.date.format(formatters)+"\n"+
                "Liste des achats\n"+
                "Désignation         \tremise\tprix(en DH)\tquantité\tprix Total\n";
        for(Achat achat:achats)
            text+=achat.toString()+'\n';
        text +="\nMontant de la facture: "+(new BigDecimal(this.montantFacture()).setScale(2,BigDecimal.ROUND_CEILING))+" DH";

        return text;
    }
}
