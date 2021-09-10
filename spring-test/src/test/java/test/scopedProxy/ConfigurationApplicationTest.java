package test.scopedProxy;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;

@Configuration
public class ConfigurationApplicationTest {

   // @Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE,
    //        proxyMode = ScopedProxyMode.TARGET_CLASS)
    @Bean()
    @Scope( value = ConfigurableBeanFactory.SCOPE_PROTOTYPE,
            proxyMode = ScopedProxyMode.TARGET_CLASS)
    public Cours monCours() {
        return new Cours("francais");
    }

    @Bean
    public Etudiant monEtudiant(Cours cours) {
        return new Etudiant(cours);
    }
}

