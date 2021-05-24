package suryapro.ustmobile.pos_clien;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import org.json.JSONException;
import org.json.JSONObject;

public class CheckoutIntent extends AppCompatActivity {
    private Button btnBayar;
    private TextView textViewNama;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout_intent);
        textViewNama = (TextView) findViewById(R.id.textViewNama);

        btnBayar = findViewById(R.id.buttonBayar);

        btnBayar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bayar();
            }
        });
    }


    private void bayar() {
        Intent intent = new Intent(this, FinishPayment.class);
        startActivity(intent);
        Toast.makeText(this, "Berhasil Bayar", Toast.LENGTH_SHORT).show();
    }

}