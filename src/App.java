import Entities.Acidente;
import Lists.ArrayListOfAcidente;
import Lists.LinkedListOfAcidentes;
import Utils.CsvToObject;

import java.util.List;

public class App {
    public static void main(String[] args){

        String[] lines = CsvToObject.readCsv("E:\\PUCRS 2020.2\\46502-04 ALEST I\\RepoAlest_1\\Trabalho\\Arquivos\\acidentes.csv");
        //ArrayListOfAcidente acidentes = new ArrayListOfAcidente(100000);
        LinkedListOfAcidentes acidentes = new LinkedListOfAcidentes();

        for(String line : lines){
            if(CsvToObject.retornaAcidente(line) != null){
                acidentes.addIncreasingOrder(CsvToObject.retornaAcidente(line));
            }
        }
        int size = acidentes.size();
        System.out.println("Tamanho Lista acidentes: "+ size);
        System.out.printf("Lista acidentes1 pos %d:\n", size);
        System.out.println(acidentes.get(size-1));
    }
}
