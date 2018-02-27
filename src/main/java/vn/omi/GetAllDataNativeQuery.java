package main.java.vn.omi;


import java.util.Iterator;
import java.util.List;

import main.java.vn.omi.entity.Employee;
import main.java.vn.omi.util.HibernateUtil;
import org.hibernate.*;
import org.hibernate.query.NativeQuery;

import javax.persistence.criteria.CriteriaQuery;

public class GetAllDataNativeQuery {
    public static void main(String[] args) throws Exception {

        SessionFactory sessFact = HibernateUtil.getSessionFactory();
        Session session = sessFact.getCurrentSession();
        org.hibernate.Transaction tr = session.beginTransaction();

        List<Employee> emp = session.createNativeQuery(
                "SELECT * FROM Employee", Employee.class )
                .getResultList();


        for (Employee employee : emp) {
            System.out.println("ID: " + employee.getId());
            System.out.println("Name: " + employee.getEmpName());
            System.out.println("Department: " + employee.getDepartment().getName());
        }


        tr.commit();
        System.out.println("Data printed");
        sessFact.close();
    }
}