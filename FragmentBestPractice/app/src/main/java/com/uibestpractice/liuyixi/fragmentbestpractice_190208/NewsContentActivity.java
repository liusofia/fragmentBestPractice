package com.uibestpractice.liuyixi.fragmentbestpractice_190208;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by sofia on 19-2-8.
 */
//单页模式
public class NewsContentActivity extends AppCompatActivity{
    //在单页中点击title时候会启动这个activity
    public static void actionStart(Context context, String newsTitle, String newsContent){
        Intent intent = new Intent(context,NewsContentActivity.class);
        intent.putExtra("news_title",newsTitle);
        intent.putExtra("news_content",newsContent);
        context.startActivity(intent);
    }

    //如果是单页就启动一个activity
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //单页模式
        setContentView(R.layout.news_content);
        String newsTitle = getIntent().getStringExtra("news_title");
        //获取传入的新闻标题
        String newsContent = getIntent().getStringExtra("news_content");
        //获取传入的新闻内容
        //这是layout中的fragment的id
        NewsContentFragment newsContentFragment = (NewsContentFragment)getSupportFragmentManager().findFragmentById(R.id.news_content_fragment);
        newsContentFragment.refresh(newsTitle,newsContent);
    }
}
