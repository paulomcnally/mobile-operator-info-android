package nd.mobileoperatorinfo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class MainActivity extends AppCompatActivity {

    OperatorObject operatorObject;

    private RecyclerView mRecyclerView ;
    private  RecyclerView . Adapter mAdapter ;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        operatorObject = Operator.info(getApplicationContext());

        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        // specify an adapter (see also next example)
        try {
            mAdapter = new MyAdapter(getDataSet());
            mRecyclerView.setAdapter(mAdapter);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        AdView mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
    }

    private JSONObject getCountryISO() throws JSONException {
         JSONObject item = new JSONObject();
        item.put("key", getString(R.string.countryISO));
        item.putOpt("value", operatorObject.getCountryISO());
        return item;
    }

    private JSONObject getMccmnc() throws JSONException {
        JSONObject item = new JSONObject();
        item.put("key", getString(R.string.mccmnc));
        item.putOpt("value", operatorObject.getMccmnc());
        return item;
    }

    private JSONObject getMcc() throws JSONException {
        JSONObject item = new JSONObject();
        item.put("key", getString(R.string.mcc));
        item.putOpt("value", operatorObject.getMcc());
        return item;
    }

    private JSONObject getMnc() throws JSONException {
        JSONObject item = new JSONObject();
        item.put("key", getString(R.string.mnc));
        item.putOpt("value", operatorObject.getMnc());
        return item;
    }

    private JSONObject getName() throws JSONException {
        JSONObject item = new JSONObject();
        item.put("key", getString(R.string.name));
        item.putOpt("value", operatorObject.getName());
        return item;
    }


    private JSONArray getDataSet() throws JSONException {
        JSONArray data = new JSONArray();
        data.put(getCountryISO());
        data.put(getMccmnc());
        data.put(getMcc());
        data.put(getMnc());
        data.put(getName());
        return data;
    }
}
