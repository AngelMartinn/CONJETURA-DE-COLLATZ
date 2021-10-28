package teorema.pkg3x.pkg1;

import java.math.BigInteger;

public class Hilo_De_Uno_En_Uno implements Runnable {
    Datos_De_Uno_En_Uno Datos;
    
    @Override
    public void run(){
        int i = 0;
        BigInteger Numero = Datos.PedirNumero(i);
        BigInteger DOS = new BigInteger("2");
        BigInteger Remainder;
        //Bucle que te pide numeros haste que la clase datos te devuelve 0; es decir que ya se acabaron lso numeros para calcular
        //     |
        //     v
        while(Numero.compareTo(BigInteger.ZERO) != 0 ){
            //Bucle para tratar a cada nuemro hasta llegar a la secuencia 4-2-1, esto inclulle guardarlo en el hasmap si no esta calculado y 
            //tambien comprobar el numero mas grande alcanzado a la vez que la secuencia mas grande alcanzada.    |
            //     |
            //     v
            while(Numero.compareTo(BigInteger.ONE) == 0){
                Remainder=  Numero.mod(DOS);
                //Aqui comprobar si esta ya calculado 
                if(Remainder ==  BigInteger.ZERO ){
                    //si es par 

                }else{
                    //si es Impar
                }
            }
            ++i;
            Numero = Datos.PedirNumero(i);
        }
        
        
    }
}// Hilo_De_Uno_En_Uno
