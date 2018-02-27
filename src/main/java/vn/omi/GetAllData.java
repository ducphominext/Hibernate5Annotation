package main.java.vn.omi;

import java.util.List;

import main.java.vn.omi.entity.Employee;
import main.java.vn.omi.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import javax.persistence.criteria.CriteriaQuery;

public class GetAllData {
	public static void main(String[] args) throws Exception {

		SessionFactory sessFact = HibernateUtil.getSessionFactory();
		Session session = sessFact.getCurrentSession();
		org.hibernate.Transaction tr = session.beginTransaction();

		
		CriteriaQuery<Employee> cq = session.getCriteriaBuilder().createQuery(Employee.class);
		cq.from(Employee.class);
		List<Employee> employeeList = session.createQuery(cq).getResultList();

		for (Employee employee : employeeList) {
			System.out.println("ID: " + employee.getId());
			System.out.println("Name: " + employee.getEmpName());
			System.out.println("Department: " + employee.getDepartment().getName());
		}  
		

		tr.commit();
		System.out.println("Data printed");
		sessFact.close();
	}
}