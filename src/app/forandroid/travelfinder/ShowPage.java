package app.forandroid.travelfinder;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class ShowPage extends Activity
{
	private Button BtnShow1;
	private Button BtnShow2;
	private TextView TextShow;
	private static StringBuffer sb = new StringBuffer(); 
	
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.show_page);
		sb = Option.get_out();
		TextShow =(TextView) findViewById(R.id.textshow);
		TextShow.setMovementMethod(ScrollingMovementMethod.getInstance());
		TextShow.setText(sb.toString());
		
		BtnShow1 = (Button) findViewById(R.id.BtnOut1);	
		BtnShow1.setOnClickListener(new OnClickListener() 
        {
			
			@Override
			public void onClick(View v) 
			{
				AlertDialog.Builder builder = new Builder(ShowPage.this);
    			builder.setMessage("已经向相关酒店发出预定");
    			builder.setTitle("提示");
    			builder.setPositiveButton("确定",
    					new android.content.DialogInterface.OnClickListener() 
    					{
    						@Override
    						public void onClick(DialogInterface arg0, int arg1) 
    						{
    							// TODO Auto-generated method stub
    							
    						}
    					});
    			builder.create().show(); 
			}
		});
		BtnShow2 = (Button)findViewById(R.id.BtnOut2);
		BtnShow2.setOnClickListener(new OnClickListener()
        {
        	@Override
        	public void onClick(View v) 
        	{
        		Option.clean();
        		Intent intent = new Intent(ShowPage.this,FirstPage.class);
        		startActivity(intent);
        		
        	}
        });	
	}
	

}
