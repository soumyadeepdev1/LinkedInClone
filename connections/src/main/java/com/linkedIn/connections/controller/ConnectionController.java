package com.linkedIn.connections.controller;


import com.linkedIn.connections.dto.request.FetchConnection;
import com.linkedIn.connections.entity.Person;
import com.linkedIn.connections.service.ConnectionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/connections")
@RequiredArgsConstructor
public class ConnectionController {
    private final ConnectionService connectionService;

    @GetMapping
    public ResponseEntity<List<Person>> get2ndDegreeConnections(@RequestBody FetchConnection fetchConnection){
        return ResponseEntity.status(HttpStatus.OK).body(
                connectionService.get2ndDegreeConnections(fetchConnection.userId(),fetchConnection.degree())
        );
    }
}
