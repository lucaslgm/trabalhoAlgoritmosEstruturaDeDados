import Entities.Acidente;
import Utils.CsvToObject;

import java.util.List;

public class App {
    public static void main(String[] args){

        String[] lines = CsvToObject.readCsv("E:\\PUCRS 2020.2\\46502-04 ALEST I\\Trabalho 1\\acidentes.csv");
        List<Acidente> acidentes = CsvToObject.retornaAcidentes(lines);
        //System.out.println(acidentes);
    }
}
