package com.bw.usercenter.mvvm.repository;

import androidx.lifecycle.LiveData;
import com.bw.mvvm_core.model.Model;
import com.bw.mvvm_core.repository.BaseRepository;
import com.bw.usercenter.mvvm.entity.LoginEntity;
import com.bw.usercenter.mvvm.entity.RegisterEntity;
import com.bw.usercenter.mvvm.model.net.LoginNetModel;
import com.bw.usercenter.mvvm.model.net.RegisterNetModel;

/**
 * @ClassName UserRepository
 * @Description TODO
 * @Author 张海旭
 * @Date 2021/8/20 15:41
 * @Version 1.0
 * Created by Android Studio.
 * User: 张海旭
 */
public class UserRepository extends BaseRepository {
    @Model
    LoginNetModel loginNetModel;
    @Model
    RegisterNetModel registerNetModel;
    public LiveData<LoginEntity> login(LoginEntity loginEntity){
        return loginNetModel.login(loginEntity);
    }
    public LiveData<RegisterEntity> register(RegisterEntity registerEntity){
        return registerNetModel.register(registerEntity);
    }
}
