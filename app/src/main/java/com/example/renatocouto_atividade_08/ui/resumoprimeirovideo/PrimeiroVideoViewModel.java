package com.example.renatocouto_atividade_08.ui.resumoprimeirovideo;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class PrimeiroVideoViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public PrimeiroVideoViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Primeiro V");
    }

    public LiveData<String> getText() {
        return mText;
    }
}