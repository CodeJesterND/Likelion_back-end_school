package sample.bean;

import org.springframework.context.annotation.Bean;

public class MyBeanConfig {
    //    <bean id="myBean" class="sample.MyBean"/>
    @Bean
    public MyBean myBean(){
        return new MyBean();
    }
}