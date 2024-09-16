package br.com.fiap.lista_files.dao;

import br.com.fiap.lista_files.model.Game;

import java.io.IOException;
import java.nio.file.*;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;

public class GameDao {

    private final Path arquivo = Paths.get("/Users/sn1006137/IdeaProjects/lista_files/src/br/com/fiap/lista_files/dados.csv");
    private List<Game> games = new ArrayList<>();
    
    public void gravar(Game g){

        String gameCsv = Game.serializarGame(g);
        System.out.println(gameCsv);

        try {
            Files.writeString(arquivo, gameCsv, StandardOpenOption.APPEND);
            System.out.println("Game gravado com sucesso!");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public void listar(){

        try {
            List<String> linhas = Files.readAllLines(arquivo);

            linhas.forEach(linha -> {
                String[] gameStr = linha.split(";");
                Game gameObj = new Game(
                        Integer.parseInt(gameStr[0]),
                        gameStr[1],
                        gameStr[2],
                        Double.parseDouble(gameStr[3]),
                        Year.of(Integer.parseInt(gameStr[4]))
                );
                games.add(gameObj);
            });

            exibirGames();

        } catch (IOException e) {
            System.out.println("Ocorreu um erro na leitura do arquivo!");
            throw new RuntimeException(e);
        }

    }

    private void exibirGames() {

        System.out.println("LISTA DE GAMES");
        System.out.println("------------------------------------------------------------------------");
        System.out.println(String.format("%5s %-20s %-10s %15s %15s", "ID", "TITULO", "ESTÚDIO", "VALOR", "LANÇAMENTO"));
        System.out.println("------------------------------------------------------------------------");
        for (Game g : games){
            System.out.println(
                    String.format("%5s %-20s %-10s %15s %15s",
                            g.getId(),
                            g.getTitulo(),
                            g.getEstudio(),
                            g.getValor(),
                            g.getAnoLancamento()
                    )
            );
        }
        System.out.println("------------------------------------------------------------------------");
    }

}
