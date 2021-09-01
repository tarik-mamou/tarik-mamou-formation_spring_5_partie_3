package application;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.annotation.PostConstruct;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


public class Facture {
    private static final Logger logger = LogManager.getLogger("HelloWorld");
    private Additioneur additioneur;

    private Map<String, Integer> consommation = new HashMap<>();

    public void setConsommation(Map<String, Integer> consommation) {
        this.consommation = consommation;
    }

    public Facture(Date date, Additioneur additioneur) {
        this.date = date;
        this.additioneur = additioneur;
    }

    @PostConstruct
    private void init() {
        logger.info("demarrage du service Facture");

    }

    Date date;


    Facture() {
        this.date = new Date();
    }

    public Facture(Date date) {
        this.date = date;
    }


    public String genererFacture() {
        logger.info("appel de la methode genererFacture");
        int addition = additioneur.additioner(this.consommation.values());
        return "la facture contient "+this.consommation.keySet() +" la somme est :" + addition;
    }

    @Override
    public String toString() {
        return "Facture{" +
                "date=" + date +
                '}';
    }
}
