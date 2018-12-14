package company.handmenu.proyecto_menuamano;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import modelo.AdaptadorCategoria;
import modelo.Categoria;

import java.util.ArrayList;


public class MenuCFragment extends Fragment {

    private ListView lista;

    private ArrayList<Categoria> itemsLista = new ArrayList<>();


    /* Este constructor es de testeo, cuando el Admin desee agregar nuevas categorias habra
    que modificarlo de modo que funcione de forma dinamica.
     */
    public MenuCFragment(){
        Categoria c1 = new Categoria("entrada_cat","Entradas", R.drawable.entrada_test);
        Categoria c2 = new Categoria("fondo_cat", "Fondos", R.drawable.fondo_test);
        Categoria c3 = new Categoria("postre_cat", "Postres", R.drawable.postre_test);
        this.itemsLista.add(c1);
        this.itemsLista.add(c2);
        this.itemsLista.add(c3);
        this.itemsLista.add(c1);
        this.itemsLista.add(c2);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_menu_c, container, false);

        lista = (ListView) view.findViewById(R.id.lista_cat);
        lista.setAdapter(new AdaptadorCategoria(this.getActivity().getApplicationContext(), itemsLista));

        return view;
    }

}
