package projetodb.projetoa3sql;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;
import projetodb.projetoa3sql.Cadastro.Amigos;
import projetodb.projetoa3sql.Cadastro.Ferramentas;

public class Menu {
    public static void adicionarFerramenta(Scanner scanner, Connection conexao) {
        Ferramentas ferramenta = obterDadosFerramenta(scanner);
        try {
            Conexao.inserirFerramenta(conexao, ferramenta);
        } catch (SQLException ex) {
            System.out.println("Erro ao inserir a ferramenta: " + ex.getMessage());
        }
    }
    
    public static Ferramentas obterDadosFerramenta(Scanner scanner) {
        System.out.println("Digite o nome da ferramenta:");
        String nome = scanner.next();
        System.out.println("Digite a marca da ferramenta:");
        String marca = scanner.next();
        System.out.println("Digite o custo de aquisição da ferramenta:");
        double custo = scanner.nextDouble();
        
        return new Ferramentas(nome, marca, custo);
    }
    
    public static void adicionarAmigo(Scanner scanner, Connection conexao) {
        System.out.println("Digite o nome do amigo:");
        String nome = scanner.next();
        System.out.println("Digite o telefone do amigo:");
        String telefone = scanner.next();

        Amigos amigo = new Amigos(nome, telefone);
        try {
            Conexao.inserirAmigo(conexao, amigo);
        } catch (SQLException ex) {
            System.out.println("Erro ao inserir o amigo: " + ex.getMessage());
        }
    }
}
