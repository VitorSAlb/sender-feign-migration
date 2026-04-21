package com.vitorsalb.sendfeignmigration.application.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.vitorsalb.sendfeignmigration.infra.port.integration.ReceiverControllerFeign;
import com.vitorsalb.sendfeignmigration.infra.port.integration.ReceiverControllerFeignImpl;
import org.springframework.stereotype.Service;

@Service
public class SenderService {

    private final ObjectMapper objectMapper;
    private final ReceiverControllerFeignImpl receiverControllerFeign;

    public SenderService(ObjectMapper objectMapper, ReceiverControllerFeignImpl receiverControllerFeign) {
        this.objectMapper = objectMapper;
        this.receiverControllerFeign = receiverControllerFeign;
    }

    public JsonNode sendMessage(JsonNode message) {
        ObjectNode envelope = JsonNodeFactory.instance.objectNode();
        ObjectNode metadados = JsonNodeFactory.instance.objectNode();

        metadados.set("source", JsonNodeFactory.instance.textNode("SenderService"));

        envelope.set("mensagemOrig", message);
        envelope.set("metadados", metadados);

        return receiverControllerFeign.receiveMessage(envelope);
    }
}
