package teorema.pkg3x.pkg1;

import java.math.BigInteger;
import java.util.HashMap;

public class DatosRangos {
    private BigInteger inicioRango;
    private BigInteger finRango;
    private int numHilos;
    private BigInteger numMax;
    private BigInteger reparto;
    private int despertador=0;
    private int contadorHilos = 0;
    private BigInteger finINICIAL;
    private HashMap <BigInteger, BigInteger> calculados = new HashMap ();
    private String secuenciaMayor="";

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
    
    public BigInteger getValor(BigInteger key) {
        return calculados.get(key);
    }
    
    public synchronized BigInteger pedirInicio(){
        if (contadorHilos==0) {
            inicioRango=inicioRango;
        }else{
            inicioRango=inicioRango.add(reparto).add(BigInteger.ONE);
        }
        ++contadorHilos;
        return inicioRango;
    }
    
    public BigInteger pedirFin(BigInteger inicio) {
        if (contadorHilos==numHilos) {
            finRango=finINICIAL;
        }else{
            finRango=inicio.add(reparto);
        }
        return finRango;
    }// pedirFin()
    
    public boolean calculados(BigInteger calculado) {
        if (calculados.get(calculado)!= null){
            return true;
        }else{
            return false;
        }
    }// calculados()
    
    public void actualizarCalculados(BigInteger key, BigInteger resultado) {
        calculados.put(key, resultado);
    }// actualizarCalculados()
    
    public synchronized void secuenciaMasLarga(String secuencia) {
        if (secuencia.length()>secuenciaMayor.length()){
            secuenciaMayor=secuencia;
        }
    }// secuenciaMasLarga()
    
    public void end(){
        System.out.println("Mayor secuencia encontrada por "+Thread.currentThread()+": "+secuenciaMayor.substring(0, secuenciaMayor.length()-3));
    }// end()
    
}// DatosRangos