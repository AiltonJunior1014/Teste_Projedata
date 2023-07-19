import java.math.BigDecimal;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;


public class Funcionario extends Pessoa{
    private BigDecimal Salario;
    private String Funcao;

    public Funcionario(String nome, LocalDate data_nasc,BigDecimal salario, String funcao){
        super(nome, data_nasc);
        this.Salario = salario;
        this.Funcao = funcao;
    }

    public Funcionario(){
        super();
        this.Salario = null;
        this.Funcao = "";
    }

    public BigDecimal getSalario(){
        return this.Salario;
    }

    public String getFuncao(){
        return this.Funcao;
    }

    public void setSalario(BigDecimal salario) {
        this.Salario = salario;
    }

    public void getFuncao(String funcao){
        this.Funcao = funcao;
    }

    @Override
    public String toString(){
        NumberFormat format = NumberFormat.getInstance(new Locale("pt","BR"));
        format.setMinimumFractionDigits(2);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/YYYY");
        return "Nome: " +this.getNome()+"\n Data Nascimento: "+formatter.format(this.getData_Nascimento())+"\n Funcao: " +this.Funcao+"\n Salario: R$ " +format.format(this.getSalario())+"\n\n";
    }
}
