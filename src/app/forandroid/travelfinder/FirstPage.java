package app.forandroid.travelfinder;
//key:YTSIItGKKms0ngn62KLF8TxS

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class FirstPage extends Activity
{

	Button BtnStart;
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.first_page);
   	
		BtnStart = (Button) findViewById(R.id.BtnStart);	
        BtnStart.setOnClickListener(new OnClickListener() 
        {
			
			@Override
			public void onClick(View v) 
			{
				Intent intent = new Intent(FirstPage.this,TimePickPage.class);
				startActivity(intent);
			}
		});
		
		
		
	}
}
