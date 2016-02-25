package com.itheima.dail;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
       Button bt_dail = (Button)findViewById(R.id.button1);
       bt_dail.setOnClickListener(new MyListener());
       
    }

    private class MyListener implements OnClickListener{

		@Override
		/*
		 * 当按钮被点击的时候调用的方法
		 * */
		public void onClick(View v) {
			EditText et_number = (EditText) MainActivity.this.findViewById (R.id.editText1);
			String number = et_number.getText().toString();
			//意图   打算去干的一件事
			Intent intent = new Intent();
			intent.setAction(intent.ACTION_CALL);
			//uri统一资源标示符      url统一资源定位符
			intent.setData(Uri.parse("tel:"+number));
			
			startActivity(intent);
		}
    	
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
