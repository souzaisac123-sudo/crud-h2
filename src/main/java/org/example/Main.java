package org.example;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        ProdutoDAO dao = new ProdutoDAO();
        dao.criarTabela();

        System.out.println("--- Antes ---");
        for (Produto p : dao.listar()) {
            System.out.println(p);
        }

        dao.deletar(1);

        System.out.println("--- Depois ---");
        for (Produto p : dao.listar()) {
            System.out.println(p);
        }
    }
}