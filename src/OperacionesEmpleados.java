import java.util.*;
import java.util.stream.Collectors;

public class OperacionesEmpleados {

    private final List<Empleado> empleados;
    private final Scanner scanner = new Scanner(System.in);

    public OperacionesEmpleados(){
        empleados = new ArrayList<Empleado>(){
            {
                add(new Empleado(1234, "Sebas", "Alarcón", 1000.0));
                add(new Empleado(2345, "Fulano", "Pérez", 2000.0));
                add(new Empleado(2346, "Aquiles", "Vaesa", 3000.0));
            }
        };
    }

    public void agregar(){
        System.out.println("Ingrese la cédula");
        int cedula = obtenerCedula();
        existeCedula(cedula);
        System.out.println("Ingrese el nombre");
        String nombre = scanner.nextLine();
        System.out.println("Ingrese el apellido");
        String apellido = scanner.nextLine();
        System.out.println("Ingrese el salario");
        double salario = obtenerSalario();

        empleados.add(
                new Empleado(cedula, nombre, apellido, salario)
        );
    }

    private int obtenerCedula(){

        try{
            int cedula = scanner.nextInt();
            scanner.nextLine();
            return cedula;
        } catch (InputMismatchException ex) {
            scanner.nextLine();
            throw new EmpleadoException("Cédula con formato no válido");
        }
    }

    private void existeCedula(int cedula) {

        for(Empleado empleado : empleados){
            if(empleado.getId() == cedula){
                throw new EmpleadoException("Cédula " + cedula + " ya existe");
            }
        }
    }

    private boolean noExisteCedula(int cedula){

        try{
            existeCedula(cedula);
            return true;
        } catch (EmpleadoException ex){
            return false;
        }
    }

    private double obtenerSalario() {

        try{
            double salario = scanner.nextDouble();
            scanner.nextLine();
            return salario;
        } catch (InputMismatchException ex) {
            scanner.nextLine();
            throw new EmpleadoException("Salario con formato no válido");
        }
    }

    public void eliminar(){

        System.out.println("Ingrese la cédula que quiere eliminar");
        int cedula = obtenerCedula();
        if(!noExisteCedula(cedula)) {
            for (Empleado empleado : empleados) {
                if (empleado.getId() == cedula) {
                    System.out.println("Se ha eliminado al empleado " + empleado);
                    empleados.remove(empleado);
                }
            }
        } else {
            throw new EmpleadoException("La cédula " + cedula + " no existe");
        }
    }

    public void actualizar(){

        System.out.println("Ingrese la cédula que quiere actualizar");
        int cedula = obtenerCedula();
        if(!noExisteCedula(cedula)){
            int opcion = 0;
            do {
                mostrarMenuActualizar();
                try {
                    opcion = scanner.nextInt();
                } catch (InputMismatchException ex) {
                    opcion = -1;
                }
                scanner.nextLine();
                actualizarEmpleado(cedula, opcion);
            } while(opcion != 4);
        } else {
            throw new EmpleadoException("La cédula " + cedula + " no existe");
        }
    }

    private void mostrarMenuActualizar(){
        System.out.println("Elija una opción:");
        System.out.println("1. Nombre");
        System.out.println("2. Apellido");
        System.out.println("3. Salario");
        System.out.println("4. Salir");
    }

    private void actualizarEmpleado(int cedula, int opcion){

        Empleado empleadoViejo = obtenerEmpleado(cedula);
        Empleado nuevoEmpleado = null;
        if(null != empleadoViejo){
            elegirOpcionDeActualizacion(opcion, empleadoViejo, nuevoEmpleado);
        } else {
            throw new EmpleadoException("La cédula " + cedula + " no existe");
        }
    }

    private void elegirOpcionDeActualizacion(int opcion, Empleado empleadoViejo, Empleado nuevoEmpleado){

        switch (opcion){
            case 1:
                System.out.println("Ingrese el nuevo nombre");
                String nuevoNombre = scanner.nextLine();
                nuevoEmpleado = new Empleado(empleadoViejo.getId(), nuevoNombre, empleadoViejo.getApellido(), empleadoViejo.getSalario());
                break;
            case 2:
                System.out.println("Ingrese el nuevo apellido");
                String nuevoApellido = scanner.nextLine();
                nuevoEmpleado = new Empleado(empleadoViejo.getId(), empleadoViejo.getNombre(), nuevoApellido, empleadoViejo.getSalario());
                break;
            case 3:
                System.out.println("Ingrese el nuevo salario");
                double nuevoSalario = obtenerSalario();
                nuevoEmpleado = new Empleado(empleadoViejo.getId(), empleadoViejo.getNombre(), empleadoViejo.getApellido(), nuevoSalario);
                break;
            case 4:
                break;
            default:
                System.out.println("Opción no válida");
        }

        if(opcion >= 1 && opcion <= 3){
            empleados.remove(empleadoViejo);
            empleados.add(nuevoEmpleado);
        }
    }

    public void mostrar(){
        for(Empleado empleado : empleados){
            System.out.println(empleado);
        }
    }

    private Empleado obtenerEmpleado(int cedula){

        for(Empleado empleado : empleados){
            if(cedula == empleado.getId()){
                return empleado;
            }
        }

        return null;
    }

    public void mayorsalario(){//findFirst()

        List<String> empleadosconmayorsalario= empleados.stream()
                .sorted(Comparator.comparing(Empleado::getSalario,Comparator.reverseOrder()))
                .map(empleado -> empleado.getNombre()+" "+ empleado.getApellido()+" ,Salario: "+empleado.getSalario())
                .collect(Collectors.toList());
        //empleadosconmayorsalario.forEach(System.out::println);
        System.out.println(empleadosconmayorsalario.get(0));

        try { Thread.sleep(2000);
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt(); }


    }



    public void menorsalario(){  //findFirst()

        List<String> menorsalario= empleados.stream()
                .sorted(Comparator.comparing(Empleado::getSalario))
                .map(empleado -> empleado.getNombre()+" "+ empleado.getApellido()+" ,Salario: "+empleado.getSalario())
                .collect(Collectors.toList());

       // menorsalario.forEach(System.out::println);
        System.out.println(menorsalario.get(0));

        try { Thread.sleep(2000);
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt(); }


    }
    public void sumarsalarios(){

        List<String> sumaSalarios = empleados.stream()
                .filter(empleado -> empleado.getSalario()>700000)
                .map(empleado -> empleado.getNombre()+" "+ empleado.getApellido()+" " +empleado.getSalario())
                        .collect(Collectors.toList());
        sumaSalarios.forEach(System.out::println);

                //empleados.forEach(System.out::println);
        try { Thread.sleep(2000);
             } catch(InterruptedException ex) {
             Thread.currentThread().interrupt(); }


    }
    public void empleadospora(){

        for(Empleado empleado : empleados){
            System.out.println(empleado);
        }

    }
    public void empleadosmayorsalario(){

        List<String> empleadosconmayorsalario= empleados.stream()
                .sorted(Comparator.comparing(Empleado::getSalario,Comparator.reverseOrder()))
                .map(empleado -> empleado.getNombre()+" "+ empleado.getApellido()+" ,Salario: "+empleado.getSalario())
                .limit(5)
                .collect(Collectors.toList());
        empleadosconmayorsalario.forEach(System.out::println);

        try { Thread.sleep(2000);
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt(); }


    }





}
