package br.com.fiap.lista_files.menu;

import br.com.fiap.lista_files.telas.GameUI;

import java.util.Scanner;

public class Menu {

    public static void construirMenu(){

        limparTela();
        Scanner leitor = new Scanner(System.in);
        GameUI gameUI = new GameUI();

        System.out.println("CATÁLOGO DE GAMES");
        System.out.println("----------------------------------");
        System.out.println("1 - CADASTRAR GAME");
        System.out.println("2 - LISTAR GAMES");
        System.out.println("3 - BUSCAR GAME");
        System.out.println("4 - EXCLUIR GAME");
        System.out.println("5 - SAIR");
        System.out.println("---------------------------------");
        System.out.print("ESCOLHA UMA OPÇÃO (1-5): ");

        int escolha = leitor.nextInt();

        switch (escolha){
            case 1: gameUI.cadastrarGame();
            case 2: gameUI.exibirGames();
            case 3: gameUI.buscarGamePeloId();
            case 5: sair();
            default:
        }

    }

    private static void sair() {

        System.out.println("Bye...");
        System.exit(0);

    }

    public static void limparTela(){
        for(int i = 0; i < 100; i++){
            System.out.println();
        }
    }

}
