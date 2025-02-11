package com.controleestoque.controle_estoque_spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.controleestoque.controle_estoque_spring.model.Produto;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
