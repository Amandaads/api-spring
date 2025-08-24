package com.api.apiProduct.service;

import com.api.apiProduct.model.Filme;
import com.api.apiProduct.repository.FilmeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FilmeService {

    @Autowired
    private final FilmeRepository filmeRepository;
    public FilmeService(FilmeRepository filmeRepository) {
        this.filmeRepository = filmeRepository;
    }

    // criar
    public Filme save(Filme filme){
        validate(filme);
        return filmeRepository.save(filme);
    }
    // listar tudo
    public List<Filme> getAll(){
        return filmeRepository.findAll();
    }
    // listar por id - teste 1
    public Optional<Filme> findById(Long id){
        return filmeRepository.findById(id);
    }
//
//    public boolean existsById(Long id){
//        return filmeRepository.existsById(id);
//    }

    // editar
    public Filme update(Long id, Filme updateProduct){
        Filme filme = filmeRepository.findById(id).orElseThrow(() ->
                new RuntimeException("movie not found"));
        filme.setTitle(updateProduct.getTitle());
        filme.setCategory(updateProduct.getCategory());
        filme.setDescription(updateProduct.getDescription());
        filme.setStatus(updateProduct.getStatus());
        return filmeRepository.save(filme);
    }
    // delete
    public String delete(Long id){
        filmeRepository.deleteById(id);
        return "movie deleted";
    }

    private void validate(Filme filme){
        if (filme.getTitle() == null)  {
            throw new IllegalArgumentException("The name of title can´t be null");
        }
    }


}
