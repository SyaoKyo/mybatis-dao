package me.syaokyo.dao;

import me.syaokyo.entity.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Created by SyaoKyo on 2018/9/4.
 */
public class StudentDao {

    //根据编号查询
    public Student queryById(String id) throws IOException {
        Student stu = null;
        // 1.读取SqlMapConfig.xml配置文件
        String path = "SqlMapConfig.xml";
        InputStream in = Resources.getResourceAsStream(path);
        // 创建会话工厂
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        // 获得会话
        SqlSession session = factory.openSession();
        // 第一个参数：映射文件中select标签的id（statement的id）
        // 第二个参数：和映射文件中指定的parameterType类型相同的参数
        stu = session.selectOne("selectStuById", id);
        return stu;
    }

    //根据姓氏查询
    public List<Student> selectByFirstName(String firstName) throws IOException {
        List<Student> list = null;
        // 1.读取SqlMapConfig.xml配置文件
        String path = "SqlMapConfig.xml";
        InputStream in = Resources.getResourceAsStream(path);
        // 创建会话工厂
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        // 获得会话
        SqlSession session = factory.openSession();
        list = session.selectList("selectByFirstName", firstName);
        return list;
    }

    //增加学生
    public void addStudent(Student stu) throws IOException {
        // 1.读取SqlMapConfig.xml配置文件
        String path = "SqlMapConfig.xml";
        InputStream in = Resources.getResourceAsStream(path);
        // 创建会话工厂
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        // 获得会话
        SqlSession session = factory.openSession();

        session.insert("addStudent", stu);
        // 提交事务
        session.commit();
        session.close();
    }

    //删除学生
    public void deleteStudentById(String id) throws IOException {
        // 1.读取SqlMapConfig.xml配置文件
        String path = "SqlMapConfig.xml";
        InputStream in = Resources.getResourceAsStream(path);
        // 创建会话工厂
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        // 获得会话
        SqlSession session = factory.openSession();
        session.delete("deleteStudentById", id);
        // 提交事务
        session.commit();
        session.close();
    }

    //更新学生
    public void updateStudentById(Student stu) throws IOException {
        // 1.读取SqlMapConfig.xml配置文件
        String path = "SqlMapConfig.xml";
        InputStream in = Resources.getResourceAsStream(path);
        // 创建会话工厂
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        // 获得会话
        SqlSession session = factory.openSession();
        session.update("updateStudentById", stu);
        // 提交事务
        session.commit();
        session.close();
    }



}

