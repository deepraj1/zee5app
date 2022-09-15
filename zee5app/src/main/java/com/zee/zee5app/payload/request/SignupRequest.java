package com.zee.zee5app.payload.request;

import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.Column;
import javax.validation.constraints.*;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;
@Data
public class SignupRequest {
  @NotBlank
  @Size(min = 3, max = 20)
  private String username;

  @NotBlank
  @Size(min = 3, max = 20)
  private String firstName;
  @NotBlank
  @Size(min = 3, max = 20)
  private String lastName;
  
  @NotBlank
  @Size(max = 50)
  @Email
  private String email;

//  private Set<String> role;

  @NotBlank
  @Size(min = 6, max = 40)
  private String password;
//  @Column(columnDefinition = "TIMESTAMP")
//  @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd-MM-yyyy-HH-mm-ss")
//  private LocalDateTime dob;
}