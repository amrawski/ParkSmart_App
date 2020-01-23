package Park.Smart;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private Button lotOne;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lotOne = findViewById(R.id.dLot);
        lotOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openlotOne();
            }
        });
    }

    public void openlotOne() {
        Intent intent = new Intent(this, LotNumber1.class);
        startActivity(intent);
    }
}