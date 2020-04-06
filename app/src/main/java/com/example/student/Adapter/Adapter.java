package com.example.student.Adapter;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.example.student.model.BaseStudent;
import com.example.student.R;
import com.example.student.databinding.ViewHomeBinding;
import java.util.ArrayList;
import java.util.Collection;

public class Adapter extends RecyclerView.Adapter<Adapter.StudentViewHolder> implements Filterable {
    ArrayList<BaseStudent> arrayList;
    ArrayList<BaseStudent> arrayListFull = new ArrayList<>();

    public Adapter(ArrayList<BaseStudent> arrayList) {
        this.arrayList = arrayList;
        this.arrayListFull.addAll(arrayList);
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
    private Filter filter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            ArrayList<BaseStudent> filterList = new ArrayList<>();
            if(constraint == null || constraint.length() == 0){
                filterList.addAll(arrayListFull);
            }
            else{
                String filterPattern = constraint.toString().toLowerCase().trim();
                for(BaseStudent x:arrayListFull){
                    if(x.SBD.toLowerCase().trim().contains(filterPattern))
                    filterList.add(x);
                }
            }
            FilterResults filterResults = new FilterResults();
            filterResults.values = filterList;
            return filterResults;
        }
        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            setListStudent((ArrayList<BaseStudent>) results.values);
        }
    };
    @Override
    public Filter getFilter() {
        return filter;
    }
    class StudentViewHolder extends RecyclerView.ViewHolder{
        ViewHomeBinding viewBinding;
        public StudentViewHolder(@NonNull ViewHomeBinding viewBinding) {
            super(viewBinding.getRoot());
            this.viewBinding = viewBinding;
        }
    }
    public void setListStudent(ArrayList<BaseStudent> listStudent){
        arrayList.clear();
        arrayList = listStudent;
        notifyDataSetChanged();
    }
}
