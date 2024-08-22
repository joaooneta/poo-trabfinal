package classes;

public class Jogo extends ItemLocadora{
  private String plataforma;

  public Jogo(String titulo, String generoPrincipal, int anoLancamento, String plataforma){
    super(titulo, generoPrincipal, anoLancamento);
    this.plataforma = plataforma;
  }

  public String getPlataforma(){
    return this.plataforma;
  }

  public String getDescricao(){
    return this.getTitulo() + " - " + 
    this.getGeneroPrincipal() + " - " + 
    this.getAnoLancamento() + " - " +
    this.getPlataforma();
  }
}
