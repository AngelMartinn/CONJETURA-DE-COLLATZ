package teorema.pkg3x.pkg1;

import java.math.BigInteger;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DatosRangos {
    private BigInteger inicioRango;
    private BigInteger finRango;
    private int numHilos;
    private BigInteger numMax;
    private BigInteger reparto;
    private int despertador=0;

    public DatosRangos(BigInteger inicioRango, BigInteger finRango, int numHilos) {
        this.inicioRango = inicioRango;
        this.finRango = finRango;
        this.numHilos = numHilos;
        reparto = finRango.divide(BigInteger.valueOf(numHilos));
    }// DatosRangos()

    public BigInteger getNumMax() {
        return numMax;
    }

    public void setNumMax(BigInteger numMax) {
        this.numMax = numMax;
    }
    
    public synchronized BigInteger repartidor(String tipoRespuesta) {       
        BigInteger respuesta = null;
        if ("inicio".equals(tipoRespuesta)){
            if (despertador==0){
                respuesta = inicioRango;
                finRango=inicioRango.add(reparto);
                inicioRango=inicioRango.add(reparto);
                despertador=1;
            }else if(despertador==1){
                try {
                    wait();
                    respuesta = inicioRango;
                    finRango=inicioRango.add(reparto);
                    inicioRango=inicioRango.add(reparto);
                    despertador=1;
                } catch (InterruptedException ex) {
                    System.out.println(ex);
                }
            }
        }else if ("fin".equals(tipoRespuesta)){
            respuesta = finRango;
            despertador=0;
            notifyAll();
        }
        return respuesta;
    }// repartidor()
    
}// DatosRangos
