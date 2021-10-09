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

    // Updates everything in a designer with a specific id
    @PutMapping("/designers/{id}")
    public String updateDesignerById(@PathVariable Long id, @RequestBody Designer designerToUpdateWith){
        if(designers.existsById(id)){
           designerToUpdateWith.setId(id);
           designers.save(designerToUpdateWith);
           return "Designer updated";
        }else{
            return "Designer not found";
        }
    }


    @PatchMapping("/designers/{id}")
    public String patchDesignerById(@PathVariable Long id, @RequestBody Designer designerToUpdateWith){
        return designers.findById(id).map( foundDesigner -> {
            if(designerToUpdateWith.getFirstName() !=null) foundDesigner.setFirstName(designerToUpdateWith.getFirstName());
            if(designerToUpdateWith.getSirName() !=null) foundDesigner.setSirName(designerToUpdateWith.getSirName());
            if(designerToUpdateWith.getBirthYear() !=0) foundDesigner.setBirthYear(designerToUpdateWith.getBirthYear());
            if(designerToUpdateWith.getNationality() !=null) foundDesigner.setNationality(designerToUpdateWith.getNationality());
            if(designerToUpdateWith.getGender() !=null) foundDesigner.setGender(designerToUpdateWith.getGender());

            designers.save(foundDesigner);
            System.out.println(foundDesigner);
            return "Designer updated";
        }) .orElse("Not found");
    }

    // Deletes a designer with a specific id
    @DeleteMapping("/designers/{id}")
    public void deleteDesignerById(@PathVariable Long id){
        designers.deleteById(id);
        System.out.println("The designer has been deleted succesfully");
    }


}
