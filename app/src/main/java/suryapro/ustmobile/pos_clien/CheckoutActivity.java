package suryapro.ustmobile.pos_clien;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import org.json.JSONException;
import org.json.JSONObject;

public class CheckoutActivity extends AppCompatActivity implements View.OnClickListener {
//    private Button buttonScan, buttonBayar;
    private TextView textViewNama;
    private IntentIntegrator intentIntegrator;
    private LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);

        textViewNama = (TextView) findViewById(R.id.textViewNama);


        linearLayout = findViewById(R.id.clickableLayout);
        linearLayout.setClickable(true);
        linearLayout.setOnClickListener(this);


    }

    private void bayar() {
        Intent intent = new Intent(this, CheckoutIntent.class);
        startActivity(intent);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if (result != null){
            if (result.getContents() == null){
                Toast.makeText(this, "Hasil tidak ditemukan", Toast.LENGTH_SHORT).show();

            }else{
                // jika qrcode berisi data
                try{
                    // converting the data json
                    JSONObject object = new JSONObject(result.getContents());
                    // atur nilai ke textviews
                    textViewNama.setText(object.getString("nama"));


                }catch (JSONException e){
                    e.printStackTrace();
                    // jika format encoded tidak sesuai maka hasil
                    // ditampilkan ke toast
//                    Toast.makeText(this, result.getContents(), Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(this, CheckoutIntent.class);
                    startActivity(intent);



                }
            }
        }else{
            super.onActivityResult(requestCode, resultCode, data);
        }
    }

    @Override
    public void onClick(View v) {
        // inisialisasi IntentIntegrator(scanQR)
        intentIntegrator = new IntentIntegrator(this);
        intentIntegrator.initiateScan();
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}