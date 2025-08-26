package com.api.apiProduct.controller;


import com.api.apiProduct.model.Filme;
import com.api.apiProduct.service.FilmeService;
import io.swagger.v3.oas.annotations.Operation;
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


    public FilmeController(FilmeService filmeService){
        this.filmeService = filmeService;
    }

    @Operation(description = "Busca todos os filmes")
    @GetMapping
    public List<Filme>getAll(){
        return filmeService.getAll();
    }


    @Operation(description = "Busca o filme pelo id")
    @GetMapping("/{id}"
    )
    public ResponseEntity<?> findById(@PathVariable Long id) {
        Optional<Filme> optionalFilme = filmeService.findById(id);

        if (optionalFilme.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Filme com ID " + id + " não encontrado.");
        }

        Filme filme = optionalFilme.get();
        return ResponseEntity.ok(filme);
    }

    @Operation(description = "Adiciona um novo filme")
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
    // teste pra passar o dto, pro swagger n colocar no body id
//    @Operation(description = "Adiciona um novo filme")
//    @PostMapping
//    public ResponseEntity<?> create(@RequestBody FilmeDTO filmeDTO){
//        try {
//            Filme saved = filmeService.save(filmeDTO);
//            System.out.println("Salvo: " + saved.getTitle() + ", " + saved.getId());
//
//            FilmeDTO createdDTO = new FilmeDTO();
//            createdDTO.setId(saved.getId());
//            createdDTO.setTitle(saved.getTitle());
//            createdDTO.setCategory(saved.getCategory());
//            createdDTO.setDescription(saved.getDescription());
//            createdDTO.setStatus(saved.getStatus());
//
//            URI location = URI.create("/filme/" + saved.getId());
//            return ResponseEntity.created(location).body(createdDTO);
//
//
//        } catch (IllegalArgumentException e){
//            return ResponseEntity.badRequest().body(e.getMessage());
//        }
//    }

    @Operation(description = "Atualiza um filme, passando o id na requisição")
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Filme filme ){
        try {
            Filme update = filmeService.update(id,filme);
            return ResponseEntity.ok(update);
        } catch (RuntimeException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }


    @Operation(description = "Exclui um filme, passando o id na requisição")
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id){
        return filmeService.delete(id);
    }


}
