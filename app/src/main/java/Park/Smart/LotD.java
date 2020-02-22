package Park.Smart;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.Group;

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

        try {
            Group group = findViewById(R.id.ldGroup);//bind view from xml
            int[] lotGroup = group.getReferencedIds();
            int arrLength = lotGroup.length;
            for(int i=0; i<arrLength; i++){
                int viewId = lotGroup[i];
                spot = findViewById(viewId);
                spot.setBackgroundColor(getResources().getColor(R.color.takenspot));
            }

        } catch (Exception e) {

            e.printStackTrace();

        }
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
