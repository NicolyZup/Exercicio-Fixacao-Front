package com.catalisa.api.controller;

import com.catalisa.api.model.ProdutoModel;
import com.catalisa.api.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/estoque/produtos")
public class ProdutoController {

    @Autowired
    ProdutoService produtoService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @CrossOrigin(origins = "http://127.0.0.1:5500/")
    public ResponseEntity<List<ProdutoModel>> listarProdutos(){
        return ResponseEntity.ok(produtoService.listarTodos());
    }

    @GetMapping(path = "/{id}")
    @CrossOrigin(origins = "http://127.0.0.1:5500/")
    @ResponseStatus(HttpStatus.OK)
    public Optional<ProdutoModel> listarProdutoPorId(@PathVariable Long id){
        return produtoService.listarPorId(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @CrossOrigin(origins = "http://127.0.0.1:5500/")
    public ProdutoModel cadastrarProduto(@RequestBody ProdutoModel produtoModel){
        return produtoService.cadastrar(produtoModel);
    }
}
