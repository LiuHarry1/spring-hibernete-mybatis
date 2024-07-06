package com.example.transactiondemo.repository;

import com.example.HibernateEntity;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class HinernateEntityServiceImpl {
    @Autowired
    SessionFactory sessionFactory ;


    public void save(HibernateEntity hibernateEntity){
        Session session = sessionFactory.getCurrentSession();
            session.save(hibernateEntity);


    }
    public <T> void deleteAll(Class<T> clazz) {
        Session session = sessionFactory.getCurrentSession();
        String hql = "delete from " + clazz.getName();
        session.createQuery(hql).executeUpdate();
    }

    public <T> long getCount(Class<T> clazz) {
        Session session = sessionFactory.getCurrentSession();
        TypedQuery<Long> query = session.createQuery("select count(e) from " + clazz.getName() + " e", Long.class);
        return query.getSingleResult();
    }

    public <T> List<T> getAll(Class<T> clazz) {
        Session session = sessionFactory.getCurrentSession();
        TypedQuery<T> query = session.createQuery("from " + clazz.getName(), clazz);
        return query.getResultList();
    }
}
