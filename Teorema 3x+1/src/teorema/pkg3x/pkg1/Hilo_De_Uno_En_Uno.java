package teorema.pkg3x.pkg1;

import java.math.BigInteger;
import java.util.ArrayList;

public class Hilo_De_Uno_En_Uno implements Runnable {
    Datos_De_Uno_En_Uno Datos;
    ArrayList<BigInteger> SecuenciaNumeros = new ArrayList<>();

    public Hilo_De_Uno_En_Uno(Datos_De_Uno_En_Uno Datos) {
        this.Datos = Datos;
    }
    
    @Override
    public void run(){
        BigInteger Numero = Datos.PedirNumero();
        BigInteger DOS = new BigInteger("2");
        BigInteger TRES = new BigInteger("3");
        boolean EstaCalculadoYa = true;
        int LongitudCadena = 0;
        
        //Bucle que te pide numeros haste que la clase datos te devuelve 0; es decir que ya se acabaron lso numeros para calcular
        //     |
        //     v
        while(Numero.compareTo(BigInteger.ZERO) != 0 ){
            SecuenciaNumeros.add(Numero);
            //Bucle para tratar a cada nuemro hasta llegar a la secuencia 4-2-1, esto inclulle guardarlo en el hasmap si no esta calculado y 
            //tambien comprobar el numero mas grande alcanzado a la vez que la secuencia mas grande alcanzada. 
            //     |
            //     v
            BigInteger NuevoValor;
            while(SecuenciaNumeros.contains(Numero) && !Datos.EstaCalculado(Numero)){
                
                if(Numero.remainder(DOS)==BigInteger.ZERO ){
                    //si es par 
                    NuevoValor = Numero.divide(DOS);
                }else{
                    //si es Impar
                    NuevoValor = (Numero.multiply(TRES).add(BigInteger.ONE));
                }
                //Guardar Aqui en el has-map el Numero y el NuevoValor
                Datos.SetNuevoNumeroRecienCalculado(Numero,NuevoValor);
                //Comprobamos si el nuevo nuemro es mayor al que habiamso calculado con anterioridad
                if(Datos.getNumMasAlto().compareTo(NuevoValor) == -1){
                    Datos.setNumMasAlto(NuevoValor);
                }
                SecuenciaNumeros.add(NuevoValor);
                //Antes de salir del bucle guardando en los hasmaps la longitud de la cadena ya calculada y su valor
                ++LongitudCadena;
                Numero = NuevoValor;
            }
            
            if(Datos.hasLongitud(Numero)){
                LongitudCadena += Datos.getLongiudCadena(Numero);
            }
            Datos.setLongitudCadena(Numero,LongitudCadena);
            //Como ya hemos acabado con un numero borramos el array, reiniciamos la longitud de la cadena y pedimos el siguietne numero
            SecuenciaNumeros.removeAll(SecuenciaNumeros);
            LongitudCadena = 0;
            EstaCalculadoYa = true;
            Numero = Datos.PedirNumero();
        }
        
        
    }
}// Hilo_De_Uno_En_Uno
