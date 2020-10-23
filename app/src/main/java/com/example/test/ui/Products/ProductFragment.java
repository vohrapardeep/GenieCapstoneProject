package com.example.test.ui.Products;

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
import com.example.test.One;
import com.example.test.R;
import com.example.test.Three;
import com.example.test.Two;
import com.example.test.ui.Adapter;

import java.util.ArrayList;
import java.util.List;

public class ProductFragment extends Fragment implements Adapter.OnmyClickListener {
    public ProductFragment(){
// empty constructor required
    }
    RecyclerView recyclerView;
    List<ProductViewModel> itemList;

    private ProductViewModel productViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
            ViewGroup container, Bundle savedInstanceState) {
     View root = inflater.inflate(R.layout.fragment_home, container, false);
        recyclerView = root.findViewById(R.id.recycler);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        recyclerView.setAdapter(new Adapter(initData(),this));





        return root;
    }

    private List<ProductViewModel> initData() {
        itemList= new ArrayList<>();
        itemList.add(new ProductViewModel(R.drawable.prod1,"Bridal Make Over","1999"));
        itemList.add(new ProductViewModel(R.drawable.prod2,"Facial","150"));
        itemList.add(new ProductViewModel(R.drawable.prod3,"Hair Color","250"));
        itemList.add(new ProductViewModel(R.drawable.prod4,"Rebonding","400"));
        itemList.add(new ProductViewModel(R.drawable.prod5,"Hair Cut","50"));
   return itemList;
    }



    @Override
    public void onmyClick(int position) {

        itemList.get(position);
        if(position==0){
            Intent i = new Intent(getActivity(), One.class);
            i.putExtra("title1",""+ itemList.get(position).getName());
            i.putExtra("img1",R.drawable.prod1);
            i.putExtra("price1",itemList.get(position).getPrice());
            startActivity(i);
        }
        if(position==1){
            Intent i = new Intent(getActivity(), Two.class);
            i.putExtra("title2",""+ itemList.get(position).getName());
            i.putExtra("img2",R.drawable.prod2);
            i.putExtra("price2",itemList.get(position).getPrice());
            startActivity(i);
        }

        if(position==2){
            Intent i = new Intent(getActivity(), Three.class);
            i.putExtra("title3",""+itemList.get(position).getName());
            i.putExtra("img3",R.drawable.prod3);
            i.putExtra("price3",itemList.get(position).getPrice());
            startActivity(i);
        }
        if(position==3){
            Intent i = new Intent(getActivity(), Four.class);
            i.putExtra("title4",""+itemList.get(position).getName());
            i.putExtra("img4",R.drawable.prod4);
            i.putExtra("price4",itemList.get(position).getPrice());
            startActivity(i);
        }
        if(position==4){
            Intent i = new Intent(getActivity(), Five.class);
            i.putExtra("title5",""+itemList.get(position).getName());
            i.putExtra("img5",R.drawable.prod5);
            i.putExtra("price5",itemList.get(position).getPrice());
            startActivity(i);
        }
    }
}
