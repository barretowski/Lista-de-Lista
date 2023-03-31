public class Estado {
    private NoEstado inicio;

    public Estado(){
        this.inicio = null;
    }
    public NoEstado getInicio() {
        return inicio;
    }
    public void setInicio(NoEstado inicio){
        this.inicio = inicio;
    }
    public void inserirEstado(String nome)
    {
        NoEstado aux = inicio;
        NoEstado novo,ant;
        novo = new NoEstado(nome,null);
        if(aux==null)
            this.inicio = novo;
        else{
            ant = aux;
            while(aux.getProx()!=null && aux.getNome().compareToIgnoreCase(nome)>0)
            {
                ant = aux;
                aux = aux.getProx();
            }
            if(aux.getProx()==null)
                aux.setProx(novo);
            else
            {
                ant.setProx(novo);
                aux.setProx(aux);
            }
        }
    }

    public NoEstado buscarEstado(String nome){
        NoEstado ini = this.inicio;
        while(ini!=null && ini.getNome()!=nome)
            ini=ini.getProx();

        return ini;
    }

}
