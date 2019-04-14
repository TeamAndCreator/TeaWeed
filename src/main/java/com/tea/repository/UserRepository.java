package com.tea.repository;


import com.tea.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;

public interface UserRepository extends JpaRepository<User,Integer> ,JpaSpecificationExecutor<User> {

    User findByPhoneNumber(String phoneNumber);

}
