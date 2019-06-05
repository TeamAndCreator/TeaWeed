package com.tea.service;



import com.tea.entity.User;
import com.tea.repository.UserRepository;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class UserService {

    @Resource
    private UserRepository userRepository;

    public void save(User user) {
        Date time = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String createTime = sdf.format(time);
        user.setCreateTime(createTime);
        user.setActive(1);
        userRepository.save(user);
    }


    public List findAll(){
        return userRepository.findAll();
    }

    public  void deleteById(Integer id){
        userRepository.deleteById(id);
    }
    //    @Cacheable(value = "cache01",unless="#result == null",key = "#p0")
    public User findByPhoneNumber(String phoneNumber){
        return userRepository.findByPhoneNumber(phoneNumber);
    }
}
