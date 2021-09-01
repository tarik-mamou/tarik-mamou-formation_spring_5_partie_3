package application;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.HashMap;
import java.util.Map;

public class SpringApplication {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(ConfigurationApplication.class);
        Facture facture = context.getBean(Facture.class);
        Map<String, Integer> consommation = new HashMap<>();
        consommation.put("boissons ", 10);
        consommation.put("repas", 20);
        consommation.put("desseret", 10);
        facture.setConsommation(consommation);
        String resulat = facture.genererFacture();
        System.out.println(resulat);
    }
}
