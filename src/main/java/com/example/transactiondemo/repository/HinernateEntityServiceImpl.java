package com.example.transactiondemo.repository;

import com.example.HibernateEntity;
import com.example.transactiondemo.entity.ARole;
import com.example.transactiondemo.entity.AUser;
import com.example.transactiondemo.entity.AuserWithSpecificRoleDTO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class HinernateEntityServiceImpl {
//    @Autowired
    @PersistenceContext
//    SessionFactory sessionFactory ;
    private EntityManager entityMananger;


    public void save(HibernateEntity hibernateEntity){
//        Session session = sessionFactory.getCurrentSession();
        Session session = entityMananger.unwrap(Session.class);
            session.save(hibernateEntity);



    }

    public void save(AUser user){
//        Session session = sessionFactory.getCurrentSession();
        Session session = entityMananger.unwrap(Session.class);
        session.save(user);

    }

    public AUser getAuser(long id){
        Session session = entityMananger.unwrap(Session.class);
//        session.createQuery("select from AUser");
        AUser auser = session.get(AUser.class, id);
//        System.out.println(auser);
        return auser;
    }

    @Transactional
    public List<AUser> getAuserByRoleId(Long userId) {
        Session session = entityMananger.unwrap(Session.class);

        // Create CriteriaBuilder
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();

        // Create CriteriaQuery
        CriteriaQuery<AUser> criteriaQuery = criteriaBuilder.createQuery(AUser.class);

        // Define root for the query
        Root<AUser> auserRoot = criteriaQuery.from(AUser.class);

        criteriaQuery.where(criteriaBuilder.equal(auserRoot.get("id"), userId));

//        // Join with Arole
//        Join<AUser, ARole> roleJoin = auserRoot.join("roles");
//
//        // Add predicate for Arole ID
//        criteriaQuery.where(criteriaBuilder.equal(roleJoin.get("id"), roleId));

        // Execute the query
        List<AUser> users = session.createQuery(criteriaQuery).getResultList();

//        session.detach(users.get(0));

        return users;
    }

    @Transactional
    public List<AuserWithSpecificRoleDTO> getAuserWithSpecificRole(Long userId, Long roleId) {
        String jpql = "SELECT new com.example.transactiondemo.entity.AuserWithSpecificRoleDTO(" +
                "u.id, u.name, r.id, r.name) " +
                "FROM AUser u JOIN u.roles r " +
                "WHERE u.id = :userId AND r.id = :roleId";

        TypedQuery<AuserWithSpecificRoleDTO> query = entityMananger.createQuery(jpql, AuserWithSpecificRoleDTO.class);
        query.setParameter("userId", userId);
        query.setParameter("roleId", roleId);

        return query.getResultList();
    }


    public <T> void deleteAll(Class<T> clazz) {
//        Session session = sessionFactory.getCurrentSession();
        Session session = entityMananger.unwrap(Session.class);
        String hql = "delete from " + clazz.getName();
        session.createQuery(hql).executeUpdate();
    }

    public <T> long getCount(Class<T> clazz) {
//        Session session = sessionFactory.getCurrentSession();
        Session session = entityMananger.unwrap(Session.class);
        TypedQuery<Long> query = session.createQuery("select count(e) from " + clazz.getName() + " e", Long.class);
        return query.getSingleResult();
    }

    public <T> List<T> getAll(Class<T> clazz) {
//        Session session = sessionFactory.getCurrentSession();
        Session session = entityMananger.unwrap(Session.class);
        TypedQuery<T> query = session.createQuery("from " + clazz.getName(), clazz);
        return query.getResultList();
    }
}
