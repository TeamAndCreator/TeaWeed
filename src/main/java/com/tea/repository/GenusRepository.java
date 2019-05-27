package com.tea.repository;

import com.tea.entity.Genus;
import com.tea.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface GenusRepository extends JpaRepository<Genus,Integer> , JpaSpecificationExecutor<Genus> {

}
