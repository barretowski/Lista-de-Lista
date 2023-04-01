public class Main {
    public static void main(String[] args) {
        ListaEstado lista = new ListaEstado();

        //A) Inserir por estado e cidade
        lista.inserirEstadoECidade("Rio de Janeiro","Cabo Frio");
        lista.inserirEstadoECidade("São Paulo", null);
        lista.inserirEstadoECidade("Santa Catarina", "Joinville");
        lista.inserirEstadoECidade("Rio de Janeiro","Niteroi");
        lista.inserirEstadoECidade("Bahia","Salvador");
        lista.inserirEstadoECidade("Amazonas","Manaus");
        lista.inserirEstadoECidade("Amazonas","Coari");
        lista.inserirEstadoECidade("Santa Catarina", "Florianópolis");
        lista.inserirEstadoECidade("Santa Catarina", "Blumenau");
        lista.inserirEstadoECidade("Santa Catarina", "Balneário Camboriú");
        System.out.println("Lista desordenada:\n");
        lista.exibirListaEstado();

        //B) Ordenar as Listas de Estado e as listas de Cidades
        lista.ordenarListaEstadosCidades();
        System.out.println("\n_______________________________________" +
                "\n Lista Ordenada: \n");
        lista.exibirListaEstado();

        //C) Buscar um Estado retornando o endereço do nodo, ou null caso não encontre
        System.out.println("\n_______________________________________" +
                "\n Endereço do estado: \n");
        System.out.println(lista.buscarEstado("Bahia"));

        //D) Listar todas as Cidades de um determinado Estado
        System.out.println("\n_______________________________________" +
                "\n Lisagem de cidades por estado: \n");
        lista.exibirCidadesDoEstado("Santa Catarina");

        //E) Verificar se um par Estado,Cidade está inserido nas Listas, retornando um boolean (True/False)
        System.out.println("\n_______________________________________" +
                "\n Estado e cidades informados existem? \n");
        System.out.println(lista.exist("Santa Catarina", "Blumenau"));
    }
}