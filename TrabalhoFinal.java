//Vinícius, Ryan, Felipe Quadrado
import java.util.Scanner;
public class TrabalhoFinal
{
    public static Vagas[][] getEstacionamento(){
        Vagas [][] estacionamento = new Vagas[10][];
        for (int i = 0; i < estacionamento.length; i++){
            //Preencheendo todas as fileiras
            if (i < estacionamento.length - 3){
            estacionamento[i] = new Vagas[8];
            }
            else{
            estacionamento[i] = new Vagas[11];
            }
        }
        //Não reutilizamos o FOR pra evitar bugs
        for (int i = 0; i < estacionamento.length; i++){
            for (int j = 0; j < estacionamento[i].length; j++){
                //Criando os objetos em cada posição
                estacionamento[i][j] = new Vagas();
                estacionamento[i][j].DefinirPadrao();
            }
        }
        return estacionamento;
    }
    
    public static void visualizarMapa(Vagas [][] estacionamento){
        System.out.printf("\f");     
        System.out.println("✔ = LIVRE | ✘ = OCUPADO");
        System.out.println("");
        for (int i = 0; i < estacionamento.length;  i++){
            for (int j = 0; j < estacionamento[i].length; j++){
                switch (i){
                case 0: System.out.print("| A"); break;
                case 1: System.out.print("| B"); break;
                case 2: System.out.print("| C"); break;
                case 3: System.out.print("| D"); break;
                case 4: System.out.print("| E"); break;
                case 5: System.out.print("| F"); break;
                case 6: System.out.print("| G"); break;
                case 7: System.out.print("| H"); break;
                case 8: System.out.print("| I"); break;
                case 9: System.out.print("| J"); break;
            }
            System.out.print(j+1);
            if (estacionamento[i][j].getEstadoVaga() == true){
                System.out.print(" ✔ |");
            }
            else{
                System.out.print(" ✘ |");
            }
            }
            System.out.println("");
        }
    }
    
    public static void ManipularUmaVaga(Vagas [][] estacionamento, int escolha, int [] valoresAutomaticos){
        Scanner in = new Scanner(System.in);
        if(valoresAutomaticos == null){
            Vagas provisoria = new Vagas();
            String codigo;
            System.out.println("Por favor, digite o código da vaga. (Exemplo: A1, E5, H10...):");
            codigo = in.nextLine();
            int [] posicoes = provisoria.RegistrarCodigoVaga(codigo);
            switch (escolha){
                case 0:
                if (estacionamento[posicoes[0]][posicoes[1]].getEstadoVaga() == false){
                System.out.println("Esta vaga já se encontra ocupada.");
                }
                else{
                    String placa, nome, cor;
                    estacionamento[posicoes[0]][posicoes[1]].OcuparVaga();
                    System.out.println("Por favor, digite as informações do veículo.");
                    System.out.println("Digite a placa (Exemplo: ABC-1234):");
                    placa = in.nextLine();
                    System.out.println("Digite o nome do condutor (Exemplo: Ryan Quadrado Dias):");
                    nome = in.nextLine();
                    System.out.println("Digite a cor do veículo (Exemplo: Vermelho):");
                    cor = in.nextLine();
                    System.out.printf("\f");
                    estacionamento[posicoes[0]][posicoes[1]].setDadosDoVeiculo(placa, nome, cor);
                }
                break;
    
                case 1:
                estacionamento[posicoes[0]][posicoes[1]].LiberarVaga();
                String placa = "", nome = "", cor = "";
                estacionamento[posicoes[0]][posicoes[1]].setDadosDoVeiculo(placa, nome, cor);
                break;
            }
        }
        else{
            String placa, nome, cor;
            estacionamento[valoresAutomaticos[0]][valoresAutomaticos[1]].OcuparVaga();
            System.out.println("Por favor, digite as informações do veículo.");
            System.out.println("Digite a placa (Exemplo: ABC-1234):");
            placa = in.nextLine();
            System.out.println("Digite o nome do condutor (Exemplo: Ryan Quadrado Dias):");
            nome = in.nextLine();
            System.out.println("Digite a cor do veículo (Exemplo: Vermelho):");
            cor = in.nextLine();
            estacionamento[valoresAutomaticos[0]][valoresAutomaticos[1]].setDadosDoVeiculo(placa, nome, cor);
        }
        
    }
    
    public static void encontrarVagaLivre(Vagas [][] estacionamento){
        Scanner in = new Scanner(System.in);
        boolean loop = true;
        for (int i = 0; i < estacionamento.length;  i++){
            for (int j = 0; j < estacionamento[i].length; j++){
                if (estacionamento[i][j].getEstadoVaga() == true && loop == true){
                    System.out.print("Vaga encontrada: ");
                    switch (i){
                        case 0: System.out.print(" A"); break;
                        case 1: System.out.print(" B"); break;
                        case 2: System.out.print(" C"); break;
                        case 3: System.out.print(" D"); break;
                        case 4: System.out.print(" E"); break;
                        case 5: System.out.print(" F"); break;
                        case 6: System.out.print(" G"); break;
                        case 7: System.out.print(" H"); break;
                        case 8: System.out.print(" I"); break;
                        case 9: System.out.print(" J"); break;
                    }
                    System.out.print(j+1);
                    System.out.println();
                    System.out.println("Você deseja ocupar esta vaga?");
                    System.out.println("Sim = 1 | Não = 2");
                    int escolha = in.nextInt();
                    switch (escolha){
                        case 1: 
                        int [] valoresAutomaticos = new int[2];
                        valoresAutomaticos[0] = i;
                        valoresAutomaticos[1] = j;
                        ManipularUmaVaga(estacionamento, 0, valoresAutomaticos);
                        loop = false;
                        System.out.printf("\f");  
                        break;
                        
                        case 2:
                        loop = false;
                        System.out.printf("\f");  
                        break;
                    }
                }
            }
        }
    }
    
    public static void calcularPercentual(Vagas [][] estacionamento){
        int numeroTotalVagas = 0;
        for (int i = 0; i < estacionamento.length;  i++){
            for (int j = 0; j < estacionamento[i].length; j++){
                numeroTotalVagas++;
            }
        }
        int contadorLivres = 0;
        int contadorOcupadas = 0;
        for (int i = 0; i < estacionamento.length;  i++){
            for (int j = 0; j < estacionamento[i].length; j++){
                if (estacionamento[i][j].getEstadoVaga() == true) contadorLivres++;
                else contadorOcupadas++;
            }
        }
        
        double percentualLivres = (contadorLivres*100) / numeroTotalVagas;
        double percentualOcupadas = (percentualLivres - 100) * -1;
        if (percentualOcupadas == -0) percentualOcupadas = 0;
        System.out.printf("Vagas livres: %d (%.2f por cento das vagas)\n", contadorLivres, percentualLivres);
        System.out.printf("Vagas ocupadas: %d (%.2f por cento das vagas)\n", contadorOcupadas, percentualOcupadas);
    }
    
    public static void localizarVeiculo(Vagas [][] estacionamento){
        Scanner in = new Scanner(System.in);
        String corGenerica;
        System.out.println("Por favor, digite a cor dos veículos que quer listar.");
        corGenerica = in.nextLine();
        corGenerica = corGenerica.toUpperCase();
        int contadorVeiculo = 1;
        for (int i = 0; i < estacionamento.length;  i++){
            for (int j = 0; j < estacionamento[i].length; j++){
                if ((estacionamento[i][j].getCorDoVeiculo()).equals(corGenerica)){
                    System.out.printf("Veículo %d:\n", contadorVeiculo);
                    System.out.println("");
                    System.out.printf("Placa: %s\n",estacionamento[i][j].getPlacaDoVeiculo());
                    System.out.printf("Nome do condutor: \n", estacionamento[i][j].getNomeDoCondutor());
                    System.out.printf("Cor do veículo:\n", estacionamento[i][j].getCorDoVeiculo());
                    System.out.print("Vaga registrada: ");
                    switch (i){
                        case 0: System.out.print("A"); break;
                        case 1: System.out.print("B"); break;
                        case 2: System.out.print("C"); break;
                        case 3: System.out.print("D"); break;
                        case 4: System.out.print("E"); break;
                        case 5: System.out.print("F"); break;
                        case 6: System.out.print("G"); break;
                        case 7: System.out.print("H"); break;
                        case 8: System.out.print("I"); break;
                        case 9: System.out.print("J"); break;
                    }
                    System.out.print(j+1);
                }
            }
        }
        if (contadorVeiculo == 1){
            System.out.println("Nenhum veículo com essa cor foi encontrado.");
        }
    }
    
    public static void preencherVagas(Vagas [][] estacionamento, String codigo, String placa, String nome, String cor){
        Scanner in = new Scanner(System.in);
        Vagas provisoria = new Vagas();
        int [] posicoes = provisoria.RegistrarCodigoVaga(codigo);
        estacionamento[posicoes[0]][posicoes[1]].OcuparVaga();
        estacionamento[posicoes[0]][posicoes[1]].setDadosDoVeiculo(placa, nome, cor);
    }
    
    public static void CarregarDadosPreenchimento(Vagas [][] estacionamento){
    preencherVagas(estacionamento, "A1", "ABC-1234", "Fulano", "Azul"); preencherVagas(estacionamento, "A2", "ABC-1234", "Ciclano", "Preto"); preencherVagas(estacionamento, "A5", "ABC-1234", "Beltrano", "Rosa"); preencherVagas(estacionamento, "A6", "ABC-1234", "Sicrano", "Amarelo"); 
    preencherVagas(estacionamento, "B3", "ABC-1234", "Fulano", "Azul"); preencherVagas(estacionamento, "B4", "ABC-1234", "Ciclano", "Preto"); preencherVagas(estacionamento, "B7", "ABC-1234", "Beltrano", "Rosa"); preencherVagas(estacionamento, "B8", "ABC-1234", "Sicrano", "Amarelo"); 
    preencherVagas(estacionamento, "C1", "ABC-1234", "Fulano", "Azul"); preencherVagas(estacionamento, "C2", "ABC-1234", "Ciclano", "Preto"); preencherVagas(estacionamento, "C5", "ABC-1234", "Beltrano", "Rosa"); preencherVagas(estacionamento, "C6", "ABC-1234", "Sicrano", "Roxo"); 
    preencherVagas(estacionamento, "D3", "ABC-1234", "Fulano", "Azul"); preencherVagas(estacionamento, "D4", "ABC-1234", "Ciclano", "Preto"); preencherVagas(estacionamento, "D7", "ABC-1234", "Beltrano", "Rosa"); preencherVagas(estacionamento, "D8", "ABC-1234", "Sicrano", "Roxo"); 
    preencherVagas(estacionamento, "E1", "ABC-1234", "Fulano", "Azul"); preencherVagas(estacionamento, "E2", "ABC-1234", "Ciclano", "Preto"); preencherVagas(estacionamento, "E5", "ABC-1234", "Beltrano", "Rosa"); preencherVagas(estacionamento, "E6", "ABC-1234", "Sicrano", "Roxo"); 
    preencherVagas(estacionamento, "F3", "ABC-1234", "Fulano", "Azul"); preencherVagas(estacionamento, "F4", "ABC-1234", "Ciclano", "Preto"); preencherVagas(estacionamento, "F7", "ABC-1234", "Beltrano", "Verde"); preencherVagas(estacionamento, "F8", "ABC-1234", "Sicrano", "Roxo"); 
    preencherVagas(estacionamento, "G1", "ABC-1234", "Fulano", "Azul"); preencherVagas(estacionamento, "G2", "ABC-1234", "Ciclano", "Preto"); preencherVagas(estacionamento, "G5", "ABC-1234", "Beltrano", "Verde"); preencherVagas(estacionamento, "G6", "ABC-1234", "Sicrano", "Roxo"); 
    preencherVagas(estacionamento, "H3", "ABC-1234", "Fulano", "Vermelho"); preencherVagas(estacionamento, "H4", "ABC-1234", "Ciclano", "Branco"); preencherVagas(estacionamento, "H7", "ABC-1234", "Beltrano", "Verde"); preencherVagas(estacionamento, "H8", "ABC-1234", "Sicrano", "RoxoRoxo"); 
    preencherVagas(estacionamento, "I1", "ABC-1234", "Fulano", "Vermelho"); preencherVagas(estacionamento, "I2", "ABC-1234", "Ciclano", "Branco"); preencherVagas(estacionamento, "I5", "ABC-1234", "Beltrano", "Verde"); preencherVagas(estacionamento, "I6", "ABC-1234", "Sicrano", "Roxo");
    preencherVagas(estacionamento, "J3", "ABC-1234", "Fulano", "Vermelho"); preencherVagas(estacionamento, "J4", "ABC-1234", "Ciclano", "Branco"); preencherVagas(estacionamento, "J7", "ABC-1234", "Beltrano", "Vermelho"); preencherVagas(estacionamento, "J8", "ABC-1234", "Sicrano", "Roxo"); 
    preencherVagas(estacionamento, "H10", "ABC-1234", "Fulano", "Vermelho"); preencherVagas(estacionamento, "H11", "ABC-1234", "Ciclano", "Branco"); preencherVagas(estacionamento, "J10", "ABC-1234", "Beltrano", "Vermelho"); preencherVagas(estacionamento, "J11", "ABC-1234", "Sicrano", "Roxo"); 
    preencherVagas(estacionamento, "J10", "ABC-1234", "Fulano", "Vermelho"); preencherVagas(estacionamento, "J11", "ABC-1234", "Ciclano", "Branco"); preencherVagas(estacionamento, "A3", "ABC-1234", "Beltrano", "Vermelho"); preencherVagas(estacionamento, "A4", "ABC-1234", "Sicrano", "Laranja"); 
    preencherVagas(estacionamento, "B1", "ABC-1234", "Fulano", "Vermelho"); preencherVagas(estacionamento, "B2", "ABC-1234", "Ciclano", "Branco"); preencherVagas(estacionamento, "C3", "ABC-1234", "Beltrano", "Vermelho"); preencherVagas(estacionamento, "C4", "ABC-1234", "Sicrano", "Laranja"); 
    preencherVagas(estacionamento, "D1", "ABC-1234", "Fulano", "Preto"); preencherVagas(estacionamento, "D2", "ABC-1234", "Ciclano", "Marrom"); preencherVagas(estacionamento, "E3", "ABC-1234", "Beltrano", "Amarelo"); preencherVagas(estacionamento, "E4", "ABC-1234", "Sicrano", "Laranja"); 
    preencherVagas(estacionamento, "F1", "ABC-1234", "Fulano", "Preto"); preencherVagas(estacionamento, "F2", "ABC-1234", "Ciclano", "Marrom"); preencherVagas(estacionamento, "G7", "ABC-1234", "Beltrano", "Amarelo"); preencherVagas(estacionamento, "G8", "ABC-1234", "Sicrano", "Laranja"); 
    preencherVagas(estacionamento, "J1", "ABC-1234", "Fulano", "Preto"); preencherVagas(estacionamento, "H2", "ABC-1234", "Ciclano", "Marrom");  
    }
    
    public static void main (String [] args){
        Scanner in = new Scanner(System.in);
        Vagas [][] estacionamento = getEstacionamento();
        int loopMain = 1;
        /*int [] teste = new int [2];
        teste = estacionamento[4][5].getCodigoVaga();
        System.out.println(teste[0]);
        System.out.println(teste[1]);*/
        CarregarDadosPreenchimento(estacionamento);
        System.out.println("Olá, bem vindo ao programa de gerenciamento de vagas do estacionamento.");
        System.out.println("Você terá 7 opções de interação com este aplicativo. Por favor, digite o número da opção que deseja interagir:");
        while (loopMain == 1){
            System.out.println("");
            System.out.println("1 - Visualizar o mapa do estacionamento");
            System.out.println("2 - Ocupar uma vaga");
            System.out.println("3 - Liberar uma vaga");
            System.out.println("4 - Encontrar a primeira vaga livre.");
            System.out.println("5 - Exibir estatísticas");
            System.out.println("6 - Localizar veículo por cor");
            System.out.println("7 - Sair do programa");
            System.out.println("");
            int escolha = in.nextInt();
            switch (escolha){
                case 1: visualizarMapa(estacionamento); break;
                case 2: ManipularUmaVaga(estacionamento, 0, null); break;
                case 3: ManipularUmaVaga(estacionamento, 1, null); break;
                case 4: encontrarVagaLivre(estacionamento); break;
                case 5: calcularPercentual(estacionamento); break;
                case 6: localizarVeiculo(estacionamento); break;
                case 7: loopMain = 0; System.out.println("--- FIM DO PROGRAMA ---"); break;
            }  
        }
    }
}
