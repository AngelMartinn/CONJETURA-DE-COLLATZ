package teorema.pkg3x.pkg1;

import java.math.BigInteger;

public class HiloRangos implements Runnable {
    private BigInteger inicioRango;
    private BigInteger finRango;
    private DatosRangos datos;

    public HiloRangos(DatosRangos datos) {
        this.datos = datos;
    }

    @Override
    public void run(){
        //Los hilos envian un mensaje de inicio y fin para
        //controlar que dos hilos no tengan el mismo inicio
        inicioRango=datos.repartidor("inicio");
        finRango=datos.repartidor("fin");
        BigInteger resultado = null;
        int compare=inicioRango.compareTo(finRango);
        for (BigInteger i=inicioRango; compare==-1; i=i.add(BigInteger.ONE)) {
            if (!datos.calculados(i)){
                if (i.remainder(BigInteger.ONE.add(BigInteger.ONE))==BigInteger.ZERO){
                    resultado=i.divide(BigInteger.ONE.add(BigInteger.ONE));
                }else{
                    resultado=(i.multiply(BigInteger.ONE.add(BigInteger.ONE).add(BigInteger.ONE))).add(BigInteger.ONE);
                }
            }
            System.out.println(""+Thread.currentThread()+inicioRango+"-"+finRango+" "+resultado);
            compare=i.compareTo(finRango);
        }
    }// run()
    
}// HiloRangos
