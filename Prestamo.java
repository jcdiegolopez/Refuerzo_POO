public class Prestamo {
    private int id;
    private int idCliente;
    private int idPublicacion;
    private String fechaInicio;
    private String fechaFinal;

    public Prestamo(int id, int idCliente, int idPublicacion, 
    String fechaInicio, String fechaFinal){
        this.id = id;
        this.idCliente = idCliente;
        this.idPublicacion = idPublicacion;
        this.fechaInicio = fechaInicio;
        this.fechaFinal = fechaFinal;
    }

    public int getIdPrestamo(){
        return this.id;
    }

    public int getIdCliente(){
        return this.idCliente;
    }

    public int getIdPublicacion(){
        return this.idPublicacion;
    }

    public String getFechaInicio(){
        return this.fechaInicio;
    }

    public String getFechaFinal(){
        return this.fechaFinal;
    }

    public void setFechaFinal(String fechaFinal){
        this.fechaFinal = fechaFinal;
    }

    public String toString(){
        return "Prestamo{" +
        "id=" + id +
        ", idCliente=" + idCliente +
        ", idPublicacion=" + idPublicacion +
        ", fechaPeticion='" + fechaInicio + '\'' +
        ", fechaEntrega='" + fechaFinal + '\'' +
        '}';
    }

}
