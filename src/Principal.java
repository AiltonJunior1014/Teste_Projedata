import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

public class Principal {

    public static void popular_Lista(List<Funcionario> funcionarios){
        funcionarios.add(new Funcionario("Maria",LocalDate.of(2000, 10, 18),BigDecimal.valueOf(2009.44),"Operador"));
        funcionarios.add(new Funcionario("João",LocalDate.of(1990, 05, 12),BigDecimal.valueOf(2284.38),"Operador"));

        funcionarios.add(new Funcionario("Caio",LocalDate.of(1961, 05, 02),BigDecimal.valueOf(9836.14),"Coordenador"));
        funcionarios.add(new Funcionario("Miguel",LocalDate.of(1988, 10, 14),BigDecimal.valueOf(19119.88),"Diretor"));

        funcionarios.add(new Funcionario("Alice",LocalDate.of(1995, 01, 05),BigDecimal.valueOf(2234.68),"Recepcionista"));
        funcionarios.add(new Funcionario("Heitor",LocalDate.of(1999, 11, 19),BigDecimal.valueOf(1582.72),"Operador"));

        funcionarios.add(new Funcionario("Arthur",LocalDate.of(1993, 03, 31),BigDecimal.valueOf(4071.84),"Contador"));
        funcionarios.add(new Funcionario("Laura",LocalDate.of(1994, 07, 8),BigDecimal.valueOf(3017.45),"Gerente"));

        funcionarios.add(new Funcionario("Heloisa",LocalDate.of(2003, 05, 24),BigDecimal.valueOf(1606.85),"Eletricista"));
        funcionarios.add(new Funcionario("Helena",LocalDate.of(1996, 9, 02),BigDecimal.valueOf(2799.93),"Gerente"));
    }

    public static void Remover_Joao(List<Funcionario> funcionarios){
        Funcionario exc_Funcionario=null;
        for(Funcionario func : funcionarios){
            if(func.getNome() == "João"){
                exc_Funcionario = func;
                break;
            }
        }
        if(exc_Funcionario != null){
        funcionarios.remove(exc_Funcionario);
        }
    }

    public static void Aumento_Salarial(List<Funcionario> funcionarios){
        for(Funcionario func : funcionarios){
            func.setSalario((func.getSalario().multiply(new BigDecimal("1.10"))).setScale(2, RoundingMode.HALF_UP));
        }
    }

    public static void Imprimir_listaCompleta(List<Funcionario> funcionarios){
        System.out.println("Lista Completa de Funcionarios: ");
        System.out.println(funcionarios);
    }

    public static Map<String, List<Funcionario>> Agrupar_Lista(List<Funcionario> funcionarios){
        Map<String, List<Funcionario>> mapa = funcionarios.stream()
                    .collect(Collectors.groupingBy(Funcionario::getFuncao));
        return mapa;
    }

    public static void Imprimir_agrupado(Map<String, List<Funcionario>> mapa){
        mapa.forEach((funcao, funcionario)->{
            System.out.println("Funcao: "+funcao);
            for(Funcionario f : funcionario){
                System.out.println("- "+f);
            }
            System.out.println("---------------------------------------");
        });
    }

    public static void Aniversariantes(List<Funcionario> funcionarios){
        List<Funcionario> aniversario10 = new ArrayList<Funcionario>(), aniversario12 = new ArrayList<Funcionario>();

        for(Funcionario f : funcionarios){
            if(f.getData_Nascimento().getMonth().getValue() == 10)
                aniversario10.add(f);                    
            if(f.getData_Nascimento().getMonth().getValue() == 12)
                aniversario12.add(f);
        }

        System.out.println("Aniversariantes mes 10:\n");
        for(Funcionario f : aniversario10){
            System.out.println("Nome: "+f.getNome()+"\n");
        }
        System.out.println("\n\n Aniversariantes mes 12:\n");
        for(Funcionario f : aniversario12){
            System.out.println("Nome: "+f.getNome()+"\n");
        }
    }

    public static void Maioridade(List<Funcionario> funcionarios){
        LocalDate date = LocalDate.MAX;
        Funcionario func_maioridade = null;

        for(Funcionario f : funcionarios){
            if(f.getData_Nascimento().isBefore(date)){
                func_maioridade = f;
                date = f.getData_Nascimento();
            }
        }
        if(func_maioridade!=null){
            System.out.println("Funcionario com a maior idade:");
            System.out.println("Nome: "+func_maioridade.getNome()+" Idade: "+(LocalDate.now().getYear()-date.getYear()));
        }
    }

    public static void Ordem_alfabetica(List<Funcionario> funcionarios){
        Collections.sort(funcionarios, Comparator.comparing(Funcionario::getNome));
        System.out.println(funcionarios);
    }

    public static void Soma_salarios(List<Funcionario> funcionarios){
        BigDecimal somasalario = new BigDecimal("0.00");
        NumberFormat format = NumberFormat.getInstance(new Locale("pt","BR"));
        for(Funcionario f : funcionarios){
            somasalario = somasalario.add(f.getSalario());
        }
        somasalario = somasalario.setScale(2, RoundingMode.HALF_EVEN);

        System.out.println("Soma dos salarios dos funcionarios: \nR$ "+format.format(somasalario));
    }

    public static void Quantidade_salariominimos(List<Funcionario> funcionarios){
        BigDecimal salariominimo = new BigDecimal("1212.00");
        for(Funcionario f : funcionarios){
            System.out.println("O funcionario "+f.getNome()+" recebe "+f.getSalario().divide(salariominimo,2,RoundingMode.HALF_EVEN)+" salarios minimos");
        }
    }

    public static void main(String[] args) throws Exception {
            Map<String, List<Funcionario>> mapa;
            List<Funcionario> funcionarios = new ArrayList<Funcionario>();
            popular_Lista(funcionarios);
            Remover_Joao(funcionarios);
            Aumento_Salarial(funcionarios);
            Imprimir_listaCompleta(funcionarios);
            mapa = Agrupar_Lista(funcionarios);
            Imprimir_agrupado(mapa);
            Aniversariantes(funcionarios);
            Maioridade(funcionarios);
            Ordem_alfabetica(funcionarios);
            Soma_salarios(funcionarios);
            Quantidade_salariominimos(funcionarios);
        }
    }
