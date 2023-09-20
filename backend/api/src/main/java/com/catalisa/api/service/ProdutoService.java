package com.catalisa.api.service;

import com.catalisa.api.model.ProdutoModel;
import com.catalisa.api.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    ProdutoRepository produtoRepository;

    public List<ProdutoModel> listarTodos(){
        return produtoRepository.findAll();
    }

    public Optional<ProdutoModel> listarPorId(Long id){
        return produtoRepository.findById(id);
    }

    public ProdutoModel cadastrar(ProdutoModel produtoModel){
        return produtoRepository.save(produtoModel);
    }
}
