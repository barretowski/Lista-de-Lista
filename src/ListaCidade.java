public class ListaCidade {
    private NoCidade inicio;
    private NoCidade fim;

    public ListaCidade(){
        this.inicio = null;
        this.fim = null;
    }
    public ListaCidade(NoCidade inicio, NoCidade fim){
        this.inicio = inicio;
        this.fim = fim;
    }
    public NoCidade getFim() {
        return fim;
    }

    public void setFim(NoCidade fim) {
        this.fim = fim;
    }
    public NoCidade getInicio(){
        return inicio;
    }
    public void setInicio(ListaCidade inicio){
        this.setInicio(inicio);
    }
    public NoCidade buscaCidade(String nome){
        NoCidade ini = this.inicio;
        while (ini!=null && ini.getNome()!=nome){
            ini = ini.getProx();
        }

        return ini;
    }
    public NoCidade ultimaPos(){
        NoCidade ini = this.inicio;
        NoCidade ant = ini;
        while(ini!=null){
            ant = ini;
            ini = ini.getProx();
        }
        return ant;
    }


}
