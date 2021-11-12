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

        while(Numero.compareTo(BigInteger.ZERO) != 0 ){
            SecuenciaNumeros.add(Numero);
            BigInteger NuevoValor;
            
            while(!Datos.EstaCalculado(Numero)){
                if(Numero.remainder(DOS)==BigInteger.ZERO ){
                    //si es par 
                    NuevoValor = Numero.divide(DOS);
                }else{
                    //si es Impar
                    NuevoValor = (Numero.multiply(TRES).add(BigInteger.ONE));
                }
                //Guardar Aqui en el ArrayList el valor del numero calculado
                SecuenciaNumeros.add(NuevoValor);
                //Comprobamos si el nuevo nuemro es mayor al que habiamso calculado con anterioridad
                if(Datos.getNumMasAlto().compareTo(NuevoValor) == -1){
                    Datos.setNumMasAlto(NuevoValor);
                }
                Numero = NuevoValor;
            }
            //Enviamos la secuencia entera de la semilla
            Datos.SetNuevoNumeroRecienCalculado(SecuenciaNumeros);
            
            //Como ya hemos acabado con un numero borramos el array y pedimos el siguietne numero
            SecuenciaNumeros.removeAll(SecuenciaNumeros);
            Numero = Datos.PedirNumero();
        }
    }
}// Hilo_De_Uno_En_Uno
