package modelo;

public class Producto {

    private String id;
    private String nombre;
    private String ingredientes;
    private String porciones;
    private int precio;
    private int imagen;
    private boolean selected;

    public Producto(String id, String nombre, int precio, int imagen) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.imagen = imagen;
    }

    public Producto(String id, String nombre, String ingredientes, String porciones, int precio, int imagen) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.ingredientes = ingredientes;
        this.porciones = porciones;
        this.imagen = imagen;
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public int getPrecio() {
        return precio;
    }

    public String getIngredientes() {
        return ingredientes;
    }

    public String getPorciones() {
        return porciones;
    }

    public int getImagen() {
        return imagen;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }
}
