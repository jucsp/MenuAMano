package company.handmenu.proyecto_menuamano;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import modelo.Producto;


public class ProductoFragment extends Fragment {

    private Producto producto;

    public ProductoFragment() {
    }

    public void getData(Producto producto){
        this.producto = producto;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_producto, container, false);

        TextView titulo = (TextView) view.findViewById(R.id.producto_h);
        TextView ingredientes = (TextView) view.findViewById(R.id.ingredientes_txt);
        TextView porciones = (TextView) view.findViewById(R.id.porciones_txt);

        ImageView imagen = (ImageView) view.findViewById(R.id.img_producto);

        titulo.setText(producto.getNombre());
        ingredientes.setText(producto.getIngredientes());
        porciones.setText(producto.getPorciones());
        System.out.println(producto.getPorciones());

        imagen.setImageResource(producto.getImagen());

        Button agregar = (Button) view.findViewById(R.id.agregar_btn);
        agregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Aqui debe llamarse a un metodo agregue el producto a la lista del carro
            }
        });

        return view;
    }

}
