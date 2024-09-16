package br.com.fiap.lista_files.model;

import java.time.Year;

public class Game {

    private int id;
    private String titulo;
    private String estudio;
    private double valor;
    private Year anoLancamento;

    public Game(){}

    public Game(int id, String titulo, String estudio, double valor, Year anoLancamento) {
        this.id = id;
        this.titulo = titulo;
        this.estudio = estudio;
        this.valor = valor;
        this.anoLancamento = anoLancamento;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getEstudio() {
        return estudio;
    }

    public void setEstudio(String estudio) {
        this.estudio = estudio;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Year getAnoLancamento() {
        return anoLancamento;
    }

    public void setAnoLancamento(Year anoLancamento) {
        this.anoLancamento = anoLancamento;
    }

    @Override
    public String toString() {
        return  "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", estudio='" + estudio + '\'' +
                ", valor=" + valor +
                ", anoLancamento=" + anoLancamento +
                "\n";
    }

    public static String serializarGame(Game game){
        return game.id + ";" + game.titulo + ";" + game.estudio + ";" + game.valor + ";" + game.anoLancamento.toString() + "\n";
    }
}
