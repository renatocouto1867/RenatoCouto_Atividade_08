package com.example.renatocouto_atividade_08.ui.resumoterceirovideo;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class TerceiroVideoViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public TerceiroVideoViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("terceiro V");
    }

    public LiveData<String> getText() {
        return mText;
    }
}