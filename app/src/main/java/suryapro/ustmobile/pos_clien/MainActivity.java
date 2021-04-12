package suryapro.ustmobile.pos_clien;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button btnLihatMenu, btnCheckout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLihatMenu = findViewById(R.id.btnLihatMenu);
        btnCheckout = findViewById(R.id.btnCheckout);

        btnLihatMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMenu();
            }
        });

        btnCheckout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openCheckout();
            }
        });
    }
    private void openMenu() {
        Intent intent = new Intent(this, MenuActivity.class);
        startActivity(intent);
    }

    private void openCheckout() {
        Intent intent = new Intent(this, CheckoutActivity.class);
        startActivity(intent);
    }
}