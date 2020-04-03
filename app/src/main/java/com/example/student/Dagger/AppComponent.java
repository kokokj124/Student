package com.example.student.Dagger;
import android.content.Context;
import com.example.student.DataBase.StudentRepository;
import com.example.student.MainActivity;
import com.example.student.ViewModel.MainViewModel;

import javax.inject.Named;
import javax.inject.Singleton;
import dagger.BindsInstance;
import dagger.Component;
@Singleton
@Component
public interface AppComponent {
    @Component.Builder
    interface Builder{
        @BindsInstance
        Builder content(@Named("context") Context context);
        AppComponent build();
    }
    void inject(MainViewModel mainViewModel);
    void inject(MainActivity mainActivity);
}
