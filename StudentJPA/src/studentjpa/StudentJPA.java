/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentjpa;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
/**
 *
 * @author luksorn
 */

public class StudentJPA {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
       Student stu1 = new Student(12345, "boy", 3.00);
       Student stu2 = new Student(12346, "girl", 3.10);
       StudentTable.insertStudent(stu1);
       StudentTable.insertStudent(stu2);
       //Employee emp;
       //emp = EmployeeTable.findEmployeeById(1);
       //if (emp != null) {
       //    emp.setName("Jack");
           //EmployeeTable.removeEmployee(emp);
       //    EmployeeTable.updateEmployee(emp);
       //}
       //List<Employee> empList = EmployeeTable.findEmployeeByName("Marry"); 
       List<Student> stuList = StudentTable.findAllStudent();
       printStudent(stuList);
    }
    public static void printStudent(List<Student> studentList) {
        for(Student emp : studentList) {
           System.out.print(emp.getId() + " ");
           System.out.print(emp.getName() + " ");
           System.out.println(emp.getGpa() + " ");
       }
    }
    public static void persist(Object object) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("StudentJPAPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(object);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }    
}
