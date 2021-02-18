package com.example.accessingdatamysql;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;


@Accessors(chain = true)
@NoArgsConstructor
@Entity // Bu entity classımızdır. @Entity, sınıfı tabloya dönüştürür. (hibernate ile)
public class User {
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

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }
}