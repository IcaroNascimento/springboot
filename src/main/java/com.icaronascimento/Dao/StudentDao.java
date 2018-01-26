package com.icaronascimento.Dao;

import com.icaronascimento.Entity.Student;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by icaronascimento on 25/01/18.
 */

@Repository
public class StudentDao {

    private static Map<Integer,Student> students;

    static {

        students = new HashMap<Integer,Student>(){

            {
                put(1,new Student(1,"Said","ComputerScience"));
                put(2,new Student(2,"Jude","Administration"));
                put(3,new Student(3,"John","Architecture"));
            }
        };
    }

    public Collection<Student> getAllStudents(){
        return this.students.values();
    }

    public Student getStudentById(int id) {
        return this.students.get(id);
    }

    public void removeStudentById(int id) {
      this.students.remove(id);
    }

    public void  updateStudent(Student student) {
        Student s = students.get(student.getId());

        s.setCourse(student.getCourse());
        s.setName(student.getName());
        students.put(student.getId(), student);
    }

    public void insertStudentToDb(Student student) {
        this.students.put(student.getId(),student);
    }
}
