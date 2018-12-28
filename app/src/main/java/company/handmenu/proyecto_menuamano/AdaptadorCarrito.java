package company.handmenu.proyecto_menuamano;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import java.util.ArrayList;

import modelo.Producto;


public class
AdaptadorCarrito extends ArrayAdapter<Producto>{

    private final ArrayList<Producto> lista;
    private final Context context;

    public AdaptadorCarrito(Context context, ArrayList<Producto> listaProductos){
        super(context, R.layout.elemento_carro, listaProductos);
        this.context = context;
        this.lista = listaProductos;
    }

    static class ViewHolder{
        protected TextView nombre;
        protected TextView precio;
        protected CheckBox checkBox;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = null;
        if(convertView == null){ //If para la primera ves que se cargue la vista.
            LayoutInflater inflator = LayoutInflater.from(context);
            view = inflator.inflate(R.layout.elemento_carro, null);

            final ViewHolder viewHolder = new ViewHolder();
            viewHolder.nombre = (TextView) view.findViewById(R.id.name_prod);
            viewHolder.precio = (TextView) view.findViewById(R.id.precio_prod);
            viewHolder.checkBox = (CheckBox) view.findViewById(R.id.quitar_cb);

            viewHolder.checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    Producto elemento = (Producto) viewHolder.checkBox.getTag();
                    elemento.setSelected(buttonView.isChecked());
                }
            });

            view.setTag(viewHolder);
            viewHolder.checkBox.setTag(lista.get(position));

        }else{

            view = convertView;
            ((ViewHolder) view.getTag()).checkBox.setTag(lista.get(position));

        }

        ViewHolder holder = (ViewHolder) view.getTag();

        holder.nombre.setText(lista.get(position).getNombre());
        holder.precio.setText(Integer.toString(lista.get(position).getPrecio()));

        holder.checkBox.setChecked(lista.get(position).isSelected());

        return view;
    }
}
