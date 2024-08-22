package classes;

public class Filme extends ItemLocadora{
  private int duracao;
  private int faixaEtaria;

  public Filme(String titulo, String generoPrincipal, int anoLancamento, int duracao, int faixaEtaria){
    super(titulo, generoPrincipal, anoLancamento);
    this.duracao = duracao;
    this.faixaEtaria = faixaEtaria;
  }

  public int getDuracao(){
    return this.duracao;
  }

  public int getFaixaEtaria(){
    return this.faixaEtaria;
  }

  public String getDescricao(){
    String idadeMinima;

    if(this.getFaixaEtaria() == 0){
      idadeMinima = "Todas as idades";
    }else{
      idadeMinima = " A partir de " + this.getFaixaEtaria() + " anos";
    }

    return this.getTitulo() + " - " + 
    this.getGeneroPrincipal() + " - " + 
    this.getAnoLancamento() + " - " +
    this.getDuracao() + " minutos - " +
    idadeMinima;
  }
}
