package Entities;

import java.time.LocalDateTime;

public class Acidente {
    private String logradouro;
    private String endereco;
    private String tipoAcidente;
    private LocalDateTime dataHora;
    private String diaSemana;
    private int feridos;
    private int fatais;
    private int autos;
    private int taxis;
    private int lotacao;
    private int onibusUrb;
    private int onibusInt;
    private int caminhao;
    private int moto;
    private int carroca;
    private int bicileta;
    private String tempo;
    private String turno;
    private String regiao;

    public Acidente() {
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTipoAcidente() {
        return tipoAcidente;
    }

    public void setTipoAcidente(String tipoAcidente) {
        this.tipoAcidente = tipoAcidente;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public String getDiaSemana() {
        return diaSemana;
    }

    public void setDiaSemana(String diaSemana) {
        this.diaSemana = diaSemana;
    }

    public int getFeridos() {
        return feridos;
    }

    public void setFeridos(int feridos) {
        this.feridos = feridos;
    }

    public int getFatais() {
        return fatais;
    }

    public void setFatais(int fatais) {
        this.fatais = fatais;
    }

    public int getAutos() {
        return autos;
    }

    public void setAutos(int autos) {
        this.autos = autos;
    }

    public int getTaxis() {
        return taxis;
    }

    public void setTaxis(int taxis) {
        this.taxis = taxis;
    }

    public int getLotacao() {
        return lotacao;
    }

    public void setLotacao(int lotacao) {
        this.lotacao = lotacao;
    }

    public int getOnibusUrb() {
        return onibusUrb;
    }

    public void setOnibusUrb(int onibusUrb) {
        this.onibusUrb = onibusUrb;
    }

    public int getOnibusInt() {
        return onibusInt;
    }

    public void setOnibusInt(int onibusInt) {
        this.onibusInt = onibusInt;
    }

    public int getCaminhao() {
        return caminhao;
    }

    public void setCaminhao(int caminhao) {
        this.caminhao = caminhao;
    }

    public int getMoto() {
        return moto;
    }

    public void setMoto(int moto) {
        this.moto = moto;
    }

    public int getCarroca() {
        return carroca;
    }

    public void setCarroca(int carroca) {
        this.carroca = carroca;
    }

    public int getBicileta() {
        return bicileta;
    }

    public void setBicileta(int bicileta) {
        this.bicileta = bicileta;
    }

    public String getTempo() {
        return tempo;
    }

    public void setTempo(String tempo) {
        this.tempo = tempo;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public String getRegiao() {
        return regiao;
    }

    public void setRegiao(String regiao) {
        this.regiao = regiao;
    }

    @Override
    public String toString() {
        return "Acidente{" +
                "logradouro='" + logradouro + '\'' +
                ", endereco='" + endereco + '\'' +
                ", tipoAcidente='" + tipoAcidente + '\'' +
                ", dataHora=" + dataHora +
                ", diaSemana='" + diaSemana + '\'' +
                ", feridos=" + feridos +
                ", fatais=" + fatais +
                ", autos=" + autos +
                ", taxis=" + taxis +
                ", lotacao=" + lotacao +
                ", onibusUrb=" + onibusUrb +
                ", onibusInt=" + onibusInt +
                ", caminhao=" + caminhao +
                ", moto=" + moto +
                ", carroca=" + carroca +
                ", bicileta=" + bicileta +
                ", tempo='" + tempo + '\'' +
                ", turno='" + turno + '\'' +
                ", regiao='" + regiao + '\'' +
                '}';
    }
}