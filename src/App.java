import classes.Locadora;

import java.util.Scanner;
import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {
        Locadora turboGames = new Locadora("Turbo Games");
        Scanner scanner = new Scanner(System.in);
        int opcao = 0;

        //turboGames.init();

        System.out.println("******************************");
        System.out.println("Bem vindo a locadora " + turboGames.getNome());
        System.out.println("******************************");
        
        while(true){
            System.out.print("\n");
            System.out.println("-----------------------");
            System.out.println("--- Menu ---");
            System.out.println("-----------------------");
            System.out.println("Digite a opcao desejada:");
            System.out.println("1 - Cadastrar um filme");
            System.out.println("2 - Cadastrar um jogo");
            System.out.println("3 - Ver catalogo de filmes");
            System.out.println("4 - Ver catalogo de jogos");
            System.out.println("5 - Registrar locacao");
            System.out.println("6 - Registrar devolucao");
            System.out.println("7 - Exibir valor em caixa");
            System.out.println("8 - Sair da aplicacao");
            System.out.println("-----------------------");
            
            try {
                opcao = Integer.valueOf(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Por favor, digite um número inteiro.");
                continue;
            }

            System.out.print("\n");

            if(opcao < 1 || opcao > 8){
                System.out.println("Digite uma opcao valida");
                continue;
            }
            
            if(opcao == 1) turboGames.cadastrarFilme();
            
            if(opcao == 2) turboGames.cadastrarJogo();

            if(opcao == 3) turboGames.exibirCatalogoFilmes();

            if(opcao == 4) turboGames.exibirCatalogoJogos();

            if(opcao == 5) turboGames.locar();

            if(opcao == 6) turboGames.devolver();

            if(opcao == 7) turboGames.exibeValorEmCaixa();

            if(opcao == 8) break;
            System.out.print("\n");
        }
    }
}
