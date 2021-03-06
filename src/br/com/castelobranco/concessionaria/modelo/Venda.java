package br.com.castelobranco.concessionaria.modelo;
// Generated May 6, 2015 3:18:57 AM by Hibernate Tools 4.3.1


import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Venda generated by hbm2java
 */
@Entity 
@Table(name = "Venda")
public class Venda {


     private long codigo;
     private long identificadorVenda;
     private Produto produto;
     private Date data;
     private long registroVendedor;
     private double desconto;
     private double valorAcessorio;
     private double valorTotal;

    public Venda() {
    }

    public Venda(long codigo, long identificadorVenda ,Produto produto, Date data, long registroVendedor, double desconto, double valorAcessorio, double valorTotal) {
       this.codigo = codigo;
       this.identificadorVenda = identificadorVenda;
       this.produto = produto;
       this.data = data;
       this.registroVendedor = registroVendedor;
       this.desconto = desconto;
       this.valorAcessorio = valorAcessorio;
       this.valorTotal = valorTotal;
    }
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Codigo_Venda")
    public long getCodigo() {
        return this.codigo;
    }
    
    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }
    
    @Column(name = "Identificador_Venda", nullable = false, unique = true)
    public long getIdentificadorVenda() {
        return identificadorVenda;
    }

    public void setIdentificadorVenda(long identificadorVenda) {
        this.identificadorVenda = identificadorVenda;
    }
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Codigo_Produto",unique = false)
    public Produto getProduto() {
        return this.produto;
    }
    
    public void setProduto(Produto produto) {
        this.produto = produto;
    }
    @Temporal(TemporalType.DATE)
    @Column(name = "Data",nullable = false,length = 10)
    public Date getData() {
        return this.data;
    }
    
    public void setData(Date data) {
        this.data = data;
    }
    
    @Column(name = "Registro_Vendedor",nullable = false)
    public long getRegistroVendedor() {
        return this.registroVendedor;
    }
    
    public void setRegistroVendedor(long registroVendedor) {
        this.registroVendedor = registroVendedor;
    }
    
    @Column(name = "Desconto", nullable = false, precision = 22, scale = 0)
    public double getDesconto() {
        return this.desconto;
    }
    
    public void setDesconto(double desconto) {
        this.desconto = desconto;
    }
    
    @Column(name = "Valor_Acessorio", nullable = false, precision = 22, scale = 0)
    public double getValorAcessorio() {
        return this.valorAcessorio;
    }
    
    public void setValorAcessorio(double valorAcessorio) {
        this.valorAcessorio = valorAcessorio;
    }
    @Column(name = "Valor_Total", nullable = false, precision = 22, scale = 0)
    public double getValorTotal() {
        return this.valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }
    
     public double calcularValorTotal(double preco, double discount, double acessorio){

            double result = (preco + acessorio - discount);
            return result;
        }
}


