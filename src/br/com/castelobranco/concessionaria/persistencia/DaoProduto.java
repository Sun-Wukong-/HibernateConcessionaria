package br.com.castelobranco.concessionaria.persistencia;

import br.com.castelobranco.concessionaria.modelo.Produto;
import static java.util.Collections.list;
import java.util.Iterator;
import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Wukong
 */
public class DaoProduto {
    
   
    public void armazenar(Produto produto) {

        
        Session session = DaoHibernateUtil.getSessionFactory().getCurrentSession();

        try {

            session.beginTransaction(); // Abre-se uma transação
            session.save(produto);      // Acumula a operação de gravação do objeto cliente no BD, na transação
            session.getTransaction().commit();   // Realiza definitivamente todas as operações pendentes na transação
            JOptionPane.showMessageDialog(null, "Produto Armazenado com Sucesso");

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);

        }
    }

    public void alterar(Produto produto) {

        Session session = DaoHibernateUtil.getSessionFactory().getCurrentSession();

        try {

            session.beginTransaction(); // Abre-se uma transação
            session.merge(produto);      // Acumula a operação de alteração do objeto cliente no BD, na transação
            session.getTransaction().commit();   // Realiza definitivamente todas as operações pendentes na transação
            JOptionPane.showMessageDialog(null, "Produto alterado com sucesso");

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);

        }
    }

    public void excluir(Long id) {

        Session session = DaoHibernateUtil.getSessionFactory().getCurrentSession();

        try {

            session.beginTransaction(); // Abre-se uma transação
            Produto result = (Produto) session.createCriteria(Produto.class)  
                             .add(Restrictions.idEq(id))  
                            .uniqueResult();      // Acumula a operação de exclusão do objeto cliente no BD, na transação
            if(result != null){
                session.delete(result);
                session.getTransaction().commit();   // Realiza definitivamente todas as operações pendentes na transação
                JOptionPane.showMessageDialog(null, "Produto excluído com sucesso");
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);

        }
    }

    public void pesquisar (Long id)  {

    
        Session session = DaoHibernateUtil.getSessionFactory().getCurrentSession();

        try {

            session.beginTransaction(); // Abre-se uma transação
            // Cria-se uma lista de clientes a partir do BD
           List<Produto> list =  session.createCriteria(Produto.class)  
                             .add(Restrictions.idEq(id))   
                             .list();  
            
            for (Iterator it = list.iterator(); it.hasNext();) {
                Produto produto = (Produto) it.next();
                System.out.println("Codigo do Produto: " + produto.getCodigo());
                System.out.println("Marca do Produto: " + produto.getMarca());
                System.out.println("Modelo do Produto: " + produto.getModelo());
                System.out.println("Cor do Produto: " + produto.getCor());
                System.out.println("Ano do Produto: " + produto.getAno());
                System.out.println("Preco do Produto: " + produto.getPreco());
            }
            
            JOptionPane.showMessageDialog(null, "Produtos listados com sucesso");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);

        }
    }
}
