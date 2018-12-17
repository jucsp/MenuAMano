package company.handmenu.proyecto_menuamano;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import modelo.Categoria;

public class AdaptadorCategoria extends BaseAdapter {

    private static LayoutInflater inflater=null;

    private Context contexto;
    private ArrayList<Categoria> itemsLista;

    public AdaptadorCategoria(Context contexto, ArrayList<Categoria> datos){

        this.contexto = contexto;
        this.itemsLista = datos;

        //Inflamos el elemento.xml
        inflater = (LayoutInflater) contexto.getSystemService(contexto.LAYOUT_INFLATER_SERVICE);
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

    //Seteo de cada item de la lista.
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        final View view = inflater.inflate(R.layout.elemento_categoria,null);

        TextView nombre = (TextView) view.findViewById(R.id.name_item_cat);

        ImageView imagen = (ImageView) view.findViewById(R.id.image_item_cat);

        nombre.setText(itemsLista.get(position).getTitulo());
        imagen.setImageResource(itemsLista.get(position).getImagen());

        return view;
    }

}
