import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {

    private final Scanner scanner = new Scanner(System.in);
    private final OperacionesEmpleados operacionesEmpleados = new OperacionesEmpleados();

    private void mostrarMenu(){

        try { Thread.sleep(1000);
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt(); }

        System.out.println("\n|-------------------------------------------------------|");
        System.out.println("|******************* EJERCICIO 3 ***********************|");
        System.out.println("|--******** DIEGO LEONARDO ALARCON MONTAÑA ***********--|");
        System.out.println("|-------------------------------------------------------|");
        System.out.println("|----------*******     MENU        *******--------------|");
        System.out.println("|-------------------------------------------------------|");
        System.out.println("|--******    DIGITE EL NUMERO QUE CORRESPONDA   ********|");
        System.out.println("|-------------------------------------------------------|");
        System.out.println("|---------  1. Agregar Empleado           --------------|");
        System.out.println("|---------  2. Eliminar Empleado por id   --------------|");
        System.out.println("|---------  3. Actualizar Empleado        --------------|");
        System.out.println("|---------  4. Mostrar todo               --------------|");
        System.out.println("|---------  5. Empleado con mayor Salario --------------|");
        System.out.println("|---------  6. Empleado con menor Salario --------------|");
        System.out.println("|---------  7. Sumar Salarios >700000     --------------|");
        System.out.println("|---------  8. Determinar el num de  em-  --------------|");
        System.out.println("|---------    pleados que empiecen por  A --------------|");
        System.out.println("|---------                                --------------|");
        System.out.println("|---------  9. Los 5 primeros empleados   --------------|");
        System.out.println("|---------     con el mayor salario       --------------|");
        System.out.println("|---------                                --------------|");
        System.out.println("|---------  10. Salir                     --------------|");
        System.out.println("|-------------------------------------------------------|");
        System.out.println("|-------------------------------------------------------|");

    }

    private void eligirOpcion(int opcion){

        switch(opcion){
            case 1:
                System.out.println("\n|-------------------------------------------------------|");
                System.out.println("|***************** Agregar Empleado ********************|");
                System.out.println("|-------------------------------------------------------|");
                try { Thread.sleep(1000);
                } catch(InterruptedException ex) {
                    Thread.currentThread().interrupt(); }

                operacionesEmpleados.agregar();
                break;
            case 2:
                System.out.println("\n|-------------------------------------------------------|");
                System.out.println("|************ Eliminar Empleado por id *****************|");
                System.out.println("|-------------------------------------------------------|");
                try { Thread.sleep(1000);
                } catch(InterruptedException ex) {
                    Thread.currentThread().interrupt(); }

                operacionesEmpleados.eliminar();
                break;
            case 3:
                System.out.println("\n|-------------------------------------------------------|");
                System.out.println("|*************** Actualizar Empleado *******************|");
                System.out.println("|-------------------------------------------------------|");
                try { Thread.sleep(1000);
                } catch(InterruptedException ex) {
                    Thread.currentThread().interrupt(); }

                operacionesEmpleados.actualizar();
                break;
            case 4:
                System.out.println("\n|-------------------------------------------------------|");
                System.out.println("|******************* Mostrar Todo **********************|");
                System.out.println("|-------------------------------------------------------|");
                try { Thread.sleep(1000);
                } catch(InterruptedException ex) {
                    Thread.currentThread().interrupt(); }

                operacionesEmpleados.mostrar();
                break;
            case 5:
                System.out.println("\n|-------------------------------------------------------|");
                System.out.println("|************ Empleado con mayor Salario ***************|");
                System.out.println("|-------------------------------------------------------|");
                try { Thread.sleep(1000);
                } catch(InterruptedException ex) {
                    Thread.currentThread().interrupt(); }

                operacionesEmpleados.mayorsalario();
                break;
            case 6:
                System.out.println("\n|-------------------------------------------------------|");
                System.out.println("|************ Empleado con menor Salario ***************|");
                System.out.println("|-------------------------------------------------------|");
                try { Thread.sleep(1000);
                } catch(InterruptedException ex) {
                    Thread.currentThread().interrupt(); }

                operacionesEmpleados.menorsalario();
                break;
            case 7:
                System.out.println("\n|-------------------------------------------------------|");
                System.out.println("|*************** Sumar Salarios >700000 ****************|");
                System.out.println("|-------------------------------------------------------|");
                try { Thread.sleep(1000);
                } catch(InterruptedException ex) {
                    Thread.currentThread().interrupt(); }

                operacionesEmpleados.sumarsalarios();
                break;
            case 8:
                System.out.println("\n|-------------------------------------------------------|");
                System.out.println("|****   Determinar el num de  empleados por A **********|");
                System.out.println("|-------------------------------------------------------|");
                try { Thread.sleep(1000);
                } catch(InterruptedException ex) {
                    Thread.currentThread().interrupt(); }

                operacionesEmpleados.empleadospora();
                break;
            case 9:
                System.out.println("\n|-------------------------------------------------------|");
                System.out.println("|******* Primeros 5 empleados con Mayor salario ********|");
                System.out.println("|-------------------------------------------------------|");
                try { Thread.sleep(1000);
                } catch(InterruptedException ex) {
                    Thread.currentThread().interrupt(); }

                operacionesEmpleados.empleadosmayorsalario();
                break;
            case 10:

                System.out.println("\n|-------------------------------------------------------|");
                System.out.println("|*******************     Salir    **********************|");
                System.out.println("|-------------------------------------------------------|");
                System.out.println("|-------           TRABAJO REALIZADO POR      ----------|");
                System.out.println("|-------      DIEGO LEONARDO ALARCON MONTAÑA   ---------|");
                System.out.println("|-------------------------------------------------------|");
                System.out.println("Adiós");
                try { Thread.sleep(1000);
                } catch(InterruptedException ex) {
                    Thread.currentThread().interrupt(); }

                break;
            default:
                System.out.println("|-------------------------------------------------------|");
                System.out.println("No elegiste una opcion valida");
        }
    }


    public void repetirMenu() {

        int opcion = 0;
        do{
            mostrarMenu();
            opcion = obtenerOpcion();
            try {
                eligirOpcion(opcion);
            }catch (EmpleadoException ex){
                System.out.println(ex.getErrorMessage());
            }
    }while(opcion != 10);
    }

    private int obtenerOpcion(){

        try {
            return scanner.nextInt();
        } catch(InputMismatchException ex) {
            scanner.nextLine();
            return -1;
        }
    }
}




