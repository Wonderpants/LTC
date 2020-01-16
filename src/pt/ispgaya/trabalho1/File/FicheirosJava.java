
package pt.ispgaya.trabalho1.File;

import java.io.IOException;

public class FicheirosJava {

    public static void main(String[] args) throws IOException {
        Ficheiro f1 = new Ficheiro();
        Ficheiro f2 = new Ficheiro();
        String linha;

        System.out.println("Qual o nome do ficheiro para escrever?");
        f1.open(Le.umaString());    // ficheiro para escrita

        // introduz as linhas para o ficheiro fxw.txt
        // termina quando for lida a palavra "fim"


        System.out.println("Teste com ficheiros:");
        do {
            System.out.println("Introduza uma linha para o ficheiro:");
            linha = Le.umaString();
            f1.write(linha);
        } while (!linha.equals("fim"));

        f1.close();   // Necessario senao o ficheiro fica vazio

        System.out.println("Qual o nome do ficheiro para ler?");

        f2.read(Le.umaString());   // ficheiro para leitura

        // le o conteudo do ficheiro
        do {
            linha = f2.readLine();
            if (linha != null)
                System.out.println("Linha lida do ficheiro: " + linha);
        } while (linha != null);
    }
}
