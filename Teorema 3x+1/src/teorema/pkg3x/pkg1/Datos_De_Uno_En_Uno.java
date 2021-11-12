package teorema.pkg3x.pkg1;
import java.util.HashMap;
import java.math.BigInteger;
import java.util.ArrayList;

public class Datos_De_Uno_En_Uno {
    private BigInteger InicioSemillas;
    private BigInteger FinSemillas;
    private BigInteger NumMasAlto = BigInteger.ZERO;
    HashMap<BigInteger,BigInteger> NumerosCalculados = new HashMap<>();
    ArrayList<BigInteger> CadenaMasLarga = new ArrayList<>();
    int i = 0;
    
    public Datos_De_Uno_En_Uno(BigInteger InicioSemillas, BigInteger FinSemillas) {
        this.InicioSemillas = InicioSemillas;
        this.FinSemillas = FinSemillas;
    }
    
    public synchronized BigInteger PedirNumero(){
        BigInteger ACalcular = InicioSemillas.add(new BigInteger(""+i));
        if(ACalcular.compareTo(FinSemillas)<= 0){
            ++i;
            return ACalcular;
        }else{
            return BigInteger.ZERO;
        }
        
    }

    public synchronized void SetNuevoNumeroRecienCalculado(ArrayList<BigInteger> arrayNumbers){
        //aqui llenamos el hasMap Con los dos numero, el que hemos calculado y su resultado
        if(arrayNumbers != null){
            for (int j = 0; j < arrayNumbers.size(); ++j) {
                if(j != 0){
                    NumerosCalculados.put( arrayNumbers.get(j-1), arrayNumbers.get(j) );
                }
            }
            //Ademas comprobamos si esta secuendia es mas larga que la anterior, si es asi guardamos la secuencia
            if(arrayNumbers.size() > CadenaMasLarga.size()){
                CadenaMasLarga=arrayNumbers;
            }
        }
    }
    
    public synchronized boolean EstaCalculado(BigInteger Numero){
        //aqui comprobamos por la key del hasmap si esta o no el numero calculado, si está debolvemos true sino false
        if(NumerosCalculados.containsKey(Numero)){
            return true;
        }
        return false;
    }
    
    public int getLongiudCadenaMax(){
        return CadenaMasLarga.size();
    }
    
    public String getCadenaMasLargar(){
        String Cadena = CadenaMasLarga.get(0) +": ";
            for (int j = 0; j < CadenaMasLarga.size(); ++j) {
            Cadena += CadenaMasLarga.get(j) + "-";            
        }
        return Cadena;
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
