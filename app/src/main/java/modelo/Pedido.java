package modelo;

import java.util.ArrayList;

public class Pedido {

    private int costoTotal;
    private ArrayList<Producto> listaPedido = new ArrayList<>();
    private int nroMesa;

    public void addProducto(Producto producto){
        listaPedido.add(producto);
    }

    public void suprProducto(Producto producto){
        listaPedido.remove(producto);
    }

    public ArrayList<Producto> getListaPedido(){
        return listaPedido;
    }

}
