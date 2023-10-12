
public class Cliente {
    private int idCliente;
    private String nombre;
    private String direccion;
    private int cantidadPrestamos;

    public Cliente(int idCliente, String nombre, String direccion){
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.direccion = direccion;
        this.cantidadPrestamos = 0;

    }

    public int getIdCliente(){
        return this.idCliente;
    }

    public String getNombre(){
        return this.nombre;
    }

    public String getDireccion(){
        return this.direccion;
    }

    public int getCantidadPrestamos(){
        return this.cantidadPrestamos;
    }

    public void setCantidadPrestamos(int cantidadPrestamos) {
        this.cantidadPrestamos = cantidadPrestamos;
    }


}
