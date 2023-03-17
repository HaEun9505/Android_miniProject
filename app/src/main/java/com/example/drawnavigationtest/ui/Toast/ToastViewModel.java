package com.example.drawnavigationtest.ui.Toast;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ToastViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public ToastViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is toast fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}