package com.tea.service;

import com.tea.entity.Permission;
import com.tea.repository.PermissionRepository;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class PermissionService {

    @Resource
    private PermissionRepository permissionRepository;

    public void save(Permission permission){
        permissionRepository.save(permission);
    }

    public void delete(Integer id){
        permissionRepository.deleteById(id);
    }

    public List findAll(){
        return permissionRepository.findAll();
    }

}
