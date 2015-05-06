package br.com.castelobranco.concessionaria.controle;

import br.com.castelobranco.concessionaria.modelo.Produto;
import br.com.castelobranco.concessionaria.persistencia.DaoProduto;

/**
 *
 * @author Wukong
 */
public class ControleProduto {
    
    public void armazenar(Produto produto) {

        DaoProduto dao = new DaoProduto();
        dao.armazenar(produto);

    }

    public void alterar(Produto produto) {

        DaoProduto dao = new DaoProduto();
        dao.alterar(produto);
    }

    public void excluir(Long id) {

        DaoProduto dao = new DaoProduto();
        dao.excluir(id);
    }
    
    public  void pesquisar(Long id){
        DaoProduto dao = new DaoProduto();
        dao.pesquisar(id);
    }
}