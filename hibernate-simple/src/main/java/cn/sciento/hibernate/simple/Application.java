package cn.sciento.hibernate.simple;

import cn.sciento.hibernate.simple.dao.Boss;
import cn.sciento.hibernate.simple.dao.Employee;
import cn.sciento.hibernate.simple.dao.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Application {

    public static void main(String[] args){
        //Session session = new AnnotationConfiguration().configure().buildSessionFactory().openSession();
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml")
                .build();
        // 2. 根据服务注册类创建一个元数据资源集，同时构建元数据并生成应用一般唯一的的session工厂
        SessionFactory sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();

        /**** 上面是配置准备，下面开始我们的数据库操作 ******/
        Session session = sessionFactory.openSession();// 从会话工厂获取一个session
        Transaction t = session.beginTransaction();

        simple(session);
        association(session);
        t.commit();
        t.begin();
        User u = session.get(User.class,1);
        Boss boss = session.get(Boss.class,1);
        Employee employee = session.get(Employee.class,1);
        t.commit();
        System.out.println(u);
        System.out.println(boss);
        System.out.println(employee);

        session.close();
        System.out.println("successfully saved");


    }


    private static void simple(Session session){
        User e1 = new User();
        e1.setName("Yii");
        e1.setAge(21);
        e1.setEmailList(new ArrayList<String>(){
            {
                add("23322@qq.com");
                add("3444233443@fgf.com");
            }
        });
        e1.setTagList(new HashSet<String>(){{
            add("学生");
            add("大一");
        }});

        e1.setMoreInfo(new HashMap<String, String>(){{
            put("play","basketball");
            put("friends","2");
        }});

        User e2 = new User();
        e2.setName("Min");
        e2.setAge(23);

        session.save(e1);
        session.save(e2);
    }

    private static void association(Session session){
        Employee employee1 = new Employee();
        employee1.setName("em1");

        Employee employee2 = new Employee();
        employee2.setName("em2");

        Boss boss = new Boss();
        Set<Employee> set = new HashSet<Employee>();
        set.add(employee1);
        set.add(employee2);
        boss.setEmployeeSet(set);
        boss.setName("boss1");

        session.save(boss);

    }
}
