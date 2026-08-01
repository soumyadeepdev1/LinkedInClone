package com.linkedIn.connections.service.Impl;

import com.linkedIn.connections.entity.Person;
import com.linkedIn.connections.repository.PersonRepository;
import com.linkedIn.connections.service.ConnectionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class ConnectionServiceImpl implements ConnectionService {
    private final PersonRepository personRepository;

    @Override
    public List<Person> get2ndDegreeConnections(Long userId, Integer degree){
        return personRepository.get2ndDegreeConnections(userId,degree);
    }
}
