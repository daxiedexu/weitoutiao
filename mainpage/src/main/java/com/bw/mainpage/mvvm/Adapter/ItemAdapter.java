package com.bw.mainpage.mvvm.Adapter;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bw.mainpage.R;
import com.bw.mainpage.mvvm.entity.NewListEntity;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

/**
 * @ClassName ItemAdapter
 * @Description TODO
 * @Author 张溢通
 * @Date 2021/8/26 16:02
 * @Version 1.0
 * Created by Android Studio.
 * User: 伊莎贝拉
 */
public class ItemAdapter extends BaseMultiItemQuickAdapter<NewListEntity, BaseViewHolder> {

        public ItemAdapter(@Nullable List<NewListEntity> data) {
            super(data);
            addItemType(0, R.layout.item1);
            addItemType(1,R.layout.item2);
            addItemType(2,R.layout.item3);
        }

        @Override
        protected void convert(@NotNull BaseViewHolder baseViewHolder, NewListEntity newListEntity) {

            switch (baseViewHolder.getItemViewType()){
                case 0:
                    baseViewHolder.setText(R.id.item1_tv,newListEntity.title);
                    break;
                case 1:
                    baseViewHolder.setText(R.id.item2_tv,newListEntity.title);
                    Glide.with(getContext()).load(newListEntity.mainimgurl).into((ImageView) baseViewHolder.findView(R.id.item2_img));
                    break;
                case 2:
                    baseViewHolder.setText(R.id.item3_tv,newListEntity.title);
                    Glide.with(getContext()).load(newListEntity.mainimgurl).into((ImageView) baseViewHolder.findView(R.id.item3_img));
                    break;
            }
        }
}
