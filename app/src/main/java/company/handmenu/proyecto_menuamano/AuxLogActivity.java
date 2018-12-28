package company.handmenu.proyecto_menuamano;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class AuxLogActivity extends AppCompatActivity {

    private Button btn_admin;
    private Button btn_user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aux_log);

        btn_admin = (Button) findViewById(R.id.admin_btn);
        btn_user =  (Button) findViewById(R.id.user_btn);

        btn_admin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), MenuLateralActivity.class);
                intent.putExtra("key","admin");
                startActivityForResult(intent, 0);
            }
        });

        btn_user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), ScanActivity.class);
                startActivityForResult(intent, 0);
            }
        });
    }
}
