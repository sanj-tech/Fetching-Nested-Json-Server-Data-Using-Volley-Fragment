package com.jsstech.definelabdemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private Context mContext;
    private ArrayList<ModelList> mExampleList;
    private AdapterView.OnItemClickListener mListener;

    public void setOnItemClickListener(AdapterView.OnItemClickListener listener) {
        mListener = listener;
    }

    public MyAdapter(Context context, ArrayList<ModelList> exampleList) {
        mContext = context;
        mExampleList = exampleList;
    }


//   String[] spacecrafts;
//   String[] address;

//private List<ModelList> listItems;
//    private Context context;

//    public MyAdapter(FragmentActivity listItems,String[] context) {
//        this.listItems = listItems;
//        this.context = context;
//    }

//    public MyAdapter(Context c,String[] spacecrafts,String[] address) {
//        this.c = c;
//        this.spacecrafts = spacecrafts;
//        this.address=address;
//    }
    //ArrayList<ModelList> lists;



    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent,int viewType) {
        View v= LayoutInflater.from(mContext).inflate(R.layout.iteminfo,parent,false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder,int position) {

        ModelList currentItem = mExampleList.get(position);
        String imageUrl = currentItem.getId();
        String creatorName = currentItem.getName();

//        String cityName=currentItem.getCity();
//        String contactName=currentItem.getContact();
//        String locationName=currentItem.getLocation();

//        holder.textView.setText(listItems.get(position).getId());
//        holder.textViewname.setText(listItems.get(position).getName());

        //holder.textView.setText(spacecrafts[position]);

        holder.textView.setText(creatorName);
        holder.textViewname.setText(imageUrl);

//        holder.textViewcity.setText(cityName);
//        holder.textViewContact.setText(contactName);
//        holder.textViewLocation.setText(locationName);

//       holder.textView.setText(spacecrafts[position]);
//       holder.textViewname.setText(address[position]);


       holder.itemView.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {



               Toast.makeText(mContext,"Your data saved",Toast.LENGTH_SHORT).show();
           }
       });
        holder.clickme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                view.setBackgroundResource(R.drawable.ic_fill);
                Toast.makeText(mContext,"saved",Toast.LENGTH_LONG).show();
            }
        });

//        ModelList modelList=lists.get(position);
//        holder.textView.setText(modelList.getIds());
//        holder.textViewname.setText(modelList.getNamem());

    }

    @Override
    public int getItemCount() {

        //return spacecrafts.length;
        return mExampleList.size();
    }

    public void setOnItemClickListener(Context context) {
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView,textViewcity,textViewContact,textViewLocation;
        TextView textViewname;
        Button clickme;
        TextView displaid,displayName;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            textView=itemView.findViewById(R.id.txtid);
            textViewname=itemView.findViewById(R.id.txtName);
            clickme=itemView.findViewById(R.id.btclick);
            displaid=itemView.findViewById(R.id.displayid);
            displayName=itemView.findViewById(R.id.displayName);



//            textViewcity=itemView.findViewById(R.id.txtcity);
//            textViewContact=itemView.findViewById(R.id.txtcontact);
//            textViewLocation=itemView.findViewById(R.id.txtlocation);
        }
    }
}
