package com.yang.shop.dao;

import com.yang.framework.Repository.MyRepository;
import com.yang.shop.entity.auth.ManUser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by Administrator on 2017/8/8.
 */
public interface ManUserDao extends MyRepository<ManUser, Long> {

    //Page<ManUser> findAll(Specification<ManUser> spec, Pageable pageRequest);

    List<ManUser> findByUsername(String name);

    List<ManUser> findByEmail(String email);
}
