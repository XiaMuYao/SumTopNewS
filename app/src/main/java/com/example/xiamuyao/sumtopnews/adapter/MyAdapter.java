package com.example.xiamuyao.sumtopnews.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.xiamuyao.sumtopnews.R;

import java.util.List;
import java.util.zip.Inflater;

/**
 * ================================================
 * 作    者：夏沐尧  Github地址：https://github.com/XiaMuYaoDQX
 * 版    本：1.0
 * 创建日期： 2018/11/6
 * 描    述：
 * 修订历史：
 * ================================================
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewMyholder> {

private Context context;
private List<String> strings;

    public MyAdapter(Context context, List<String> strings) {
        this.context = context;
        this.strings = strings;
    }

    @NonNull
    @Override
    public MyViewMyholder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
View view = LayoutInflater.from(context).inflate(R.layout.item_text,null,false);
return new MyViewMyholder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewMyholder myViewMyholder, int i) {
myViewMyholder.textView.setText(strings.get(i));
    }

    @Override
    public int getItemCount() {
        return strings.size();
    }

    class MyViewMyholder extends RecyclerView.ViewHolder{

        TextView textView;
    public MyViewMyholder(@NonNull View itemView) {


        super(itemView);
textView = itemView.findViewById(R.id.item_text);

    }
}
}