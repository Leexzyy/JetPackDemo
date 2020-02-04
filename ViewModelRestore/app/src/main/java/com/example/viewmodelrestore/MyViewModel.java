package com.example.viewmodelrestore;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;

/***
 *Create By Lee  On 2020-02-04
 **/
public class MyViewModel extends ViewModel {
//    private MutableLiveData<Integer> number;
    //这个变量是新加androidx.lifecycle:lifecycle-viewmodel-savedstate:1.0.0-rc03里面的
    private SavedStateHandle handle;
    public MyViewModel (SavedStateHandle handle){
        this.handle = handle;
    }

    public MutableLiveData<Integer> getNumber() {
        //判断handle里面是否包含这个Key 如果不包含的话 初始化这个KEY的值为0 这个是发生在程序第一次加载入内存时
        if ( !handle .contains(MainActivity.KEY_NUMBER)){
            handle.set(MainActivity.KEY_NUMBER,0);

        }
        return handle.getLiveData(MainActivity.KEY_NUMBER);
//        if (number == null){
//            number = new MutableLiveData<>();
//            number.setValue(0);
//        }
//        return number;
    }
    public void add(){
//        number.setValue(number.getValue() +1);
        getNumber().setValue(getNumber().getValue()+1);

    }
}
