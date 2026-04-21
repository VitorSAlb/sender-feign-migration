package com.vitorsalb.sendfeignmigration.application.service;


import com.vitorsalb.sendfeignmigration.infra.port.integration.ReceiverControllerFeignImpl;
import org.springframework.stereotype.Service;
import tools.jackson.databind.JsonNode;
import tools.jackson.databind.ObjectMapper;
import tools.jackson.databind.node.JsonNodeFactory;
import tools.jackson.databind.node.ObjectNode;

@Service
public class SenderService {

    private final ObjectMapper objectMapper = new ObjectMapper();
    private final ReceiverControllerFeignImpl receiverControllerFeign;

    public SenderService(ReceiverControllerFeignImpl receiverControllerFeign) {
        this.receiverControllerFeign = receiverControllerFeign;
    }

    public JsonNode sendMessage(JsonNode message) {
        ObjectNode envelope = JsonNodeFactory.instance.objectNode();
        ObjectNode metadados = JsonNodeFactory.instance.objectNode();

        metadados.set("source", JsonNodeFactory.instance.stringNode("SenderService"));

        envelope.set("mensagemOrig", message);
        envelope.set("metadados", metadados);

        return receiverControllerFeign.receiveMessage(envelope);
    }
}
