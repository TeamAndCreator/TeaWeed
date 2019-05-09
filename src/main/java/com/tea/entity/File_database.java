package com.tea.entity;



import javax.persistence.*;

@Entity
public class File_database {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /*文件原名*/
    private String name;

    /*改名后的文件名*/
    private String uuid_name;

    /*文件路径*/
    private String path;

    /*文件类型（竹藤或杂草）*/
    private String type;

    /*上传时间*/
    private String time;

    /*检测结果*/
    private String test_result;

    /*用户输入结果*/
    private String input_result;

    /*上传用户*/
    @ManyToOne
    private User user;

    public File_database(){}

    public File_database(String name,String uuid_name,String path,String type,String time,String test_result,User user){
        this.name=name;
        this.uuid_name=uuid_name;
        this.path=path;
        this.type=type;
        this.time=time;
        this.test_result=test_result;
        this.user=user;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUuid_name() {
        return uuid_name;
    }

    public void setUuid_name(String uuid_name) {
        this.uuid_name = uuid_name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getTest_result() {
        return test_result;
    }

    public void setTest_result(String test_result) {
        this.test_result = test_result;
    }

    public String getInput_result() {
        return input_result;
    }

    public void setInput_result(String input_result) {
        this.input_result = input_result;
    }

    @Override
    public String toString() {
        return "File_database{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", uuid_name='" + uuid_name + '\'' +
                ", path='" + path + '\'' +
                ", type='" + type + '\'' +
                ", time='" + time + '\'' +
                ", test_result='" + test_result + '\'' +
                ", input_result='" + input_result + '\'' +
                ", user=" + user +
                '}';
    }
}
