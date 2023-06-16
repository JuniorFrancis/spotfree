package com.exame.spotfree.controllers;

import com.exame.spotfree.exceptions.DefaultException;
import com.exame.spotfree.models.ReproductionList;
import com.exame.spotfree.models.request.ReprodutionListRequest;
import com.exame.spotfree.services.impl.ReproductionListServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/lists")
public class ReproductionListController {

    @Autowired
    public ReproductionListController(ReproductionListServiceImpl reproductionListService) {
        this.reproductionListService = reproductionListService;
    }

    private final ReproductionListServiceImpl reproductionListService;

    @GetMapping
    public List<ReproductionList> getAll(){
        return reproductionListService.getAll();
    }

    @GetMapping("/{name}")
    public ReproductionList getByName(@PathVariable String name){
        return reproductionListService.getByName(name);
    }

    @GetMapping("/id/{id}")
    public ReproductionList getOne(@PathVariable Long id){
        return reproductionListService.getOne(id);
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ReproductionList create(@RequestBody ReprodutionListRequest reproductionList){
        return reproductionListService.create(reproductionList);
    }

    @DeleteMapping("/id/{id}")
    public void delete(@PathVariable Long id){
        reproductionListService.delete(id);
    }

    @DeleteMapping("/{name}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable String name){
        reproductionListService.deleteByName(name);
    }

}
