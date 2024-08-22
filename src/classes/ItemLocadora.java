package classes;

public abstract class ItemLocadora {
  private String titulo;
  private String generoPrincipal;
  private int anoLancamento;
  private boolean estaLocado;

  public ItemLocadora(String titulo, String generoPrincipal, int anoLancamento){
    this.titulo = titulo;
    this.generoPrincipal = generoPrincipal;
    this.anoLancamento = anoLancamento;
    this.estaLocado = false;
  }

  public void setTitulo(String titulo){
    this.titulo = titulo;
  }

  public String getTitulo(){
    return this.titulo;
  }

  public void setGeneroPrincipal(String generoPrincipal){
    this.generoPrincipal = generoPrincipal;
  }

  public String getGeneroPrincipal(){
    return this.generoPrincipal;
  }

  public void setAnoLancamento(int anoLancamento){
    this.anoLancamento = anoLancamento;
  }

  public int getAnoLancamento(){
    return this.anoLancamento;
  }

  public boolean getEstaLocado(){
    return this.estaLocado;
  }

  public void setEstaLocado(boolean estaLocado){
    this.estaLocado = estaLocado;
  }

  public String getDescricao(){
    return this.getTitulo() + " - " + 
    this.getGeneroPrincipal() + " - " + 
    this.getAnoLancamento();
  }
}
