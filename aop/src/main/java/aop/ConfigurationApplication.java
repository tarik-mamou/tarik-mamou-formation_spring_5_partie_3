package aop;

import org.springframework.context.annotation.*;

import java.util.Date;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan
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