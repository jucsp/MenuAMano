package company.handmenu.proyecto_menuamano;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;

import modelo.Categoria;
import modelo.Menu;


public class AdminCatFragment extends Fragment {

    private Menu categorias;

    public void getData(Menu categorias){
        this.categorias = categorias;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_admin_cat, container, false);

        Spinner opciones_edit = (Spinner) view.findViewById(R.id.spin_edit);
        Spinner opciones_del = (Spinner) view.findViewById(R.id.spin_del);

        ArrayList<String> aux = new ArrayList<>();
        aux.add("Seleccionar");
        for(Categoria cat: categorias.getMenuCategorias()){
            aux.add(cat.getTitulo());
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this.getActivity().getApplicationContext(), R.layout.spinner_item, aux);

        opciones_edit.setAdapter(adapter);
        opciones_del.setAdapter(adapter);

        return view;
    }

}
