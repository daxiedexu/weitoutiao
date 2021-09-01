package com.bw.mainpage.mvvm.Fragment;

import android.content.Intent;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bw.http.protocol.BaseRespEntity;
import com.bw.mainpage.BR;
import com.bw.mainpage.R;
import com.bw.mainpage.databinding.HeadlineFragmentBinding;
import com.bw.mainpage.mvvm.Adapter.MissAdapter;
import com.bw.mainpage.mvvm.CommentActivity;
import com.bw.mainpage.mvvm.entity.MissEntity;
import com.bw.mainpage.mvvm.entity.UserCommentEntity;
import com.bw.mainpage.mvvm.viewmodel.CommentViewModel;
import com.bw.mvvm_core.view.BaseFragment;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemChildClickListener;
import com.chad.library.adapter.base.listener.OnItemClickListener;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @ClassName Fragment_Headline
 * @Description TODO
 * @Author 张溢通
 * @Date 2021/8/28 8:38
 * @Version 1.0
 * Created by Android Studio.
 * User: 伊莎贝拉
 */
public class Fragment_Headline extends BaseFragment<CommentViewModel, HeadlineFragmentBinding> {

    private RecyclerView headlineRv;

    @Override
    protected void initEvent() {
        headlineRv = (RecyclerView) getActivity().findViewById(R.id.headline_rv);
        mViewModel.getComment(1).observe(this, new Observer<BaseRespEntity<List<UserCommentEntity>>>() {
            @Override
            public void onChanged(BaseRespEntity<List<UserCommentEntity>> listBaseRespEntity) {
                List<UserCommentEntity> data = listBaseRespEntity.getData();
//                Log.d("123456", "onChanged: "+data.get(0).getContent());
            }
        });
        List<MissEntity> list = new ArrayList<>();
        list.add(new MissEntity());
        list.add(new MissEntity());
        list.add(new MissEntity());
        list.add(new MissEntity());
        list.add(new MissEntity());
        MissAdapter missAdapter = new MissAdapter(R.layout.item_miss, list);
        headlineRv.setAdapter(missAdapter);
        headlineRv.setLayoutManager(new LinearLayoutManager(getActivity()));
        headlineRv.addItemDecoration(new DividerItemDecoration(getActivity(),1));
        missAdapter.setOnItemChildClickListener(new OnItemChildClickListener() {
            @Override
            public void onItemChildClick(@NonNull BaseQuickAdapter adapter, @NotNull View view, int position) {
                switch (view.getId()){
                    case R.id.miss_detel:
                        missAdapter.notifyItemRemoved(position);
                    break;
                    case R.id.miss_pay:
                        Toast.makeText(getActivity(), "bbb", Toast.LENGTH_SHORT).show();

                        break;
                }
            }
        });
        missAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(@NonNull BaseQuickAdapter<?, ?> adapter,@NotNull View view, int position) {
                Intent intent = new Intent(getActivity(), CommentActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void loadData() {

    }

    @Override
    protected void prepareSetVars(HashMap<Integer, Object> mMap) {
        mMap.put(BR.WebViewModel, mViewModel);
    }

    @Override
    protected CommentViewModel createViewModel() {
        return new CommentViewModel(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.headline_fragment;
    }

    private void initView() {

    }
}
