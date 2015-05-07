package br.com.castelobranco.concessionaria;

import br.com.castelobranco.concessionaria.controle.ControleProduto;
import br.com.castelobranco.concessionaria.controle.ControleVenda;
import br.com.castelobranco.concessionaria.modelo.Produto;
import br.com.castelobranco.concessionaria.modelo.Venda;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author Wukong
 */
public class ConcessionariaCasteloBranco {

    private static Scanner s;
    public static void main(String[] args) throws ParseException {
        
                // instanciar Classe Scanner
		s = new Scanner(System.in);
                Produto OBJProduto = new Produto();
                Venda OBJVenda = new Venda();
		ControleProduto controleProduto = new ControleProduto();
                ControleVenda controleVenda = new ControleVenda();
                Long cod;
                
		int op = 0;
		while (op <= 9) {

			System.out.println("[1] Inserir Produto");
			System.out.println("[2] Excluir Produto");
			System.out.println("[3] Alterar Produto");
			System.out.println("[4] Pesquisar Produto");
			System.out.println("---------------------------------------------");
			System.out.println("[5] Realizar Venda");
			System.out.println("[6] Excluir Vendas");
                        System.out.println("[7] Pesquisar Vendas");
                        System.out.println("[8] Pesquisar Vendas do Vendedor");
                        System.out.println("[9] Pesquisar Vendas da Data");
			System.out.println("---------------------------------------------");
			System.out.println("[10] Sair");

			op = s.nextInt();

			if (op >= 10) {
				System.out.println("Finalizado!!!");
                                System.exit(0);
			} else {

				switch (op) {
				// Adicionar Automovel
				case 1:

					// CriandoObj
                                        
                                        System.out.println("Entre com as informcoes do Produto: ");
                                        System.out.println("Marca: ");
                                        OBJProduto.setMarca(s.next());
                                        System.out.println("Modelo: ");
                                        OBJProduto.setModelo(s.next());
                                        System.out.println("Cor: ");
                                        OBJProduto.setCor(s.next());
                                        System.out.println("Ano: ");
                                        OBJProduto.setAno(s.nextInt());
                                        System.out.println("Preco: ");
                                        OBJProduto.setPreco(s.nextDouble());

					// Chamando Fun��es
					controleProduto.armazenar(OBJProduto);

				break;
				// Excluir Automovel
				case 2:
                                    System.out.println("Digite o Codigo do Produto que Deseja Excluir: ");
                                    cod = (s.nextLong());
                                    controleProduto.excluir(cod);
					
                                break;

				// Atualizar Automovel
				case 3:
                                    
                                    System.out.println("Entre com as Informcoes do Produto: ");
                                    System.out.println("Codigo Produto: ");
                                    OBJProduto.setCodigo(s.nextLong());
                                    System.out.println("Marca: ");
                                    OBJProduto.setMarca(s.next());
                                    System.out.println("Modelo: ");
                                    OBJProduto.setModelo(s.next());
                                    System.out.println("Cor: ");
                                    OBJProduto.setCor(s.next());
                                    System.out.println("Ano: ");
                                    OBJProduto.setAno(s.nextInt());
                                    System.out.println("Preco: ");
                                    OBJProduto.setPreco(s.nextDouble());
                                    
                                    // Chamando Fun��es
                                    controleProduto.alterar(OBJProduto);
                                    
                                    break;

				// Pesquisar Produto
				case 4:
                                    System.out.println("Digite o Codigo do Produto que Deseja Visulizar ");
                                    cod = (s.nextLong());
                                    controleProduto.pesquisar(cod);
				break;
				
				//Realizar Venda
				case 5:
                                    System.out.println("Codigo do Produto: ");
                                    Long codigoProduto = s.nextLong();
                                    Produto produtoAux = controleProduto.recuperar(codigoProduto);
                                    OBJVenda.setProduto(produtoAux);
                                    
                                    System.out.println("Identificador Venda:: ");
                                    OBJVenda.setIdentificadorVenda(s.nextLong());
                                    System.out.println("Data - YYYY/MM/DD: ");
                                    
                                    String dataRecebida = s.next();
                                    DateFormat df = new SimpleDateFormat("yyyy/MM/dd");    
                                    Date dt = df.parse(dataRecebida);  
                                    OBJVenda.setData(dt);
                                    System.out.println("Registro Vendedor: ");
                                    OBJVenda.setRegistroVendedor(s.nextLong());
                                    
                                    System.out.println("Valor Desconto: ");
                                    double desconto = s.nextDouble();
                                    OBJVenda.setDesconto(desconto);
                                    
                                    System.out.println("Valor Acessorios: ");
                                    double acessorio = s.nextDouble();
                                    OBJVenda.setValorAcessorio(acessorio);                                    
                                    
                                    double valorProduto = produtoAux.getPreco();
                                    double valorFinal = OBJVenda.calcularValorTotal(valorProduto, desconto, acessorio);     
                                    OBJVenda.setValorTotal(valorFinal);
                                    
                                    controleVenda.armazenar(OBJVenda);
                                break;

				// Exluir Venda
				case 6:
                                    System.out.println("Digite o Codigo da Venda que Deseja Excluir: ");
                                    cod = (s.nextLong());
                                    controleVenda.excluir(cod);
				break;
                                
                                case 7:
                                    System.out.println("Digite o Codigo da Venda que Deseja Visulizar ");
                                    cod = (s.nextLong());
                                    controleVenda.pesquisar(cod);
				break;
                                    
                                case 8:
                                    System.out.println("Digite o Registro do Vendedor que Deseja Visualizar ");
                                    cod = (s.nextLong());
                                    controleVenda.pesquisarVendedor(cod);
				break;
                                    
                                case 9:
                                     System.out.println("Digite a Data que Deseja Visualizar ");
                                     System.out.println("Data - YYYY/MM/DD: ");
                                     String dataVisualizada = s.next();
                                     DateFormat dr = new SimpleDateFormat("yyyy/MM/dd");    
                                     Date de = dr.parse(dataVisualizada);
                                     controleVenda.pesquisarData(de);
				break;
                            }
			}
		}
	}
}
