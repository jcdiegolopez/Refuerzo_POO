
public class Libro extends Publicacion {

    private String autor;
    private String editorial;

    public Libro(int id, String titulo, String materia, int cantidadEjemplares, String autor, String editorial) {
        super(id, titulo, materia, cantidadEjemplares);
        this.autor = autor;
        this.editorial = editorial;
    }

    public String getAutor() {
        return autor;
    }


    public String getEditorial() {
        return editorial;
    }


    public String toString() {
        return "Libro{" +
                "id=" + id +
                ", título='" + titulo + '\'' +
                ", materia='" + materia + '\'' +
                ", cantidadEjemplares=" + cantidadEjemplares +
                ", autor='" + autor + '\'' +
                ", editorial='" + editorial + '\'' +
                '}';
    }
}
