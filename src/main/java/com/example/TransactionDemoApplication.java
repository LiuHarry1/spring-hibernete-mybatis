package com.example;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.autoconfigure.transaction.TransactionAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.transaction.PlatformTransactionManager;

//@SpringBootApplication(exclude = {HibernateJpaAutoConfiguration.class, DataSourceTransactionManagerAutoConfiguration.class})
@SpringBootApplication
public class TransactionDemoApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(TransactionDemoApplication.class, args);

        PlatformTransactionManager platformTransactionManager =  context.getBean(PlatformTransactionManager.class);
        System.out.println(platformTransactionManager);
    }
}
