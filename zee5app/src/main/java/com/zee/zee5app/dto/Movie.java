package com.zee.zee5app.dto;

import java.sql.Blob;
import java.time.LocalDate;
import java.time.LocalTime;

//import javax.management.relation.InvalidRelationIdException;
import javax.naming.InvalidNameException;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatTypes;
import com.zee.zee5app.enums.Genre;
import com.zee.zee5app.enums.Languages;
import com.zee.zee5app.exceptions.InvalidIdException;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import com.fasterxml.jackson.annotation.JsonFormat;
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
//@Table(name = "movie_table")
public class Movie {
	@Id
	@GenericGenerator(name = "useridgenerator", strategy = "com.zee.zee5app.utils.UserIdGenerator")//generting the value
	@GeneratedValue(generator = "useridgenerator")//consuming the generated value
	private String movieId;
    private String actors;
    @NotNull
    private String movieName;
    private String director;
    @NotNull
    private String genre;
    private String production;
    private String languages;
    @NotNull
    @Column(columnDefinition = "TIME")
    @JsonFormat(shape = JsonFormat.Shape.STRING , pattern = "HH:mm")
    private LocalTime movieLength;
    @Lob
    private String trailer1;
//    private byte[] trailer2;
    
    
}