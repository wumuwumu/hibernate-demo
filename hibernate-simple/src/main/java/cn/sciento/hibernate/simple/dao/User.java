package cn.sciento.hibernate.simple.dao;

import org.hibernate.annotations.IndexColumn;

import javax.persistence.*;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Entity
@Table(name = "sys_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private Integer age;

    @ElementCollection
    @CollectionTable(name = "user_email")
    @Column(name = "email")
    private List<String> emailList;

    @ElementCollection
    @CollectionTable(name = "user_tags")
    @Column(name = "tag")
    private Set<String> tagList;

    @ElementCollection
    @CollectionTable(name = "user_more_info")
    @Column(name = "info")
    private Map<String,String> moreInfo;

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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public List<String> getEmailList() {
        return emailList;
    }

    public void setEmailList(List<String> emailList) {
        this.emailList = emailList;
    }

    public Set<String> getTagList() {
        return tagList;
    }

    public void setTagList(Set<String> tagList) {
        this.tagList = tagList;
    }

    public Map<String, String> getMoreInfo() {
        return moreInfo;
    }

    public void setMoreInfo(Map<String, String> moreInfo) {
        this.moreInfo = moreInfo;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", emailList=" + emailList +
                ", tagList=" + tagList +
                ", moreInfo=" + moreInfo +
                '}';
    }
}
