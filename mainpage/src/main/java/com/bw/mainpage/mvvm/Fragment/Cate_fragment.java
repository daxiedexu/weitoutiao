package com.bw.mainpage.mvvm.Fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import com.bumptech.glide.Glide;
import com.bw.http.RetrofitManger;
import com.bw.http.protocol.BaseRespEntity;
import com.bw.mainpage.BR;
import com.bw.mainpage.R;
import com.bw.mainpage.databinding.ActivityHomeBinding;
import com.bw.mainpage.mvvm.HomeActivity;
import com.bw.mainpage.mvvm.api.HomeApi;
import com.bw.mainpage.mvvm.entity.NewListEntity;
import com.bw.mainpage.mvvm.viewmodel.NewListViewModel;
import com.bw.mvvm_core.view.BaseFragment;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Cate_fragment extends BaseFragment<NewListViewModel, ActivityHomeBinding> implements OnRefreshLoadMoreListener {
    private RecyclerView cateRv;
    private SmartRefreshLayout cateSm;

    boolean refresh = false;
    int page = 1;
    Wn wn;
    int index = 0;
    int pageSize = 12;

    @Override
    protected void initEvent() {
        //View inflate=getLayoutInflater( ).inflate(R.layout.fragment_cate_fragment, null);
        cateRv = (RecyclerView) getActivity().findViewById(R.id.cate_rv);
        cateSm = (SmartRefreshLayout) getActivity().findViewById(R.id.cate_sm);
        cateSm.setOnRefreshLoadMoreListener(this);


        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL);
        cateRv.addItemDecoration(dividerItemDecoration);
        cateRv.setLayoutManager(new LinearLayoutManager(getActivity()));
        RetrofitManger.getInstance().getRetrofit().create(HomeApi.class)
                .newList(1, page, pageSize)
                .observe(getActivity(), new Observer<BaseRespEntity<List<NewListEntity>>>() {
                    @Override
                    public void onChanged(BaseRespEntity<List<NewListEntity>> newListEntity) {
                        show(newListEntity.getData());
                    }
                });

    }

    public void show(List<NewListEntity> data) {

        cateSm.finishRefresh();
        cateSm.finishLoadMore();
        for (int i = 0; i < data.size(); i++) {
            data.get(i).type = i;
        }

        if (wn == null) {
            wn = new Wn(data);
            cateRv.setAdapter(wn);
        } else {
            if (refresh) {
                wn.getData().clear();
            }
            wn.getData().addAll(data);
            wn.notifyDataSetChanged();
        }
        index = wn.getData().size();
    }

    @Override
    protected void loadData() {

    }

    @Override
    protected void prepareSetVars(HashMap<Integer, Object> mMap) {
        mMap.put(BR.viewmodel, mViewModel);
    }

    @Override
    protected NewListViewModel createViewModel() {
        return new NewListViewModel(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_cate_fragment;
    }

    @Override
    public void onLoadMore(@NonNull @NotNull RefreshLayout refreshLayout) {
        refresh = false;
        page++;
        RetrofitManger.getInstance().getRetrofit().create(HomeApi.class)
                .newList(1, page, pageSize)
                .observe(getActivity(), new Observer<BaseRespEntity<List<NewListEntity>>>() {
                    @Override
                    public void onChanged(BaseRespEntity<List<NewListEntity>> newListEntity) {
                        show(newListEntity.getData());
                    }
                });

    }

    @Override
    public void onRefresh(@NonNull @NotNull RefreshLayout refreshLayout) {
        refresh = true;
        page = 1;
        RetrofitManger.getInstance().getRetrofit().create(HomeApi.class)
                .newList(1, page, pageSize)
                .observe(getActivity(), new Observer<BaseRespEntity<List<NewListEntity>>>() {
                    @Override
                    public void onChanged(BaseRespEntity<List<NewListEntity>> newListEntity) {
                        show(newListEntity.getData());
                    }
                });
    }

    public class Wn extends BaseMultiItemQuickAdapter<NewListEntity, BaseViewHolder> {
        public Wn(@Nullable List<NewListEntity> data) {
            super(data);
            addItemType(0, R.layout.item1);
            addItemType(1, R.layout.item2);
            addItemType(2, R.layout.item3);
        }

        @Override
        protected void convert(@NotNull BaseViewHolder baseViewHolder, NewListEntity newListEntity) {

            switch (baseViewHolder.getItemViewType()) {
                case 0:
                    baseViewHolder.setText(R.id.item1_tv, newListEntity.title);
                    break;
                case 1:
                    baseViewHolder.setText(R.id.item2_tv, newListEntity.title);
                    Glide.with(getActivity()).load(newListEntity.mainimgurl).into((ImageView) baseViewHolder.findView(R.id.item2_img));
                    break;
                case 2:
                    baseViewHolder.setText(R.id.item3_tv, newListEntity.title);
                    Glide.with(getActivity()).load(newListEntity.mainimgurl).into((ImageView) baseViewHolder.findView(R.id.item3_img));
                    break;
            }
        }
    }
}