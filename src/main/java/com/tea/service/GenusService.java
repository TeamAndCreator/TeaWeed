package com.tea.service;

import com.tea.entity.Genus;
import com.tea.repository.GenusRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class GenusService {
    @Resource
    private GenusRepository genusRepository;
    public List findAll(){

        return genusRepository.findAll();
    }
    public void save(Genus genus){

 genusRepository.save(genus);
    }
    public void deleteById(Integer id){
        genusRepository.deleteById(id);

    }
    public void findById(Integer id){
        genusRepository.findById(id);
    }
}
