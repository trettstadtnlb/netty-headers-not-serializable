package com.example.nettyexceptionnotserializable.controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ExampleControllerTest {

  @Autowired WebTestClient webTestClient;
  @LocalServerPort int port;

  @Test
  void example() throws IOException {
    WebClient webClient = WebClient.builder().baseUrl("http://localhost:" + port).build();
    try {
      webClient.get().uri("/example").retrieve().bodyToMono(Object.class).block();
    } catch (Exception e) {
      e.printStackTrace();
      final ByteArrayOutputStream baos = new ByteArrayOutputStream();
      ObjectOutputStream objectOutputStream = new ObjectOutputStream(baos);
      objectOutputStream.writeObject(e);
    }
  }
}
