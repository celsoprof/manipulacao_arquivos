package br.com.fiap.lista_files.telas;

import br.com.fiap.lista_files.App;
import br.com.fiap.lista_files.dao.GameDao;
import br.com.fiap.lista_files.menu.Menu;
import br.com.fiap.lista_files.model.Game;

import java.time.Year;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GameUI {

    Scanner leitor = new Scanner(System.in);
    String resposta = "s";
    GameDao gameDao = new GameDao();

    public void cadastrarGame() {

        Menu.limparTela();

        while (resposta.equalsIgnoreCase("s")) {

            System.out.print("Qual o ID? ");
            String id = leitor.nextLine();
            System.out.print("Qual o TITULO? ");
            String titulo = leitor.nextLine();
            System.out.print("Qual o ESTUDIO? ");
            String estudio = leitor.nextLine();
            System.out.print("Qual o VALOR? ");
            String valor = leitor.nextLine();
            System.out.print("Qual o ANO LANÇAMENTO? ");
            String anoLancamento = leitor.nextLine();

            Game game = new Game(
                    Integer.parseInt(id),
                    titulo,
                    estudio,
                    Double.parseDouble(valor),
                    Year.of(Integer.parseInt(anoLancamento))
            );

            if (gameDao.gravar(game)){
                System.out.print("Deseja cadastrar outro game (S/N)? ");
                resposta = leitor.nextLine();
            }
        }

        Menu.construirMenu();

    }

    public void exibirGames() {

        Menu.limparTela();

        List<Game> games = new ArrayList<>();

        games = gameDao.listar();

        System.out.println("------------------------------------------------------------------------------------");
        System.out.println("|LISTA DE GAMES");
        System.out.println("------------------------------------------------------------------------------------");
        System.out.printf("|%5s | %-20s | %-20s | %12s | %12s |%n", "ID", "TITULO", "ESTÚDIO", "VALOR", "LANÇAMENTO");
        System.out.println("------------------------------------------------------------------------------------");
        for (Game g : games){
            System.out.printf("|%5s | %-20s | %-20s | %12s | %12s |%n",
                    g.getId(),
                    g.getTitulo(),
                    g.getEstudio(),
                    g.getValor(),
                    g.getAnoLancamento()
            );
        }
        System.out.println("------------------------------------------------------------------------------------");

        System.out.println();
        System.out.print("Pressione ENTER para retornar ao menu...");
        leitor.nextLine();
        Menu.construirMenu();

    }

    public void buscarGamePeloId() {

        Menu.limparTela();

        Game game = new Game();

        System.out.print("Qual o ID do jogo procurado? ");
        int id = leitor.nextInt();
        leitor.nextLine();

        game = gameDao.buscarGamepeloId(id);

        if (game.getId() != 0){
            System.out.println();
            System.out.println("RESULTADO DA BUSCA");
            System.out.println("------------------------------------------------------------------------");
            System.out.printf("%5s %-20s %-10s %15s %15s%n", "ID", "TITULO", "ESTÚDIO", "VALOR", "LANÇAMENTO");
            System.out.println("------------------------------------------------------------------------");
            System.out.printf("%5s %-20s %-10s %15s %15s%n",
                    game.getId(),
                    game.getTitulo(),
                    game.getEstudio(),
                    game.getValor(),
                    game.getAnoLancamento()
            );

            System.out.println("------------------------------------------------------------------------");

        } else {
            System.out.println("-------------------------------------------");
            System.out.println("         JOGO NÃO ENCONTRADO!!!");
            System.out.println("-------------------------------------------");
        }

        System.out.println();
        System.out.print("Pressione ENTER para retornar ao menu...");
        leitor.nextLine();
        Menu.construirMenu();

    }

}
