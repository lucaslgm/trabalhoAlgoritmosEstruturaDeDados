import Entities.Acidente;
import Entities.Street;
import Lists.ArrayListOfAcidente;
import Lists.DoubleLinkedListOfStreets;
import Lists.LinkedListOfAcidentes;
import Utils.CsvToObject;

import java.util.List;

public class App {
    public static void main(String[] args){

        String[] lines = CsvToObject.readCsv("E:\\PUCRS 2020.2\\46502-04 ALEST I\\RepoAlest_1\\Trabalho\\Arquivos\\acidentes.csv");
//        ArrayListOfAcidente acidentes = new ArrayListOfAcidente(100000);
//        LinkedListOfAcidentes acidentes = new LinkedListOfAcidentes();
//
//        for(String line : lines){
//            if(CsvToObject.retornaAcidente(line) != null){
//                acidentes.addIncreasingOrder(CsvToObject.retornaAcidente(line));
//            }
//        }
//        int size = acidentes.size();
//        System.out.println("Tamanho Lista acidentes: "+ size);
//        System.out.printf("Lista acidentes1 pos %d:\n", size);
//        System.out.println(acidentes.get(size-1));

//        DoubleLinkedListOfStreets streets = new DoubleLinkedListOfStreets();
//                for(String line : lines) {
//            if (CsvToObject.retornaAcidente(line) != null) {
//                Acidente acidente = CsvToObject.retornaAcidente(line);
//                if (streets.isEmpty()) {
//                    streets.add(retNovaRua(acidente));
//                } else {
//                    int index = 0;
//                    while (index < streets.size()) {
//                        String nome = acidente.getLogradouro().concat(" ").concat(acidente.getEndereco());
//                        if (streets.get(index).getNome().equals(nome)) {
//                            streets.get(index).getAcidentes().addIncreasingOrder(acidente);
//                            index = 0;
//                            break;
//                        }
//                        index++;
//                    }
//                    if (index == streets.size()) {
//                        streets.add(retNovaRua(acidente));
//                    }
//                }
//            }
//        }


//        DoubleLinkedListOfStreets streets = new DoubleLinkedListOfStreets();
//        for(int i = 0; i <= 500; i++){
//            if(CsvToObject.retornaAcidente(lines[i]) != null) {
//                Acidente acidente = CsvToObject.retornaAcidente(lines[i]);
//                if (streets.isEmpty()) {
//                    streets.add(retNovaRua(acidente));
//                }
//                else {
//                    int index = 0;
//                    while (index < streets.size()){
//                        String nome = acidente.getLogradouro().concat(" ").concat(acidente.getEndereco());
//                        if (streets.get(index).getNome().equals(nome)) {
//                            streets.get(index).getAcidentes().addIncreasingOrder(acidente);
//                            index = 0;
//                            break;
//                        }
//                        index++;
//                    }
//                    if(index == streets.size()){
//                        streets.add(retNovaRua(acidente));
//                    }
//                }
//            }
//        }
//
//        int totalAcidentes = 0;
//        int maior = 0;
//        String rua = null;
//        for(int i = 0; i < streets.size(); i++){
//            System.out.println("LOCAL: " + streets.get(i).getNome());
//            System.out.println("Nº ACIDENTES: " + streets.get(i).getAcidentes().size());
//            totalAcidentes+=streets.get(i).getAcidentes().size();
//            if(streets.get(i).getAcidentes().size() > maior){
//                maior = streets.get(i).getAcidentes().size();
//                rua = streets.get(i).getNome();
//            }
//        }
//        int motos = 0;
//        String diaSemana = null;
//        if(streets.get("AV IPIRANGA") != null) {
//            Street sAux = streets.get("AV IPIRANGA");
//            motos = sAux.getAcidentes().getTotalAcidentesMotos();
//            diaSemana = sAux.getAcidentes().getDiaSemanaMaisAcidentes();
//        }
//
//        System.out.println("TOTAL DE ACIDENTES: "+ totalAcidentes);
//        System.out.printf("RUA COM MAIS ACIDENTES: %s\nTOTAL: %d\n", rua, maior);
//        System.out.println("TOTAL DE ACIDENTES COM MOTOS AV IPIRANGA: "+ motos);
//        System.out.println("DIA DA SEMANA COM MAIS ACIDENTES AV IPIRANGA: "+ diaSemana);

        testeContagemMotos_DiaSemana();

    }

    private static Street retNovaRua(Acidente acidente){
        Street street = new Street();
        street.setNome(acidente.getLogradouro().concat(" ").concat(acidente.getEndereco()));
        street.getAcidentes().addIncreasingOrder(acidente);
        return street;
    }

    private static void testeContagemMotos_DiaSemana(){
        Acidente ac1 = new Acidente();
        ac1.setDiaSemana("DOMINGO");
        ac1.setMoto(1);
        Acidente ac2 = new Acidente();
        ac2.setDiaSemana("DOMINGO");
        ac2.setMoto(2);
        Acidente ac3 = new Acidente();
        ac3.setDiaSemana("SABADO");
        ac3.setMoto(3);
        Acidente ac4 = new Acidente();
        ac4.setDiaSemana("DOMINGO");
        ac4.setMoto(2);
        Acidente ac5 = new Acidente();
        ac5.setDiaSemana("SABADO");
        ac5.setMoto(2);
        Street ruaTeste = new Street();
        ruaTeste.setNome("RUA TESTE");
        LinkedListOfAcidentes listaTeste = new LinkedListOfAcidentes();
        listaTeste.add(ac1);
        listaTeste.add(ac2);
        listaTeste.add(ac3);
        listaTeste.add(ac4);
        listaTeste.add(ac5);
        ruaTeste.setAcidentes(listaTeste);
        int moto = ruaTeste.getAcidentes().getTotalAcidentesMotos();
        String dia = ruaTeste.getAcidentes().getDiaSemanaMaisAcidentes();

        System.out.println("ACIDENTES DE MOTO: "+ moto);
        System.out.println("SEMANA COM MAIS ACIDENTES: "+ dia);
    }
}
