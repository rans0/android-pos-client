package suryapro.ustmobile.pos_clien;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FinishPayment extends AppCompatActivity {
    Button menuBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finish_payment);
        menuBtn = findViewById(R.id.backMenu);
        menuBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FinishPayment.this, DaftarMenuActivity.class);
                startActivity(intent);
            }
        });
    }
}