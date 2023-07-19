import java.time.LocalDate;

public class Pessoa {
    private String Nome;
    private LocalDate Data_nascimento;
    
    public Pessoa(){
        this.Nome = "";
        this.Data_nascimento = null;
    }

    public Pessoa(String nome, LocalDate data_nasc){
        this.Nome = nome;
        this.Data_nascimento = data_nasc;
    }

    public String getNome(){
        return this.Nome;    
    }

    public LocalDate getData_Nascimento(){
        return Data_nascimento;
    }

    public void setNome(String nome){
        this.Nome = nome;
    }

    public void setData_Nascimento(LocalDate data){
        this.Data_nascimento = data;
    }


}
