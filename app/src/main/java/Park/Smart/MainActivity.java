/******************************************************************************
 *  App: Park Smart
 *  Author: Adam Rawski
 *  Date created: 11/09/19
 *  Version 1.0
 *  Last revision: 01/25/20
 *
 *  Application to view current parking space availability and percent full
 *
 ******************************************************************************/

package Park.Smart;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import static Park.Smart.R.string.user_greeting;

public class MainActivity extends AppCompatActivity {
    private Button lotD;
    private Button lotA;
    private TextView helloTextView;

    //Set button to wait for a user to press a button to select a specific lot
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lotD = findViewById(R.id.dLot);
        lotA = findViewById(R.id.aLot);
        lotD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openlotD();
            }
        });
        lotA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setuserGreeting();
            }
        });
    }


    //When user presses the button to go to a specific lot navigate to that page
    public void openlotD() {
        Intent intent = new Intent(this, LotD.class);
        startActivity(intent);
    }
    public void setuserGreeting() {
        helloTextView = findViewById(R.id.text_view_id);
        CharSequence a = helloTextView.getText();
        helloTextView.setText(user_greeting);
    }
    }

/*<!--       _
        .__(.)< (MEOW)
        \___)
        ~~~~~~~~~~~~~~~~~~-->*/