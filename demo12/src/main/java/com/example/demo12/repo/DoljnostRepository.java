package com.example.demo12.repo;

import com.example.demo12.dtos.Doljnost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoljnostRepository extends JpaRepository<Doljnost, String> {

     Doljnost findByFilial_id(String id);

}
