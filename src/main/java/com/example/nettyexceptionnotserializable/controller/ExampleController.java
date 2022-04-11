package com.example.nettyexceptionnotserializable.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExampleController {

  @GetMapping("/example")
  public ResponseEntity<Object> example() {
    return ResponseEntity.unprocessableEntity().build();
  }
}
