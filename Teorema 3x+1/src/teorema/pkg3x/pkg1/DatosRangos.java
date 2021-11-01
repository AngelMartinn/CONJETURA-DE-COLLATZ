package teorema.pkg3x.pkg1;

import java.math.BigInteger;

public class DatosRangos {
    private BigInteger inicioRango;
    private BigInteger finRango;
    private int numHilos;
    private BigInteger numMax;
    private BigInteger reparto;
    private int despertador=0;
    private int contadorHilos = 0;
    private BigInteger finINICIAL;

    public DatosRangos(BigInteger inicioRango, BigInteger finRango, int numHilos) {
        this.inicioRango = inicioRango;
        this.finRango = finRango;
        finINICIAL=finRango;
        this.numHilos = numHilos;
        reparto = (finRango.subtract(inicioRango)).divide(BigInteger.valueOf(numHilos));
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
            ++contadorHilos;
            if (despertador==0){
                respuesta = inicioRango;
                finRango=inicioRango.add(reparto);
                inicioRango=inicioRango.add(reparto);
                despertador=1;
            }else if(despertador==1){
                try {
                //Con la variable despertador si es el segundo hilo que
                //entra pidiendo el inicio del rango, se queda esperando a
                //que el primero obtenga el valor del final de su rango y
                //asi este segundo no obtiene el mismo inicio que el primero,
                //ya que en el momento que se pide el fin del rango es cuando
                //se suma al inicio el valor correspondiente del reparto
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
            if (contadorHilos==numHilos) {
                respuesta = inicioRango;
                //Este for comprueba si el ultimo hilo se tiene que
                //llevar un rango mayor que el resto, por si el reparto
                //del rango entre los hilos no es exacto
                int compare=inicioRango.compareTo(finINICIAL);
                for (BigInteger i=inicioRango; compare==-1; i=i.add(BigInteger.ONE)) {
                    respuesta = respuesta.add(BigInteger.ONE);
                    compare=respuesta.compareTo(finINICIAL);
                }
            }else{
                respuesta = finRango;
                despertador=0;
                notifyAll();
            }
        }
        return respuesta;
    }// repartidor()
    
    public boolean calculados(BigInteger calculado) {
        
        
        return false;  
    }// calculados()
    
}// DatosRangos
