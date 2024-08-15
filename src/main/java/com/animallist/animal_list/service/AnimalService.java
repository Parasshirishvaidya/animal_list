package com.animallist.animal_list.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.animallist.animal_list.domain.Animal;
import com.animallist.animal_list.repository.AnimalRepository;

@Service
public class AnimalService {

	
	@Autowired
    private AnimalRepository animalRepository;

    public Animal saveAnimal(Animal animal) {
        if (animal.getId() == null) {
            Long maxId = animalRepository.findMaxId();
            animal.setId(maxId == null ? 1 : maxId + 1);
        }
        return animalRepository.save(animal);
    }

    public List<Animal> getAllAnimals(String sortBy) {
        switch (sortBy) {
            case "name":
                return animalRepository.findAllByOrderByNameAsc();
            case "category":
                return animalRepository.findAllByOrderByCategoryAsc();
            case "lifeExpectancy":
                return animalRepository.findAllByOrderByLifeExpectancyAsc();
            default:
                return animalRepository.findAll();
        }
    }

    public void deleteAnimal(Long id) {
        animalRepository.deleteById(id);
    }

    public Optional<Animal> getAnimalById(Long id) {
        return animalRepository.findById(id);
    }
	
	
}
