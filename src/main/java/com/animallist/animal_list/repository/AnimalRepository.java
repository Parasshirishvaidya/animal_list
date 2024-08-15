package com.animallist.animal_list.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.animallist.animal_list.domain.Animal;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Long> {

    @Query("SELECT MAX(a.id) FROM Animal a")
    Long findMaxId();

    List<Animal> findAllByOrderByNameAsc();
    List<Animal> findAllByOrderByCategoryAsc();
    List<Animal> findAllByOrderByLifeExpectancyAsc();
}