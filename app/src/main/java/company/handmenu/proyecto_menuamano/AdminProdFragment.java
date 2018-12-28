package company.handmenu.proyecto_menuamano;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;

import modelo.Categoria;
import modelo.Menu;
import modelo.Producto;


public class AdminProdFragment extends Fragment {

    private Menu categorias;
    private Categoria productos;
    private ArrayAdapter<String> adapter;
    private ArrayAdapter<String> adapter2;
    private ArrayList<String> aux2;

    public void getData(Menu categorias){

        this.categorias = categorias;

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_admin_prod, container, false);

        Spinner spin_cat = (Spinner) view.findViewById(R.id.spin_select);
        Spinner spin_prod = (Spinner) view.findViewById(R.id.spin_del_prod);
        Spinner spin_edit = (Spinner) view.findViewById(R.id.spin_edit_prod);

        final ArrayList<String> aux = new ArrayList<>();
        aux.add("Seleccionar");
        for(Categoria cat: categorias.getMenuCategorias()){
            aux.add(cat.getTitulo());
        }

        aux2 = new ArrayList<>();
        aux2.add("Seleccionar");

        adapter = new ArrayAdapter<>(this.getActivity().getApplicationContext(), R.layout.spinner_item, aux);
        adapter2 = new ArrayAdapter<>(this.getActivity().getApplicationContext(), R.layout.spinner_item, aux2);

        spin_cat.setAdapter(adapter);
        spin_prod.setAdapter(adapter2);
        spin_edit.setAdapter(adapter2);

        spin_cat.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                for(Categoria catAux : categorias.getMenuCategorias()){
                    if(catAux.getTitulo().equals(aux.get(position))){
                        productos = catAux;
                    }
                }

                if(position!=0){

                    aux2.clear();
                    aux2.add("Seleccionar");
                    for(Producto prod: productos.getListaProductos()){
                        aux2.add(prod.getNombre());
                    }
                }

                adapter2.notifyDataSetChanged();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        return view;
    }

}
