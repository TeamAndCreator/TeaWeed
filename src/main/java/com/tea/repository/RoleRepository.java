package com.tea.repository;


import com.tea.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface RoleRepository extends JpaRepository<Role,Integer>,JpaSpecificationExecutor<Role> {


}
