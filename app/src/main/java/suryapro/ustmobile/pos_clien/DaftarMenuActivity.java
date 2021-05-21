package suryapro.ustmobile.pos_clien;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class DaftarMenuActivity extends AppCompatActivity {
    private RecyclerView daftarMenu;
    private FirebaseFirestore db;
    private DaftarMenuAdapter adapter;
    private List<ModelMenu>list;
    private List<ModelPesanan>listPesan;
    private Button btnCheckout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar_menu);

        daftarMenu = findViewById(R.id.daftar_menu);
        daftarMenu.setHasFixedSize(true);
        daftarMenu.setLayoutManager(new LinearLayoutManager(this));
        btnCheckout = findViewById(R.id.btnCheckout);

        btnCheckout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkout();
            };
        });

        db = FirebaseFirestore.getInstance();
        list = new ArrayList<>();
        adapter = new DaftarMenuAdapter(this, list);
        daftarMenu.setAdapter(adapter);

        listPesan = new ArrayList<>();

        showData();
        order();
    }

    private void checkout() {
        Intent intent = new Intent(this, CheckoutActivity.class);
        startActivity(intent);
    }

    private void showData() {
        db.collection("DaftarMenu").get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        list.clear();
                        for (DocumentSnapshot snapshot : task.getResult()) {
                            ModelMenu model = new ModelMenu(snapshot.getString("id"),
                                    snapshot.getString("nama"),
                                    snapshot.getString("deskripsi"),
                                    snapshot.getString("harga"));
                            list.add(model);
                        }
                        adapter.notifyDataSetChanged();
                    }
                }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(DaftarMenuActivity.this,
                        "Gagagl Mendapatkan Daftar Menu", Toast.LENGTH_SHORT).show();
            }
        });

    }
    private void order() {
        db.collection("DaftarPesanan").get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        listPesan.clear();
                        for (DocumentSnapshot snapshot : task.getResult()) {
                            ModelPesanan model = new ModelPesanan(snapshot.getString("id"),
                                    snapshot.getString("nama"),
                                    snapshot.getString("total"),
                                    snapshot.getString("status_pembayaran"));
                            listPesan.add(model);
                        }
                        adapter.notifyDataSetChanged();
                    }
                }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(DaftarMenuActivity.this,
                        "Gagagl Mendapatkan Pesanan", Toast.LENGTH_SHORT).show();
            }
        });
    }
}