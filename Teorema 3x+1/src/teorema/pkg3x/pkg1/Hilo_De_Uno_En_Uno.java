package teorema.pkg3x.pkg1;

import java.math.BigInteger;

public class Hilo_De_Uno_En_Uno implements Runnable {
    Datos_De_Uno_En_Uno Datos;

    public Hilo_De_Uno_En_Uno(Datos_De_Uno_En_Uno Datos) {
        this.Datos = Datos;
    }
    
    @Override
    public void run(){
        BigInteger Numero = Datos.PedirNumero();
        BigInteger DOS = new BigInteger("2");
        BigInteger TRES = new BigInteger("3");
        //Bucle que te pide numeros haste que la clase datos te devuelve 0; es decir que ya se acabaron lso numeros para calcular
        //     |
        //     v
        while(Numero.compareTo(BigInteger.ZERO) != 0 ){
            //Bucle para tratar a cada nuemro hasta llegar a la secuencia 4-2-1, esto inclulle guardarlo en el hasmap si no esta calculado y 
            //tambien comprobar el numero mas grande alcanzado a la vez que la secuencia mas grande alcanzada.    |
            //     |
            //     v
            while(Numero.compareTo(BigInteger.ONE) == 0){
                BigInteger NuevoValor;
                //Aqui comprobar si esta ya calculado
                if(!Datos.EstaCalculado(Numero)){
                    
                    if(Numero.remainder(DOS)==BigInteger.ZERO ){
                        //si es par 
                        NuevoValor = Numero.divide(DOS);
                    }else{
                        //si es Impar
                        NuevoValor = (Numero.multiply(TRES).add(BigInteger.ONE));
                    }
                    //Guardar Aqui en el has-map el Numero y el NuevoValor
                    Datos.SetNuevoNumeroRecienCalculado(Numero,NuevoValor);
                    
                }else{
                    //Si ya esta calculado recoje del hasmap ese valor y no lo calcula
                    NuevoValor = Datos.GetNumCalculado(Numero);
                }
                Numero = NuevoValor;
            }
            Numero = Datos.PedirNumero();
        }
        
        
    }
}// Hilo_De_Uno_En_Uno
