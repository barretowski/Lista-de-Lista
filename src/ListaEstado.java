import java.util.ArrayList;

public class ListaEstado {
    private NoEstado inicio;
    private NoEstado fim;

    public ListaEstado(){
        this.inicio = null;
    }
    public ListaEstado(NoEstado inicio, NoEstado fim){
        this.inicio = inicio;
        this.fim = fim;
    }
    public NoEstado getInicio() {
        return inicio;
    }
    public void setInicio(NoEstado inicio){
        this.inicio = inicio;
    }
    public NoEstado getFim() {
        return fim;
    }

    public void setFim(NoEstado fim) {
        this.fim = fim;
    }
    public void insereCidade(NoEstado posEstado, String nomeCidade, NoCidade novaCidade){
        ListaCidade cidade;
        cidade = posEstado.getListaCidade();
        if(cidade == null)
            posEstado.setListaCidade(new ListaCidade(novaCidade, novaCidade));
        else{
            NoCidade posCidade = cidade.buscaCidade(nomeCidade);
            if(posCidade == null)//verifica se cidade não existe na lista de cidades
            {
                posCidade = cidade.getFim();
                posCidade.setProx(novaCidade);
                cidade.setFim(novaCidade);
            }
            else{
                System.out.println("A cidade "+nomeCidade+" já existe");
            }
        }
    }
    public void inserirEstadoECidade(String nomeEstado, String nomeCidade)
    {
        NoEstado aux = inicio;
        NoEstado novoEstado = new NoEstado(nomeEstado,null);
        NoCidade novaCidade = new NoCidade(nomeCidade);

        if(aux==null){
            ListaEstado estado = new ListaEstado();
            if(nomeCidade != null && nomeCidade != "")
                novoEstado.setListaCidade(new ListaCidade(novaCidade, novaCidade));

            this.inicio = novoEstado;
            this.fim = novoEstado;
        }
        else{
            NoEstado posEstado = this.buscarEstado(nomeEstado);
            if(posEstado != null)//posiciona no Nodo do estado já existente e insere a cidade
            {
                if(nomeCidade != null && nomeCidade != "")//
                    insereCidade(posEstado, nomeCidade, novaCidade);
            }
            else {//insere um novo estado no final da lista de estados
                posEstado = getFim();
                posEstado.setProx(new NoEstado(nomeEstado));
                posEstado = posEstado.getProx();
                posEstado.setListaCidade(new ListaCidade(novaCidade, novaCidade));
                this.fim = posEstado;
            }
        }


    }
    public void exibirCidadesDoEstado(String nomeEstado){
        NoEstado posEstado = buscarEstado(nomeEstado);
        if(posEstado!=null){
            ListaCidade cidades = posEstado.getListaCidade();
            NoCidade posCidade = cidades.getInicio();
            if(posCidade.getNome() == null || posCidade.getNome()== "")
                System.out.println("Nenhuma cidade encontrada no estado de "+nomeEstado);
            else{
                while(posCidade!=null){
                    System.out.println(posCidade.getNome());
                    posCidade = posCidade.getProx();
                }
            }
        }
        else
            System.out.println("Nenhum estado cadastrado");
    }
    public void ordenarListaEstadosCidades(){
        NoEstado posMenor = null;
        String menor;
        NoEstado pi, pj, aux;
        ListaCidade auxCidade;

        pi = this.inicio;
        NoEstado atual = pi;
        while(pi.getProx()!=null){
            menor = pi.getNome();
            posMenor = pi;

            pj=pi.getProx();
            while(pj!=null){
                if(pj.getNome().compareToIgnoreCase(menor)<0){
                    menor = pj.getNome();
                    posMenor = pj;
                }
                pj=pj.getProx();
            }
            auxCidade = posMenor.getListaCidade();
            String auxEstado = posMenor.getNome();

            posMenor.setNome(pi.getNome());
            posMenor.setListaCidade(pi.getListaCidade());

            pi.setNome(auxEstado);
            aux = buscarEstado(auxEstado);

            if(aux!=null){
                pi.setListaCidade(auxCidade);
                ListaCidade cidades = pi.getListaCidade();
                ordernaListaCidade(cidades.getInicio());
            }else{
                pi.setListaCidade(null);
            }
            pi=pi.getProx();
        }

    }
    public void ordernaListaCidade(NoCidade cidades){
        NoCidade pj, pi = cidades;
        String menor;
        NoCidade aux,posMenor=null;
        while(pi.getProx()!=null){
            pj = pi.getProx();
            menor = pi.getNome();
            posMenor = pi;
            while(pj!=null){
                if(pj.getNome().compareToIgnoreCase(menor)<0){
                    menor = pj.getNome();
                    posMenor = pj;
                }
                pj = pj.getProx();
            }
            posMenor.setNome(pi.getNome());
            pi.setNome(menor);
            pi = pi.getProx();
        }
    }
    public NoEstado buscarEstado(String nome){
        NoEstado ini = this.inicio;
        while(ini!=null && ini.getNome()!=nome)
            ini=ini.getProx();

        return ini;
    }
    public Boolean exist(String nomeEstado, String nomeCidade){
        NoEstado posEstado = buscarEstado(nomeEstado);
        if(posEstado != null){
            ListaCidade cidade = posEstado.getListaCidade();
            NoCidade posCidade = cidade.buscaCidade(nomeCidade);
            if(posCidade!=null){
                if(posEstado.getNome() == nomeEstado && posCidade.getNome() == nomeCidade)
                    return true;
                else
                    return false;
            }
            else
                return false;
        }else
            return false;

    }
    public NoEstado ultimaPos(){
        NoEstado ini = this.inicio;
        NoEstado ant = ini;
        while(ini!=null){
            ant = ini;
            ini = ini.getProx();
        }
        return ant;
    }
    public void exibirListaEstado(){
        NoEstado aux = this.inicio;
        ListaCidade cidade;
        while(aux!=null){
            System.out.println("\n--->["+aux.getNome()+"]");
            cidade = aux.getListaCidade();
            if(cidade!=null){
                NoCidade auxCidade = cidade.getInicio();
                while(auxCidade!=null){
                    if(auxCidade.getNome()!=null && auxCidade.getNome() != "")
                        System.out.print(" - "+auxCidade.getNome());
                    else
                        System.out.print(" - Nenhuma cidade vinculada.");
                    auxCidade=auxCidade.getProx();
                }
            }
            aux=aux.getProx();
        }
    }

}
