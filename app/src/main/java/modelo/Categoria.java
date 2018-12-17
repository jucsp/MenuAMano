package modelo;

import java.util.ArrayList;

public class Categoria {

    private String titulo;
    private String id;
    private ArrayList<Producto> listaProductos;
    private int imagen;


    public Categoria(String idCategoria, String titulo, int imagen){
        this.id = idCategoria;
        this.titulo = titulo;
        this.imagen = imagen;
        listaProductos = new ArrayList<>();
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

    public void addProducto(Producto producto){
        listaProductos.add(producto);
    }

    public ArrayList<Producto> getListaProductos() {
        return listaProductos;
    }
}
