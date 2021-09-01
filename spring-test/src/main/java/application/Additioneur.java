package application;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Collection;

@Service
public class Additioneur {
    private static final Logger logger = LogManager.getLogger("HelloWorld");
    private  String nom;

    @PostConstruct
    private void init(){
        logger.info("demarrage du service Additioneur");

    }

    @Override
    public String toString() {
        return "Additioneur{" +
                "nom='" + nom + '\'' +
                '}';
    }

    public Additioneur() {
        nom="additioneur";
    }

    public  int additioner(int a, int b) {
        logger.info("additioner {} et {} ",a,b);
        return a + b;

    }


    public int additioner(Collection<Integer> values) {

        return values.stream().reduce(0,  Integer::sum);
    }
}
