package com.zee.zee5app.dto;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonValueFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import com.fasterxml.jackson.annotation.JsonFormat;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(uniqueConstraints = {@UniqueConstraint(columnNames  = "email"),@UniqueConstraint(columnNames = "userName")})
//@Table(name = "user_table")

public class User { // implements Comparable<User> {
	
	public User( String firstName2, String lastName2, String email2, LocalDate doj,
			LocalDateTime dob2, boolean b, String username2, String password2) {
		// TODO Auto-generated constructor stub
//		this.userId=string;
		this.firstName=firstName2;
		this.lastName=lastName2;
		this.email=email2;
		this.doj=doj;
		this.dob=dob2;
		this.active=b;
		this.userName=username2;
		this.password=password2;
		
	}

	@Id
	@GenericGenerator(name = "useridgenerator", strategy = "com.zee.zee5app.utils.UserIdGenerator")//generting the value
	@GeneratedValue(generator = "useridgenerator")//consuming the generated value
//	@GeneratedValue(strategy = GenerationType.AUTO)
	private String userId;
	@NotNull
	@Size(max = 50)
	private String firstName;
	@NotNull
	@Size(max = 50)
	private String lastName;
	@Email
	@Size(max = 100)
	private String email;
	@Column(columnDefinition = "DATE")
	@JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd-MM-yyyy")
	private LocalDate doj;
	@Column(columnDefinition = "TIMESTAMP")
	@JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd-MM-yyyy-HH-mm-ss")
	private LocalDateTime dob;
	private boolean active;
	@NotNull
	private String userName;
	@NotNull
	@JsonIgnore
	private String password;
	
	@ManyToMany(fetch = FetchType.LAZY)
//	3rd table
	@JoinTable(name = "user_role" , joinColumns = @JoinColumn(name = "userId")
	,inverseJoinColumns = @JoinColumn(name ="roleId"))
	private Set<Role> roles = new HashSet<>();
	
	

}
