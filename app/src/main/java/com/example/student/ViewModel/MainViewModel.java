package com.example.student.ViewModel;
import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import com.example.student.Dagger.AppComponent;
import com.example.student.Dagger.DaggerAppComponent;
import com.example.student.DataBase.StudentRepository;
import com.example.student.model.BaseStudent;
import java.util.ArrayList;
import javax.inject.Inject;
public class MainViewModel extends AndroidViewModel {
    @Inject
    StudentRepository studentRepository;
    public MainViewModel(@NonNull Application application) {
        super(application);
        AppComponent component = DaggerAppComponent.builder().content(application).build();
        component.inject(this);
    }

    public LiveData<ArrayList<BaseStudent>> getListStudent(){
        return studentRepository.getListStudent();
    }
}
