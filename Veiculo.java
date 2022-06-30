public class Veiculo
{
    private String placa;
    private String nomeCondutor;
    private String corPredominante;
    
    public void setPlaca(String placa){
        this.placa = placa;
    }
    public String getPlaca(){
        return this.placa;
    }
    
    public void setNomeCondutor(String nomeCondutor){
        this.nomeCondutor = nomeCondutor;
    }
    public String getNomeCondutor(){
        return this.nomeCondutor;
    }
    
    public void setCorPredominante(String corPredominante){
        corPredominante = corPredominante.toUpperCase();
        this.corPredominante = corPredominante;
    }
    public String getCorPredominante(){
        return this.corPredominante;
    }
    
}
