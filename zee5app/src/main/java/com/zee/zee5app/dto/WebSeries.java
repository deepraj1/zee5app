package com.zee.zee5app.dto;

import java.awt.geom.GeneralPath;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.zee.zee5app.enums.Genre;
import com.zee.zee5app.enums.Languages;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table

public class WebSeries {
	@Id
	@GenericGenerator(name = "useridgenerator" , strategy = "com.zee.zee5app.utils.WebsIdGenerator")
	@GeneratedValue(generator = "useridgenerator")
	private String websId;
	@NotNull
	private String websName;
	@NotNull
	private int totalSeason;
	@NotNull
	@Column(columnDefinition = "DATE")
	@JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd-MM-yyyy")
	private LocalDate realseDate;
	@NotNull
	private String director;
//	@Column(columnDefinition = "DATE")
//	@JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd-MM-yyyy")
	private String[] cast;
//	@Enumerated(EnumType.STRING)
	private String languages[];
//	@Enumerated(EnumType.STRING)
	private String genre[];
	
	
	

}
