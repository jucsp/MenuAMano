package modelo;

import java.util.ArrayList;

public class Menu {

    private ArrayList<Categoria> menuCategorias;

    public Menu(){
        menuCategorias = new ArrayList<>();
    }

    public ArrayList<Categoria> getMenuCategorias() {
        return menuCategorias;
    }

    public void addCategoria(Categoria categoria){
        menuCategorias.add(categoria);
    }

}
