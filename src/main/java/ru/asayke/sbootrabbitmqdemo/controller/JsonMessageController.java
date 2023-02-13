package ru.asayke.sbootrabbitmqdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.asayke.sbootrabbitmqdemo.dto.User;
import ru.asayke.sbootrabbitmqdemo.publisher.RabbitMQJsonProducer;

@RestController
@RequestMapping("/api/v2")
public class JsonMessageController {
    private final RabbitMQJsonProducer jsonProducer;

    @Autowired
    public JsonMessageController(RabbitMQJsonProducer jsonProducer) {
        this.jsonProducer = jsonProducer;
    }

    @PostMapping("/publish")
    public ResponseEntity<String> sendJsonMessage(@RequestBody User user) {
        jsonProducer.sendJsonMessage(user);

        return ResponseEntity.ok("Json message send to RabbitMQ...");
    }
}