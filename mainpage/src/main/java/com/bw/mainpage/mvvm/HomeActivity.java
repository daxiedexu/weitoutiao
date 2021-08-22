package com.bw.mainpage.mvvm;

import androidx.lifecycle.Observer;
import android.widget.Toast;
import com.bw.http.RetrofitManger;
import com.bw.mainpage.R;
import com.bw.mainpage.databinding.ActivityHomeBinding;
import com.bw.mainpage.mvvm.api.HomeApi;
import com.bw.mainpage.mvvm.entity.NewListEntity;
import com.bw.mainpage.mvvm.viewmodel.NewListViewModel;
import com.bw.mvvm_core.view.BaseActivity;
import java.util.HashMap;

public class HomeActivity extends BaseActivity<NewListViewModel, ActivityHomeBinding> {

    @Override
    protected void initEvent() {

    }

    @Override
    protected void prepareSetVars(HashMap<Integer, Object> mMap) {
        RetrofitManger.getInstance().getRetrofit().create(HomeApi.class)
                .newList(1,1,10)
                .observe(HomeActivity.this, new Observer<NewListEntity>() {
                    @Override
                    public void onChanged(NewListEntity newListEntity) {
                        Toast.makeText(HomeActivity.this, newListEntity.toString(), Toast.LENGTH_SHORT).show();
                    }
                });
    }

    @Override
    protected NewListViewModel createViewModel() {
        return new NewListViewModel(this);
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_home;
    }
}