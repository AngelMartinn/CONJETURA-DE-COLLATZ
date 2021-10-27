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

    public synchronized BigInteger PedirNumero(int i){
        BigInteger count = new BigInteger(""+i);
        BigInteger ACalcular = InicioSemillas.add(count);
        
        if(ACalcular.compareTo(FinSemillas)<= 0){
            return ACalcular;
        }else{
            return BigInteger.ZERO;
        }
        
    }
    public synchronized void setNumMasAlto(BigInteger i){
        NumMasAlto = i;
    }
    public BigInteger getNumMasAlto(){
        return NumMasAlto;
    }
    
    
}// Datos1
