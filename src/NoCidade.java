public class NoCidade {
    private NoCidade prox;
    private String nome;

    public NoCidade(){
        this.nome="";
        this.prox = null;
    }
    public NoCidade(String nome){
        this.nome=nome;
        this.prox = null;
    }

    public void setProx(NoCidade prox) {
        this.prox = prox;
    }
    public NoCidade getProx(){
        return prox;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome){
        this.nome=nome;
    }
}
