package org.example;

public class Main {
    public static void main(String[] args) {
        ProdutoDAO dao = new ProdutoDAO();
        dao.criarTabela();

        dao.inserir(new Produto("Telcado", 150.00));
        dao.inserir(new Produto("mouse", 80.50));
    }
}