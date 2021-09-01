package application;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Date;

@Configuration
public class ConfigurationApplication {



    @Bean
    public Facture maFacture(Additioneur additioneur) {

        return new Facture(new Date(),additioneur);
    }

    @Bean
    public Additioneur monAdditioneur() {
    return  new Additioneur();
    }

}