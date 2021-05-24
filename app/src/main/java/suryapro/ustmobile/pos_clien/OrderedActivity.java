package suryapro.ustmobile.pos_clien;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class OrderedActivity extends AppCompatActivity {

    Button backBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ordered);

        backBtn = findViewById(R.id.backMenuBtn);

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(OrderedActivity.this, DaftarMenuActivity.class);
                startActivity(intent);
            }
        });
    }
}