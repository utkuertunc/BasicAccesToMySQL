package com.example.accessingdatamysql;

import org.springframework.data.repository.CrudRepository;
import com.example.accessingdatamysql.User;

//Springten crud işlemlerini extends ettik

public interface UserRepository extends CrudRepository<User, Integer> {


}