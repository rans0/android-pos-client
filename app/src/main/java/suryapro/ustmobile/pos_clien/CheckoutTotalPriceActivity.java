package suryapro.ustmobile.pos_clien;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CheckoutTotalPriceActivity extends AppCompatActivity {
    Button BayarBtn;
    RecyclerView ItemCheckout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout_total_price);
        ItemCheckout = findViewById(R.id.rvTotalPrice);
        ItemCheckout.setHasFixedSize(true);
        ItemCheckout.setLayoutManager(new LinearLayoutManager(this));

        BayarBtn = findViewById(R.id.btnBayar);

        BayarBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CheckoutTotalPriceActivity.this, CheckoutActivity.class);
                startActivity(intent);
            }
        });
    }
}