package com.tea.service;

import com.tea.entity.Genus;
import com.tea.entity.Spec;
import com.tea.repository.GenusRepository;
import com.tea.repository.SpecRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service

public class SpecService {
    @Resource
    private SpecRepository specRepository;
    public List findALL(){
        return specRepository.findAll();
    }
    public void save(Spec spec){
       specRepository.save(spec);



    }
    public void deleteById(Integer id){
       specRepository.deleteById(id);

    }
}
