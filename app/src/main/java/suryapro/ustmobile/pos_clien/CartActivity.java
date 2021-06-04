package suryapro.ustmobile.pos_clien;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class CartActivity extends AppCompatActivity {
    private RecyclerView daftarCart;
    private List<ModelMenu> list;
    private CartAdapter adapter;
    private List<ModelPesanan>listPesan;
    Button orderCart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        orderCart = findViewById(R.id.btnOrder);

        orderCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CartActivity.this, OrderedActivity.class);
                startActivity(intent);
            }
        });
        daftarCart = findViewById(R.id.cartMenu);
        daftarCart.setLayoutManager(new LinearLayoutManager(this));
        daftarCart.setHasFixedSize(true);
        list = new ArrayList<>();
        adapter = new CartAdapter(this, listPesan);
        daftarCart.setAdapter(adapter);
    }
}