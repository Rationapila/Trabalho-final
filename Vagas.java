import java.util.Scanner;
public class Vagas
{
    Scanner in = new Scanner(System.in);
    private boolean estadoVaga = true; //True == Vaga livre, False == Vaga ocupada.
    private int[] codigoVaga = new int [2];
    private Veiculo veiculoEstaVaga = new Veiculo();
    
    public void setDadosDoVeiculo(String placaR, String nomeCondutorR, String corPredominanteR){
        this.veiculoEstaVaga.setPlaca(placaR);
        this.veiculoEstaVaga.setNomeCondutor(nomeCondutorR);
        this.veiculoEstaVaga.setCorPredominante(corPredominanteR);
    }
    
    public String getPlacaDoVeiculo(){
        return veiculoEstaVaga.getPlaca();
    }
    
    public String getNomeDoCondutor(){
        return veiculoEstaVaga.getNomeCondutor();
    }
    
    public String getCorDoVeiculo(){
        return veiculoEstaVaga.getCorPredominante();
    }
    
    public int getConversorLetraPNumero(char letra){
        int fileira = 0;
        switch (letra){
            case 'A': fileira = 0; break;
            case 'B': fileira = 1; break;
            case 'C': fileira = 2; break;
            case 'D': fileira = 3; break;
            case 'E': fileira = 4; break;
            case 'F': fileira = 5; break;
            case 'G': fileira = 6; break;
            case 'H': fileira = 7; break;
            case 'I': fileira = 8; break;
            case 'J': fileira = 9; break;
        }
        return fileira;
    }
    public int getConversorNumeroPNumero(String numeros){
        int linha = 0;
        switch (numeros){
            case "-1": linha = 0; break;
            case "-2": linha = 1; break;
            case "-3": linha = 2; break;
            case "-4": linha = 3; break;
            case "-5": linha = 4; break;
            case "-6": linha = 5; break;
            case "-7": linha = 6; break;
            case "-8": linha = 7; break;
            case "-9": linha = 8; break;
            case "-10": linha = 9; break;
            case "-11": linha = 10; break;
            case "-12": linha = 11; break;
            case "-13": linha = 12; break;
        }
        return linha;
    }
    
    public void DefinirPadrao(){
        this.codigoVaga[0] = -1;
        this.codigoVaga[1] = -1;
    }
    
    public int[] RegistrarCodigoVaga(String codigoDaVaga){
        codigoDaVaga = codigoDaVaga.toUpperCase();
        if (codigoDaVaga.length() > 3){
            System.out.println("Você digitou mais do que deveria. Reinsira o código.");
            String NovaString = in.nextLine();
            RegistrarCodigoVaga(NovaString);
        }
        if (
        codigoDaVaga.charAt(0) != 'A' &&
        codigoDaVaga.charAt(0) != 'B' &&
        codigoDaVaga.charAt(0) != 'C' &&
        codigoDaVaga.charAt(0) != 'D' &&
        codigoDaVaga.charAt(0) != 'E' &&
        codigoDaVaga.charAt(0) != 'F' &&
        codigoDaVaga.charAt(0) != 'G' &&
        codigoDaVaga.charAt(0) != 'H' &&
        codigoDaVaga.charAt(0) != 'I' &&
        codigoDaVaga.charAt(0) != 'J')
        {
            System.out.println("Você digitou uma letra inválida. As letras vão de A a J. Reinsira o código.");
            String NovaString = in.nextLine();
            RegistrarCodigoVaga(NovaString);
        }
        String checkNumeros = codigoDaVaga;
        checkNumeros = checkNumeros.replace(checkNumeros.charAt(0), '-');
        if (
        !checkNumeros.equals("-1") &&
        !checkNumeros.equals("-2") &&
        !checkNumeros.equals("-3") &&
        !checkNumeros.equals("-4") &&
        !checkNumeros.equals("-5") &&
        !checkNumeros.equals("-6") &&
        !checkNumeros.equals("-7") &&
        !checkNumeros.equals("-8") &&
        !checkNumeros.equals("-9") &&
        !checkNumeros.equals("-10") &&
        !checkNumeros.equals("-11") &&
        !checkNumeros.equals("-12") &&
        !checkNumeros.equals("-13"))
        {
            System.out.println("Você digitou o número da fileira errado. Reinsira o código.");
            String NovaString = in.nextLine();
            RegistrarCodigoVaga(NovaString);
        }
        this.codigoVaga[0] = getConversorLetraPNumero(codigoDaVaga.charAt(0));
        this.codigoVaga[1] = getConversorNumeroPNumero(checkNumeros);
        return this.codigoVaga;
    }
    
    public int[] getCodigoVaga(){
        return this.codigoVaga;
    }
    
    public void OcuparVaga (){
        this.estadoVaga = false;
    }
    
    public void LiberarVaga (){
        this.estadoVaga = true;
    }
    
    public boolean getEstadoVaga (){
        return this.estadoVaga;
    }
}
