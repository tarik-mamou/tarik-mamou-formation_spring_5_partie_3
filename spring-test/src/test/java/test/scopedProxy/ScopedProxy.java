package test.scopedProxy;

import application.ConfigurationApplication;
import application.Facture;
import javafx.application.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@ContextConfiguration(classes = {ConfigurationApplicationTest.class})
@RunWith(SpringRunner.class)
public class ScopedProxy {
    @Autowired
    ApplicationContext applicationContext;

    @Test
    public void test() {
        //Cours cours1=applicationContext.getBean("monCours",Cours.class);
        //System.out.println(cours1);
        //Cours cours2=applicationContext.getBean("monCours",Cours.class);
        //System.out.println(cours2);
        Etudiant etudiant1=applicationContext.getBean("monEtudiant",Etudiant.class);
        Etudiant etudiant2=applicationContext.getBean("monEtudiant",Etudiant.class);

        System.out.println(etudiant1);
        System.out.println(etudiant2);


    }


}
