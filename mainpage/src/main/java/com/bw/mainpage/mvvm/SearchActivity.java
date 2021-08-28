package com.bw.mainpage.mvvm;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bw.mainpage.R;
import com.bw.mainpage.mvvm.customview.LineGroup;

public class SearchActivity extends AppCompatActivity {

    private EditText searchEdit;
    private TextView searchText;
    private LineGroup searchLine;
    String edit_text;
    private ImageView searchDel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        initView();

        searchText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edit_text = searchEdit.getText().toString();
//                LinearLayout.LayoutParams layoutParams= new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
//
//
//                MyBtnView myBtnView = new MyBtnView(SearchActivity.this);
//                myBtnView.setText(edit_text);
//                myBtnView.setLayoutParams(layoutParams);
//
//                searchLine.addView(myBtnView);
                searchLine.addViews(edit_text);


            }
        });
        searchDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchLine.removeAllViews();
            }
        });

    }

    private void initView() {
        searchEdit = (EditText) findViewById(R.id.search_edit);
        searchText = (TextView) findViewById(R.id.search_text);
        searchLine = (LineGroup) findViewById(R.id.search_line);
        searchDel = (ImageView) findViewById(R.id.search_del);
    }
}