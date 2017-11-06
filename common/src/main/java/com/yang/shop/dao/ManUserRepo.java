package com.yang.shop.dao;

import com.yang.framework.Repository.MyRepository;
import com.yang.shop.entity.auth.ManUser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
* Auto generated file.
* The spring-data interface declaration of entity ManUser
*/
public interface ManUserRepo extends MyRepository<ManUser, String> {

    Page<ManUser> findAll(Specification<ManUser> spec, Pageable pageRequest);

    @Modifying
    @Query("update ManUser set password=? where username=?")
    void updatePasswd(String newPassword1, String username);

    List<ManUser> findByUsername(String name);

    List<ManUser> findByEmail(String email);
}
