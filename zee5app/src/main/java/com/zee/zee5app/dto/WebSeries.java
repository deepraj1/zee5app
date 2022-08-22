package com.zee.zee5app.dto;

import java.awt.geom.GeneralPath;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.zee.zee5app.enums.Genre;

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
	private String WebsId;
	private String WebsName;
	private int totalSeason;
	private String[] audioLanguage;
	private LocalDate realseDate;
	private String Director;
	private String[] cast;
	private String languages[];
	private Genre genre;
	
	
	

}
