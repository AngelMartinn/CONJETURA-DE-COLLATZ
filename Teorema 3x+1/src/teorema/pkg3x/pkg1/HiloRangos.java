package teorema.pkg3x.pkg1;

import java.math.BigInteger;
import java.util.HashMap;

public class HiloRangos implements Runnable {
    private BigInteger inicioRango;
    private BigInteger finRango;
    private DatosRangos datos;
    private BigInteger DOS=new BigInteger("2");
    private BigInteger TRES=new BigInteger("3");
    private HashMap <BigInteger, BigInteger> repetido = new HashMap ();
    private String secuencia="";
    private BigInteger numMax=BigInteger.ZERO;
    
    public HiloRangos(DatosRangos datos) {
        this.datos = datos;
    }

    @Override
    public void run(){
        inicioRango=datos.pedirInicio();
        finRango=datos.pedirFin(inicioRango);
        BigInteger resultado = BigInteger.ZERO;
        BigInteger numActual = BigInteger.ZERO;
        for (BigInteger i = inicioRango; i.compareTo(finRango)==-1 || i.compareTo(finRango)==0; i=i.add(BigInteger.ONE)) {
            secuencia="";
            resultado=i;
            int contSecuencias=0;
            while (repetido.get(resultado) == null) {
                numActual=resultado;
                if (datos.calculados(numActual)==false) {
                    if (numActual.remainder(DOS)==BigInteger.ZERO){
                        resultado=numActual.divide(DOS);
                    }else{
                        resultado=(numActual.multiply(TRES)).add(BigInteger.ONE);
                    }
                ++contSecuencias;
                }else{
                    contSecuencias+=datos.getSecuencia(resultado);
                }
                secuencia+=numActual+"-";
                repetido.put(numActual, resultado);
                if (resultado.compareTo(numMax)==1){
                    numMax=resultado;
                }    
            }
            secuencia+=resultado;
            datos.actualizarCalculados(secuencia);
            datos.secuenciaMasLarga(i, contSecuencias);
            repetido.clear();
        }
        datos.setNumMax(numMax);
    }// run()
    
}// HiloRangos
