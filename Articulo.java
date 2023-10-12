
public class Articulo extends Publicacion {

    private String autor;

    public Articulo(int id, String titulo, String materia, int cantidadEjemplares, String autor) {
        super(id, titulo, materia, cantidadEjemplares);
        this.autor = autor;
    }

    public String getAutor() {
        return autor;
    }


    public String toString() {
        return "Articulo{" +
                "id=" + id +
                ", título='" + titulo + '\'' +
                ", materia='" + materia + '\'' +
                ", cantidadEjemplares=" + cantidadEjemplares;
    }

}

