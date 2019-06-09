package com.tea.service;

import com.tea.entity.Role;
import com.tea.entity.Spec;
import com.tea.repository.RoleRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

@Service
public class RoleService {

    @Resource
    private RoleRepository roleRepository;

    public void save(Role role){
        roleRepository.save(role);
    }

    public void delete(Integer id){
        roleRepository.deleteById(id);
    }

    public List<Role> findAll(){
        return roleRepository.findAll();
    }
    public  Role  findById(Integer id){
        Optional<Role> role=roleRepository.findById(id);
        if (role.isPresent()){
            return role.get();
        }else {
            return null;
        }
    }
}
