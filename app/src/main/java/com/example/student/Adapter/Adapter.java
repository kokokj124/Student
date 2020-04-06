package com.example.student.Adapter;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.example.student.model.BaseStudent;
import com.example.student.R;
import com.example.student.databinding.ViewHomeBinding;
import com.example.student.model.ConverBaseStudent;

import java.util.ArrayList;
public class Adapter extends RecyclerView.Adapter<Adapter.StudentViewHolder> {
    ArrayList<BaseStudent> arrayList;

    public Adapter(ArrayList<BaseStudent> arrayList) {
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public StudentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ViewHomeBinding viewBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.view_home,parent,false);
        return new StudentViewHolder(viewBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull StudentViewHolder holder, int position) {
        BaseStudent currentStudent = arrayList.get(position);
        holder.viewBinding.setStudent(currentStudent);
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    class StudentViewHolder extends RecyclerView.ViewHolder{
        ViewHomeBinding viewBinding;

        public StudentViewHolder(@NonNull ViewHomeBinding viewBinding) {
            super(viewBinding.getRoot());
            this.viewBinding = viewBinding;
        }
    }

    public void setListStudent(ArrayList<BaseStudent> listStudent){
        arrayList = listStudent;
        notifyDataSetChanged();
    }
}
