package br.com.castelobranco.concessionaria.modelo;
// Generated May 6, 2015 3:18:57 AM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Produto generated by hbm2java
 */
@Entity
@Table(name = "Produto")
public class Produto  {
    
     private long codigo;
     private String marca;
     private String modelo;
     private String cor;
     private int ano;
     private double preco;


    public Produto() {
    }

	
    public Produto(long codigo, String marca, String modelo, String cor, int ano, double preco) {
        this.codigo = codigo;
        this.marca = marca;
        this.modelo = modelo;
        this.cor = cor;
        this.ano = ano;
        this.preco = preco;
    }
    
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Codigo_Produto")
    public long getCodigo() {
        return this.codigo;
    }
    
    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }
    
    @Column(name = "Marca", nullable = false, length = 35)
    public String getMarca() {
        return this.marca;
    }
    
    public void setMarca(String marca) {
        this.marca = marca;
    }
    @Column(name = "Modelo", nullable = false, length = 35)
    public String getModelo() {
        return this.modelo;
    }
    
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    @Column(name = "Cor", nullable = false, length = 35)
    public String getCor() {
        return this.cor;
    }
    
    public void setCor(String cor) {
        this.cor = cor;
    }
    @Column(name = "Ano", nullable = false)
    public int getAno() {
        return this.ano;
    }
    
    public void setAno(int ano) {
        this.ano = ano;
    }
    @Column(name = "Preco", nullable = false, precision = 22, scale = 0)
    public double getPreco() {
        return this.preco;
    }
    
    public void setPreco(double preco) {
        this.preco = preco;
    }
}


