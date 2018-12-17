package company.handmenu.proyecto_menuamano;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;


import modelo.Categoria;
import modelo.Producto;


public class MenuPFragment extends Fragment {

    private Producto p1, p2, p3;
    private Categoria categoria;

    private FragmentManager fragmentManager;

    private  ListView lista;

    /*
        Al igual que en las Categorias, estos platos son de prueba, falta crear un metodo que agregue
        de forma automatica los platos ingresados por el ADMIN a la categoria que corresponda.
    */
    public MenuPFragment() {
        p1 = new Producto("pizza_nap",
                "Pizza Napolitana",
                "Ing1 - Ing2 -Ing1 - Ing2 -Ing1 - Ing2 -Ing1 - Ing2 -Ing1 - Ing2 -Ing1 - Ing2 -Ing1 - Ing2 -Ing1 - Ing2 -",
                "5 Personas",
                15000,
                R.drawable.prod1_test);
        p2 = new Producto( "carbonara",
                "Espagueti a la carbonara",
                "Ing1 - Ing2 -Ing1 - Ing2 -Ing1 - Ing2 -Ing1 - Ing2 -Ing1 - Ing2 -Ing1 - Ing2 -Ing1 - Ing2 -Ing1 - Ing2 -",
                "1 Persona",
                12000,
                R.drawable.prod2_test);
        p3 = new Producto("funghi_porcini",
                "Risotto con funghi porcini",
                "Ing1 - Ing2 -Ing1 - Ing2 -Ing1 - Ing2 -Ing1 - Ing2 -Ing1 - Ing2 -Ing1 - Ing2 -Ing1 - Ing2 -Ing1 - Ing2 -",
                "1 Persona",
                11000,
                R.drawable.prod3_test);
    }

    public void setData(Categoria categoria){
        this.categoria = categoria;
        if(this.categoria.getId()=="entrada_cat"){

        }else if(this.categoria.getId()=="fondo_cat"){
            this.categoria.addProducto(p1);
            this.categoria.addProducto(p2);
            this.categoria.addProducto(p3);
        }else if(this.categoria.getId()=="postre_cat"){

        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_menu_p, container, false);

        lista = (ListView) view.findViewById(R.id.lista_plat);
        lista.setAdapter(new AdaptadorProducto(this.getActivity().getApplicationContext(), this.categoria.getListaProductos()));

        TextView title = (TextView) view.findViewById(R.id.title_p);
        title.setText(this.categoria.getTitulo());

        fragmentManager = getActivity().getSupportFragmentManager();

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Producto producto = categoria.getListaProductos().get(position);
                ProductoFragment productoFragment = new ProductoFragment();

                productoFragment.setData(producto);

                fragmentManager.beginTransaction().replace(R.id.contenedor, productoFragment).commit();
            }
        });

        return view;
    }

}
