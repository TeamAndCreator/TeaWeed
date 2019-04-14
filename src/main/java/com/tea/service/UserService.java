package com.tea.service;


import com.tea.entity.User;
import com.tea.repository.UserRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;

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

    public Integer login(User user) {
        User user1 = userRepository.findByPhoneNumber(user.getPhoneNumber());
        if (user1 != null) {
            String password_truth =user1.getPassword();
            if (password_truth.equals(user.getPassword()))
                return 1;
            else
                return 2;
        }else {
            return 0;
        }
    }
}
