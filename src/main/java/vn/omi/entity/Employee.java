package main.java.vn.omi.entity;
import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "employee")
public class Employee implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	@Column(name="id")
	private int id;	

	@Column(name="emp_name")
	private String empName;

	@Column(name="emp_address")
	private String empAddress;	  

	@Column(name="emp_mobile_nos")
	private String empMobileNos;

//	@ManyToOne
//	@JoinColumn(name="dpt_id",foreignKey=@ForeignKey(name="dpt_id_fk"))
//	private Department department;

	@ManyToOne
	@JoinColumn(name = "dpt_id")
	private Department department;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpAddress() {
		return empAddress;
	}

	public void setEmpAddress(String empAddress) {
		this.empAddress = empAddress;
	}

	public String getEmpMobileNos() {
		return empMobileNos;
	}

	public void setEmpMobileNos(String empMobileNos) {
		this.empMobileNos = empMobileNos;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}
}
