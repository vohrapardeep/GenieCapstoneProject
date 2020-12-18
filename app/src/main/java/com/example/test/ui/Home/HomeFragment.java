package com.example.test.ui.Home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.test.R;
import com.example.test.ui.Adapter;
import com.example.test.ui.ServiceProvider.Five;
import com.example.test.ui.ServiceProvider.Four;
import com.example.test.ui.ServiceProvider.One;
import com.example.test.ui.ServiceProvider.Three;
import com.example.test.ui.ServiceProvider.Two;
import com.example.test.ui.Services.ServicesFragment;
import com.example.test.ui.Services.ServicesViewModel;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment implements Adapter.OnmyClickListener {

    private HomeModel slideshowViewModel;
    Spinner spinner_home;
    RecyclerView recyclerView;
    List<ServicesViewModel> itemList;

    Button btnServices;
    DatabaseReference databaseReference;
    ValueEventListener listener;
    ArrayAdapter<String> adapter;
    ArrayList<String> spinnerCities;

    public View onCreateView(@NonNull LayoutInflater inflater,
            ViewGroup container, Bundle savedInstanceState) {
//        slideshowViewModel =
//                ViewModelProviders.of(this).get(HomeModel.class);
        View root = inflater.inflate(R.layout.fragment_slideshow, container, false);


         spinner_home = root.findViewById(R.id.spinner_locationHome);

        databaseReference = FirebaseDatabase.getInstance().getReference("Location");
        spinnerCities = new ArrayList<>();
        adapter = new ArrayAdapter<String>(getActivity(),
                R.layout.itemcolor,spinnerCities);
        spinner_home.setAdapter(adapter);
        retreiveCities();


        btnServices=root.findViewById(R.id.btnServices);
        btnServices.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Fragment fragment = new ServicesFragment();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.nav_host_fragment, fragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });
        recyclerView = root.findViewById(R.id.homeRecycler);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(new Adapter(initData(),this));


        return root;
    }

    private List<ServicesViewModel> initData() {
        itemList= new ArrayList<>();
        itemList.add(new ServicesViewModel(R.drawable.elec,"Electrician"));
        itemList.add(new ServicesViewModel(R.drawable.plumber1,"Plumber"));


        itemList.add(new ServicesViewModel(R.drawable.fitness2,"Health Instructor"));
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
            i.putExtra("img3",R.drawable.fitness2);
            startActivity(i);
        }

    }
    public void retreiveCities(){
        listener = databaseReference.orderByPriority().addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot item:snapshot.getChildren()){
                    spinnerCities.add(item.getValue().toString());
                    spinnerCities.add("Kitchener");
                    spinnerCities.add("Waterloo");
                    spinnerCities.add("Guelph");
                    spinnerCities.add("Brantford");

                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}
