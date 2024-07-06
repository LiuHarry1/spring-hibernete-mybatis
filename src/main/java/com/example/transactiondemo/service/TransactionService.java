package com.example.transactiondemo.service;


import com.example.HibernateEntity;
import com.example.transactiondemo.entity.MyBatisEntity;
import com.example.transactiondemo.mapper.MyBatisMapper;
import com.example.transactiondemo.repository.HinernateEntityServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TransactionService {

//    @Autowired
//    private HibernateRepository hibernateRepository;
    @Autowired
    private MyBatisMapper myBatisMapper;
    @Autowired
    private HinernateEntityServiceImpl hinernateEntityServiceImpl;



    @Transactional
    public void successfulTransaction() {
        HibernateEntity hibernateEntity = new HibernateEntity();
        hibernateEntity.setName("Hibernate Entity");
//        hibernateRepository.save(hibernateEntity);
        hinernateEntityServiceImpl.save(hibernateEntity);

        MyBatisEntity myBatisEntity = new MyBatisEntity();
        myBatisEntity.setName("MyBatis Entity");
        myBatisMapper.insert(myBatisEntity);

        System.out.println(myBatisMapper.getCount());
    }

    @Transactional
    public void failTransactionWithMyBatis() {
        HibernateEntity hibernateEntity = new HibernateEntity();
        hibernateEntity.setName("Hibernate Entity");
//        hibernateRepository.save(hibernateEntity);
        hinernateEntityServiceImpl.save(hibernateEntity);

        MyBatisEntity myBatisEntity = new MyBatisEntity();
        myBatisEntity.setName("MyBatis Entity");
        myBatisMapper.insert(myBatisEntity);

        throw new RuntimeException("Failing transaction with MyBatis");
    }

    @Transactional
    public void failTransactionWithHibernate() {
        HibernateEntity hibernateEntity = new HibernateEntity();
        hibernateEntity.setName("Hibernate Entity");
//        hibernateRepository.save(hibernateEntity);
        hinernateEntityServiceImpl.save(hibernateEntity);

        throw new RuntimeException("Failing transaction with Hibernate");

        // MyBatisEntity myBatisEntity = new MyBatisEntity();
        // myBatisEntity.setName("MyBatis Entity");
        // myBatisMapper.insert(myBatisEntity);
    }
}
