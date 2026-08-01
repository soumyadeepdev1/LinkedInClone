package com.linkedIn.connections.service;

import com.linkedIn.connections.entity.Person;

import java.util.List;

public interface ConnectionService {
    public List<Person> get2ndDegreeConnections(Long userId, Integer degree);
}
