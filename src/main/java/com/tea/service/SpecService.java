package com.tea.service;

import com.tea.entity.Genus;
import com.tea.entity.Spec;
import com.tea.repository.GenusRepository;
import com.tea.repository.SpecRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
    //查询
    public   Spec findById(Integer id){
        Optional<Spec> spec=specRepository.findById(id);
        if (spec.isPresent()){
            return spec.get();
        }else {
            return null;
        }

    }
    //批量删除
    public void deleteByIds(List<Integer> ids) {
        List<List<Integer>> idList=new ArrayList<>();
        idList.add(ids);
        specRepository.deleteSpecByIdIn(ids);


    }
}
