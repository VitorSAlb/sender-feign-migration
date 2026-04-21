package com.vitorsalb.sendfeignmigration.infra.port.integration;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class ReceiverControllerFeignImpl {

    @Autowired
    private ReceiverControllerFeign receiverControllerFeign;

    public JsonNode receiveMessage(JsonNode message) {
        ResponseEntity<JsonNode> response = receiverControllerFeign.receiveMessage(message);
        return response.getBody();
    }

}
