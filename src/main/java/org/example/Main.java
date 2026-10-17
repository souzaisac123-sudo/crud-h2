package org.example;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ProdutoDAO dao = new ProdutoDAO();
        dao.criarTabela();

        Scanner sc = new Scanner(System.in);
        int opcao = -1;

        do {
            System.out.println("\n===== CRUD DE PRODUTOS =====");
            System.out.println("1 - Cadastrar");
            System.out.println("2 - Listar");
            System.out.println("3 - Buscar por ID");
            System.out.println("4 - Atualizar");
            System.out.println("5 - Deletar");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");

            try {
                opcao = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Digite apenas números.");
                continue;
            }

            switch (opcao) {
                case 1 -> {
                    System.out.print("Nome: ");
                    String nome = sc.nextLine();
                    System.out.print("Preço: ");
                    double preco = Double.parseDouble(sc.nextLine().replace(",", "."));
                    dao.inserir(new Produto(nome, preco));
                }
                case 2 -> {
                    List<Produto> lista = dao.listar();
                    if (lista.isEmpty()) {
                        System.out.println("Nenhum produto cadastrado.");
                    } else {
                        lista.forEach(System.out::println);
                    }
                }
                case 3 -> {
                    System.out.print("ID: ");
                    int id = Integer.parseInt(sc.nextLine());
                    Produto p = dao.buscarPorId(id);
                    System.out.println(p != null ? p : "Produto não encontrado.");
                }
                case 4 -> {
                    System.out.print("ID do produto: ");
                    int id = Integer.parseInt(sc.nextLine());
                    System.out.print("Novo nome: ");
                    String nome = sc.nextLine();
                    System.out.print("Novo preço: ");
                    double preco = Double.parseDouble(sc.nextLine().replace(",", "."));
                    dao.atualizar(new Produto(id, nome, preco));
                }
                case 5 -> {
                    System.out.print("ID do produto: ");
                    int id = Integer.parseInt(sc.nextLine());
                    dao.deletar(id);
                }
                case 0 -> System.out.println("Encerrando...\n" +
                        "Obrigado por Nada!");
                default -> System.out.println("Opção inválida.");
            }
        } while (opcao != 0);

        sc.close();
    }
}