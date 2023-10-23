package q2_JoaoGabrielNunes;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Usuario {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        File newArchive = new File("credenciais.txt");

        // boolean para ver se está logado começa em false pq não está logado;
        boolean estaLogado = false;
        // apenas para rodar direto; cadastro e login;
        while (!estaLogado) {
            System.out.println("Choose 1 to register and 2 to login (0 to exit)");
            int option = s.nextInt();
            s.nextLine();

            if (option == 1) {
                // Registro de usuário
                System.out.println("--- FOR YOUR REGISTER ---");
                System.out.println("Write your name: ");
                String newName = s.next();
                System.out.println("Write your password: ");
                String newPassword = s.next();

                // Cria o arquivo de credenciais se não existir
                if (!newArchive.exists()) {
                    try {
                        newArchive.createNewFile();
                    } catch (IOException e) {
                        System.out.println("Erro ao criar o arquivo.");
                    }
                }

                // Escreve o nome e senha no arquivo de credenciais
                try {
                    FileWriter writer = new FileWriter(newArchive, true);
                    writer.write(newName + ":" + newPassword + "\n");
                    writer.close();
                    System.out.println("SUCESSO, você foi cadastrado!");
                } catch (IOException e) {
                    System.out.println("FRACASSO, não deu certo, tente novamente!");
                }

            } else if (option == 2) {
                // Login de usuário
                System.out.println("--- FOR YOUR LOGIN ---");
                System.out.println("Write your name: ");
                String name = s.next();
                System.out.println("Write your password: ");
                String password = s.next();

                boolean successfully = false;

                // Verifica se as credenciais coincidem com o arquivo
                try {
                    Scanner arquivoScanner = new Scanner(newArchive);
                    while (arquivoScanner.hasNextLine()) {
                        String line = arquivoScanner.nextLine();
                        String[] parts = line.split(":");
                        if (parts.length == 2) {
                            String user = parts[0];
                            String pass = parts[1];
                            if (user.equals(name) && pass.equals(password)) {
                                successfully = true;
                                break;
                            }
                        }
                    }
                    arquivoScanner.close();
                } catch (IOException e) {
                    System.out.println("Erro ao ler o arquivo.");
                }

                if (successfully) {
                    System.out.println("SUCESSO! Você fez login com sucesso.");
                    estaLogado = true; //muda o boolean para true;
                } else {
                    System.out.println("FRACASSO! Nome de usuário ou senha incorretos.");
                }
            } else if (option == 0) {
                System.out.println("Saindo do programa.");
                break; // Sai do loop e encerra o programa
            } else {
                System.out.println("Opção inválida.");
            }
        }
    }
}