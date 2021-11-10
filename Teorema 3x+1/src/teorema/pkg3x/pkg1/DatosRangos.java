package teorema.pkg3x.pkg1;

import java.math.BigInteger;
import java.util.HashMap;

public class DatosRangos {
    private BigInteger inicioRango;
    private BigInteger finRango;
    private int numHilos;
    private BigInteger numMax=BigInteger.ZERO;
    private BigInteger reparto;
    private int despertador=0;
    private int contadorHilos = 0;
    private BigInteger finINICIAL;
    private HashMap <BigInteger, BigInteger> calculados = new HashMap ();
    private int longitudSecuenciaMayor=0;
    private BigInteger semillaSecuenciaMayor=BigInteger.ZERO;
    private String secuenciaMayor="";
    private HashMap <BigInteger, BigInteger> repetido = new HashMap ();
            
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

    public synchronized void setNumMax(BigInteger numMax) {
        if (numMax.compareTo(this.numMax)==1) {
            this.numMax = numMax;
        }
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
    
    public synchronized void actualizarCalculados(String secuencia) {
        String[] arraySecuencia=secuencia.split("-");
        BigInteger key;
        BigInteger value = BigInteger.ZERO;
        for (int i = 0; i < arraySecuencia.length-1; ++i) {
            key=new BigInteger(arraySecuencia[i]);
            if (calculados.get(key)==null){
                if (i<arraySecuencia.length-1){
                    value=new BigInteger(arraySecuencia[i+1]);
                }
            calculados.put(key, value);
            }
        }
    }// actualizarCalculados()
    
    public synchronized int getSecuencia(BigInteger num){
        int contExtra=0;
        BigInteger numActual;
        while (repetido.get(num)==null) {
            numActual=num;
            ++contExtra;       
            num=calculados.get(num);
            repetido.put(numActual, num);
        }
        repetido.clear();
        return contExtra;
    }
    
    public synchronized void secuenciaMasLarga(BigInteger semilla, int tamanioSecuencia) {
        if (tamanioSecuencia>longitudSecuenciaMayor){
            semillaSecuenciaMayor=semilla;
            longitudSecuenciaMayor=tamanioSecuencia;
        }
    }// secuenciaMasLarga()
    
    public void end(){
        BigInteger siguienteNum=semillaSecuenciaMayor;
        BigInteger numActual;
        while (repetido.get(siguienteNum)==null) {
            numActual=siguienteNum;
            secuenciaMayor+=siguienteNum+"-";        
            siguienteNum=calculados.get(siguienteNum);
            repetido.put(numActual, siguienteNum);
        }
        
        System.out.println("Semilla de la mayor secuencia encontrada: "+semillaSecuenciaMayor);
        //El -1 porque sino sacaría la longitud de la secuencia contando con el
        //numero que se repite(4) generando el bucle 4-2-1 u otro
        System.out.println("Longitud de la secuencia de "+semillaSecuenciaMayor+": "+(longitudSecuenciaMayor-1));
        //substring para quitar el ultimo - al sacar la secuencia por pantalla
        System.out.println("Secuencia de "+semillaSecuenciaMayor+": "+secuenciaMayor.substring(0, secuenciaMayor.length()-1));
        System.out.println("Numero maximo alcanzado: "+numMax);
    }// end()
    
}// DatosRangos