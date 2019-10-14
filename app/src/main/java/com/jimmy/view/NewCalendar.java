package com.jimmy.view;

import android.content.Context;
import android.icu.util.Calendar;
import android.os.Build;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

import com.jimmy.R;

/**
 * 1.继承系统控件
 * 2.组合系统控件
 * 3.自定义绘制控件
 */
public class NewCalendar extends LinearLayout implements View.OnClickListener {
    private ImageView btnPre,btnNext;
    private TextView txtDate;
    private GridView gridCalendar;
    private Calendar mCurDate;

    @RequiresApi(api = Build.VERSION_CODES.N)
    public NewCalendar(Context context) {
        super(context);
        initView(context);
        mCurDate = Calendar.getInstance();
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public NewCalendar(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView(context);
        mCurDate = Calendar.getInstance();
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public NewCalendar(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mCurDate = Calendar.getInstance();
    }

    private void initView(Context context){
        LayoutInflater inflater = LayoutInflater.from(context);
        inflater.inflate(R.layout.calendar_view,this,false);

        btnPre = findViewById(R.id.btn_prev);
        btnNext = findViewById(R.id.btn_next);
//        txtDate = findViewById(R.id.calendar_week_head);
        gridCalendar = findViewById(R.id.calendar_grid);
        btnPre.setOnClickListener(this);
        btnNext.setOnClickListener(this);


    }

    public void onClick(View v){
        switch (v.getId()){
            case R.id.btn_prev:
                mCurDate.add(Calendar.MONTH,-1);
                break;
            case R.id.btn_next:
                mCurDate.add(Calendar.MONTH,1);
                break;
        }


    }
}
