package com.controleestoque.controle_estoque_spring.controller;

import com.controleestoque.controle_estoque_spring.model.Produto;
import com.controleestoque.controle_estoque_spring.service.ProdutoService;
import jakarta.validation.Valid;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping
    public List<Produto> listarTodos(){
        return produtoService.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produto> buscarPorId(@PathVariable Long id){
        Optional<Produto> produto = produtoService.buscarPorId(id);

        return produto.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Produto criarProduto(@Valid @RequestBody Produto produto){

        return produtoService.salvar(produto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarProduto(@PathVariable Long id){
        produtoService.deletar(id);

        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Produto> atualizarProduto(@PathVariable Long id, @Valid @RequestBody Produto produtoAtualizado){

        Optional<Produto> produtoExistente = produtoService.buscarPorId(id);
        if (produtoExistente.isEmpty()) {
            return ResponseEntity.notFound().build(); // Retorna 404 se o produto não existir
        }

        Produto produto = produtoExistente.get();

        produto.setCodigoSku(produtoAtualizado.getCodigoSku());
        produto.setNome(produtoAtualizado.getNome());
        produto.setCategoria(produtoAtualizado.getCategoria());
        produto.setPreco(produtoAtualizado.getPreco());
        produto.setQuantidade(produtoAtualizado.getQuantidade());
        produto.setFornecedor(produtoAtualizado.getFornecedor());

        // Salva e retorna o produto atualizado
        Produto produtoSalvo = produtoService.salvar(produto);
        return ResponseEntity.ok(produtoSalvo);
    }
}
