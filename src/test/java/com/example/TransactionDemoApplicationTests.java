package com.example;


import com.example.transactiondemo.repository.HinernateEntityServiceImpl;
import com.example.transactiondemo.service.TransactionService;
import jakarta.persistence.EntityManagerFactory;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.Transactional;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class TransactionDemoApplicationTests {

    @Autowired
    private EntityManagerFactory  entityManagerFactory;

    @Autowired
    private TransactionService transactionService;

    @Autowired
    private HinernateEntityServiceImpl hinernateEntityServiceImpl;

    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    @Autowired
    private PlatformTransactionManager platformTransactionManager;


    private void deleteData(){
        System.out.println(entityManagerFactory);
        hinernateEntityServiceImpl.deleteAll(HibernateEntity.class);
        sqlSessionTemplate.getSqlSessionFactory().openSession().delete("deleteAllData");
    }

    @Test
    @Rollback
    public void testSuccessfulTransaction() {
        System.out.println(platformTransactionManager);
        transactionService.successfulTransaction();
        assertEquals(1, hinernateEntityServiceImpl.getCount(HibernateEntity.class));

        try (SqlSession session = sqlSessionTemplate.getSqlSessionFactory().openSession()) {
            Integer count = session.selectOne("getCount");
//            Integer count = session.selectOne("SELECT COUNT(*) FROM MYBATIS_ENTITY");
            assertEquals(1, count);
        } catch (Exception e) {
            e.printStackTrace();
            fail("MyBatis entity not found.");
        }
        deleteData();
    }

    @Test
    @Rollback
    public void testFailTransactionWithMyBatis() {
        assertEquals(0, hinernateEntityServiceImpl.getCount(HibernateEntity.class));
        assertThrows(RuntimeException.class, () -> transactionService.failTransactionWithMyBatis());

        assertEquals(0, hinernateEntityServiceImpl.getCount(HibernateEntity.class));


        try (SqlSession session = sqlSessionTemplate.getSqlSessionFactory().openSession()) {
//            Integer count = session.selectOne("select count(*) from mybatis_entity");
            Integer count = session.selectOne("getCount");
            assertEquals(0, count);
        } catch (Exception e) {
            // Expecting no MyBatis entity to be found
        }

    }

    @Test
    @Rollback
    public void testFailTransactionWithHibernate() {
        assertEquals(0, hinernateEntityServiceImpl.getCount(HibernateEntity.class));
        assertThrows(RuntimeException.class, () -> transactionService.failTransactionWithHibernate());
        assertEquals(0, hinernateEntityServiceImpl.getCount(HibernateEntity.class));

        try (SqlSession session = sqlSessionTemplate.getSqlSessionFactory().openSession()) {
//            Integer count = session.selectOne("select count(*) from mybatis_entity");
            Integer count = session.selectOne("getCount");
            assertEquals(0, count);
        } catch (Exception e) {
            // Expecting no MyBatis entity to be found
        }
    }
}
