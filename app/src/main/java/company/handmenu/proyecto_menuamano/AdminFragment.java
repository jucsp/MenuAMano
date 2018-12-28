package company.handmenu.proyecto_menuamano;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import modelo.Menu;


public class AdminFragment extends Fragment {

    private final String[] opciones = new String[3]; //Se define la cantidad de opciones
    private int[] iconos = new int[3];
    private MenuCFragment menuCFragment = new MenuCFragment();

    private Menu categorias;

    public AdminFragment(){
        opciones[0] = "Administrar secciones/categorias";
        opciones[1] = "Administrar productos";
        opciones[2] = "Vista cliente";

        iconos[0] = R.drawable.categoria;
        iconos[1] = R.drawable.prod;
        iconos[2] = R.drawable.eye;
    }

    public void setData(Menu categorias){

        this.categorias = categorias;
        menuCFragment.getMenu(categorias);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_admin, container, false);

        ListView lista = (ListView) view.findViewById(R.id.lista_admin);
        lista.setAdapter(new AdaptadorAdmin(this.getActivity().getApplicationContext(), opciones, iconos));

        final AdminCatFragment admin_cat = new AdminCatFragment();
        admin_cat.getData(categorias);
        ;
        final AdminProdFragment admin_prod = new AdminProdFragment();
        admin_prod.getData(categorias);

        final FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch(position){

                    case 0:
                        fragmentManager.beginTransaction().replace(R.id.contenedor, admin_cat).commit();
                        break;

                    case 1:
                        fragmentManager.beginTransaction().replace(R.id.contenedor, admin_prod).commit();
                        break;

                    case 2:
                        fragmentManager.beginTransaction().replace(R.id.contenedor, menuCFragment).commit();
                        break;


                }

            }
        });

        return view;
    }

}
