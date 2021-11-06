package teorema.pkg3x.pkg1;

import java.math.BigInteger;
import java.util.HashMap;

public class HiloRangos implements Runnable {
    private BigInteger inicioRango;
    private BigInteger finRango;
    private DatosRangos datos;
    private BigInteger DOS=new BigInteger("2");
    private BigInteger TRES=new BigInteger("3");
    private static String secuencia="";
    
    public HiloRangos(DatosRangos datos) {
        this.datos = datos;
    }

    @Override
    public void run(){
        inicioRango=datos.pedirInicio();
        finRango=datos.pedirFin(inicioRango);
        BigInteger resultado;
        for (BigInteger i = inicioRango; i.compareTo(finRango)==-1 || i.compareTo(finRango)==0; i=i.add(BigInteger.ONE)) {
            String secuenciaMasLarga = "";
            HashMap <BigInteger, BigInteger> repetido = new HashMap ();
            resultado=i;
            while (repetido.get(resultado) == null) {
                BigInteger numActual=resultado;
                if (datos.calculados(numActual)==false) {
                    if (numActual.remainder(DOS)==BigInteger.ZERO){
                        resultado=numActual.divide(DOS);
                    }else{
                        resultado=(numActual.multiply(TRES)).add(BigInteger.ONE);
                    }
                }else{
                    resultado=datos.getValor(resultado);
                }
                secuenciaMasLarga+=resultado+"-";
                datos.actualizarCalculados(numActual, resultado);
                repetido.put(numActual, resultado);
            }
            datos.secuenciaMasLarga(secuenciaMasLarga);
        }
        datos.end();
    }// run()
    
    private void secuenciaMasLarga(BigInteger i, String fin) {
        if ("mas".equals(fin)){
            secuencia+=i.toString()+"-";
        }else if("fin".equals(fin)){
            datos.secuenciaMasLarga(secuencia);
            secuencia="";
        }
    }// secuenciaMasLarga()
    
}// HiloRangos
