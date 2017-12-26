package com.conceptual.config;

import java.time.YearMonth;
import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.conceptual.tools.loan.Calculator;


public class Main {
    
    public static final void main(String argvs[]){
        
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        
        ctx.scan("com.conceptual.config");
        ctx.refresh();
        
        // Sample code...
        Calculator calculator = ctx.getBean(Calculator.class);
        List<YearMonth> projection = calculator.projectLoanData(10_000.00, 0.12, 300.00);
        System.out.println( calculator.getPrincipal( projection.get(0) ) );
        
        ctx.close();
    }
}
