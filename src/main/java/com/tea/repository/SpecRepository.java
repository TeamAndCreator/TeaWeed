package com.tea.repository;

import com.tea.entity.Genus;
import com.tea.entity.Spec;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SpecRepository extends JpaRepository<Spec,Integer>, JpaSpecificationExecutor<Spec> {
    void deleteSpecByIdIn(List<Integer> ids);

    @Query(value = "SELECT new Spec (id,specNameCh,specImgs) from Spec where genus.id = :id")
    @Modifying
    List<Spec> findByGenus(Integer id);

}

