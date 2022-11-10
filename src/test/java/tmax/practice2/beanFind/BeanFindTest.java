package tmax.practice2.beanFind;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import tmax.practice2.AppConfig;

public class BeanFindTest {
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    void 모든빈출력하기(){
        String[] beanDefinitionName = ac.getBeanDefinitionNames();
        for (String s : beanDefinitionName) {
            Object bean = ac.getBean(s);
            System.out.println("Name = " + s +" object = "+bean);
        }
    }

    @Test
    void 애플리케이션빈출력(){
        String[] beanDefinitionName = ac.getBeanDefinitionNames();
        for (String s : beanDefinitionName) {
            BeanDefinition beanDefinition = ac.getBeanDefinition(s);

            //ROLE_APPLICATION : 사용자가 직접 등록한 bean
            //ROLE_INFRASTRUCTURE : 스프링이 내부에서 사용한 bean
            if (beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION) {
                Object bean = ac.getBean(s);
                System.out.println("Name = " + s +" object = "+bean);
            }
        }
    }
}