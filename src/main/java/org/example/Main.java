package org.example;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        ProdutoDAO dao = new ProdutoDAO();
        dao.criarTabela();

        System.out.println("--- Todos os produtos ---");
        List<Produto> lista = dao.listar();
        for (Produto p : lista) {
            System.out.println(p);
        }

        System.out.println("--- Buscando o produto de id 1 ---");
        Produto encontrado = dao.buscarPorId(1);
        if (encontrado != null) {
            System.out.println(encontrado);
        } else {
            System.out.println("Produto não encontrado.");
        }
    }
}