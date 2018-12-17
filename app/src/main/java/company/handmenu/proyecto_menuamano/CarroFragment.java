package company.handmenu.proyecto_menuamano;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;


import modelo.Pedido;
import modelo.Producto;


public class CarroFragment extends Fragment {

    private Pedido pedido = new Pedido();
    private ArrayAdapter<Producto> adapter;

    public CarroFragment(){
        Producto p1 = new Producto("","Producto 1",10000,R.drawable.prod1_test);
        pedido.addProducto(p1);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final View view = inflater.inflate(R.layout.fragment_carro, container, false);

        ListView lista = (ListView) view.findViewById(R.id.listCarrito);
        adapter = new AdaptadorCarrito(this.getActivity().getApplicationContext(), pedido.getListaPedido());
        lista.setAdapter(adapter);

        FloatingActionButton delete = (FloatingActionButton) view.findViewById(R.id.delete_btn);
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i = pedido.getListaPedido().size()-1; i>=0; i--){
                    if(pedido.getListaPedido().get(i).isSelected()){
                        pedido.getListaPedido().remove(i);
                    }
                }
                adapter.notifyDataSetChanged();
            }
        });

        return view;
    }

}
