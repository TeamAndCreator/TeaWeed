package com.tea.service;

import com.tea.entity.Genus;
import com.tea.repository.GenusRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class GenusService {
    @Resource
    private GenusRepository genusRepository;

    public List findAll(){

        return genusRepository.findAll();
    }
    //保存
    public void save(Genus genus){

 genusRepository.save(genus);
    }
    //删除
    public void deleteById(Integer id){
        genusRepository.deleteById(id);

    }
    //查询
    public Genus findById(Integer id){
        Optional<Genus> genus = genusRepository.findById(id);
        if (genus.isPresent()){
            return genus.get();
        }else {
            return null;
        }


    }
//批量删除
    public void deleteByIds(List<Integer> ids) {
        List<List<Integer>> idList=new ArrayList<>();
        idList.add(ids);
      genusRepository.deleteGenusByIdIn(ids);


    }
}