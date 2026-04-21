package com.vitorsalb.sendfeignmigration.infra.port.integration;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import tools.jackson.databind.JsonNode;

@FeignClient(name = "receiverControllerFeign", url = "${receiver.base-url}")
public interface ReceiverControllerFeign {

    @PostMapping("/receiver")
    ResponseEntity<JsonNode> receiveMessage(@RequestBody JsonNode message);
}
