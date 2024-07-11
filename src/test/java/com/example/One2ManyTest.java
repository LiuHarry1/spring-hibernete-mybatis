package com.example;


import com.example.transactiondemo.entity.AUser;
import com.example.transactiondemo.entity.ARole;
import com.example.transactiondemo.entity.AuserWithSpecificRoleDTO;
import com.example.transactiondemo.repository.HinernateEntityServiceImpl;
import com.example.transactiondemo.service.TransactionService;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.PlatformTransactionManager;

import java.util.List;
import java.util.Set;

@SpringBootTest
public class One2ManyTest {


    @Autowired
    private TransactionService transactionService;

    @Autowired
    private HinernateEntityServiceImpl hinernateEntityServiceImpl;

    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    @Autowired
    private PlatformTransactionManager platformTransactionManager;



    @Test
    @Rollback
    public void testSuccessfulTransaction() {

        AUser user = new AUser();
        user.setName("user1");
        user.setId(1l);

        ARole role1 =new ARole();
        role1.setId(1l);
        role1.setName("role1");
        user.getRoles().add(role1);

        ARole role2 =new ARole();
        role2.setId(2l);
        role2.setName("role2");
        user.getRoles().add(role2);



        hinernateEntityServiceImpl.save(user);
//        AUser result = hinernateEntityServiceImpl.getAuser(1l);
        List<AUser> result =hinernateEntityServiceImpl.getAuserByRoleId(1l);
//        List<AuserWithSpecificRoleDTO> result = hinernateEntityServiceImpl.getAuserWithSpecificRole(1l, 1l);
        System.out.println(result);

    }

}
