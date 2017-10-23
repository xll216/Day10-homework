package com.lanou.test;

import com.lanou.dao.StudentDao;
import com.lanou.dao.impl.StudentDaoImpl;
import com.lanou.domain.Student;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 蓝鸥科技有限公司  www.lanou3g.com.
 */
public class MainTest {

    @Test
    public void findById() {
        StudentDao dao = new StudentDaoImpl();
        Student student = dao.findById(Student.class, 1);

        System.out.println(student);
    }

    @Test
    public void findAll() {
        StudentDao dao = new StudentDaoImpl();
        List<Student> students = dao.findAll("from Student");
        for (Student stu : students) {
            System.out.println(stu);
        }
    }

    @Test
    public void find() {
        StudentDao dao = new StudentDaoImpl();

        String hql = "from Student where sname=:name";
        Map<String, Object> param = new HashMap<>();
        param.put("name", "张三");
        List<Student> students = dao.find(hql, param);

        for (Student stu : students) {
            System.out.println(stu);
        }
    }
}
