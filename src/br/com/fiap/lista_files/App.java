package br.com.fiap.lista_files;

import br.com.fiap.lista_files.dao.GameDao;
import br.com.fiap.lista_files.menu.Menu;
import br.com.fiap.lista_files.model.Game;

import java.time.Year;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Menu.construirMenu();

//        Scanner leitor = new Scanner(System.in);
//
//        System.out.print("Qual o ID? ");
//        String id = leitor.nextLine();
//        System.out.print("Qual o TITULO? ");
//        String titulo = leitor.nextLine();
//        System.out.print("Qual o ESTUDIO? ");
//        String estudio = leitor.nextLine();
//        System.out.print("Qual o VALOR? ");
//        String valor = leitor.nextLine();
//        System.out.print("Qual o ANO LANÇAMENTO? ");
//        String anoLancamento = leitor.nextLine();
//
//        GameDao gd = new GameDao();
//
//        Game game = new Game(
//                Integer.parseInt(id),
//                titulo,
//                estudio,
//                Double.parseDouble(valor),
//                Year.of(Integer.parseInt(anoLancamento))
//        );
//
//        gd.gravar(game);
//        gd.listar();

    }

}
