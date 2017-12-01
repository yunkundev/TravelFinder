package app.forandroid.travelfinder;

import java.util.Calendar;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

public class TimePickPage extends Activity implements OnTouchListener
{
	 	private EditText etStartTime; 
	    private EditText etEndTime; 
		Button BtnNextTimepick;
		Button BtnBackTimepick;
	    static int[]map={31,29,31,30,31,30,31,31,30,31,30,31};
		static int styear=0;
        static int stmonth=0;
        static int stday=0;
        static int edyear=0;
        static int edmonth=0;
        static int edday=0;
        static int t;
	    @Override 
	    public void onCreate(Bundle savedInstanceState) 
	    { 
	        super.onCreate(savedInstanceState); 
	        setContentView(R.layout.timepick_page); 
	        
	        // TODO Auto-generated method stub
			super.onCreate(savedInstanceState);
			setContentView(R.layout.timepick_page);
			
	        BtnNextTimepick = (Button) findViewById(R.id.BtnNextTimepick);	
	        BtnNextTimepick.setOnClickListener(new OnClickListener() 
	        {
				
				@Override
				public void onClick(View v) 
				{	
					String time_start = etStartTime.getText().toString();
					String time_end = etEndTime.getText().toString();
					System.out.println(time_start);
					System.out.println(time_end);
					if(time_start.length()<1||time_end.length()<1)
					{
						Toast.makeText(getApplicationContext(), "你还未选择开始和结束日期", Toast.LENGTH_SHORT).show();
					}
					else
					{
						Option.set_start_time(time_start);
						Option.set_end_time(time_end);
						t=0;
						//计算所需时间
						if(edyear == styear+1 && edmonth == 1 && stmonth == 12)
						{
							t=(edday-stday)+31+1;
						}
						else
						{
							t=(edmonth-stmonth)*map[stmonth-1]+(edday-stday)+1;
						}
						if(t<0||t>10)
						{
							Toast.makeText(getApplicationContext(), "你需要选择一个1~10天的时间段", Toast.LENGTH_SHORT).show();
						}
						else
						{
							Option.set_date(t);
							Option.print_date();
							Intent intent = new Intent(TimePickPage.this,PlacePickPage.class);
							startActivity(intent);
						}	
					}
					
				}
			});
	        BtnBackTimepick = (Button)findViewById(R.id.BtnBackTimepick);
	        BtnBackTimepick.setOnClickListener(new OnClickListener()
	        {
	        	@Override
	        	public void onClick(View v) {
	        		Intent intent = new Intent(TimePickPage.this,FirstPage.class);
	        		startActivity(intent);		
	        	}
	        });
	        etStartTime = (EditText) this.findViewById(R.id.et_start_time); 
	        etEndTime = (EditText) this.findViewById(R.id.et_end_time); 
	           
	        etStartTime.setOnTouchListener(this);
	        etEndTime.setOnTouchListener(this); 
	           
	    }
	    
	
	    
	    
	    @SuppressLint("ClickableViewAccessibility") @Override
	    public boolean onTouch(View v, MotionEvent event) { 
	        if(event.getAction() == MotionEvent.ACTION_DOWN) { 
	        	
	            AlertDialog.Builder builder = new AlertDialog.Builder(this); 
	            View view = View.inflate(this, R.layout.date_time_dialog, null); 
	            final DatePicker datePicker = (DatePicker) view.findViewById(R.id.date_picker); 
	            builder.setView(view); 
	   
	            Calendar cal = Calendar.getInstance(); 
	            cal.setTimeInMillis(System.currentTimeMillis()); 
	            datePicker.init(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH), null); 

	            if (v.getId() == R.id.et_start_time) { 
	                final int inType = etStartTime.getInputType(); 
	                etStartTime.setInputType(InputType.TYPE_NULL); 
	                etStartTime.onTouchEvent(event); 
	                etStartTime.setInputType(inType); 
	                etStartTime.setSelection(etStartTime.getText().length()); 
	                   
	                builder.setTitle("选取起始时间"); 
	                builder.setPositiveButton("确  定", new DialogInterface.OnClickListener() { 
	   
	                    @Override 
	                    public void onClick(DialogInterface dialog, int which) { 
	   
	                        StringBuffer sb = new StringBuffer(); 
	                        sb.append(String.format("%d-%02d-%02d",  
	                                datePicker.getYear(),  
	                                datePicker.getMonth() + 1, 
	                                datePicker.getDayOfMonth())); 
	                        styear=datePicker.getYear();
	                        stmonth= datePicker.getMonth() + 1;
	                        stday= datePicker.getDayOfMonth();
	                        etStartTime.setText(sb); 
	                        etEndTime.requestFocus(); 
	                        dialog.cancel(); 
	                    } 
	                }); 
	                   
	            } 
	            else if (v.getId() == R.id.et_end_time) { 
	                int inType = etEndTime.getInputType(); 
	                etEndTime.setInputType(InputType.TYPE_NULL);     
	                etEndTime.onTouchEvent(event); 
	                etEndTime.setInputType(inType); 
	                etEndTime.setSelection(etEndTime.getText().length()); 
	   
	                builder.setTitle("选取结束时间"); 
	                builder.setPositiveButton("确  定", new DialogInterface.OnClickListener() 
	                { 
	   
	                    @Override 
	                    public void onClick(DialogInterface dialog, int which) 
	                    { 
	   
	                        StringBuffer sb = new StringBuffer(); 
	                        sb.append(String.format("%d-%02d-%02d",  
	                                datePicker.getYear(),  
	                                datePicker.getMonth() + 1,  
	                                datePicker.getDayOfMonth())); 
	                        edyear=datePicker.getYear();
	                        edmonth= datePicker.getMonth() + 1;
	                        edday= datePicker.getDayOfMonth();
	                        
	                        
	                        etEndTime.setText(sb); 
	                        dialog.cancel(); 
	                    } 
	                }); 
	            } 
	               
	            Dialog dialog = builder.create(); 
	            dialog.show(); 
	        } 
	   
	        return true; 
	    } 
}
