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
    //查询所有
    public List findALL(){
        return specRepository.findAll();
    }
    //保存
    public void save(Spec spec){
       specRepository.save(spec);



    }
    //单个删除
    public void deleteById(Integer id){
       specRepository.deleteById(id);

    }
}
