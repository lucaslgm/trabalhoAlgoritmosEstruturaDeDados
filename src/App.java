import Entities.Acidente;
import Entities.Street;
import Lists.ArrayListOfAcidente;
import Lists.DoubleLinkedListOfStreets;
import Lists.LinkedListOfAcidentes;
import Utils.CsvToObject;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args){

        String[] lines = CsvToObject.readCsv("/Users/vitordelela/Documents/PUCRS/2 SEM/Alest I/acidentes.csv");
//        ArrayListOfAcidente acidentes = new ArrayListOfAcidente(100000);
        LinkedListOfAcidentes acidentes = new LinkedListOfAcidentes();

        Scanner input = new Scanner(System.in);
        Scanner inputStr = new Scanner(System.in);

        DoubleLinkedListOfStreets streets = new DoubleLinkedListOfStreets();
        for(int i = 0; i <= 500; i++){
            if(CsvToObject.retornaAcidente(lines[i]) != null) {
                Acidente acidente = CsvToObject.retornaAcidente(lines[i]);
                if (streets.isEmpty()) {
                    streets.add(retNovaRua(acidente));
                }
                else {
                    int index = 0;
                    while (index < streets.size()){
                        String nome = acidente.getLogradouro().concat(" ").concat(acidente.getEndereco());
                        if (streets.get(index).getNome().equals(nome)) {
                            streets.get(index).getAcidentes().addIncreasingOrder(acidente);
                            index = 0;
                            break;
                        }
                        index++;
                    }
                    if(index == streets.size()){
                        streets.add(retNovaRua(acidente));
                    }
                }
            }
        }

        for (int j=0; j<183; j++)
        for (int i=0; i<streets.size()-1; i++){
            Street aux = new Street();
            Street aux2 = new Street();
            String nomeAtual = streets.get(i).getNome();
            aux = streets.get(i);
            if (nomeAtual.compareToIgnoreCase(streets.get(i+1).getNome()) > 0){
                aux = streets.get(i);
                aux2 = streets.get(i+1);
                streets.removeByIndex(i);
                streets.add(i, aux2);
                streets.removeByIndex(i+1);
                streets.add(i+1, aux);
            }
        }

        int opcao;
        do {
            System.out.println("\n\n1 - Rua com mais acidentes\n" +
                    "2 - Identificar dia da semana com mais acidentes para um rua\n" +
                    "3 - Total de acidentes envolvendo moto\n" +
                    "4 - Navegar pelos acidentes\n" +
                    "5 - Sair");

            System.out.print("\nEscolha a opcao desejada: ");
            opcao = input.nextInt();

            switch (opcao){
                case 1:
                    int maior = 0;
                    String rua = null;
                    for(int i = 0; i < streets.size(); i++){
                        if(streets.get(i).getAcidentes().size() > maior){
                            maior = streets.get(i).getAcidentes().size();
                            rua = streets.get(i).getNome();
                        }
                    }
                    System.out.printf("RUA COM MAIS ACIDENTES: %s\nTOTAL: %d\n", rua, maior);
                    holdResult();
                    break;
                case 2:
                    System.out.print("\nNome da Rua: ");
                    String nomeRua = inputStr.nextLine();
                    String diaSemana = null;
                    if(streets.get(nomeRua.toUpperCase()) != null) {
                        Street sAux = streets.get(nomeRua.toUpperCase());
                        diaSemana = sAux.getAcidentes().getDiaSemanaMaisAcidentes();
                        System.out.println("DIA DA SEMANA COM MAIS ACIDENTES: "+ diaSemana);
                    }
                    holdResult();
                    break;
                case 3:
                    int motos = 0;
                    for(int i = 0; i < streets.size(); i++){
                        if(streets.get(i).getAcidentes().getTotalAcidentesMotos() > 0){
                            motos += streets.get(i).getAcidentes().getTotalAcidentesMotos();
                        }
                    }
                    System.out.println("Total de Acidentes com Moto: "+ motos);
                    holdResult();
                    break;
                case 4:
                    int option = 0;
                    streets.resetNext();
                    Street aux = streets.next();
                    do {
                        if (option==1)
                            aux = streets.next2();
                        else if (option==2)
                            aux = streets.prev2();

                        if (aux == null) System.out.println("Fim da lista.");
                        else System.out.println(aux.toString());
                        System.out.print("\n1 - Next / ");
                        System.out.print("2 - Prev / ");
                        System.out.println("3 - Voltar");
                        System.out.print("Opcao desejada: ");
                        option = input.nextInt();
                    }while (option != 3);
                    break;
                default:
                    break;
            }
        }while (opcao!=5);

    }

    private static Street retNovaRua(Acidente acidente){
        Street street = new Street();
        street.setNome(acidente.getLogradouro().concat(" ").concat(acidente.getEndereco()));
        street.getAcidentes().addIncreasingOrder(acidente);
        return street;
    }

    private static void holdResult(){
        Scanner in = new Scanner(System.in);
        System.out.println("Pressione enter para continuar...");
        String aux = in.nextLine();
    }
}
