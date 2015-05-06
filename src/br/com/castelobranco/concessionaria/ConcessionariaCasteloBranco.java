package br.com.castelobranco.concessionaria;

import br.com.castelobranco.concessionaria.controle.ControleProduto;
import br.com.castelobranco.concessionaria.modelo.Produto;
import java.util.Scanner;

/**
 *
 * @author Wukong
 */
public class ConcessionariaCasteloBranco {

    private static Scanner s;
    public static void main(String[] args) {
        
                // instanciar Classe Scanner
		s = new Scanner(System.in);
                Produto OBJProduto = new Produto();
		ControleProduto controleProduto = new ControleProduto();
                Long codPro;
                
		int op = 0;
		while (op <= 6) {

			System.out.println("[1] Inserir Produto");
			System.out.println("[2] Excluir Produto");
			System.out.println("[3] Alterar Produto");
			System.out.println("[4] Pesquisar Produto");
			System.out.println("---------------------------------------------");
			System.out.println("[5] Realizar Venda");
			System.out.println("[6] Realizar Pesquisas de Vendas");
			System.out.println("---------------------------------------------");
			System.out.println("[7] Sair");

			op = s.nextInt();

			if (op > 6) {
				System.out.println("Finalizado!!!");
			} else {

				switch (op) {
				// Adicionar Automovel
				case 1:

					// CriandoObj
                                        
                                        System.out.println("Entre com As inform��es do Produto: ");
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
                                    System.out.println("Digite o C�digo do produto que deseja excluir: ");
                                    codPro = (s.nextLong());
                                    controleProduto.excluir(codPro);
					
                                break;

				// Atualizar Automovel
				case 3:
                                    
                                    System.out.println("Entre com As inform��es do Produto: ");
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
                                    System.out.println("Digite o C�digo do produto que deseja visulizar ");
                                    codPro = (s.nextLong());
                                    controleProduto.pesquisar(codPro);
				break;
				
				//Realizar Venda
				case 5:
			
					break;

				// Pesquisas de venda
				case 6:
			
					break;
				}
			}
		}
	}
}
