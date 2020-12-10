package com.example.test.ui.Services;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.test.Five;
import com.example.test.Four;
import com.example.test.ui.ServiceOne.One;
import com.example.test.R;
import com.example.test.Three;
import com.example.test.Two;
import com.example.test.ui.Adapter;

import java.util.ArrayList;
import java.util.List;

public class ServicesFragment extends Fragment implements Adapter.OnmyClickListener {
    public ServicesFragment(){
// empty constructor required
    }
    RecyclerView recyclerView;
    List<ServicesViewModel> itemList;

    private ServicesViewModel productViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
            ViewGroup container, Bundle savedInstanceState) {
     View root = inflater.inflate(R.layout.fragment_home, container, false);
        recyclerView = root.findViewById(R.id.recycler);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(new Adapter(initData(),this));

        return root;
    }

    private List<ServicesViewModel> initData() {
        itemList= new ArrayList<>();
        itemList.add(new ServicesViewModel(R.drawable.elec,"Electrician"));
        itemList.add(new ServicesViewModel(R.drawable.plumber,"Plumber"));
        itemList.add(new ServicesViewModel(R.drawable.prod1,"Beautician"));
        itemList.add(new ServicesViewModel(R.drawable.health,"Health Instructor"));
        itemList.add(new ServicesViewModel(R.drawable.constr,"Construction Worker"));
         return itemList;
    }



    @Override
    public void onmyClick(int position) {

        itemList.get(position);
        if(position==0){
            Intent i = new Intent(getActivity(), One.class);
            i.putExtra("title1",""+ itemList.get(position).getName());
            i.putExtra("img1",R.drawable.elec);
             startActivity(i);
        }
        if(position==1){
            Intent i = new Intent(getActivity(), Two.class);
            i.putExtra("title2",""+ itemList.get(position).getName());
            i.putExtra("img2",R.drawable.plumber);
           startActivity(i);
        }

        if(position==2){
            Intent i = new Intent(getActivity(), Three.class);
            i.putExtra("title3",""+itemList.get(position).getName());
            i.putExtra("img3",R.drawable.prod1);
           startActivity(i);
        }
        if(position==3){
            Intent i = new Intent(getActivity(), Four.class);
            i.putExtra("title4",""+itemList.get(position).getName());
            i.putExtra("img4",R.drawable.health);
            startActivity(i);
        }
        if(position==4){
            Intent i = new Intent(getActivity(), Five.class);
            i.putExtra("title5",""+itemList.get(position).getName());
            i.putExtra("img5",R.drawable.constr);
           startActivity(i);
        }
    }
}
