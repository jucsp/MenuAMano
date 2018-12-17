package company.handmenu.proyecto_menuamano;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import modelo.Producto;

public class AdaptadorProducto extends BaseAdapter {

    private static LayoutInflater inflater=null;

    private Context contexto;
    private ArrayList<Producto> itemsLista;

    public AdaptadorProducto(Context contexto, ArrayList<Producto> itemsLista) {
        this.contexto = contexto;
        this.itemsLista = itemsLista;

        inflater = (LayoutInflater) contexto.getSystemService(contexto.LAYOUT_INFLATER_SERVICE);
    }

    public void primeraFila(){

    }

    @Override
    public int getCount() {
        return itemsLista.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        final View view = inflater.inflate(R.layout.elemento_producto, null);

        TextView nombre = (TextView) view.findViewById(R.id.name_item_p);
        TextView precio = (TextView) view.findViewById(R.id.price_item_p);

        ImageView imagen = (ImageView) view.findViewById(R.id.img_item_p);

        nombre.setText(itemsLista.get(position).getNombre());
        precio.setText("$"+Integer.toString(itemsLista.get(position).getPrecio()));
        imagen.setImageResource(itemsLista.get(position).getImagen());

        return view;
    }
}
