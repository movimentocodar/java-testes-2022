package org.run;

import menuclasses.*;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        chamarMenuPrincipal();
    }

    public static void chamarMenuPrincipal() throws IOException {

        Scanner selecionadorDeOpcao = new Scanner(System.in);

        System.out.println(
                "\nBem vindo Admin, o que você deseja?\n" +
                "        1 - Candidatar-se\n" +
                "        2 - Adicionar pergunta ao formulário\n" +
                "        3 - Remover pergunta do formulário\n" +
                "        4 - Listar formulários cadastrados\n" +
                "        5 - Pesquisar formulários cadastrados\n" +
                "        6 - Validar formulários\n" +
                "        7 - Sair" + "\n" +
                "Escolha um número: ");

        int selecionador = selecionadorDeOpcao.nextInt();

        try {
            switch (selecionador){

                case 1: new AdicionaCandidato().candidatar();
                    break;
                case 2: new AdicionaPergunta().adicionar();
                    break;
                case 3: new RemovePergunta().remover();
                    break;
                case 4: new ListaDeCandidatos().listarCandidatos();
                    break;
                case 5: new PesquisaCandidato().pesquisar();
                    break;
                case 6: new ValidaCandidato().validar();
                    break;
                case 7:
                    System.out.println("Saindo do programa...");
                    System.exit(0);
                    break;
                default : System.out.println("Escolha um número válido");
                chamarMenuPrincipal();
                    break;
            }
        }catch (IOException e){
            e.printStackTrace();
            System.out.println("Erro ao chamar o menu principal");
        }
    }
}
