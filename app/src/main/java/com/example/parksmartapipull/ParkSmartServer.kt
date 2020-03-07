package com.example.parksmartapipull

import android.app.Activity
import android.util.Log
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.VolleyError
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import org.json.JSONObject

object ParkSmartServer : Activity() {
    @JvmStatic val base_URL: String = "http://lamp.engin.umd.umich.edu/~bbrauchl"
    @JvmStatic val pull_URL_ext: String = "/api/pull.php"
    @JvmStatic val queue : RequestQueue = Volley.newRequestQueue(this.applicationContext)

    @JvmOverloads
    @JvmStatic fun pull(lot: String? = "Lot_D", cb: Response.Listener<JSONObject>,
                        ecb: Response.ErrorListener? = null) {
        //create an object to hold all the data from our request
        val requestJSON = JSONObject()

        //if the lot was specified, assign its value
        if (lot != null) requestJSON.put("Lot", lot)

        val request = JsonObjectRequest(Request.Method.POST, base_URL + pull_URL_ext, requestJSON, cb,
            Response.ErrorListener { it: VolleyError ->
                Log.e("ParkSmartServer", "Error! The pull request failed!")
                if (ecb != null) ecb.onErrorResponse(it)
        })
        queue.add(request)
    }
}