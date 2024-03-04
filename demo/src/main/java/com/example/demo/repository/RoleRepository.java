package com.example.demo.repository;

import com.example.demo.entity.UserRole;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public class RoleRepository {
    @Autowired
    private EntityManager entityManager;
    public List<String> getRoleNames(String Username){
        String sql="Select ur.Role.RoleName from" + UserRole.class.getName()+" ur " //
        +" where ur.TaiKhoan.UserName=:Username";
        Query query=this.entityManager.createQuery(sql, String.class);
        query.setParameter("Username",Username);
        return query.getResultList();
    }
}
