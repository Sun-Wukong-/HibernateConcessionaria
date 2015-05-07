package br.com.castelobranco.concessionaria.persistencia;

import br.com.castelobranco.concessionaria.modelo.Produto;
import br.com.castelobranco.concessionaria.modelo.Venda;
import java.util.Date;
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
public class DaoVenda {
    public void armazenar(Venda venda) {
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction(); // Abre-se uma transação
        try {
            session.save(venda);      // Acumula a operação de gravação do objeto cliente no BD, na transação
            tx.commit();   // Realiza definitivamente todas as operações pendentes na transação
            JOptionPane.showMessageDialog(null, "Venda Registrada com Sucesso");

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            tx.rollback();
        }finally{
            session.close();
        }
    }
    
        public void excluir(Long id) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Object test = session.get(Venda.class, id);
        if(test != null){
            Transaction tx = session.beginTransaction(); // Abre-se uma transação
            try {
                Venda result = (Venda) session.createCriteria(Venda.class)  
                                 .add(Restrictions.idEq(id))  
                                .uniqueResult();      // Acumula a operação de exclusão do objeto cliente no BD, na transação
                if(result != null){
                    session.delete(result);
                    tx.commit();  // Realiza definitivamente todas as operações pendentes na transação
                    JOptionPane.showMessageDialog(null, "Venda Excluída com Sucesso");
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
                // Cria-se uma lista de clientes a partir do BD
               List<Venda> list =  session.createCriteria(Venda.class)  
                                 .add(Restrictions.eqOrIsNull("identificadorVenda",id))   
                                 .list();  
                if(list.isEmpty()){
                    session.close();
                    JOptionPane.showMessageDialog(null, "O Codigo Correspondente não Existe no BD");
                }else{
                    try{
                        for (Iterator it = list.iterator(); it.hasNext();) {
                            Venda venda = (Venda) it.next();
                            System.out.println("Identificador da Venda: " + venda.getIdentificadorVenda());
                            System.out.println("Data da Venda: " + venda.getData());
                            System.out.println("Registro Vendedor: " + venda.getRegistroVendedor());
                            System.out.println("Codigo Produto: " + venda.getProduto().getCodigo());
                            System.out.println("Desconto: " + venda.getDesconto());
                            System.out.println("Valor Acessorio: " + venda.getValorAcessorio());
                            System.out.println("Valor Total: " + venda.getValorTotal());
                        }
                        JOptionPane.showMessageDialog(null, "Venda Recuperada com Sucesso");
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, ex.getMessage());
                    }finally{
                        session.close();
                    }
            }
    }
    
    public void pesquisarVendedor(Long vendedor){
        Session session = HibernateUtil.getSessionFactory().openSession();
       
         
                // Cria-se uma lista de clientes a partir do BD
               List<Venda> list =  session.createCriteria(Venda.class)  
                                 .add(Restrictions.eq("registroVendedor", vendedor))
                                 .list(); 
                if(list.isEmpty()){
                    session.close();
                    JOptionPane.showMessageDialog(null, "O Codigo Correspondente não Existe no BD");
                }else{
                    try{
                        int i = 0;
                        double valor = 0;
                         for (Iterator it = list.iterator(); it.hasNext();) {
                             Venda venda = (Venda) it.next();
                             System.out.println("-----------------------------------------");
                             System.out.println("Registro Vendedor: " + venda.getRegistroVendedor());
                             System.out.println("Data da Venda: " + venda.getData());
                             System.out.println("Valor Total: " + venda.getValorTotal());
                             System.out.println("-----------------------------------------");
                             i++;
                             valor += venda.getValorTotal();
                         }
                         System.out.println("Quantidade Vendida: " + i);
                         System.out.println("Somatorio das Venda: " + valor);

                         JOptionPane.showMessageDialog(null, "Venda Recuperada com Sucesso");
                    } catch (Exception ex) {
                         JOptionPane.showMessageDialog(null, ex.getMessage());
                     }finally{
                         session.close();
                     }
            }
        }
    
    public void pesquisarData(Date data){
        Session session = HibernateUtil.getSessionFactory().openSession();
       
         
                // Cria-se uma lista de clientes a partir do BD
               List<Venda> list =  session.createCriteria(Venda.class)  
                                 .add(Restrictions.eq("data", data))
                                 .list(); 
                if(list.isEmpty()){
                    session.close();
                    JOptionPane.showMessageDialog(null, "O Codigo Correspondente não Existe no BD");
                }else{
                    try{
                        int i = 0;
                        double valor = 0;
                         for (Iterator it = list.iterator(); it.hasNext();) {
                             Venda venda = (Venda) it.next();
                             System.out.println("-----------------------------------------");
                             System.out.println("Registro Vendedor: " + venda.getRegistroVendedor());
                             System.out.println("Data da Venda: " + venda.getData());
                             System.out.println("Valor Total: " + venda.getValorTotal());
                             System.out.println("-----------------------------------------");
                             i++;
                             valor += venda.getValorTotal();
                         }
                         System.out.println("Quantidade Vendida: " + i);
                         System.out.println("Somatorio das Venda: " + valor);

                         JOptionPane.showMessageDialog(null, "Venda Recuperada com Sucesso");
                    } catch (Exception ex) {
                         JOptionPane.showMessageDialog(null, ex.getMessage());
                     }finally{
                         session.close();
                     }
            }
        }
    }

