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
        inicioRango=datos.repartidor("inicio");
        finRango=datos.repartidor("fin");
        System.out.println(""+Thread.currentThread()+inicioRango+"-"+finRango);
    }// run()
    
}// HiloRangos
