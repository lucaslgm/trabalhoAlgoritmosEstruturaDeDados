package Utils;

import Entities.Acidente;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class CsvToObject {

    public static String[] readCsv(String url){
        Path path = Paths.get(url);
        String[] lines = new String[100000];
        int index = 0;

        try (BufferedReader reader = Files.newBufferedReader(path, Charset.defaultCharset())) {
            String line = reader.readLine();
            while ((line = reader.readLine()) != null) {
                lines[index] = line;
                index++;
            }
        } catch (IOException e) {
            System.err.format("Erro na leitura do arquivo: ", e);
        }
        return lines;
    }
    public static List<Acidente> retornaAcidentes(String[] lines){
        List<Acidente> acidentes = new ArrayList<Acidente>();
        for(String line : lines){
            Acidente acidente = new Acidente();
            String[] campos = line.split(";");

            acidente.setLogradouro(campos[0].substring(0,campos[0].indexOf(" ")));
            acidente.setEndereco(campos[0].substring(campos[0].indexOf(" ")+1));
            String dataHora = campos[2].replaceAll("\\D", "").replaceAll(" ", "").trim();
            System.out.println(dataHora);

            if(dataHora.length() == 12){
                acidente.setDataHora(LocalDateTime.of(
                    Integer.parseInt(campos[2].substring(0,4)),
                    Integer.parseInt(campos[2].substring(4,6)),
                    Integer.parseInt(campos[2].substring(6,8)),
                    Integer.parseInt(campos[2].substring(8,10)),
                    Integer.parseInt(campos[2].substring(10)))
                );
            }
            else if(dataHora.length() == 8){
                acidente.setDataHora(LocalDateTime.of(
                    Integer.parseInt(campos[2].substring(0,4)),
                    Integer.parseInt(campos[2].substring(4,6)),
                    Integer.parseInt(campos[2].substring(6,8)),
                    00,
                    00)
                );
            }
            else{
                System.out.println(dataHora);
            }
            acidente.setDiaSemana(campos[3]);
            acidente.setFeridos(Integer.parseInt(campos[4]));
            acidente.setFatais(Integer.parseInt(campos[5]));
            acidente.setAutos(Integer.parseInt(campos[6]));
            acidente.setTaxis(Integer.parseInt(campos[7]));
            acidente.setLotacao(Integer.parseInt(campos[8]));
            acidente.setOnibusUrb(Integer.parseInt(campos[9]));
            acidente.setOnibusInt(Integer.parseInt(campos[10]));
            acidente.setCaminhao(Integer.parseInt(campos[11]));
            acidente.setMoto(Integer.parseInt(campos[12]));
            acidente.setCarroca(Integer.parseInt(campos[13]));
            acidente.setBicileta(Integer.parseInt(campos[14]));
            acidente.setTempo(campos[15]);
            acidente.setTurno(campos[16]);
            acidente.setRegiao(campos[17]);
            acidentes.add(acidente);
        }
        return acidentes;
    }
}
