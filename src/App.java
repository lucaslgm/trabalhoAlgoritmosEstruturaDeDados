import Entities.Acidente;
import Lists.ArrayListOfAcidente;
import Utils.CsvToObject;

import java.util.List;

public class App {
    public static void main(String[] args){

        String[] lines = CsvToObject.readCsv("E:\\PUCRS 2020.2\\46502-04 ALEST I\\RepoAlest_1\\Trabalho\\Arquivos\\acidentes.csv");
        ArrayListOfAcidente acidentes = new ArrayListOfAcidente(100000);
        ArrayListOfAcidente acidentes2 = new ArrayListOfAcidente(100000);

        for(String line : lines){
            if(CsvToObject.retornaAcidente(line) != null){
//                if(!acidentes.addIncreasingOrder(CsvToObject.retornaAcidente(line))){
//                    System.out.println(CsvToObject.retornaAcidente(line));
//                }
                acidentes.add(CsvToObject.retornaAcidente(line));
            }
            acidentes2.add(CsvToObject.retornaAcidente(line));
        }

        System.out.println("Tamanho Lista acidentes1: "+ acidentes.size());
        System.out.println("Tamanho Lista acidentes2: "+ acidentes2.size());

        System.out.println("Lista acidentes1 pos 91381: "+ acidentes.get(91381));
        System.out.println("Lista acidentes2 pos 99999: "+ acidentes2.get(99999));
    }
}
