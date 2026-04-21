package com.vitorsalb.sendfeignmigration.infra.port.integration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import tools.jackson.databind.JsonNode;

@Component
public class ReceiverControllerFeignImpl {

    @Autowired
    private ReceiverControllerFeign receiverControllerFeign;

    public JsonNode receiveMessage(JsonNode message) {
        ResponseEntity<JsonNode> response = receiverControllerFeign.receiveMessage(message);
        return response.getBody();
    }

}
