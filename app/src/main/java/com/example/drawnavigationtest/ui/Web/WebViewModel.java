package com.example.drawnavigationtest.ui.Web;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class WebViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public WebViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is toast fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}