-- Create table for MyBatisEntity
CREATE TABLE IF NOT EXISTS MYBATIS_ENTITY (
                                              id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                              name VARCHAR(255) NOT NULL
    );

-- Create table for HibernateEntity (assuming an example schema)
CREATE TABLE IF NOT EXISTS HIBERNATE_ENTITY ( id BIGINT AUTO_INCREMENT PRIMARY KEY,
name VARCHAR(255) NOT NULL
);


CREATE TABLE IF NOT EXISTS AUSER ( id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                              name VARCHAR(255) NOT NULL,
                                    fk_role_id BIGINT
    );

CREATE TABLE IF NOT EXISTS AROLE ( id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                   name VARCHAR(255) NOT NULL
    );
