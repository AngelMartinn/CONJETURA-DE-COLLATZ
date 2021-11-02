package teorema.pkg3x.pkg1;
import java.util.HashMap;
import java.math.BigInteger;

public class Datos_De_Uno_En_Uno {
    private BigInteger InicioSemillas;
    private BigInteger FinSemillas;
    private BigInteger NumMasAlto;
    public Datos_De_Uno_En_Uno(BigInteger InicioSemillas, BigInteger FinSemillas) {
        this.InicioSemillas = InicioSemillas;
        this.FinSemillas = FinSemillas;
    }
    int i = 0;
    
    public synchronized BigInteger PedirNumero(){
        BigInteger count = new BigInteger(""+i);
        BigInteger ACalcular = InicioSemillas.add(count);
        
        if(ACalcular.compareTo(FinSemillas)<= 0){
            ++i;
            return ACalcular;
        }else{
            return BigInteger.ZERO;
        }
        
    }
    public BigInteger GetNumCalculado(BigInteger NumeroYaCalculado){
        //aqui te coje el valor del hasmap  el cual si esta calculado
        return BigInteger.ONE;//<---- momentanio para que no pete y compile
    }
    
    public synchronized void SetNuevoNumeroRecienCalculado(BigInteger NumeroCalculado, BigInteger ResultadoDelCalculo){
        //aqui llenamos el hasMap Con los dos numero, el que hemos calculado y su resultado
    }
    
    public synchronized boolean EstaCalculado(BigInteger Numero){
        //aqui comprobamos por la key del hasmap si esta o no el numero calculado, si está debolvemos true sino false
        return false;
    }
    
    public BigInteger getNumMasAlto(){
        return NumMasAlto;
    }
    
    public synchronized void setNumMasAlto(BigInteger i){
        NumMasAlto = i;
    }
    
    
}// Datos_De_Uno_En_Uno
