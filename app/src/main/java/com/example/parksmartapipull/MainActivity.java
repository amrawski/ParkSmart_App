package com.example.parksmartapipull;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Response;
import com.android.volley.VolleyError;

import org.json.JSONObject;

// for more reference, see https://developer.android.com/training/volley/simple
// I have included examples for both java and kotlin
public final class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView outputView = findViewById(R.id.test);

        ParkSmartServer server = new ParkSmartServer(this);
        //java8 allows you to write the callback functions as lambdas, see the notation below.
        server.pull("Lot_D", response -> {
            String output = "(java8) Response is: " + response.toString();
            outputView.setText(output);
        }, error -> {
            String output = "(java8) HTTP request encountered Error: " + error.getMessage();
            outputView.setText(output);
        });
    }
}
