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

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private Button lotOne;
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
    }
    //When user presses the button to go to a specific lot navigate to that page
    public void openlotOne() {
        Intent intent = new Intent(this, LotNumber1.class);
        startActivity(intent);
    }
}
/*<!--       _
        .__(.)< (MEOW)
        \___)
        ~~~~~~~~~~~~~~~~~~-->*/