package com.example.renatocouto_atividade_08.ui.analiseacessibilidade;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class AnaliseAcessibilidadeViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public AnaliseAcessibilidadeViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Acessibilidade");
    }

    public LiveData<String> getText() {
        return mText;
    }
}