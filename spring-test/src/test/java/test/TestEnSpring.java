package test;

import application.Additioneur;
import application.ConfigurationApplication;
import application.Facture;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static org.springframework.test.annotation.DirtiesContext.MethodMode.BEFORE_METHOD;


@ContextConfiguration(classes = {ConfigurationApplication.class})
@RunWith(SpringRunner.class)
public class TestEnSpring {

    @Autowired
    Facture facture;

    @Test
    public void test() {


        int a = 5;
        int b = 10;
        int resultatAttendu = 15;
        Additioneur additioneur = new Additioneur();


        int result = additioneur.additioner(a, b);

        Assert.assertEquals(resultatAttendu, result);



    }

    @Test
    public void test2() {
        int a = 5;
        int b = 10;
        int resultatNonAttendu = 17;
        Additioneur additioneur = new Additioneur();
        int result = additioneur.additioner(a, b);
        Assert.assertNotEquals(resultatNonAttendu, result);
    }

    @Test
    public void testFacture() {
        String resultatAttendu = "la facture contient [boissons , desseret, repas] la somme est :40";
        Additioneur additioneur = new Additioneur();
        Facture facture = new Facture(new Date(), additioneur);
        facture.genererFacture();
        Map<String, Integer> consommation = new HashMap<>();
        consommation.put("boissons ", 10);
        consommation.put("repas", 20);
        consommation.put("desseret", 10);
        facture.setConsommation(consommation);
        String resultatReel = facture.genererFacture();
        Assert.assertEquals(resultatAttendu, resultatReel);
    }

    @Test
    public void testApplicationContext() {
        String resultatAttendu = "la facture contient [boissons , desseret, repas] la somme est :40";

        Map<String, Integer> consommation = new HashMap<>();
        consommation.put("boissons ", 10);
        consommation.put("repas", 20);
        consommation.put("desseret", 10);
        facture.setConsommation(consommation);


        String resultatReel = facture.genererFacture();

        Assert.assertEquals(resultatAttendu, resultatReel);

    }

    @Test
    @DirtiesContext(methodMode = BEFORE_METHOD)
    public void testChampPrive() throws IllegalAccessException {
        Map<String, Integer> consommation = new HashMap<>();
        consommation.put("boissons ", 10);
        consommation.put("repas", 20);
        consommation.put("desseret", 10);
        facture.setConsommation(consommation);

        Map<String, Integer> consommationRelle = (Map<String, Integer>) ReflectionTestUtils.getField(facture, "consommation");
        Assert.assertEquals(consommation, consommationRelle);
    }

    @Test
    public void testSansDirtiesContext() {

        Map<String, Integer> consommation = (Map<String, Integer>) ReflectionTestUtils.getField(facture, "consommation");
        Assert.assertFalse(consommation.isEmpty());
    }

    @Test
    @DirtiesContext
    public void testAvecDirtiesContext() {

        Map<String, Integer> consommation = (Map<String, Integer>) ReflectionTestUtils.getField(facture, "consommation");
        Assert.assertTrue(consommation.isEmpty());
    }
}

