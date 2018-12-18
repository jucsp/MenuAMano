package company.handmenu.proyecto_menuamano;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import modelo.Menu;

public class MenuLateralActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private FragmentManager fragmentManager;
    private FloatingActionButton fab;
    private CarroFragment carro = new CarroFragment();
    private MenuCFragment menuCategoria = new MenuCFragment();
    private String key = "admin";
    private Menu menu = new Menu();


    public MenuLateralActivity(){
        fragmentManager = getSupportFragmentManager();
        menuCategoria.getMenu(menu);
        menuCategoria.setData();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_lateral);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                flat(true, carro);
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        determinante(key);
    }

    /*
        Metodo para ocultar el boton flotante del carro
     */
    public void flat(boolean bool, Fragment clase){
        if(bool == true){
            fab.hide();
        }else{
            fab.show();
        }
        fragmentManager.beginTransaction().replace(R.id.contenedor, clase).commit();
    }

    public void recibirKey(String key){
        this.key = key;
    }

    public void determinante(String key){
        AdminFragment admin = new AdminFragment();
        admin.getData(menu);
        if(key == "admin"){
            flat(true, admin);
        }else{
            flat(true, menuCategoria);
        }
    }

    /*
        Metodo para indicar que hacer al presionar el boton atras
        De momento solo oculta el menu lateral
     */
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        }
        /*else {
            super.onBackPressed();
        }*/ //Con esto se evita volver a la pantalla Scanner
    }

    /*
        Metodo para indicar que hacer al presionar un elemento
        del menu lateral.
     */
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        if (id == R.id.nav_inicio) {
            determinante(key);
        } else if (id == R.id.nav_carro) {
            flat(true, carro);
        } else if (id == R.id.nav_idioma) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
