package com.jsstech.definelabdemo;

import android.app.ProgressDialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;


public class AllMatchesFragment extends Fragment {
    RecyclerView allmatchRecycler;
    private MyAdapter mExampleAdapter;
    private ArrayList<ModelList> mExampleList;
    private RequestQueue mRequestQueue;
    Button bt;


//    List<ModelList> listItems;
//    MyAdapter adapter;


//    public static final String TAG = "MYTAG";
//    private RequestQueue mRequestQueue;

//    private  static String[] spacecrafts={"Dr.Roy","Ap Patel","Soham","Mr. Desai","Mr.Ankit","name","name","name","name","name","hello","hi","name","name","name","name","name","name"};
//    private  static String[] address={"khopoli","mumbai","pune","ambernath","badalapur","Pune","Banglore","Thane","Vangani","name","hello","hi","name","name","name","name","name","name"};

   // private  static final String url="https://api.foursquare.com/v2/venues/search?ll=40.7484,-73.9857&oauth_token=NPKYZ3WZ1VYMNAZ2FLX1WLECAWSMUVOQZOIDBN53F3LVZBPQ&v=20180616";

    public static AllMatchesFragment newInstance(){
        AllMatchesFragment allMatchesFragment=new AllMatchesFragment();
        return allMatchesFragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,
                             Bundle savedInstanceState) {




        getActivity().setTitle("All Matches");
        mExampleList = new ArrayList<>();
        mRequestQueue = Volley.newRequestQueue(getContext());
        parseJSON();


        // Inflate the layout for this fragment
       // return inflater.inflate(R.layout.fragment_all_matches,container,false);
        View view=inflater.inflate(R.layout.fragment_all_matches,null);

        allmatchRecycler=view.findViewById(R.id.allMatchRV);
        bt=view.findViewById(R.id.btclick);

        allmatchRecycler.setLayoutManager(new LinearLayoutManager(getContext()));



        //allmatchRecycler.setAdapter(new MyAdapter(getActivity(),spacecrafts,address));

        //adapter= new MyAdapter(getContext(),lists,this);
        //listItems=new ArrayList<>();
        //adapter=new MyAdapter(getContext(),listItems,this)

        return view;

    }

    private void parseJSON() {
        ProgressDialog progressDialog=new ProgressDialog(getContext());
        progressDialog.setMessage("loading");
        progressDialog.show();

        String url="";
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET,url,null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray jsonArray = response.getJSONObject("response")
                                    .getJSONArray("venues");
                            JSONObject arra1=jsonArray.getJSONObject(0).put("contact",0);

                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject hit = jsonArray.getJSONObject(i);
                                String creatorName = hit.getString("id");
                                String imageUrl = hit.getString("name");

//                                String citys = hit.getString("city");
//                                String con = hit.getString("state");
//                                String loc = hit.getString("phone");

                                mExampleList.add(new ModelList(imageUrl,creatorName));
                            }
                            mExampleAdapter = new MyAdapter(getContext(), mExampleList);
                            allmatchRecycler.setAdapter(mExampleAdapter);
                            mExampleAdapter.setOnItemClickListener(getContext());

                            progressDialog.dismiss();
                        } catch (JSONException e) {
                            e.printStackTrace();
                            progressDialog.dismiss();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {


                error.printStackTrace();
                progressDialog.dismiss();
            }
        });
        mRequestQueue.add(request);


    }


    @NonNull
    @Override
    public String toString() {
        return "AllMatchesFragments";
    }
}