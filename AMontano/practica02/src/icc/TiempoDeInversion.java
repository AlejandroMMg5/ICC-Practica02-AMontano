import java.util.Scanner;

/**
 * clase:TiempoDeInversion.java
 * descripcion: Esta clase calcula el tiempo de inversion y el monto final de la inversion
 * @author Alejandro Montaño Mauro 
 * @version 1.0
 */

public class TiempoDeInversion{
    /**
     * Constructor de la clase TiempoDeInversion sin uso, ya que el programa se ejecuta desde el metodo main
     */
    public TiempoDeInversion(){
    }
    /**
     * Metodo principal del programa.
     *
     * Solicita los datos necesarios para realizar una inversion
     * calcula el numero de dias transcurridos el interes generado y
     * el monto final. El usuario puede realizar varias inversiones
     * durante la ejecucion del programa
     *
     * @param args recibidos desde la linea de comandos
     */

    public static void main(String [] args){

        Scanner in = new Scanner(System.in);
        String nombreCompleto = new String();
        double monto = 0.0;
        String respuesta = new String();

        System.out.println("Buenas tardes");
        System.out.println("Favor de ingrear su nombre completo");
        nombreCompleto = in.nextLine();
        nombreCompleto = nombreCompleto.trim();

        do {

            System.out.println("Buenas tardes " + nombreCompleto + ",favor de ingresar su monto de inversion");
            System.out.println("Favor de ingresar los pesos sin centavos");
            int pesos = in.nextInt();

            System.out.println("Favor de ingresar los Centavos");
            int centavos = in.nextInt();
                while (centavos>99){
                    System.out.println("Favor de ingresar los centavos correctamente");
                    centavos = in.nextInt();
                }
                
            monto = pesos + (centavos/100.0);

            System.out.println("Favor de ingresar el dia de inicio de la inversion (dd):");
            int dayIn = in.nextInt();
            while (dayIn>31){
                System.out.println("Favor de ingresar el dia correctamente");
                dayIn = in.nextInt();
            }

            System.out.println("Favor de ingresar el mes de inicio de la inversion (mm):");
            int monthIn = in.nextInt();
            while (monthIn>12){
                System.out.println("Favor de ingresar el mes correctamente");
                monthIn = in.nextInt();
            }

            System.out.println("Favor de ingresar el año de inicio de la inversion (yyyy):");
            int yearIn = in.nextInt();
            while (yearIn<2026){
                System.out.println("Favor de ingresar el año correctamente");
                yearIn = in.nextInt();
            }

            /** 
             * Se crea un objeto de tipo Fecha con los datos ingresados por el usuario
             */

            Fecha fechaInicio = new Fecha(dayIn, monthIn, yearIn);

            System.out.println("Favor de ingresar el dia de fin de la inversion (dd):");
            int dayEnd = in.nextInt();
            while (dayEnd>31){
                System.out.println("Favor de ingresar el dia correctamente");
                dayEnd = in.nextInt();
            }

            System.out.println("Favor de ingresar el mes de fin de la inversion (mm):");
            int monthEnd = in.nextInt();
            while (monthEnd>12){
                System.out.println("Favor de ingresar el mes correctamente");
                monthEnd = in.nextInt();
            }

            System.out.println("Favor de ingresar el año de fin de la inversion (yyyy):");
            int yearEnd = in.nextInt();
            while (yearEnd<2026){
                System.out.println("Favor de ingresar el año correctamente");
                yearEnd = in.nextInt();
            }
            /** 
             * Se crea un objeto de tipo Fecha con los datos ingresados por el usuario
             */

            Fecha fechaFin = new Fecha(dayEnd, monthEnd, yearEnd);

            // Formula de interes usada: I = C * r * t

            /**
             * Número de días que dura la inversión
             */

            int t = fechaFin.differencebyDay(fechaInicio);

            /**
             * Tasa de interés diaria correspondiente a una tasa anual del 12%
             */
            double r = 0.12 / 365.0;

             /**
              * Interés generado durante el tiempo de la inversión.
              */

            double interes = monto * r * t;

            double montoFinal = monto + interes;

            System.out.println("Dias de su inversion: " + t);
            System.out.println("monto de su inversion en ese lapso: " + montoFinal);

            System.out.println("¿Desea hacer otra inversion? (si/no)");
            in.nextLine();
            respuesta = in.nextLine();  
            respuesta = respuesta.trim();     



        }while (respuesta.equals("si"));

        System.out.println("Gracias por su tiempo," + nombreCompleto);
    }
}