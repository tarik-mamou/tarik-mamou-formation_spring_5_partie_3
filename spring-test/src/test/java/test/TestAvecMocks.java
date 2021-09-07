package test;

import application.Additioneur;
import application.ConfigurationApplication;
import application.Facture;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.util.ReflectionTestUtils;

import static org.mockito.ArgumentMatchers.*;

@ContextConfiguration(classes = {ConfigurationApplication.class})
@RunWith(SpringRunner.class)
public class TestAvecMocks {


    private Additioneur monAdditioneur;

    @Autowired
    private ApplicationContext context;

    @Autowired
    private Facture facture;



    @Before
    public void before() {
        monAdditioneur = Mockito.mock(Additioneur.class);
        Mockito.when(monAdditioneur.additioner(anyCollection())).thenReturn(5);
        ReflectionTestUtils.setField(facture, "additioneur", monAdditioneur);
    }

    @Test
    public void test() {

        System.out.println(facture.genererFacture());
        System.out.println(facture);
    }
}
