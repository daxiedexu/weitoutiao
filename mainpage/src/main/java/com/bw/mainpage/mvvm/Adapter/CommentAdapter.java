package com.bw.mainpage.mvvm.Adapter;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bw.mainpage.R;
import com.bw.mainpage.mvvm.entity.MissEntity;
import com.bw.mainpage.mvvm.entity.UserCommentEntity;
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
public class CommentAdapter extends BaseQuickAdapter<UserCommentEntity, BaseViewHolder> {

    public CommentAdapter(int layoutResId, @Nullable List<UserCommentEntity> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(@NotNull BaseViewHolder baseViewHolder, UserCommentEntity userCommentEntity) {
        baseViewHolder.setText(R.id.item_name,userCommentEntity.getUserid()+"");
        baseViewHolder.setText(R.id.item_time,userCommentEntity.getCtime());
        baseViewHolder.setText(R.id.item_content,userCommentEntity.getContent());
        baseViewHolder.setText(R.id.item_zan,userCommentEntity.getId()+"");

        Glide.with(getContext()).load(R.mipmap.ic_launcher_round).transform(new CircleCrop()).into((ImageView) baseViewHolder.getView(R.id.item_img));

    }
}
