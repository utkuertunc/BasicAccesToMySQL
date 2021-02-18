package com.example.accessingdatamysql;


import java.util.List;

import javax.management.RuntimeErrorException;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController //Bu class controller classıdır
@RequestMapping(path="/demo") // URL'ler bu pathten başlıyor. Demomuun çalışacağı main path
public class MainController{
  @Autowired // userRepository beanini get ettik
         	 // UserRepository interfaceini kullanacağız
  private UserRepository userRepository;

  @PostMapping(path="/add") //Sadece Post Requestler için pathimiz
  public @ResponseBody String addNewUser (@RequestParam String name, @RequestParam String email) {
    // @ResponseBody response string dönsün
    // @RequestParam get veya post request için parametre. string

	  User n = new User();
    n.setName(name);
    n.setEmail(email);
    userRepository.save(n);
    return "Saved";
    
  }

  @GetMapping(path="/all")
  public @ResponseBody Iterable<User> getAllUsers() {
    // json ya da xml döner

    return userRepository.findAll();
  }
  
}