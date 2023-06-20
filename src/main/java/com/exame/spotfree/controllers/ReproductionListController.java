package com.exame.spotfree.controllers;

import com.exame.spotfree.models.ReproductionList;
import com.exame.spotfree.models.request.ReproductionListRequest;
import com.exame.spotfree.services.impl.ReproductionListServiceImpl;
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
    public List<ReproductionList> getByName(@PathVariable String name){
        return reproductionListService.getByName(name);
    }

    @GetMapping("/id/{id}")
    public ReproductionList getOne(@PathVariable Long id){
        return reproductionListService.getOne(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ReproductionList create(@RequestBody ReproductionListRequest reproductionList){
        return reproductionListService.create(reproductionList);
    }

    @PutMapping("/{id}")
    public ReproductionList update(@PathVariable String id,@RequestBody ReproductionListRequest reproductionList)  {
        return reproductionListService.update(Long.valueOf(id), reproductionList);
    }

    @DeleteMapping("/id/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){


        reproductionListService.delete(id);
    }

    @DeleteMapping("/{name}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable String name){
        reproductionListService.deleteByName(name);
    }

}
