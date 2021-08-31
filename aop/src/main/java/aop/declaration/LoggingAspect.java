package aop.declaration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
    private static final Logger logger = LogManager.getLogger("LoggingAspect");

    /*@AfterReturning("execution(public * *(..))")
    private void anyOldTransfer() {

        System.out.println("dans aspect");
        logger.info("dans aspect");

    } */// the pointcut signature


    @Pointcut("execution(public * *(..))")
    private void myPointCut() {
    }

    @Pointcut("execution(* aop.Facture.*(..))")
    private void myPointCutFacture() {
    }

   /* @Before("myPointCut()")
    private void beforeAdvice() {
        logger.info("dans before advice");
    }*/

    /*@AfterReturning(pointcut = "myPointCut()",
            returning="retVal")
    private void afterReturningAdvice(Object retVal) {

        logger.info("dans AfterReturning advice");
        logger.info("retour :"+retVal);
    }*/

  /*  @Around("myPointCutFacture()")
    private void AroundAdvice(ProceedingJoinPoint pjp) throws Throwable {

        logger.info("dans AroundAdvice  avant appel methode");
        pjp.proceed();
        logger.info("dans AroundAdvice  apres appel methode");

    }*/


    @Around("myPointCutFacture()")
    private Object AroundAdvicePlus(ProceedingJoinPoint pjp) throws Throwable {

        logger.info("dans AroundAdvice  avant appel methode");
        logger.info("object courant " + pjp.getTarget());
        logger.info("methode courante " + pjp.getSignature());
        logger.info("parametres methode  courante " + pjp.getArgs());
        Object retour = pjp.proceed();
        logger.info("dans AroundAdvice  apres appel methode");
        logger.info("retour de l appel : " + retour);
        return retour;

    }


}
