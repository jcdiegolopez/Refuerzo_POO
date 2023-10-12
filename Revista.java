
public class Revista extends Publicacion {

    private int año;
    private int numero;

    public Revista(int id, String titulo, String materia, int cantidadEjemplares, int año, int numero) {
        super(id, titulo, materia, cantidadEjemplares);
        this.año = año;
        this.numero = numero;
    }

    public int getAño() {
        return this.año;
    }


    public int getNumero() {
        return this.numero;
    }

    public String toString() {
        return "Revista{" +
                "id=" + id +
                ", título='" + titulo + '\'' +
                ", materia='" + materia + '\'' +
                ", cantidadEjemplares=" + cantidadEjemplares +
                ", disponible=" + disponible +
                ", año=" + año +
                ", número=" + numero +
                '}';
    }
}
