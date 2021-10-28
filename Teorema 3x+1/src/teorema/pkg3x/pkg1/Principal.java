package teorema.pkg3x.pkg1;
import java.math.BigInteger;
import java.util.Scanner;

public class Principal {
    private static BigInteger Inicio; 
    private static BigInteger Fin;
    public static void main(String[] args) {
         InterfazUsuario();
    }// main()
    
    private static void InterfazUsuario(){
        int Metodo;
        int NumHilos;
        
        Scanner teclado = new Scanner(System.in);
        System.out.println("Bienvenido al programa calculadora de casos del Teorema 3x+1");
        System.out.println("Que cantiad de hilos quiere utilizar");
        NumHilos = teclado.nextInt();teclado.nextLine();
        System.out.println("Que metodo quieres utilizar:\n \t DeUnoEnUno-1 \n\t SubIntervalos-2");
        Metodo = teclado.nextInt(); teclado.nextLine();
        System.out.println("Dime el inicio de las señillas a calcular");
        Inicio = new BigInteger(teclado.nextLine());
        System.out.println("Por ultimo dime el final de las semillas a calcular");
        Fin= new BigInteger(teclado.nextLine());
        
        if (Metodo==2) {
            creadorHilosRangos(NumHilos);
        }else if(Metodo==2){
            
        }
        
    }// InterfazUsuario()
    
    private static void creadorHilosRangos(int numHilos) {
        DatosRangos datos=new DatosRangos(Inicio, Fin, numHilos);
        Thread[] hilos=new Thread[numHilos];       
        for (int i = 0; i < hilos.length; ++i) {
            HiloRangos h = new HiloRangos(datos);
            hilos[i] = new Thread(h);
            hilos[i].start();
        }
    }// creadorHilosRangos()
    
}// Principal