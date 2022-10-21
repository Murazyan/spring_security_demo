package com.example.spring_security_demo.repository;

import com.example.spring_security_demo.model.Role;
import com.example.spring_security_demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.UUID;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    @Modifying
    @Transactional
    @Query("update Role r set r.name=:name where r.id=:id")
    void updateNameById(@Param("id") long id,
                        @Param("name")String name);


    @Modifying
    @Transactional()
    @Query(value = "update roles r set r.name=:name where r.id=:id; update ", nativeQuery = true)
    void updateNameByIsdfd(@Param("id") long id,
                        @Param("name")String name);


}
