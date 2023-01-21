package exceptions;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;

import javax.swing.JOptionPane;

//Imprimir um arquivo no console.
public class CheckedException {
    public static void main(String[] args) {
        String nomeDoArquivo = "romances-blake-crouch.txt";

        try { //tratamento na exceção
            imprimirArquivoNoConsole(nomeDoArquivo);
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null,
                    "Revise o nome do arquivo que você deseja imprimir! " + e.getCause());
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,
                    "Ocorreu um erro inesperado! Entre em contato com o suporte! " + e.getCause());
        } finally {
            System.out.println("Chegou no finally!");
        }

        System.out.println("Apesar da exception ou não, o programa continua...");
    }

    public static void imprimirArquivoNoConsole(String nomeDoArquivo) throws IOException {
        File file = new File(nomeDoArquivo);

        BufferedReader br = new BufferedReader(new FileReader(file.getName())); //FileReader lança uma exception
        String line = br.readLine(); //readLine também traz uma exception

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        do{ //laço para ler no console até que não tenha informações na linha
            bw.write(line);
            bw.newLine();
            line=br.readLine();
        } while(line != null);
        bw.flush();
        br.close();
    }
}