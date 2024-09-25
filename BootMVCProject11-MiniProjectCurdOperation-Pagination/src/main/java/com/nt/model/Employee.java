package com.nt.model;

import java.io.Serializable;

import org.hibernate.annotations.SQLDelete;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.Data;


//@SuppressWarnings("deprecation")
@Entity
@Table(name="emp")
@SQLDelete(sql="UPDATE EMP SET STATUS='inactive' WHERE EMPNO=? ")
//@Where(clause="STATUS <> 'inactive' ")
@Data
public class Employee implements Serializable {
	
	@Id
	@SequenceGenerator(name="gen1",sequenceName="emp_id_seq",allocationSize=1,initialValue=1)
	@GeneratedValue(generator="gen1",strategy=GenerationType.SEQUENCE)
	private Integer empno;
	private String ename;
	private String job;
	private Float sal;
	@Transient
	private String vflag="no";
	

}
