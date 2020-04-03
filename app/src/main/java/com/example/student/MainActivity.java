package com.example.student;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import com.example.student.Adapter.Adapter;
import com.example.student.Dagger.AppComponent;
import com.example.student.Dagger.DaggerAppComponent;
import com.example.student.DataBase.StudentRepository;
import com.example.student.databinding.ActivityMainBindingImpl;
import com.example.student.model.BaseStudent;
import com.example.student.ViewModel.MainViewModel;
import com.example.student.databinding.ActivityMainBinding;
import java.util.ArrayList;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

    MainViewModel mainViewModel;
    Adapter adapter;
    @Inject
    StudentRepository studentRepository;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding activityMainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main);

        RecyclerView recyclerView = activityMainBinding.recycalerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);


        mainViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        adapter = new Adapter(mainViewModel.getListStudent().getValue());

        recyclerView.setAdapter(adapter);
        getAllStudent();

    }

    public void getAllStudent(){
        mainViewModel.getListStudent().observe(this, new Observer<ArrayList<BaseStudent>>() {
            @Override
            public void onChanged(ArrayList<BaseStudent> baseStudents) {
                adapter.setListStudent(baseStudents);
            }
        });
    }
}
