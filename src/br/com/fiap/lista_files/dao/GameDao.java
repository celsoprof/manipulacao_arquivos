package br.com.fiap.lista_files.dao;

import br.com.fiap.lista_files.model.Game;

import java.io.IOException;
import java.nio.file.*;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;

public class GameDao {

    private final Path arquivo = Paths.get("/Users/celsofurtado/IdeaProjects/manipulacao_arquivos/src/br/com/fiap/lista_files/dados.csv");
    private List<Game> games = new ArrayList<>();

    public boolean gravar(Game g) {

        String gameCsv = Game.serializarGame(g);
        System.out.println(gameCsv);

        try {
            Files.writeString(arquivo, gameCsv, StandardOpenOption.APPEND);
            System.out.println("Game gravado com sucesso!");
            return true;
        } catch (IOException e) {
            System.out.println("Ocorreu um erro na gravação do novo game.");
            ;
            return false;
        }

    }

    public List<Game> listar() {

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

            return games;

        } catch (IOException e) {
            System.out.println("Ocorreu um erro na leitura do arquivo!");
            throw new RuntimeException(e);
        }

    }

    public Game buscarGamepeloId(int id) {

        Game gameEncontrado = new Game();

        try {
            List<String> linhas = Files.readAllLines(arquivo);

            linhas.forEach(linha -> {
                String[] gameStr = linha.split(";");
                if (Integer.parseInt(gameStr[0]) == id) {
                    gameEncontrado.setId(Integer.parseInt(gameStr[0]));
                    gameEncontrado.setTitulo(gameStr[1]);
                    gameEncontrado.setEstudio(gameStr[2]);
                    gameEncontrado.setValor(Double.parseDouble(gameStr[3]));
                    gameEncontrado.setAnoLancamento(Year.of(Integer.parseInt(gameStr[4])));
                }
            });

            return gameEncontrado;

        } catch (IOException e) {
            System.out.println("Ocorreu um erro na leitura do arquivo!");
            throw new RuntimeException(e);
        }

    }

}
