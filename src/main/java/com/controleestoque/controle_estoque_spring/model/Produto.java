package com.controleestoque.controle_estoque_spring.model;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "produto")
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String codigoSku;

    @Column(nullable = false)
    private String nome;

    public String getCodigoSku() {
        return codigoSku;
    }

    public String getNome() {
        return nome;
    }

    public void setCodigoSku(String codigoSku) {
        this.codigoSku = codigoSku;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public void setFornecedor(String fornecedor) {
        this.fornecedor = fornecedor;
    }

    public String getCategoria() {
        return categoria;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public String getFornecedor() {
        return fornecedor;
    }

    public Produto(Long id, String codigoSku, String nome, String categoria, BigDecimal preco, int quantidade, String fornecedor) {
        this.id = id;
        this.codigoSku = codigoSku;
        this.nome = nome;
        this.categoria = categoria;
        this.preco = preco;
        this.quantidade = quantidade;
        this.fornecedor = fornecedor;
    }

    public Produto(){

    }

    private String categoria;

    @Column(nullable = false)
    private BigDecimal preco;

    @Column(nullable = false)
    private int quantidade;

    private String fornecedor;

    public Long getId() {
        return id;
    }
}
