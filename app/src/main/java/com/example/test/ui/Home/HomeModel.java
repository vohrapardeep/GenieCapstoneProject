package com.example.test.ui.Home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class HomeModel extends ViewModel {

    private MutableLiveData<String> mText;

    public HomeModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is Checkout Activity");
    }

    public LiveData<String> getText() {
        return mText;
    }
}