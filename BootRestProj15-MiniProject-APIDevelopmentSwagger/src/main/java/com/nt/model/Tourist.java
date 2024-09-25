package com.nt.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@Table(name="REST_TOURIST")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Tourist implements Serializable {
	
	@Id
	@SequenceGenerator(name="gen1",sequenceName="TID_SEQ",allocationSize=1,initialValue=1)
	@GeneratedValue(generator="gen1",strategy=GenerationType.SEQUENCE)
	private Integer tid;
	@Column(length=20)
	@NonNull
	private String tname;
	@Column(length=20)
	@NonNull
	private String taddr;
	@Column(length=20)
	@NonNull
	private String packageType;
	@NonNull
	private Double budget;
	@NonNull
	private LocalDateTime startDate;
	@NonNull
	private LocalDateTime endDate;

}
