package com.example.parksmartapipull

import android.app.DownloadManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.android.volley.toolbox.Volley
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.VolleyError
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.JsonObjectRequest
import org.json.JSONArray
import org.json.JSONObject

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // get handle for the output view where the response should be displayed
        val outputView = findViewById<TextView>(R.id.test)

        //form request using API call
        var server = ParkSmartServer(this)
        server.pull("Lot_D", Response.Listener { response ->
            //display the response from the request
            outputView.text = "(kotlin) Response is: ${response.toString()}"
        }, Response.ErrorListener { error: VolleyError ->
            outputView.text = "(kotlin) HTTP request encountered Error: ${error.message}"
        })
    }

}
