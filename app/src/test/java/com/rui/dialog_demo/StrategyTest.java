package com.rui.dialog_demo;

import android.text.TextUtils;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 策略模式的lambda表达式简单使用
 */
public class StrategyTest {

    //定义过滤数据的接口
    public interface StudentPredicate {
        //过滤数据的条，具体由实现类决定
        boolean test(Student student);

    }

    //过滤数据的方法
    public List<Student> filterStudents(List<Student> students, StudentPredicate predicate) {
        List<Student> list = new ArrayList<>();
        for (Student s : students) {
            if (predicate.test(s)) {
                list.add(s);
            }
        }
        return list;
    }

    //数据的实体类
    class Student {
        int age;
        String area;
        int id;
    }


    @Test
    public void strategyTest() {
        List<Student> students = new ArrayList<>();
        //年龄大于20的学生，过滤数据条件：用匿名内部类的lambda表达式来实现
        List<Student> list0 = filterStudents(students, student -> student.age > 20);
        //来自广州的学生
        List<Student> list1 = filterStudents(students, student -> TextUtils.equals(student.area, "广州"));
        //来自广州，年龄大于20的学生
        List<Student> list2 = filterStudents(students, student -> TextUtils.equals(student.area, "广州") && student.age > 20);

    }

}
