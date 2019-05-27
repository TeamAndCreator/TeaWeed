package com.tea.repository;

import com.tea.entity.Genus;
import com.tea.entity.Spec;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface SpecRepository extends JpaRepository<Spec,Integer>, JpaSpecificationExecutor<Spec> {
}
