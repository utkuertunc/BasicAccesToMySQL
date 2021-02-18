package com.example.accessingdatamysql;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class UserDTO {
	
	  @Id //primary key
	  @GeneratedValue(strategy=GenerationType.AUTO)  //@GeneratedValue değer üretir
	  @Min(10)
	  @NotNull
	  private Integer id;
	
	  @Size(min = 1, max = 5)
	  @NotEmpty(message = "Ismi Bos Biraktiniz")
	  private String name;

	  @Email(message = "Bu Bir Email Degildir. Lutfen Email Giriniz")
	  @Size(min = 1, max = 99)
	  @NotEmpty(message = "Email'i Bos Biraktiniz")
	  private String email;

	  
}
