package teorema.pkg3x.pkg1;
import java.math.BigInteger;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
         InterfazUsuario();
    }// main()
    
    private static void InterfazUsuario(){
        int Metodo;
        int NumHilos;
        BigInteger Inicio; 
        BigInteger Fin;
        
        Scanner teclado = new Scanner(System.in);
        System.out.println("Bienvenido al programa calculadora de casos del Teorema 3x-1");
        System.out.println("Que cantiad de hilos quiere utilizar");
        NumHilos = teclado.nextInt();teclado.nextLine();
        System.out.println("Que metodo quieres utilizar:\n \t DeUnoEnUno-1 \n\t SubIntervalos-2");
        Metodo = teclado.nextInt(); teclado.nextLine();
        System.out.println("Dime el inicio de las señillas a calcular");
        Inicio = new BigInteger(teclado.nextLine());
        System.out.println("Por ultimo dime el final de las semillas a calcular");
        Fin= new BigInteger(teclado.nextLine());
        
    }
}// Principal