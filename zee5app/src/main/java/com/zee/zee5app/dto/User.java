package com.zee.zee5app.dto;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Comparator;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonFormat;
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
//@Table(name = "user_table")

public class User { // implements Comparable<User> {
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
	private String password;

}
