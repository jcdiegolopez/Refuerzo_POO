import java.util.ArrayList;
import java.util.Scanner;


public class Biblioteca{
        public static void main(String[] args){
            ArrayList<Cliente> clientes = new ArrayList<Cliente>();
            ArrayList<Publicacion> publicaciones = new ArrayList<Publicacion>();
            ArrayList<Prestamo>prestamos = new ArrayList<Prestamo>();
            Scanner myScanner = new Scanner(System.in);

            boolean running = true;

            while(running){
                System.out.println("1. Ingresar nuevo usuario");
                System.out.println("2. Ingresar nuevo documento");
                System.out.println("3. Realizar prestamo");
                System.out.println("4. Busqueda de documento");
                System.out.println("5. Cantidad de documentos por materia");
                System.out.println("6. Cantidad de revistas por materia");
                System.out.println("7. Libros de la biblioteca");
                System.out.println("8. Salir");
                System.out.println("Ingrese lo que desea hacer: ");

                int opt = myScanner.nextInt();

                switch (opt) {
                    case 1:
                        try {
                            clientes.add(newUser(myScanner,clientes));             
                            System.out.println("Se ha creado el usuario");
                        } catch (Exception e) {
                            System.out.println("No se ha creado el usuario");
                        }
                        break; 
                    
                    case 2:
                        try {
                            publicaciones.add(newDocument(myScanner,publicaciones));
                            System.out.println("Se ha creado el documento");
                        } catch (Exception e) {
                            System.out.println("No se ha creado el documento" + e.getMessage());
                        }
                        break;
                    case 3:
                        try {
                            System.out.println("Ingrese el id de cliente: ");
                            int idCliente = myScanner.nextInt();
                            if(clienteExiste(idCliente, clientes)){
                                System.out.println("Ingrese el id de la publicacion: ");
                                int idPublicacion = myScanner.nextInt();
                                if(documentoExiste(idPublicacion, publicaciones)){
                                    System.out.println("Ingrese la fecha inicial: ");
                                    String fechaI = myScanner.next();
                                    System.out.println("Ingrese la fecha Final: ");
                                    String fechaF = myScanner.next();
                                    int idprestamo = prestamos.size() + 1;
                                    prestamos.add(new Prestamo(idprestamo,idCliente, idPublicacion, fechaI, fechaF));
                                }else{
                                    throw new Exception("No existe un documento con este id");
                                }
                            }else{
                                throw new Exception("No existe un cliente con este id");
                            }
                            break;
                            
                        } catch (Exception e) {
                            System.out.println("No se pudo realizar el prestamo" + e.getMessage());
                        }
                        break;
                    
                    case 4:
                        try {
                            System.out.println("Ingrese el id del documento que desea buscar: ");
                            int idPub = myScanner.nextInt();
                            for(Publicacion publicacion: publicaciones){
                                if(publicacion.getId() == idPub){
                                    System.out.println(publicacion.toString());
                                    break;
                                }else{
                                    throw new Exception("No existe un documento con este id");
                                }
                            }
                        } catch (Exception e) {
                            System.out.println("No se pudo encontrar el documento, " + e.getMessage());
                        }
                        break;
                    case 5:
                        ArrayList<String> materias = new ArrayList<String>();
                        for (Publicacion documento : publicaciones) {
                            if(!materias.contains(documento.getMateria())){
                                materias.add(documento.getMateria());
                            }
                        }
                        for(String materia : materias) {
                            int cant = 0; 
                            for (Publicacion pub : publicaciones) {
                                if(pub.getMateria().equals(materia)){
                                    cant =  cant +1;
                                }
                            }
                            System.out.println("La cantida de documentos de la materia " + materia + " son: " + cant);
                        }
                        break;
                    case 6:
                        ArrayList<String> mat = new ArrayList<String>();
                        for (Publicacion documento : publicaciones) {
                            if(!mat.contains(documento.getMateria())){
                                mat.add(documento.getMateria());
                            }
                        }
                        for(String materia : mat) {
                            int cant = 0; 
                            for (Publicacion pub : publicaciones) {
                                if(pub instanceof Revista){
                                    if(pub.getMateria().equals(materia)){
                                        cant =  cant + 1;
                                    }
                                }
                            }
                            System.out.println("La cantida de revistas de la materia " + materia + " son: " + cant);
                        }
                        break;

                    case 7:
                        for (Publicacion doc : publicaciones) {
                            if(doc instanceof Libro){
                                System.out.println(doc.toString());
                            }
                            
                        }
                        break;

                    case 8:
                        running = false;
                        System.out.println("Saliendo del programa");
                        break;

                    default:
                        System.out.println("No es una opcion valida");
                        break;
                }
            }
        }
    
    



    public static boolean clienteExiste(int idCliente, ArrayList<Cliente> clientes) {
        for (Cliente cliente : clientes) {
            if(cliente.getIdCliente() == idCliente) {
                return true;
            }
        }
        return false;
    }

    public static boolean documentoExiste(int idPublicacion, ArrayList<Publicacion> publicaciones) {
        for (Publicacion publicacion : publicaciones) {
            if(publicacion.getId() == idPublicacion) {
                return true;
            }
        }
        return false;
    }

    public static Cliente newUser(Scanner myScanner,ArrayList<Cliente> clientes){
        int id = clientes.size() + 1 ;
        System.out.println("Ingrese el nombre de cliente: ");
        String nombre = myScanner.next();
        System.out.println("Ingrese la direccion de cliente: ");
        String direccion = myScanner.next();
        return new Cliente(id, nombre, direccion);   
    }

    public static Publicacion newDocument(Scanner myScanner, ArrayList<Publicacion> publicaciones) throws Exception{
        System.out.println("1. Libro");
        System.out.println("2. Revista");
        System.out.println("3. Articulo");
        System.out.println("Elija el documento de preferencia: ");
        int opt = myScanner.nextInt();

        int id = publicaciones.size() + 1 ;
        System.out.println("Ingrese el titulo del documento: ");
        String titulo = myScanner.next();
        System.out.println("Ingrese la materia del documento: ");
        String materia = myScanner.next();
        System.out.println("Ingrese la cantidad de ejemplares: ");
        int cantidad = myScanner.nextInt();

        switch (opt) {
            case 1:
                System.out.println("Ingrese el autor del libro: ");
                String autor = myScanner.next();
                System.out.println("Ingrese la editorial del libro: ");
                String editorial = myScanner.next();
                return new Libro(id, titulo, materia, cantidad, autor, editorial);
            case 2:
                System.out.println("Ingrese el año de la revista: ");
                int year = myScanner.nextInt();
                System.out.println("Ingrese el numero de la revista: ");
                int numero = myScanner.nextInt();
                return new Revista(id, titulo, materia, cantidad, year, numero);
            case 3:
                System.out.println("Ingrese el autor del libro: ");
                String aut = myScanner.next();
                return new Articulo(id, titulo, materia, cantidad, aut);
        
            default:
                throw new Exception("No es una opcion valida");
                
        }
        

        
    }
}