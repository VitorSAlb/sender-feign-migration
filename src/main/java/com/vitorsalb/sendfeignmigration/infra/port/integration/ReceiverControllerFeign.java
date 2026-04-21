package com.vitorsalb.sendfeignmigration.infra.port.integration;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "receiverControllerFeign", url = "${receiver.base-url}")
public interface ReceiverControllerFeign {

    @PostMapping("/receiver")
    ResponseEntity<JsonNode> receiveMessage(@RequestBody JsonNode message);
}
