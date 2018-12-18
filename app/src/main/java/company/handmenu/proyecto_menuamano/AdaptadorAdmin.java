package company.handmenu.proyecto_menuamano;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import modelo.Producto;

public class AdaptadorAdmin extends BaseAdapter {

    private static LayoutInflater inflater = null;

    private Context context;
    private String[] opcion;
    private int[] icon;

    public AdaptadorAdmin(Context context, String[] opcion, int[] icon) {
        this.context = context;
        this.opcion = opcion;
        this.icon = icon;

        inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return icon.length;
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

        final View view = inflater.inflate(R.layout.elemento_admin, null);

        TextView lab = (TextView) view.findViewById(R.id.menu_admin_lab);
        ImageView img = (ImageView) view.findViewById(R.id.menu_admin_icon);

        lab.setText(opcion[position]);
        img.setImageResource(icon[position]);

        return view;
    }
}
