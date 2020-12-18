package com.example.test.ui.Services;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ServicesViewModel extends ViewModel {

    private MutableLiveData<String> mText;
    int image;
    String name;



    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ServicesViewModel(int image, String name) {
        this.image = image;
        this.name = name;

        mText = new MutableLiveData<>();
        mText.setValue("This is home Activity");
    }

    public LiveData<String> getText() {
        return mText;
    }
}