package exceptions;

import javax.swing.JOptionPane;

//Fazer a divisão de 2 valores inteiros
public class UncheckedException {
    public static void main(String[] args) {

        boolean continueLooping = true;
        do { //laço para que o código continue pedindo até colocar entradas válidas
            String a = JOptionPane.showInputDialog("Numerador: ");
            String b = JOptionPane.showInputDialog("Denominador: ");

            try{ //tratar exception usando try
                int resultado = dividir(Integer.parseInt(a), Integer.parseInt(b));
                System.out.println("Resultado: " + resultado);
                continueLooping = false;
            } catch (NumberFormatException e) { //exeção da condição de número
                e.printStackTrace(); //imprime a exception para o dev ver
                JOptionPane.showMessageDialog(null, "Entrada inválida, informe um número inteiro! " + e.getMessage());
            } catch (ArithmeticException e) { //exceção de lógica aritmética
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Impossível dividir um número por 0.");
            }
            finally {
                System.out.println("Chegou no finally!");
            }
        } while(continueLooping);


        System.out.println("O código continua...");
    }

    public static int dividir(int a, int b) {
        return a / b;
    }
}
