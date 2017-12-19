package com.conceptual.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;
import com.conceptual.tools.loan.Calculator;
import com.conceptual.games.Bowling;

/**
 * Class used for Spring Application DI Configuration.
 * <br/> NOTE: Spring scope default is 'prototype'
 * 
 * @since 12/19/2017
 * @author Christopher Jepson
 * @see com.conceptual.config.AbstractConfig
 */
@Configuration
public class AppConfig extends AbstractConfig {
    
    public AppConfig(){
        super();
    }
    
    /**
     * @see com.conceptual.tools.number.Finder
     */
    @Bean
    public com.conceptual.tools.number.Finder numberFinder(){
        return new com.conceptual.tools.number.Finder();
    }
    
    /**
     * @see com.conceptual.tools.string.Finder
     */
    @Bean
    public com.conceptual.tools.string.Finder stringFinder(){
        return new com.conceptual.tools.string.Finder();
    }
    
    /**
     * @see com.conceptual.tools.loan.Calculator
     */
    @Bean
    public Calculator calculator(){
        return new Calculator();
    }
    
    /**
     * @see com.conceptual.games.Bowling
     */
    @Bean
    public Bowling bowling(){
        return new Bowling();
    }
    
}