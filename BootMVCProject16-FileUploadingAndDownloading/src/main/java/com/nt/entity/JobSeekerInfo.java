package com.nt.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="BOOT_JS_INFO")
@Data
public class JobSeekerInfo implements Serializable {
	
	@Id
	@GeneratedValue
	private Integer jsId;
	@Column(length=15)
	private String jsName;
	@Column(length=15)
	private String jsAddrs;
	@Column(length=200)
	private String resumePath;
	@Column(length=200)
	private String photoPath;

}
