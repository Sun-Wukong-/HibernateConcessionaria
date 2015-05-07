package br.com.castelobranco.concessionaria.controle;

import br.com.castelobranco.concessionaria.modelo.Venda;
import br.com.castelobranco.concessionaria.persistencia.DaoVenda;
import java.util.Date;

/**
 *
 * @author Wukong
 */
public class ControleVenda {
     
    public void armazenar(Venda venda) {
         DaoVenda dao = new DaoVenda();
        dao.armazenar(venda);
    }
    
    public void excluir(Long id) {
        DaoVenda dao = new DaoVenda();
        dao.excluir(id);
    }
    
    public  void pesquisar(Long id){
        DaoVenda dao = new DaoVenda();
        dao.pesquisar(id);
    }
    
    public void pesquisarVendedor(Long idVendedor){
        DaoVenda dao = new DaoVenda();
        dao.pesquisarVendedor(idVendedor);
    }
    
    public void pesquisarData(Date data){
        DaoVenda dao = new DaoVenda();
        dao.pesquisarData(data);
    }
}
