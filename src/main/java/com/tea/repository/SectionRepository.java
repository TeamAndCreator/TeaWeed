package com.tea.repository;



import com.tea.entity.Section;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface SectionRepository extends JpaRepository<Section,Integer>, JpaSpecificationExecutor<Section> {
    void deleteSectionByIdIn(List<Integer> ids);
}
