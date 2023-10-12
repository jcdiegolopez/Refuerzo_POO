public class Publicacion {
    protected int id;
    protected String titulo;
    protected String materia;
    protected int cantidadEjemplares;
    protected boolean disponible = true;

    public Publicacion(int id, String titulo, String materia, int cantidadEjemplares) {
        this.id = id;
        this.titulo = titulo;
        this.materia = materia;
        this.cantidadEjemplares = cantidadEjemplares;
    }

    public int getId() {
        return this.id;
    }

    public String getTitulo() {
        return this.titulo;
    }

    public String getMateria() {
        return this.materia;
    }

    public int getcantidadEjemplares(){
        return this.cantidadEjemplares;
    }

    public boolean getDisponible() {
        return this.disponible;
    }

    public void setDisponible(boolean disponible){
        this.disponible = disponible;
    }

    @Override
    public String toString() {
        return "Publicación{" +
                "id=" + id +
                ", título='" + titulo + '\'' +
                ", materia='" + materia + '\'' +
                ", cantidadEjemplares=" + cantidadEjemplares +
                ", disponible=" + disponible +
                '}';
    }
}
