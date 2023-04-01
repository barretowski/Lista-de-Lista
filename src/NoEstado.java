
public class NoEstado {
    private NoEstado prox;
    private ListaCidade cidade;
    private String nome;

    public NoEstado()
    {
        this.prox = null;
        this.nome = "";
        this.cidade = null;
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
        return this.nome;
    }
    public void setNome(String nome){
        this.nome = nome;
    }
    public void setListaCidade(ListaCidade listaCidade) {
        this.cidade = listaCidade;
    }
    public ListaCidade getListaCidade() {
        return cidade;
    }
}
