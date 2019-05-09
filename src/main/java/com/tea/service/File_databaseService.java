package com.tea.service;

import com.tea.entity.File_database;
import com.tea.entity.User;
import com.tea.repository.File_databaseRepository;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@Transactional
@Service
public class File_databaseService {

    @Resource
    private File_databaseRepository file_databaseRepository;

    @Resource
    private UserService userService;

    @Value("${file.root_path}")
    private String root_path;

    public Integer save(MultipartFile multipartFile,String test_result ,String type) throws IOException {
        /*获取当前用户*/
        Subject current_user = SecurityUtils.getSubject();
        String phone_number = (String) current_user.getSession().getAttribute("username");
        User user = userService.findByPhoneNumber(phone_number);
        /*获取当前时间*/
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String strTime = sdf.format(new Date());
        //物理路径
        String path = root_path+type+"/"+user.getId();
        String name = multipartFile.getOriginalFilename();
        //获取文件后缀
        String fileEnd = name.substring(name.lastIndexOf(".") + 1).toLowerCase();
        //创建唯一文件名
        String uuid= UUID.randomUUID().toString();
        String uuid_name=uuid+"."+fileEnd;
        File file = new File(path,uuid_name);
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
        multipartFile.transferTo(new File(path + File.separator + uuid_name));
        File_database file_database = new File_database(name,uuid_name,path,type,strTime,test_result,user);
        File_database saved_file_database = file_databaseRepository.save(file_database);
        return saved_file_database.getId();
    }

    public void update_input_result(Integer id , String input_result){
        file_databaseRepository.update_input_result(id, input_result);
    }

}
