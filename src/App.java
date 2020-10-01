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


        DoubleLinkedListOfStreets streets = new DoubleLinkedListOfStreets();

        for(int i = 0; i <= 50000; i++){
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

        int totalAcidentes = 0;
        int maior = 0;
        String rua = "";
        for(int i = 0; i < streets.size(); i++){
            System.out.println("LOCAL: " + streets.get(i).getNome());
            System.out.println("Nº ACIDENTES: " + streets.get(i).getAcidentes().size());
            totalAcidentes+=streets.get(i).getAcidentes().size();
            if(streets.get(i).getAcidentes().size() > maior){
                maior = streets.get(i).getAcidentes().size();
                rua = streets.get(i).getNome();
            }
        }
        if(streets.get("AV IPIRANGA") != null){
            Street sAux = streets.get("AV IPIRANGA");
            int dom = 0;
            int seg = 0;
            int ter = 0;
            int qua = 0;
            int qui = 0;
            int sex = 0;
            int sab = 0;
            for(int i = 0; i < sAux.getAcidentes().size(); i++){
                if(sAux.getAcidentes().get(i).getDiaSemana().equals("DOMINGO")){
                    dom++;
                }
                else if(sAux.getAcidentes().get(i).getDiaSemana().equals("SEGUNDA-FEIRA")){
                    seg++;
                }
                else if(sAux.getAcidentes().get(i).getDiaSemana().equals("TERCA-FEIRA")){
                    ter++;
                }
                else if(sAux.getAcidentes().get(i).getDiaSemana().equals("QUARTA-FEIRA")){
                    qua++;
                }
                else if(sAux.getAcidentes().get(i).getDiaSemana().equals("QUINTA-FEIRA")){
                    qui++;
                }
                else if(sAux.getAcidentes().get(i).getDiaSemana().equals("SEXTA-FEIRA")){
                    sex++;
                }
                else if(sAux.getAcidentes().get(i).getDiaSemana().equals("SABADO")){
                    sab++;
                }
            }
            int dAux = 0;
        }
        System.out.println("TOTAL DE ACIDENTES: "+ totalAcidentes);
        System.out.printf("RUA COM MAIS ACIDENTES: %s\nTOTAL: %d\n", rua, maior);
    }

    private static Street retNovaRua(Acidente acidente){
        Street street = new Street();
        street.setNome(acidente.getLogradouro().concat(" ").concat(acidente.getEndereco()));
        street.getAcidentes().addIncreasingOrder(acidente);
        return street;
    }
}
