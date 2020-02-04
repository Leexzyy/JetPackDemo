package com.example.viewmodelrestore;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.SavedStateViewModelFactory;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.os.PersistableBundle;

import com.example.viewmodelrestore.databinding.ActivityMainBinding;

//在后台被杀死时可以得到数值有两种方式
//第一种时使用onSaveInstanceState方法使用KEY值保存数据
//第二种使用的是ViewModel最新的方法保存数据
public class MainActivity extends AppCompatActivity {
   public final static String KEY_NUMBER = "my_number";
    ActivityMainBinding binding;
    MyViewModel myViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);
//        myViewModel =  ViewModelProviders.of(this).get(MyViewModel.class);
        //ViewModelProviders这个方法被废弃了所以需要用这个方法了
        myViewModel = new ViewModelProvider(this,new SavedStateViewModelFactory(getApplication(),this)).get(MyViewModel.class);
        binding.setData(myViewModel);
        binding.setLifecycleOwner(this);
    }
}
