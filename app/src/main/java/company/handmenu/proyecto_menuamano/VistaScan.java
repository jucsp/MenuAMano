package company.handmenu.proyecto_menuamano;


import android.content.Intent;
import android.icu.text.AlphabeticIndex;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class VistaScan extends AppCompatActivity{

    private Button aux_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vista_scan);

        aux_btn = findViewById(R.id.aux_btn);

        aux_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), MenuLateral.class);
                startActivityForResult(intent, 0);
            }
        });
    }
}
