package app.forandroid.travelfinder;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class PlacePickPage extends Activity
{

	Button BtnNextPlacepick;
	Button BtnBackPlacepick;
	GridView gridView_check; //多选宫格
	ImageAdapter ia_check; //存储图片源的适配器
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.placepick_page);
		//实现GridView
		gridView_check = (GridView) findViewById(R.id.gridview_check);
		ia_check = new ImageAdapter(this, true);
		gridView_check.setAdapter(ia_check);
		// 设置点击监听
		gridView_check.setOnItemClickListener(new OnItemClickListener() 
		{
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1,int position, long arg3) 
			{
				// TODO Auto-generated method stub
				ia_check.changeState(position);
			}
		});

		
		BtnNextPlacepick = (Button) findViewById(R.id.BtnNextPlacepick);	
		BtnNextPlacepick.setOnClickListener(new OnClickListener() 
		{
					
			@Override
			public void onClick(View v) 
			{
				
				int flag = 0;
				for(int i=0;i<16;i++)
				{
					if(ia_check.mImage_bs.elementAt(i))
					{
						flag++;
					}
				}
				if(flag == 0)
				{
					Toast.makeText(getApplicationContext(), "你必须选择景点", Toast.LENGTH_SHORT).show();
				}
				else
				{
					Option.set_place_select(ia_check.mImage_bs);
					Intent intent = new Intent(PlacePickPage.this,MoneyPickPage.class);
					startActivity(intent);	
				}
						
			}
		});
		BtnBackPlacepick = (Button)findViewById(R.id.BtnBackPlacepick);
		BtnBackPlacepick.setOnClickListener(new OnClickListener()
		{
		      @Override
		      public void onClick(View v) 
		      {
		    	  Intent intent = new Intent(PlacePickPage.this,TimePickPage.class);
		    	  startActivity(intent);
		        		
		       }
		  });	

		
		
		
	}
}
