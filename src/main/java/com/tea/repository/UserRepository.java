package com.tea.repository;


import com.tea.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Integer> ,JpaSpecificationExecutor<User> {

    User findByPhoneNumber(String phoneNumber);
    void deleteUsersByIdIn(List<Integer> ids);

}
