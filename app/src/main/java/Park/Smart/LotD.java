package Park.Smart;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.Group;

import com.android.volley.Response;
import com.android.volley.VolleyError;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class LotD extends AppCompatActivity {
private Button red;
private Button refreshPage;
private TextView spot;
private View a;

    public static List<View> findViewWithTag(ViewGroup root, Object tag){
        List<View> allViews = new ArrayList<View>();
        final int childCount = root.getChildCount();
        for(int i=0; i<childCount;i++){
            final View childView = root.getChildAt(i);
            if(childView instanceof ViewGroup){
                allViews.addAll(findViewWithTag((ViewGroup)childView, tag));
            }
            else{
                final Object tagView = childView.getTag();
                if((tagView != null && tagView.equals(tag)))
                    allViews.add(childView);
            }
        }
        return allViews;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lot_d);
        red = findViewById(R.id.buttonred);
        red.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                spotFilled();
            }
        });
        refreshPage = findViewById(R.id.refreshButton);
        refreshPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pageRefresh();
            }
        });
        try {
            Group group = findViewById(R.id.ldGroup);//bind view from xml
            int[] lotGroup = group.getReferencedIds();
           int arrLength = lotGroup.length;
           for(int i=0; i<arrLength; i++){
              int viewId = lotGroup[i];
              spot = findViewById(viewId);
              spot.setBackgroundColor(getResources().getColor(R.color.openspot));
           }

        } catch (Exception e) {

            e.printStackTrace();

        }


    }

    public void spotFilled(){

        ParkSmartServer server = new ParkSmartServer(this);
        server.pull("Lot_D", new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                try {
                    Group group = findViewById(R.id.ldGroup);//bind view from xml
                    int[] lotGroup = group.getReferencedIds();
                    int arrLength = lotGroup.length;

                    //set all the spots to unknown
                    for(int i=0; i < arrLength; i++){

                        int viewId = lotGroup[i];
                        spot = findViewById(viewId);
                        spot.setBackgroundColor(getResources().getColor(R.color.unknownspot));
                    }

                    //this will trigger the catch statement if there is no data received.
                    //it still works fine, this means that no updates are needed
                    JSONArray spaces = response.getJSONArray("Lot_D");

                    //iterate through response and update values.
                    for(int i=0; i < spaces.length(); i++) {
                        JSONObject space = spaces.getJSONObject(i);
                        
                        //get the spot to update from the "Space" field of the response
                        spot = findViewById(lotGroup[space.getInt("Space")]);

                        //Color based off of the "IsOccupied" field of the response
                        if (space.getInt("IsOccupied") == 1) {
                            spot.setBackgroundColor(getResources().getColor(R.color.takenspot));
                        }
                        else {
                            spot.setBackgroundColor(getResources().getColor(R.color.openspot));
                        }
                    }
                } catch (Exception e) {

                    e.printStackTrace();

                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                String output = "(java) HTTP request encountered Error: " + error.getMessage();
                /* PUT CODE HERE FOR IF THE HTTP REQUEST FAILS
                *
                *
                *
                *
                *
                *
                *
                *
                *
                *
                *
                *
                *
                *
                *
                *
                *
                */
            }
        });




    }
        public void spotOpen(){

            try {
                Group group = findViewById(R.id.ldGroup);//bind view from xml
                int[] lotGroup = group.getReferencedIds();
                int arrLength = lotGroup.length;
                for(int i=0; i<arrLength; i++){
                    int viewId = lotGroup[i];
                    spot = findViewById(viewId);
                    spot.setBackgroundColor(getResources().getColor(R.color.openspot));
                }

            } catch (Exception e) {

                e.printStackTrace();

            }


    }
    public void pageRefresh(){
        a = findViewById(R.id.lotD);
        Intent intent = getIntent();
        finish();
        startActivity(intent);

    }
}
