package com.example.viewmodelshp;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.SavedStateHandle;

/***
 *Create By Lee  On 2020-02-13
 **/
public class MyViewModel extends AndroidViewModel {
    private SavedStateHandle handle;
    private String key = getApplication().getResources().getString(R.string.data_key);
    private String shp_name = getApplication().getResources().getString(R.string.shp_name);


    public MyViewModel(@NonNull Application application, SavedStateHandle handle) {
        super(application);
        this.handle = handle;

        if (!handle.contains(key)) {
            load();
        }
    }


    //    public（全局可见） provate(私有) proteced(自己以及自己的子类可见) 空 （默认有效值是同一个包里面）
    public LiveData<Integer> getNumber() {

        return handle.getLiveData(key);
    }


    private void load() {
        SharedPreferences shp = getApplication().getSharedPreferences(shp_name, Context.MODE_PRIVATE);
        int x = shp.getInt(key, 0);

        handle.set(key, x);
    }

    void save() {
        SharedPreferences shp = getApplication().getSharedPreferences(shp_name, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = shp.edit();
        editor.putInt(key, getNumber().getValue() == null ? 0 : getNumber().getValue());
        editor.apply();
    }

    public void add(int x) {
        handle.set(key, getNumber().getValue() + x);
//        save();
    }
}
