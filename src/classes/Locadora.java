package classes;

import interfaces.Loja;
import java.util.Scanner;

import java.util.ArrayList;

public class Locadora implements Loja{
  private String nome;
  private Scanner scanner = new Scanner(System.in);
  private Double caixa;
  private ArrayList<Filme> filmes = new ArrayList<Filme>();
  private ArrayList<Jogo> jogos = new ArrayList<Jogo>();

  public Locadora(String nome){
    this.nome = nome;
    this.caixa = 0.0;
  }

  public void init(){
    this.getFilmes().add(new Filme("Matrix", "Ação", 2020, 35, 0));
    this.getFilmes().add(new Filme("Shrek", "Aventura", 2200, 35, 123));
    this.getJogos().add(new Jogo("Mario", "Plataforma", 2305, "SNES"));
    this.getJogos().add(new Jogo("Sonic", "Plataforma", 2215, "Sega Saturn"));
  }

  public String getNome(){
    return this.nome;
  }

  public void addAoCaixa(Double valor){
    this.caixa += valor;
  }

  public Double getCaixa(){
    return this.caixa;
  }

  public Scanner getScanner(){
    return this.scanner;
  }

  public ArrayList<Filme> getFilmes(){
    return this.filmes;
  }

  public ArrayList<Jogo> getJogos(){
    return this.jogos;
  }


  public void cadastrarFilme(){
    System.out.println("-----------------------");
    System.out.println("--- Cadastrando filme ---");
    System.out.println("-----------------------");

    System.out.println("Titulo:");
    String titulo = scanner.nextLine();

    if(this.existeProduto("Filme", titulo)){
      System.out.println("Produto ja existe!");
      return;
    }

    System.out.println("Genero principal:");
    String generoPrincipal = scanner.nextLine();

    System.out.println("Ano de lancamento:");
    int anoLancamento;
    while(true){
      try {
        anoLancamento = Integer.valueOf(scanner.nextLine());
        break;
      } catch (NumberFormatException e) {
        System.out.println("Entrada inválida. Por favor, digite um número inteiro.");
      }
    }

    System.out.println("Duracao (em minutos):");
    int duracao;
    while(true){
      try {
        duracao = Integer.valueOf(scanner.nextLine());
        break;
      } catch (NumberFormatException e) {
        System.out.println("Entrada inválida. Por favor, digite um número inteiro.");
      }
    }

    System.out.println("Faixa etaria (0 para todas as idades):");
    int faixaEtaria;
    while(true){
      try {
        faixaEtaria = Integer.valueOf(scanner.nextLine());
        break;
      } catch (NumberFormatException e) {
        System.out.println("Entrada inválida. Por favor, digite um número inteiro.");
      }
    }

    Filme filme = new Filme(titulo, generoPrincipal, anoLancamento, duracao, faixaEtaria);

    this.getFilmes().add(filme);
  }

  public void cadastrarJogo(){
    System.out.println("-----------------------");
    System.out.println("--- Cadastrando jogo ---");
    System.out.println("-----------------------");

    System.out.println("Titulo:");
    String titulo = scanner.nextLine();

    if(this.existeProduto("Jogo", titulo)){
      System.out.println("Produto ja existe!");
      return;
    }

    System.out.println("Genero principal:");
    String generoPrincipal = scanner.nextLine();

    System.out.println("Ano de lancamento:");
    int anoLancamento;
    while(true){
      try {
        anoLancamento = Integer.valueOf(scanner.nextLine());
        break;
      } catch (NumberFormatException e) {
        System.out.println("Entrada inválida. Por favor, digite um número inteiro.");
      }
    }

    System.out.println("Plataforma:");
    String plataforma = scanner.nextLine();

    Jogo jogo = new Jogo(titulo, generoPrincipal, anoLancamento, plataforma);
    this.getJogos().add(jogo);
  }

  public void exibirCatalogoFilmes(){
    System.out.println("-----------------------");
    System.out.println("--- Catalogo filmes ---");
    System.out.println("-----------------------");

    if(this.getFilmes().size() == 0){
      System.out.println("Nenhum filme disponivel :(");
    }else{
        int count = 0;    
        System.out.println("Filmes disponiveis:");    

        for(Filme filme : this.getFilmes()){
          if(!filme.getEstaLocado()){
            System.out.println(filme.getDescricao());
            count++;
          }
        }

        if(count == 0) System.out.println("Todos os filmes foram locados :(");
    }
  }

  public void exibirCatalogoJogos(){
    System.out.println("-----------------------");
    System.out.println("--- Catalogo jogos ---");
    System.out.println("-----------------------");

    if(this.getJogos().size() == 0){
      System.out.println("Nenhum jogo disponivel :(");
    }else{       
        int count = 0;         
        System.out.println("Jogos disponiveis:");

        for (Jogo jogo : this.getJogos()) {
            if(!jogo.getEstaLocado()){
              System.out.println(jogo.getDescricao());
              count++;
            }
        }

        if(count == 0) System.out.println("Todos os jogos foram locados :(");
    }
  }

  public void locar(){
    String tipoProduto = "";
    String titulo;

    System.out.println("-----------------------");
    System.out.println("--- Locando Produto ---");
    System.out.println("-----------------------");

    while(!this.filmeOuJogo(tipoProduto)){
      System.out.println("Locando Filme ou Jogo?");
      tipoProduto = scanner.nextLine();

      if(!this.filmeOuJogo(tipoProduto)) System.out.println("Input deve ser Filme ou Jogo");
    }

    if(tipoProduto.equals("Filme")){
      System.out.println("Titulo do Filme:");
      titulo = scanner.nextLine();

      if(!this.existeProduto(tipoProduto, titulo)){
        System.out.println("Produto não existe!");
        return;
      }

      for(Filme filme : this.getFilmes()){
        if(filme.getTitulo().equals(titulo)){
          if(filme.getEstaLocado()){
            System.out.println("Filme ja foi locado");
            return;
          }

          System.out.println("Filme Locado!");
          filme.setEstaLocado(true);
          this.addAoCaixa(5.0);
        }
      }
    }else if(tipoProduto.equals("Jogo")){
      System.out.println("Titulo do Jogo:");
      titulo = scanner.nextLine();

      if(!this.existeProduto(tipoProduto, titulo)){
        System.out.println("Produto não existe!");
        return;
      }

      for(Jogo jogo : this.getJogos()){
        if(jogo.getTitulo().equals(titulo)){
          if(jogo.getEstaLocado()){
            System.out.println("Filme ja foi locado");
            return;
          }

          System.out.println("Jogo Locado!");
          jogo.setEstaLocado(true);
          this.addAoCaixa(10.0);
        }
      }
    }
  }

  public void devolver(){
    String tipoProduto = "";
    String titulo;

    System.out.println("-----------------------");
    System.out.println("--- Devolvendo Produto ---");
    System.out.println("-----------------------");

    while(!this.filmeOuJogo(tipoProduto)){
      System.out.println("Devolvendo Filme ou Jogo?");
      tipoProduto = scanner.nextLine();

      if(!this.filmeOuJogo(tipoProduto)) System.out.println("Input deve ser Filme ou Jogo");
    }
    

    if(tipoProduto.equals("Filme")){
      System.out.println("Titulo do Filme:");
      titulo = scanner.nextLine();

      if(!this.existeProduto(tipoProduto, titulo)){
        System.out.println("Produto não existe!");
        return;
      }

      for(Filme filme : this.getFilmes()){
        if(filme.getTitulo().equals(titulo)){
          if(!filme.getEstaLocado()){
            System.out.println("Filme não foi locado!");
            continue;
          }

          System.out.println("Filme devolvido!");
          filme.setEstaLocado(false);
        }
      }
    }else if(tipoProduto.equals("Jogo")){
      System.out.println("Titulo do Jogo:");
      titulo = scanner.nextLine();

      if(!this.existeProduto(tipoProduto, titulo)){
        System.out.println("Produto não existe!");
        return;
      }

      for(Jogo jogo : this.getJogos()){
        if(jogo.getTitulo().equals(titulo)){
          if(!jogo.getEstaLocado()){
            System.out.println("Jogo não foi locado!");
            continue;
          }

          System.out.println("Jogo devolvido!");
          jogo.setEstaLocado(false);
        }
      }
    }
  }

  public boolean filmeOuJogo(String tipoProduto){
    if(tipoProduto.equals("Filme") || tipoProduto.equals("Jogo")) return true;

    return false;
  }

  public boolean existeProduto(String tipoProduto, String titulo){
    if(tipoProduto.equals("Filme")){
      for(Filme filme : this.getFilmes()){
        if(filme.getTitulo().equals(titulo)) return true;
      }
    }

    if(tipoProduto.equals("Jogo")){
      for(Jogo jogo : this.getJogos()){
        if(jogo.getTitulo().equals(titulo)) return true;
      }
    }

    return false;
  }

  public void exibeValorEmCaixa(){
    System.out.println(this.getCaixa() + " reais");
  }
}
