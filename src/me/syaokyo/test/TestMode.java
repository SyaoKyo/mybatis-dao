package me.syaokyo.test;

import me.syaokyo.dao.StudentDao;
import me.syaokyo.entity.Student;

import java.io.IOException;
import java.util.List;

/**
 * Created by SyaoKyo on 2018/9/4.
 */
public class TestMode {
    public static void main(String[] args) throws IOException {
        StudentDao dao =new StudentDao();
        System.out.println(dao.queryById("201801010001").getStuName());
        System.out.println(dao.queryById("201801010002").getStuName());
        System.out.println("\nadd:");

        //addStudent
        Student s=new Student("201801010007","李白","男",18);
        dao.addStudent(s);

        List<Student> list1 = dao.selectByFirstName("张");
        int listSize = list1.size();
        for (int i=0;i<listSize;i++){
            System.out.println(list1.get(i).getStuNo()+'\t'+
                    list1.get(i).getStuName()+ '\t'+
                    list1.get(i).getStuSex()+'\t'+
                    list1.get(i).getStuAge());
        }
        System.out.println("\ndelete:");

        //deleteStudent
        dao.deleteStudentById("201801010007");

        list1 = dao.selectByFirstName("张");
        listSize = list1.size();
        for (int i=0;i<listSize;i++){
            System.out.println(list1.get(i).getStuNo()+'\t'+
                    list1.get(i).getStuName()+ '\t'+
                    list1.get(i).getStuSex()+'\t'+
                    list1.get(i).getStuAge());
        }
        System.out.println("\nupdate:");

        //updateStudent
        Student stu=new Student("201801010001","张三","女",17);
        dao.updateStudentById(stu);

        list1 = dao.selectByFirstName("张");
        listSize = list1.size();
        for (int i=0;i<listSize;i++){
            System.out.println(list1.get(i).getStuNo()+'\t'+
                    list1.get(i).getStuName()+ '\t'+
                    list1.get(i).getStuSex()+'\t'+
                    list1.get(i).getStuAge());
        }
    }
}
