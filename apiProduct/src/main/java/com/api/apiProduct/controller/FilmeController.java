package com.api.apiProduct.controller;

import com.api.apiProduct.model.Filme;
import com.api.apiProduct.repository.FilmeRepository;
import com.api.apiProduct.service.FilmeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/filme")
public class FilmeController {
    @Autowired
    private final FilmeService filmeService;
    private final FilmeRepository filmeRepository;

    public FilmeController(FilmeService filmeService, FilmeRepository filmeRepository) {
        this.filmeService = filmeService;
        this.filmeRepository = filmeRepository;
    }


    @GetMapping
    public List<Filme>getAll(){
        return filmeService.getAll();
    }

    @GetMapping("search")
    public List<Filme> findByTitle(@RequestParam("title") String title) {
        return filmeRepository.findByTitle(title);
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Filme filme){
        try {
            Filme created = filmeService.save(filme);
            URI location = URI.create("/filme/" + created.getId());
            return ResponseEntity.created(location).body(created);

        } catch (IllegalArgumentException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Filme filme ){
        try {
            Filme update = filmeService.update(id,filme);
            return ResponseEntity.ok(update);
        } catch (RuntimeException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }


    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id){
        return filmeService.delete(id);
    }


}
