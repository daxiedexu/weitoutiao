package com.bw.mainpage.mvvm.Adapter;

import com.bw.mainpage.mvvm.entity.NewsDetailEntity;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;

import org.jetbrains.annotations.NotNull;

/**
 * @ClassName NewDetailAdapter
 * @Author 孔晨亮
 * @Date 2021/8/28 10:02
 * User: msi
 */
public class NewDetailAdapter extends BaseQuickAdapter<NewsDetailEntity.DataBean, BaseViewHolder> {
    public NewDetailAdapter(int layoutResId) {
        super(layoutResId);
    }

    @Override
    protected void convert(@NotNull BaseViewHolder baseViewHolder, NewsDetailEntity.DataBean dataBean) {

    }
}
