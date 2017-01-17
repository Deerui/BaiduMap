package com.example.sdr123.test_map;

import android.os.Bundle;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.location.LocationListener;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import java.util.ArrayList;
import android.app.Activity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.location.BDNotifyListener;//假如用到位置提醒功能，需要import该类
import com.baidu.location.Poi;
import com.baidu.location.LocationClient;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.MapStatusUpdate;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.MyLocationData;
import com.baidu.mapapi.model.LatLng;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by sdr123 on 2016/10/25.
 */
public class M1 extends Activity{
    private Button btn;
    private EditText phoneEt,contextEt;
    private OnClickListener listener = new OnClickListener(){
        @Override
        public void onClick(View v) {
            String phone = phoneEt.getText().toString();
            String context = contextEt.getText().toString();
            SmsManager manager = SmsManager.getDefault();
            ArrayList<String> list = manager.divideMessage(context);  //因为一条短信有字数限制，因此要将长短信拆分
            for(String text:list){
                manager.sendTextMessage(phone, null, text, null, null);
            }
            Toast.makeText(getApplicationContext(), "发送完毕", Toast.LENGTH_SHORT).show();
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.duanxin);
        btn = (Button)this.findViewById(R.id.btn_dialog_ok);
        phoneEt = (EditText)this.findViewById(R.id.txt_friend_name);
        contextEt = (EditText)this.findViewById(R.id.txt_friend_number);
        btn.setOnClickListener(listener);
    }
}
