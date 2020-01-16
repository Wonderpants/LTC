/*
 * Classe com as funcionalidades necessárias para ler e
 * escrever num ficheiro de texto
 */

package pt.ispgaya.trabalho1.File;

import java.io.*;

public class Ficheiro {

    private BufferedReader fr;
    private BufferedWriter fw;

    public void read(String nomeFicheiro ) throws IOException {
        fr = new BufferedReader( new FileReader( nomeFicheiro ) );
    }

    public void open(String nomeFicheiro ) throws IOException {
        fw = new BufferedWriter( new FileWriter( nomeFicheiro ) );
    }

    public void close() throws IOException {
        fw.close();
    }

    public String readLine() throws IOException{
        return fr.readLine();
    }

     public void write(String linha ) throws IOException{
        fw.write( linha, 0, linha.length());
        fw.newLine();
    }
}
