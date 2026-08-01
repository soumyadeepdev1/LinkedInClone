package com.linkedIn.connections.repository;

import com.linkedIn.connections.entity.Person;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends Neo4jRepository<Person,Long> {

    @Query("""
        MATCH (n:Person)-[r:CONNECTED_TO*2]->(m:Person)
        WHERE n.userId = $userId AND NOT (n)-[:CONNECTED_TO]->(m)
        RETURN m""")
    List<Person> get2ndDegreeConnections(
            Long userId,
            Integer degree);
}
