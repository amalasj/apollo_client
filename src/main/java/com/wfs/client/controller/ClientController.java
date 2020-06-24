package com.wfs.client.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.wfs.client.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api")
public class ClientController {

    @Autowired
    ClientService clientService;

    @GetMapping("/v1/findUser/{id}")
    public ResponseEntity<String> getSalesExecutive(@PathVariable Integer id) throws JsonProcessingException {
        return ResponseEntity.ok(clientService.findUser(id).toString());

    }

}
