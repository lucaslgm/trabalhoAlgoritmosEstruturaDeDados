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
    public static Acidente retornaAcidente(String line){
        if(line != null) {
            Acidente acidente = new Acidente();
            String[] campos = line.split(";");
            if (campos[0].length() > 1) {
                acidente.setLogradouro(campos[0].substring(0, campos[0].indexOf(" ")));
                acidente.setEndereco(campos[0].substring(campos[0].indexOf(" ") + 1));
                acidente.setDataHora(retornaDataHora(campos[2].trim().replaceAll(" ", "").replaceAll("\\D", "")));
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
            }
            return acidente;
        }
        return null;
    }

    private static LocalDateTime retornaDataHora(String date){
        String dataHora = date;

        if(dataHora.length() != 12) {
            dataHora = dataHora + "0".repeat(Math.max(0, 12 - dataHora.length()));
        }

        int ano = Integer.parseInt(dataHora.substring(0,4),10);
        int mes = Integer.parseInt(dataHora.substring(4,6),10);
        int dia = Integer.parseInt(dataHora.substring(6,8),10);
        int hor = Integer.parseInt(dataHora.substring(8,10),10);
        int min = Integer.parseInt(dataHora.substring(10),10);
        if(mes < 1 || mes > 12){
            System.out.println(dataHora);
            return null;
        }
        else if(hor < 0 || hor > 23){
            System.out.println(dataHora);
            return null;
        }
        else if(min < 0 || min > 60){
            System.out.println(dataHora);
            return null;
        }

        return LocalDateTime.of(ano,mes,dia,hor,min);
    }
}
