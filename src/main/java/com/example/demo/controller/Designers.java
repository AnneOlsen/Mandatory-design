package com.example.demo.controller;

import com.example.demo.model.Designer;
import com.example.demo.repository.DesignerRepository;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;

@Api(value="Designers controller", description = "REST endpoints for designers")
@RestController
public class Designers {

    @Autowired
    DesignerRepository designers;

    // Getting all designer
    @GetMapping("/designers")
    public Iterable<Designer> getDesigners(){
        return designers.findAll();
    }

    // Getting a designer with the specific id
    @GetMapping("/designers/{id}")
    public Designer getDesignerById(@PathVariable Long id){
        return (Designer) designers.findAllById(Collections.singleton(id));
    }

    // Adds a new designer
    @PostMapping("/designers")
    public Designer addDesigner(@RequestBody Designer newDesigner){
        return designers.save(newDesigner);
    }

    // Updates a designer with a specific id
    @PutMapping("/designers/{id}")
    public Designer updateDesignerById(@PathVariable Long id, @RequestBody Designer updatedDesigner){
        return designers.save(updatedDesigner);

    }

    // Deletes a designer with a specific id
    @DeleteMapping("/designers/{id}")
    public void deleteDesignerById(@PathVariable Long id){
        designers.deleteById(id);
        System.out.println("The designer has been deleted succesfully");
    }


}
