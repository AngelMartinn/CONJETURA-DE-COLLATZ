package teorema.pkg3x.pkg1;
import java.util.HashMap;
import java.math.BigInteger;

public class Datos_De_Uno_En_Uno {
    private BigInteger InicioSemillas;
    private BigInteger FinSemillas;
    private BigInteger NumMasAlto = BigInteger.ZERO;
    HashMap<BigInteger,BigInteger> NumerosCalculados = new HashMap<>();
    HashMap<BigInteger,Integer> LongitudesDeNuemrosCalculados = new HashMap<>();
    
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
    //HashMap de Nuemro y resultado siguietne
    public BigInteger GetNumCalculado(BigInteger NumeroYaCalculado){
        //aqui te coje el valor del hasmap  el cual si esta calculado
        return BigInteger.ONE;//<---- momentanio para que no pete y compile
    }
    public synchronized void SetNuevoNumeroRecienCalculado(BigInteger NumeroCalculado, BigInteger ResultadoDelCalculo){
        //aqui llenamos el hasMap Con los dos numero, el que hemos calculado y su resultado
        NumerosCalculados.put(NumeroCalculado, ResultadoDelCalculo);
    }
    public synchronized boolean EstaCalculado(BigInteger Numero){
        //aqui comprobamos por la key del hasmap si esta o no el numero calculado, si está debolvemos true sino false
        if(NumerosCalculados.containsKey(Numero)){
            return true;
        }
        return false;
    }
    //Hashmap de Numero y longitud de cadena calculada
    public synchronized void setLongitudCadena(BigInteger Bigi, int i){
        //Guardamos en un hasmap el numero que hemos calculado(key) y la lognitud de su cadena(value)
        LongitudesDeNuemrosCalculados.put(Bigi, i);
    }
    public int getLongiudCadema(BigInteger i){
        //devolvemos la longitud del numero introducido el cual ya hemos calculado anteriormente y por tanto conocemos tambien la longitud de su cadena
        int LongitudMayor = LongitudesDeNuemrosCalculados.get(i);
        return LongitudMayor;
    }
    
    
    public BigInteger getNumMasAlto(){
        //Devolvemos el numero mas alto alcanzado
        return NumMasAlto;
    }
    public synchronized void setNumMasAlto(BigInteger i){
        //Como hemos encontrado un numero mayor al que tenemos guardado lo sustituimos por el mas alto 
        NumMasAlto = i;
    }

}// Datos_De_Uno_En_Uno
