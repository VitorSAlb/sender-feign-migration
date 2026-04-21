package com.vitorsalb.sendfeignmigration.infra.port.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.vitorsalb.sendfeignmigration.application.service.SenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sender")
public class SenderController {

    @Autowired
    private SenderService senderService;

    @PostMapping
    public ResponseEntity<JsonNode> sendMessage(@RequestBody JsonNode message) {
        return ResponseEntity.ok(senderService.sendMessage(message));
    }

}
