package com.animallist.animal_list.controller;
import org.springframework.ui.Model;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.animallist.animal_list.domain.Animal;
import com.animallist.animal_list.service.AnimalService;

@Controller
public class AnimalController {

	 @Autowired
	    private AnimalService animalService;

	    @GetMapping("/")
	    public String listAnimals(Model model, @RequestParam(defaultValue = "name") String sortBy) {
	        model.addAttribute("animals", animalService.getAllAnimals(sortBy));
	        return "index";
	    }

	    @GetMapping("/new")
	    public String add(Model model) {
	    	model.addAttribute("animal", new Animal());
	    	return "new";
	    }

	    @PostMapping("/animal/save")
	    public String saveAnimal(@ModelAttribute Animal animal, @RequestParam(value = "imageFile", required = false) MultipartFile file) {
	        try {
	            if (file != null && !file.isEmpty()) {
	                animal.setImage(file.getBytes());
	            }
	            animalService.saveAnimal(animal);
	            return "redirect:/";
	        } catch (Exception e) {
	            e.printStackTrace(); // For debugging purposes, consider logging the error in production.
	            return "index";
	        }
	    }


	    @GetMapping("/edit/{id}")
	    public String editAnimal(@PathVariable Long id, Model model) {
	        Optional<Animal> animal = animalService.getAnimalById(id);
	        if (animal.isPresent()) {
	            model.addAttribute("animal", animal.get());
	            return "new"; 
	        } else {
	            return "error"; 
	        }
	    }
	    @GetMapping("/delete/{id}")
	    public String deleteAnimal(@PathVariable Long id) {
	        animalService.deleteAnimal(id);
	        return "redirect:/";
	    }
	    
	    @GetMapping("/back")
	    public String list() {
	        return "redirect:/";
	    }
}
