package modelo;

public class Categoria {

    private String titulo, id; //Titulo de la categoria, ID de la categoria
    private int imagen;

    public Categoria(String idCategoria, String titulo, int imagen){
        this.id = idCategoria;
        this.titulo = titulo;
        this.imagen = imagen;
    }

    public String getId(){
        return  id;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getImagen() {
        return imagen;
    }
}
