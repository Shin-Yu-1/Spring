package org.zerock.controller;

import java.util.ArrayList;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.zerock.domain.SampleDTO;
import org.zerock.domain.SampleDTOList;
import org.zerock.domain.TodoDTO;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/sample/*")
@Log4j
public class SampleController {
   //http://localhost:8080/sample/bbb
   @RequestMapping("")
   public void basic() {
      log.info("basic------------");
   }
   
   @GetMapping("bbb")
   public void basicGet() {
      log.info("bbb-------------------");
   }
   // http://localhost:8080/sample/ex01?name=hong&age=12
   @GetMapping("/ex01")
   public String ex01(SampleDTO dto) {
      log.info(dto);
      return "ex01";
   }
   //http://localhos:8080/sample/ex02?name=hong&age=12
   @GetMapping("/ex02")
   public String ex02(@RequestParam("name") String name,@RequestParam("age") int age) {
      log.info(name);
      log.info(age);
      return "ex02";   
   }
   //http://localhost:8080/sample/ex02?ids=23&ids=34&ids=44
   @GetMapping("/ex02List")
   public void ex02List(@RequestParam("ids") ArrayList<String> ids) {
      log.info("ids" + ids);
   }
   //[ %5B      ] %5D
   //http://localhost:8080/sample/ex02Bean?list[0].name=hong&list[1].name=age&list[2].name=bbb
   //http://localhost:8080/sample/ex02Bean?list%5B0%5D.name=hong&list%5B1%5D.name=age&list%5B2%5D.name=bbb
   @GetMapping("/ex02Bean")
   public String ex02Bean(SampleDTOList list) {
      log.info("list dtos : " + list);
      return "ex02Bean";
   }
   //http://localhost:8080/sample/ex03?title=test&duedate=2021/05/13
   @GetMapping("/ex03")
   public String ex03(TodoDTO todo) {
      log.info("todo : " + todo);
      return "ex03date";
   }
   //http://localhost:8080/sample/ex04?name=hong&age=12&page=2
   @GetMapping("/ex04")
   public String ex04(SampleDTO dto,@ModelAttribute("page") int page) {
      log.info("dto : " + dto);
      log.info("page : " + page);
      
      return "/sample/ex04";
   }
   //http://localhost:8080/sample/ex06
   @GetMapping("/ex06")
   public @ResponseBody SampleDTO ex06() {
      log.info("/ex06----------------");
      SampleDTO dto = new SampleDTO();
      dto.setAge(30);
      dto.setName("hongGildong");
      return dto;
   }
   
   //http:localhost:8080/sample/ex07
   @GetMapping("/ex07")
   public ResponseEntity<String> ex07(){
      log.info("/ex07");
      String msg ="{\"name\":\"홍길동\"}";
      HttpHeaders header = new HttpHeaders();
      header.add("Content-Type", "application/json;charset=UTF-8");
      return new ResponseEntity<>(msg, header, HttpStatus.OK);
   }
   //http://localhost:8080/sample/exUpload
   @GetMapping("/exUpload")
   public void exUpload() {
      log.info("/exUpload---------------");
   }
   
   @PostMapping("exUploadPost")
   public void exUploadPst(ArrayList<MultipartFile> files) {
      files.forEach(file -> {
         log.info("/exUploadPost--------------------");
         log.info(file.getOriginalFilename());
         log.info(file.getSize());
         log.info(file.getContentType());
         
      });
   }
}