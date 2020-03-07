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
        server.pull("Lot_D", new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                String output = "(java) Response is: " + response.toString();
                outputView.setText(output);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                String output = "(java) HTTP request encountered Error: " + error.getMessage();
                outputView.setText(output);
            }
        });
    }
}
