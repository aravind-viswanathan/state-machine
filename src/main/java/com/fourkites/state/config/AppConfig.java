package com.fourkites.state.config;

import org.springframework.beans.factory.config.ServiceLocatorFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fourkites.state.action.StateFactory;

@Configuration
public class AppConfig {

    @Bean
    public ServiceLocatorFactoryBean serviceLocatorBean(){
        ServiceLocatorFactoryBean bean = new ServiceLocatorFactoryBean();
        bean.setServiceLocatorInterface(StateFactory.class);
        return bean;
    }
}
