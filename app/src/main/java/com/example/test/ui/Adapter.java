package com.example.test.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.test.R;
import com.example.test.ui.Products.ProductViewModel;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    List<ProductViewModel> itemList1;
    private OnmyClickListener mOnClickListener;
    public Adapter(List<ProductViewModel> itemList, OnmyClickListener onmyClickListener){
        this.itemList1 = itemList;
        this.mOnClickListener = onmyClickListener;
    }
    @NonNull
    @Override
    public Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rowitem,parent,false);
        ViewHolder viewHolder = new ViewHolder(view,mOnClickListener);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.ViewHolder holder, int position) {

        holder.image.setImageResource(itemList1.get(position).getImage());
        holder.tv.setText(itemList1.get(position).getName());
        holder.tvPrice.setText(itemList1.get(position).getPrice());
    }

    @Override
    public int getItemCount() {
        return itemList1.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        ImageView image;
        TextView tv,tvPrice;
        OnmyClickListener onmyClickListener;
        public ViewHolder(@NonNull View itemView, OnmyClickListener onmyClickListener) {
            super(itemView);
            image = itemView.findViewById(R.id.imgItem);
            tv = itemView.findViewById(R.id.nameItem);
            tvPrice = itemView.findViewById(R.id.txtPrice);
            this.onmyClickListener = onmyClickListener;

            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {

            onmyClickListener.onmyClick(getAdapterPosition());
        }
    }

    public interface OnmyClickListener{
        void onmyClick(int position);

    }
}
