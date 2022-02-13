package com.navin.digishop.ui.main.category;

import android.app.Application;
import android.hardware.lights.LightState;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.navin.digishop.api.ApiConfig;
import com.navin.digishop.api.IService;
import com.navin.digishop.models.BaseModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CategoryViewModel extends AndroidViewModel {


    MutableLiveData<BaseModel> baseModelData;

    public CategoryViewModel(@NonNull Application application) {
        super(application);
    }


    public MutableLiveData<BaseModel> getCategories(){

        if(baseModelData== null) {

            baseModelData = new MutableLiveData<>();

            getBaseModel();
            //boro webservice ro ejra kon

        }

        return  baseModelData;

    }


    public void getBaseModel() {

        IService iService = ApiConfig.INSTANCE.getRetrofit().create(IService.class);

        iService.getCategories().enqueue(new Callback<BaseModel>() {
            @Override
            public void onResponse(Call<BaseModel> call, Response<BaseModel> response) {


                baseModelData.setValue(response.body());

            }

            @Override
            public void onFailure(Call<BaseModel> call, Throwable t) {

                baseModelData.setValue(null);

            }
        });


    }





}
