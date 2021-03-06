package com.bw.mainpage.mvvm.Fragment;

import android.content.Intent;
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
import android.view.ViewStub;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import com.bumptech.glide.Glide;
import com.bw.http.RetrofitManger;
import com.bw.http.protocol.BaseRespEntity;
import com.bw.mainpage.BR;
import com.bw.mainpage.R;
import com.bw.mainpage.databinding.ActivityHomeBinding;
import com.bw.mainpage.mvvm.Adapter.ItemAdapter;
import com.bw.mainpage.mvvm.HomeActivity;
import com.bw.mainpage.mvvm.WebActivity;
import com.bw.mainpage.mvvm.api.HomeApi;
import com.bw.mainpage.mvvm.entity.NewListEntity;
import com.bw.mainpage.mvvm.entity.NewsDetailEntity;
import com.bw.mainpage.mvvm.viewmodel.NewListViewModel;
import com.bw.mvvm_core.view.BaseFragment;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class Cate_fragment extends BaseFragment<NewListViewModel, ActivityHomeBinding> implements OnRefreshLoadMoreListener, OnItemClickListener {
    private RecyclerView cateRv;
    private SmartRefreshLayout cateSm;

    boolean refresh = false;
    int page = 1;
    int index = 0;
    int pageSize = 12;
    ItemAdapter wn;
    NewsDetailEntity.DataBean data;
    private TextView cateTz;


    @Override
    protected void initEvent() {

        cateRv = (RecyclerView) getActivity().findViewById(R.id.cate_rv);
        cateSm = (SmartRefreshLayout) getActivity().findViewById(R.id.cate_sm);
        cateSm.setOnRefreshLoadMoreListener(this);

        cateTz = (TextView) getActivity().findViewById(R.id.cate_tz);



        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL);
        cateRv.addItemDecoration(dividerItemDecoration);
        cateRv.setLayoutManager(new LinearLayoutManager(getActivity()));

        getNet();
    }

    private void getNet() {
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
        cateSm.finishLoadMore();
        if(refresh){
            cateSm.finishRefresh();
            cateTz.setVisibility(View.VISIBLE);
            Timer timer=new Timer( );
            timer.schedule(new TimerTask( ) {
                @Override
                public void run() {
                    Handler handler=new Handler(Looper.getMainLooper( ));
                    handler.post(new Runnable( ) {
                        @Override
                        public void run() {
                            cateTz.setVisibility(View.GONE);
                        }
                    });

                }
            },3000);
        }

        for (int i=0; i < data.size( ); i++) {
            data.get(i).type=i;
        }

        if(wn==null){
            wn=new ItemAdapter(data);
            cateRv.setAdapter(wn);
            wn.setOnItemClickListener(this::onItemClick);
        }else {
            if(refresh){
                wn.getData().clear();
            }
            wn.getData().addAll(data);
            wn.notifyDataSetChanged();
        }
        index=wn.getData().size();


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



        getNet();

    }

    @Override
    public void onRefresh(@NonNull @NotNull RefreshLayout refreshLayout) {

        refresh = true;
        page = 1;

        getNet();

    }

    @Override
    public void onItemClick(@NonNull BaseQuickAdapter<?, ?> adapter, @NonNull View view, int position) {
        NewListEntity item=(NewListEntity) adapter.getItem(position);

        String newscode = item.newscode;

        Intent intent=new Intent(getActivity(), WebActivity.class);
        intent.putExtra("newscode",newscode);
        startActivity(intent);
//        RetrofitManger.getInstance().getRetrofit().create(HomeApi.class)
//                .newsdeta(item.newscode)
//                .observe(getActivity( ), new Observer<NewsDetailEntity>( ) {
//
//                    @Override
//                    public void onChanged(NewsDetailEntity newsDetailEntity) {
//                        Log.i("123", "onChanged:++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ ");
//                        Toast.makeText(getActivity(), "cg", Toast.LENGTH_SHORT).show( );
//
////                        data=newsDetailEntity.data;
////                        if(newsDetailEntity.code==200){
////                            Intent intent=new Intent(getActivity(), WebActivity.class);
////                            Bundle bundle=new Bundle( );
////                            bundle.putParcelable("newsDetail",data);
////                            intent.putExtras(bundle);
////                            startActivity(intent);
////
////                        }
//                    }
//                });
    }



}