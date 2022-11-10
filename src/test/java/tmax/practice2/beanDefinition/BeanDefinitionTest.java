package tmax.practice2.beanDefinition;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import tmax.practice2.AppConfig;

public class BeanDefinitionTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    void  빈설정메타정보확인(){
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        for (String a : beanDefinitionNames) {
            BeanDefinition beanDefinition = ac.getBeanDefinition(a);

            if (beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION) {
                System.out.println("beanDefinitionName = " + a + " beanDefinition = " + beanDefinition);
            }
        }
    }
}
