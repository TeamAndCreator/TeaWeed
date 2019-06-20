package com.tea.service;

import com.tea.entity.Section;
import com.tea.repository.SectionRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SectionService {
    @Resource
    private SectionRepository sectionRepository;
    public List findAll(){

        return sectionRepository.findAll();
    }
    //保存
    public void save(Section section){

        sectionRepository.save(section);
    }
    //删除
    public void deleteById(Integer id){
        sectionRepository.deleteById(id);

    }
    //查询
    public Section findById(Integer id){
        Optional<Section> section = sectionRepository.findById(id);
        if (section.isPresent()){
            return section.get();
        }else {
            return null;
        }


    }
    //批量删除
    public void deleteByIds(List<Integer> ids) {
        List<List<Integer>> idList=new ArrayList<>();
        idList.add(ids);
        sectionRepository.deleteSectionByIdIn(ids);


    }
}
