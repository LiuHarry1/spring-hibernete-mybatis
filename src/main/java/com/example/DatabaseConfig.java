//package com.example;
//
//import jakarta.persistence.EntityManagerFactory;
//import org.hibernate.SessionFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.boot.jdbc.DataSourceBuilder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
//import org.springframework.jdbc.datasource.DataSourceTransactionManager;
//import org.springframework.orm.hibernate5.HibernateTransactionManager;
//import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
//import org.springframework.orm.jpa.JpaTransactionManager;
//import org.springframework.transaction.PlatformTransactionManager;
//import org.springframework.transaction.TransactionManager;
//import org.springframework.transaction.annotation.EnableTransactionManagement;
//import org.springframework.transaction.annotation.TransactionManagementConfigurer;
//
//import javax.sql.DataSource;
//import java.util.Properties;
//
//@Configuration
//@EnableTransactionManagement()
//public class DatabaseConfig  {
//
////    @Bean
////    @Primary
////    @ConfigurationProperties("spring.datasource")
////    public DataSource dataSource() {
////        return DataSourceBuilder.create().build();
////    }
//
//    @Autowired
//    private DataSource dataSource;
//
//    @Autowired
//    private EntityManagerFactory entityManagerFactory;
//
////    @Bean
////    public LocalSessionFactoryBean sessionFactory() {
////        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
////        sessionFactory.setDataSource(dataSource);
////        // Set packages to scan for entity classes
////        sessionFactory.setPackagesToScan("com.example");
////        // Set Hibernate properties
////        Properties hibernateProperties = new Properties();
////        hibernateProperties.setProperty("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
////        sessionFactory.setHibernateProperties(hibernateProperties);
////        return sessionFactory;
////    }
////    @Bean
////    public PlatformTransactionManager transactionManager(DataSource dataSource) {
////        return new DataSourceTransactionManager(dataSource);
////    }
//
//
//    @Bean
//    public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
//        JpaTransactionManager transactionManager = new JpaTransactionManager();
//        transactionManager.setEntityManagerFactory(entityManagerFactory);
//        return transactionManager;
//    }
//
////    @Bean
////    public PlatformTransactionManager txManager(DataSource dataSource) {
////        return new DataSourceTransactionManager(dataSource);
////    }
////
////    @Override
////    public TransactionManager annotationDrivenTransactionManager() {
////        return  txManager(dataSource);
////    }
//
////    @Bean
////    public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
////        HibernateTransactionManager txManager = new HibernateTransactionManager();
////        txManager.setSessionFactory(sessionFactory);
////        return txManager;
////    }
//}
