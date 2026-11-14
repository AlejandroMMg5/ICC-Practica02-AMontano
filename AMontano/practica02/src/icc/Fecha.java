/** 
 * clase:Fecha.java
 * descripcion: Esta clase maneja 2 fechas , podiendo calcular varios datos y asi manipular o trabajar estas
 * @author Alejandro Montaño Mauro
 * @version 1.0
 */

public class Fecha {
    /** Día de la fecha. */
    private int day;
    /** Mes de la fecha. */
    private int month;
    /** Año de la fecha. */
    private int year; 

    /**
     * Constructor por defecto que inicializa la fecha a 01/01/2026
     */
    public Fecha(){
        this.day=01;
        this.month=01;
        this.year=2026;

    }
    /**
     * Constructor que inicializa la fecha con los valores proporcionados
     * @param day el día de la fecha
     * @param month el mes de la fecha
     * @param year el año de la fecha
     */
    public Fecha (int day, int month, int year){
        this.day= day;
        this.month= month;
        this.year= year;
    }

    /**
     * Constructor que inicializa la fecha con los valores proporcionados
     * @param day el día de la fecha
     * @param month el mes de la fecha, permitiendo ingresar el nombre del mes en lugar del número
     * @param year el año de la fecha
     */
    public Fecha (int day, String month, int year){
        this.day= day;
        this.month= getMonthNumber(month);
        this.year= year;
    }

    /**
     * Establece la fecha con los valores proporcionados
     * @param day el día de la fecha
     * @param month el mes de la fecha
     * @param year el año de la fecha
     */
    public void setDate(int day, int month, int year){
        if(getMonthName(month).equals("enero") && day>0 && day<32 && year>0){
            this.day=day;
            this.month=month;
            this.year=year;
        }else if(getMonthName(month).equals("febrero") && day>0 && day<29 && year>0){
            this.day=day;
            this.month=month;
            this.year=year;
            if(isLeapYear(year) && day>0 && day<30){
                this.day=day;
                this.month=month;
                this.year=year;
            }
        }else if(getMonthName(month).equals("marzo") && day>0 && day<32 && year>0){
            this.day=day;
            this.month=month;
            this.year=year;
        }else if(getMonthName(month).equals("abril") && day>0 && day<31 && year>0){
            this.day=day;
            this.month=month;
            this.year=year;
        }else if(getMonthName(month).equals("mayo") && day>0 && day<32 && year>0){
            this.day=day;
            this.month=month;
            this.year=year;
        }else if(getMonthName(month).equals("junio") && day>0 && day<31 && year>0){
            this.day=day;
            this.month=month;
            this.year=year;
        }else if(getMonthName(month).equals("julio") && day>0 && day<32 && year>0){
            this.day=day;
            this.month=month;
            this.year=year;
        }else if(getMonthName(month).equals("agosto") && day>0 && day<32 && year>0){
            this.day=day;
            this.month=month;
            this.year=year;
        }else if(getMonthName(month).equals("septiembre") && day>0 && day<31 && year>0){
            this.day=day;
            this.month=month;
            this.year=year;
        }else if(getMonthName(month).equals("octubre") && day>0 && day<32 && year>0){
            this.day=day;
            this.month=month;
            this.year=year;
        }else if(getMonthName(month).equals("noviembre") && day>0 && day<31 && year>0){
            this.day=day;
            this.month=month;
            this.year=year;
        }else if(getMonthName(month).equals("diciembre") && day>0 && day<32 && year>0){
            this.day=day;
            this.month=month;
            this.year=year;
        }else{
            System.out.println("fecha invalida");
        }
    
        
    }

    /**
     * Devuelve el día de la fecha
     * @return el día de la fecha
     */
    public int getDay(){
        return this.day;
    }

    /**
     * Devuelve el mes de la fecha
     * @return el mes de la fecha
     */
    public int getMonth(){
        return this.month;
    }

    /**
     * Devuelve el año de la fecha
     * @return el año de la fecha
     */
    public int getYear(){
        return this.year;
    }
    /**
     * Determina si un año es bisiesto
     * @param year el año a evaluar
     * @return true si el año es bisiesto, false en caso contrario
     */
    public boolean isLeapYear(int year) {
        return (this.year % 4 == 0 && this.year % 100 != 0) || (this.year % 400 == 0);
    }

    /**
     * Calcula la diferencia en días entre dos fechas
     * @param fecha la fecha con la que se compara
     * @return la diferencia en días
     */
    public int differencebyDay(Fecha fecha) {
        int diff = 0;

        // Caso 1: Mismo año (daysPassed resuelve días y meses directamente)
        if (this.year == fecha.year) {
            diff = this.daysPassed(this.day, this.month, this.year) - fecha.daysPassed(fecha.day, fecha.month, fecha.year);
        } 
        // Caso 2: this es una fecha posterior a fecha
        else if (this.year > fecha.year) {
            // 1. Días que faltan para terminar el primer año
            int daysFirstYear;
            if (isLeapYear(fecha.year)) {
                daysFirstYear = 366;
            } else {
                daysFirstYear = 365;
            }
            diff = daysFirstYear - fecha.daysPassed(fecha.day, fecha.month, fecha.year);

            // 2. Sumar días año por año evaluando si cada año intermedio es bisiesto
            int y = fecha.year + 1;
            while (y < this.year) {
                if (isLeapYear(y)) {
                    diff = diff + 366;
                } else {
                    diff = diff + 365;
                }
                y = y + 1;
            }

            // 3. Sumar días transcurridos en el año actual
            diff = diff + this.daysPassed(this.day, this.month, this.year);
        } 
        // Caso 3: 'this' es una fecha anterior a 'fecha'
        else if (this.year < fecha.year) {
            int daysFirstYear;
            if (isLeapYear(this.year)) {
                daysFirstYear = 366;
            } else {
                daysFirstYear = 365;
            }
            diff = daysFirstYear - this.daysPassed(this.day, this.month, this.year);

            int y = this.year + 1;
            while (y < fecha.year) {
                if (isLeapYear(y)) {
                    diff = diff + 366;
                } else {
                    diff = diff + 365;
                }
                y = y + 1;
            }

            diff = diff + fecha.daysPassed(fecha.day, fecha.month, fecha.year);
        }

        return diff;

    }

    /**
     * Modifica la fecha sumando o restando un número de días
     * @param days el número de días a sumar o restar 
     */
    public void operarFecha(int days){
        if (days>=0){
            this.day+=days;
            while(this.day>30){
                this.day-=30;
                this.month++;
                if(this.month>12){
                    this.month=1;
                    this.year++;
                }
            }
        }else if(days<0){
            this.day+=days;
            while(this.day<1){
                this.day+=30;
                this.month--;
                if(this.month<1){   
                    this.month=12;
                    this.year--;
                }
            }
       }
    }

    /**
     * Compara si dos fechas son iguales
     * @param fecha la fecha con la que se compara
     * @return true si las fechas son iguales, false en caso contrario
     */
    public boolean equals(Fecha fecha){
        return this.day==fecha.day && this.month==fecha.month && this.year==fecha.year;
    }

    /**
     * Devuelve el número del mes correspondiente al nombre del mes proporcionado
     * @param name el nombre del mes
     * @return el número del mes (1-12) o 0 si el nombre no es válido
     */
    public int getMonthNumber(String name) {
        if (name.equals("enero")) return 1;
        else if (name.equals("febrero")) return 2;
        else if (name.equals("marzo")) return 3;
        else if (name.equals("abril")) return 4;
        else if (name.equals("mayo")) return 5;
        else if (name.equals("junio")) return 6;
        else if (name.equals("julio")) return 7;
        else if (name.equals("agosto")) return 8;
        else if (name.equals("septiembre")) return 9;
        else if (name.equals("octubre")) return 10;
        else if (name.equals("noviembre")) return 11;
        else if (name.equals("diciembre")) return 12;
        else return 0;
    }

    /**
     * Devuelve el nombre del mes correspondiente al número del mes proporcionado
     * @param month el número del mes (1-12)
     * @return el nombre del mes o una cadena vacía si el número no es válido
     */
    public String getMonthName(int month) {
        if (month == 1) return "enero";
        else if (month == 2) return "febrero";
        else if (month == 3) return "marzo";
        else if (month == 4) return "abril";
        else if (month == 5) return "mayo";
        else if (month == 6) return "junio";
        else if (month == 7) return "julio";
        else if (month == 8) return "agosto";
        else if (month == 9) return "septiembre";
        else if (month == 10) return "octubre";
        else if (month == 11) return "noviembre";
        else if (month == 12) return "diciembre";
        else return "";
    }

    /**
     * Calcula el número de días transcurridos desde el inicio del año hasta la fecha proporcionada
     * @param day el día de la fecha
     * @param month el mes de la fecha
     * @param year el año de la fecha
     * @return el número de días transcurridos
     */
    public int daysPassed(int day, int month, int year) {
        int diasPrevios = 0;

        if (month == 1)      diasPrevios = 0;
        else if (month == 2) diasPrevios = 31;
        else if (month == 3) diasPrevios = 59;
        else if (month == 4) diasPrevios = 90;
        else if (month == 5) diasPrevios = 120;
        else if (month == 6) diasPrevios = 151;
        else if (month == 7) diasPrevios = 181;
        else if (month == 8) diasPrevios = 212;
        else if (month == 9) diasPrevios = 243;
        else if (month == 10) diasPrevios = 273;
        else if (month == 11) diasPrevios = 304;
        else if (month == 12) diasPrevios = 334;

        int total = diasPrevios + day;
        if (isLeapYear(year) && month > 2) {
            total += 1;
        }
        return total;
    }
    
    /**
     * Calcula el número de días transcurridos desde el inicio del año hasta la fecha proporcionada
     * @param day el día de la fecha
     * @param month el nombre del mes de la fecha
     * @param year el año de la fecha
     * @return el número de días transcurridos
     */
    public int daysPassed(int day, String month, int year) {
        int monthNumber = getMonthNumber(month);
        return daysPassed(day, monthNumber, year);
    }

    /**
     * Devuelve una representación en cadena de la fecha en formato "dd/mm/yyyy"
     * @return la representación en cadena de la fecha
     */
    public String toString() {
        return day + "/" + month + "/" + year;
    }

    /**
     * Devuelve una representación en cadena de la fecha en formato "dd/mm/yyyy"
     * @param day el día de la fecha
     * @param month el nombre del mes de la fecha
     * @param year el año de la fecha
     * @return la representación en cadena de la fecha
     */
    public String toString(int day, String month, int year) {
        int monthNumber = getMonthNumber(month);
        return day + "/" + monthNumber + "/" + year;
    }

    /**
     * Método principal para probar la clase Fecha
     * @param args no tiene uso en este caso
     */
    public static void main(String[] args) {
        Fecha fecha1 = new Fecha();
        Fecha fecha2 = new Fecha(2,2,2026);
        Fecha fecha3 = new Fecha(2,"marzo",2028);
        System.out.println(fecha3.isLeapYear(fecha1.getYear()));

    }

}