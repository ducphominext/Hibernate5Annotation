package main.java.vn.omi;

import main.java.vn.omi.entity.Department;
import main.java.vn.omi.entity.Employee;
import main.java.vn.omi.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.Date;

public class CreateData {
	public static void main(String[] args) throws Exception {

		SessionFactory sessFact = HibernateUtil.getSessionFactory();
		Session session = sessFact.getCurrentSession();
		org.hibernate.Transaction tr = session.beginTransaction();

		Department department = new Department();
		department.setName("deparment2018");
		session.save(department);

		Employee emp = new Employee();
		emp.setEmpName("Nguyen Van Nghiem" + (new Date()).toString());
		emp.setEmpMobileNos("000000");
		emp.setEmpAddress("139 Cau giay, HN");
		emp.setDepartment(department);
		session.save(emp);

		tr.commit();
		System.out.println("Successfully inserted");
		sessFact.close();
	}

}