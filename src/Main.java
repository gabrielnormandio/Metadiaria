import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 1. perguntar qual a meta para o mes.
        Scanner entrada = new Scanner(System.in);
        System.out.print("Qual sera a meta para este mes? ");
        double metaDoMes = entrada.nextDouble();

        // 2. perguntar quantos dias no mes vai trabalhar.
        System.out.print("Quantos dias você vai trabalhar este mês? ");
        int diasDeTrabalho = entrada.nextInt();

        // 3. calcular quanto vai ser a meta por dia.
        double metaDoDia = metaDoMes / diasDeTrabalho;
        System.out.println("--------------------------------------------");
        System.out.printf("Sua meta para cada dia é de R$%.2f", metaDoDia);

        // 4. perguntar cada dia qual foi o valor alcançado.
        double dinheiroGuardado = 0;
        double lucro = 0;
        for(int dia = 1; dia <= diasDeTrabalho; dia++) {
            System.out.printf("\n%dº Dia: Quanto você faz hoje? ", dia);
            double valorDoDia = entrada.nextDouble();

            // 5. recalcular a meta para cada dia de acordo com o valor feito cada dia.
            dinheiroGuardado += valorDoDia;
            double novaMetaDoDia = (metaDoMes - dinheiroGuardado) / (diasDeTrabalho - dia);

            if(metaDoMes - dinheiroGuardado > 0) {
                if(metaDoMes - dinheiroGuardado > 0 && dia == diasDeTrabalho) {
                    System.out.printf("\nVocê só conseguiu R$%.2f faltou R$%.2f para alcançar o Objetivo.", dinheiroGuardado, metaDoMes - dinheiroGuardado);
                    break;
                }
                System.out.printf("Voce precisa fazer R$ %.2f por dia para a meta.", novaMetaDoDia);
                System.out.print("\n-----------------------------------------");
            } else if(metaDoMes - dinheiroGuardado == 0) {
                System.out.println("Parabens! você conseguiu o valor total do mês.");
                for(int diaRestante = dia + 1; diaRestante <= diasDeTrabalho; diaRestante++) {
                    System.out.printf("\n%dº Dia: Quanto você faz hoje? ", diaRestante);
                    double extra = entrada.nextDouble();
                    lucro += extra;
                    System.out.printf("\nVocê esta com R$%.2f de Lucro.", lucro);
                }
                System.out.printf("\nMês Finalizado! Seu Lucro foi de R$%.2f.", lucro);
                break;
            } else {
                lucro = dinheiroGuardado - metaDoMes;
                System.out.printf("Você conseguiu alcançar o objetivo e esta com um lucro de R$%.2f", lucro);
                for(int diasRestante = dia + 1; diasRestante <= diasDeTrabalho; diasRestante++) {
                    System.out.printf("\n%dº Dia: Quanto você faz hoje? ", diasRestante);
                    double extra = entrada.nextDouble();
                    lucro += extra;
                    System.out.printf("\nVocê esta com %.2f de Lucro.", lucro);
                }
                System.out.printf("\nMês Finalizado! Seu Lucro foi de R$%.2f.", lucro);
                break;
            }


        }


        entrada.close();
    }
}