package com.example.scorpio.smshelper;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ListNumberActivity extends AppCompatActivity {

    private ListView lv;
    private String [] objects ={"1234","4321","4123","3124"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sms);
        lv = (ListView) findViewById(R.id.lv);
        lv.setAdapter(new ArrayAdapter<String>(this, R.layout.sms_item,
                R.id.tv_info, objects));
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String smsinfo = objects[position];
                Intent data = new Intent();
                data.putExtra("smsinfo", smsinfo);
                //设置数据
                setResult(1, data);
                //关闭掉当前的activity，并且回传数据 onAcrivityResult()
                finish();
            }
        });
    }
}
