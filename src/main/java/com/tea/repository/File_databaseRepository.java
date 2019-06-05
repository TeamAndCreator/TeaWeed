package com.tea.repository;


import com.tea.entity.File_database;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface File_databaseRepository extends JpaRepository<File_database,Integer>,JpaSpecificationExecutor<File_database> {

    @Query(value = "update File_database set input_result = :input_result where id = :id")
    @Modifying
    void update_input_result(Integer id , String input_result);

    @Query(value = "select new File_database(uuid_name,path,type,test_result,input_result) from File_database")
    @Modifying
    List page(Integer start , Integer pageSize);

}
