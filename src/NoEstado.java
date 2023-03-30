
public class NoEstado {
    private NoEstado prox;
    private Cidade listaCidade;
    private String nome;

    public NoEstado()
    {
        this.prox = null;
        this.nome = "";
        this.listaCidade = null;
    }
    public NoEstado(String nome)
    {
        new NoEstado();
        this.nome = nome;
    }
    public NoEstado(String nome, NoEstado prox)
    {
        new NoEstado();
        this.nome = nome;
        this.prox = prox;
    }
    public NoEstado getProx(){
        return prox;
    }
    public void setProx(NoEstado prox){
        this.prox = prox;
    }
    public String getNome(){
        return this.getNome();
    }
    public void setNome(String nome){
        this.setNome(nome);
    }
    public void setListaCidade(Cidade listaCidade) {
        this.listaCidade = listaCidade;
    }
    public Cidade getListaCidade() {
        return listaCidade;
    }
}
