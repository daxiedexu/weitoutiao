package com.bw.mainpage.mvvm.Adapter;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bw.mainpage.R;
import com.bw.mainpage.mvvm.entity.MissEntity;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

/**
 * @ClassName MissAdapter
 * @Author 孔晨亮
 * @Date 2021/8/31 19:32
 * User: msi
 */
public class MissAdapter extends BaseQuickAdapter<MissEntity, BaseViewHolder> {

    public MissAdapter(int layoutResId, @Nullable List<MissEntity> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(@NotNull BaseViewHolder baseViewHolder, MissEntity missEntity) {
        Glide.with(getContext()).load(R.drawable.ic_launcher_background).transform(new CircleCrop()).into((ImageView) baseViewHolder.getView(R.id.miss_head));
        Glide.with(getContext()).load(R.drawable.delete).into((ImageView) baseViewHolder.getView(R.id.miss_detel));

        addChildClickViewIds(R.id.miss_detel);
        addChildClickViewIds(R.id.miss_pay);
    }
}
