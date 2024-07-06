-- Create table for MyBatisEntity
CREATE TABLE IF NOT EXISTS MYBATIS_ENTITY (
                                              id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                              name VARCHAR(255) NOT NULL
    );

-- Create table for HibernateEntity (assuming an example schema)
CREATE TABLE IF NOT EXISTS HIBERNATE_ENTITY ( id BIGINT AUTO_INCREMENT PRIMARY KEY,
name VARCHAR(255) NOT NULL
);
