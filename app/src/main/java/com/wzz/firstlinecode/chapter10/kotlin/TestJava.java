package com.wzz.firstlinecode.chapter10.kotlin;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName TestJava
 * @Description TODO
 * @Author Lenovo
 * @Date 2022/7/5 16:04
 * @Version 1.0
 */
public class TestJava {
    private List<Person> mP;
    private List<Student> students;

    private void testDemo(){
        mP = new ArrayList<>();
        students = new ArrayList<>();
        Person person = new Person("测试" , 20);
        Student student = new Student("你好",18);
        Teacher teacher = new Teacher("老师",12);
        mP.add(person);
        mP.add(student);
        mP.add(teacher);
    }

    private void testL(List<Person> list){

    }
}
