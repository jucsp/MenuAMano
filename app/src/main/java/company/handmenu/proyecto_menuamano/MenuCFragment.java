package company.handmenu.proyecto_menuamano;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import modelo.Categoria;
import modelo.Menu;



public class MenuCFragment extends Fragment {

    private ListView lista;

    private final Menu menu = new Menu();

    private FragmentManager fragmentManager;


    /* Este constructor es de testeo, cuando el Admin desee agregar nuevas categorias habra
    que modificarlo de modo que funcione de forma dinamica.
     */
    public MenuCFragment(){
        Categoria c1 = new Categoria("entrada_cat","Entradas", R.drawable.entrada_test);
        Categoria c2 = new Categoria("fondo_cat", "Fondos", R.drawable.fondo_test);
        Categoria c3 = new Categoria("postre_cat", "Postres", R.drawable.postre_test);
        menu.addCategoria(c1);
        menu.addCategoria(c2);
        menu.addCategoria(c3);
        menu.addCategoria(c1);
        menu.addCategoria(c2);
        menu.addCategoria(c3);
        menu.addCategoria(c1);
        menu.addCategoria(c2);
        menu.addCategoria(c3);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_menu_c, container, false);

        lista = (ListView) view.findViewById(R.id.lista_cat);
        lista.setAdapter(new AdaptadorCategoria(this.getActivity().getApplicationContext(), menu.getMenuCategorias()));

        fragmentManager = getActivity().getSupportFragmentManager();

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Categoria categoria = menu.getMenuCategorias().get(position);
                MenuPFragment listaProducto = new MenuPFragment();

                listaProducto.setData(categoria);

                fragmentManager.beginTransaction().replace(R.id.contenedor, listaProducto).commit();
            }
        });

        return view;
    }

}
