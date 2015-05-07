package br.com.castelobranco.concessionaria.persistencia;

import br.com.castelobranco.concessionaria.modelo.Produto;
import java.util.Iterator;
import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Wukong
 */
public class DaoProduto {
    
   
    public void armazenar(Produto produto) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction(); // Abre-se uma transação
        try {
            session.save(produto);      // Acumula a operação de gravação do objeto cliente no BD, na transação
            tx.commit();   // Realiza definitivamente todas as operações pendentes na transação
            JOptionPane.showMessageDialog(null, "Produto Armazenado com Sucesso");

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            tx.rollback();
        }finally{
            session.close();
        }
    }

    public void alterar(Produto produto) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction(); // Abre-se uma transação
        try {
            session.merge(produto);      // Acumula a operação de alteração do objeto cliente no BD, na transação
            tx.commit();  // Realiza definitivamente todas as operações pendentes na transação
            JOptionPane.showMessageDialog(null, "Produto alterado com sucesso");

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            tx.rollback();
        }finally{
            session.close();
        }
    }

    public void excluir(Long id) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Object test = session.get(Produto.class, id);
        if(test != null){
            Transaction tx = session.beginTransaction(); // Abre-se uma transação
            try {
                Produto result = (Produto) session.createCriteria(Produto.class)  
                                 .add(Restrictions.idEq(id))  
                                .uniqueResult();      // Acumula a operação de exclusão do objeto cliente no BD, na transação
                if(result != null){
                    session.delete(result);
                    tx.commit();  // Realiza definitivamente todas as operações pendentes na transação
                    JOptionPane.showMessageDialog(null, "Produto excluído com sucesso");
                }

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
                tx.rollback();
            }finally{
                session.close();
            }
        }else{
            JOptionPane.showMessageDialog(null, "O Codigo Correspondente não Existe no BD");
            session.close();
            }
    }

    public void pesquisar (Long id)  {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Object test = session.get(Produto.class, id);
        if(test != null){
            try {
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
                JOptionPane.showMessageDialog(null, "Produtos Recuperado com sucesso");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }finally{
                session.close();
            }
        }else{
            JOptionPane.showMessageDialog(null, "O Codigo Correspondente não Existe no BD");
            session.close();
        }
    }
    
    public Produto recuperar(Long id){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Produto result = (Produto) session.get(Produto.class, id);
        session.close();
        return result;
    }
}
