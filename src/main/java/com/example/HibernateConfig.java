//package com.example;
//
//import org.hibernate.SessionFactory;
//import org.hibernate.dialect.H2Dialect;
//import org.springframework.boot.jdbc.DataSourceBuilder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.io.ClassPathResource;
//import org.springframework.core.io.Resource;
//import org.springframework.jdbc.datasource.init.DataSourceInitializer;
//import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
//import org.springframework.orm.hibernate5.HibernateTransactionManager;
//import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
//import org.springframework.orm.hibernate5.SpringSessionContext;
//import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
//import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
//import org.springframework.transaction.annotation.EnableTransactionManagement;
//import java.util.Properties;
//import javax.sql.DataSource;
//
//@Configuration
//@EnableTransactionManagement()
//public class HibernateConfig {
//
//    @Bean
//    public DataSource dataSource() {
//        return DataSourceBuilder.create()
//                .url("jdbc:h2:mem:testdb")
//                .username("sa")
//                .password("")
//                .driverClassName("org.h2.Driver")
//                .build();
//    }
//
//       @Bean
//    public LocalSessionFactoryBean sessionFactory(DataSource dataSource) {
//        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
//        sessionFactory.setDataSource(dataSource);
//        // Set packages to scan for entity classes
//        sessionFactory.setPackagesToScan("com.example");
//        // Set Hibernate properties
//
//        sessionFactory.setHibernateProperties(hibernateProperties());
//        return sessionFactory;
//    }
//
////    @Bean
////    public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource) {
////        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
////        em.setDataSource(dataSource);
////        em.setPackagesToScan("com.example"); // Update with your package containing JPA entities
////        em.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
////
////        em.setJpaProperties(hibernateProperties());
////        return em;
////    }
//
//        @Bean
//    public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
//        HibernateTransactionManager txManager = new HibernateTransactionManager();
//        txManager.setSessionFactory(sessionFactory);
//        return txManager;
//    }
//
//    @Bean
//    public DataSourceInitializer dataSourceInitializer(DataSource dataSource) {
//        DataSourceInitializer initializer = new DataSourceInitializer();
//        initializer.setDataSource(dataSource);
//        Resource resource = new ClassPathResource("schema.sql");
//        initializer.setDatabasePopulator(new ResourceDatabasePopulator(resource));
//        return initializer;
//    }
//
//    private Properties hibernateProperties() {
//        Properties properties = new Properties();
//        properties.setProperty("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
//        properties.setProperty("hibernate.hbm2ddl.auto", "create");
//        properties.setProperty("hibernate.current_session_context_class", SpringSessionContext.class.getName());
//        return properties;
//    }
//}
