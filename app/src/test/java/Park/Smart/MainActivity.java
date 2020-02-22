package Park.Smart;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private Button lotOne;
    private TextView helloTextView;

    //Set button to wait for a user to press a button to select a specific lot
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
        helloTextView = findViewById(R.id.text_view_id);
        helloTextView.setText(R.string.user_greeting);
    }

    public void openlotOne() {
        Intent intent = new Intent(this, LotD.class);
        startActivity(intent);
    }
}