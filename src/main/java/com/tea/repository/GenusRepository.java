package com.tea.repository;

import com.tea.entity.Genus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface GenusRepository extends JpaRepository<Genus,Integer> , JpaSpecificationExecutor<Genus> {
       void deleteGenusByIdIn(List<Integer> ids);

}
