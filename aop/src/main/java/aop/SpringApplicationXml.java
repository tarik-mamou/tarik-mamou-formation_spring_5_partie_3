package aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.HashMap;
import java.util.Map;

public class SpringApplicationXml {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConfigurationApplication.class);
        Facture facture = context.getBean("maFacture",Facture.class);
        Map<String, Integer> consommation = new HashMap<>();
        consommation.put("boissons ", 10);
        consommation.put("repas", 20);
        consommation.put("desseret", 10);
        facture.setConsommation(consommation);
        String resulat = facture.genererFacture();
        System.out.println(resulat);
    }
}
