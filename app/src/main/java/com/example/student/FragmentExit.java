package com.example.student;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.student.ViewModel.MainViewModel;
import com.example.student.databinding.ExitStudentBinding;
import com.example.student.model.BaseStudent;

public class FragmentExit extends Fragment {
    BaseStudent baseStudent;
    MainActivity mainActivity;

    public FragmentExit(BaseStudent baseStudent,MainActivity mainActivity) {
        this.baseStudent = baseStudent;
        this.mainActivity = mainActivity;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ExitStudentBinding exitStudentBinding = DataBindingUtil.inflate(inflater,R.layout.exit_student,container,false);
        exitStudentBinding.setStudent(baseStudent);
        exitStudentBinding.btXacNhan.setOnClickListener((v)->{
        MainViewModel mainViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        mainViewModel.editStudent(new BaseStudent(exitStudentBinding.edtSBD.getText().toString(),
                exitStudentBinding.edtHoTen.getText().toString(),
                Double.parseDouble(exitStudentBinding.edtDT.getText().toString()),
                Double.parseDouble(exitStudentBinding.edtDL.getText().toString()),
                Double.parseDouble(exitStudentBinding.edtDH.getText().toString())));
        mainActivity.getAllStudent();
        });
        return exitStudentBinding.getRoot();
    }
}
