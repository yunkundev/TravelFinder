package app.forandroid.travelfinder;

import java.util.Vector;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MoneyPickPage extends Activity
{
	private Button BtnNextMoneypick;
	private Button BtnBackMoneypick;
	private RadioGroup group;
	private RadioButton rb1;
	private RadioButton rb2;
	private RadioButton rb3;
	private RadioButton rb4;
	private CheckBox ch1;
	private CheckBox ch2;
	private CheckBox ch3;
	private Vector<Boolean> check = new Vector<Boolean>();
	private static int radio ;
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.moneypick_page);
		BtnNextMoneypick = (Button) findViewById(R.id.BtnNextMoneypick);
		BtnBackMoneypick = (Button) findViewById(R.id.BtnBackMoneypick);
		group = (RadioGroup) findViewById(R.id.radiogroup);
		rb1=(RadioButton) findViewById(R.id.radioButton1);
		rb2=(RadioButton) findViewById(R.id.radioButton2);
		rb3=(RadioButton) findViewById(R.id.radioButton3);
		rb4=(RadioButton) findViewById(R.id.radioButton4);
		
		ch1=(CheckBox) findViewById(R.id.checkBox1);
		ch2=(CheckBox) findViewById(R.id.checkBox2);
		ch3=(CheckBox) findViewById(R.id.checkBox3);
		
		check.add(false);
		check.add(false);
		check.add(false);
		radio = 0;
		
		ch1.setOnCheckedChangeListener(new OnCheckedChangeListener() 
		{
		
			@Override
			public void onCheckedChanged(CompoundButton buttonView,boolean isChecked) {
				// TODO Auto-generated method stub
				if(isChecked)
				{
					check.setElementAt(true, 0);
				}
				else
				{
					check.setElementAt(false, 0);
				}
				
			}
		});
		ch2.setOnCheckedChangeListener(new OnCheckedChangeListener() 
		{
		
			@Override
			public void onCheckedChanged(CompoundButton buttonView,boolean isChecked) {
				// TODO Auto-generated method stub
				if(isChecked)
				{
					check.setElementAt(true, 1);
				}
				else
				{
					check.setElementAt(false, 1);
				}
				
			}
		});
		ch3.setOnCheckedChangeListener(new OnCheckedChangeListener() 
		{
		
			@Override
			public void onCheckedChanged(CompoundButton buttonView,boolean isChecked) {
				// TODO Auto-generated method stub
				if(isChecked)
				{
					check.setElementAt(true, 2);
				}
				else
				{
					check.setElementAt(false, 2);
				}
				
			}
		});
		group.setOnCheckedChangeListener(new OnCheckedChageListener()
		{

			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) 
			{
				// TODO Auto-generated method stub
				if(checkedId == R.id.radioButton1)
				{
					radio = 1;
					System.out.println(rb1.getText().toString());
				}
				if(checkedId == R.id.radioButton2)
				{
					radio = 2;
					System.out.println(rb2.getText().toString());
				}
				if(checkedId == R.id.radioButton3)
				{
					radio = 3;
					System.out.println(rb3.getText().toString());
				}
				if(checkedId == R.id.radioButton4)
				{
					radio = 4;
					System.out.println(rb4.getText().toString());
				}
			}
			
		});
		
        BtnNextMoneypick.setOnClickListener(new OnClickListener() 
        {
        	
			@Override
			public void onClick(View v) 
			{
				if(radio == 0)
				{
					Toast.makeText(getApplicationContext(), "你还未选择自己的预期花费", Toast.LENGTH_SHORT).show();
				}
				else
				{
					Option.set_money_select(radio);
					Option.set_other_select(check);
					findWay();
					Option.set_out(sb);
					Intent intent = new Intent(MoneyPickPage.this,ShowPage.class);
					startActivity(intent);
				}
			}
			
		});
        BtnBackMoneypick.setOnClickListener(new OnClickListener()
        {
        	@Override
        	public void onClick(View v) 
        	{
        		Intent intent = new Intent(MoneyPickPage.this,PlacePickPage.class);
        		startActivity(intent);
        		
        	}
        });	
		
		
	}
	private static StringBuffer sb = new StringBuffer(); 
	private static int T;
	private static double[] p={0,0,0,0,0}; 
	private static int[] picks ={0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
	private static double[] values= {0,1.0,0.5,0.1,0.3,0.3,0.2,0.4,1.0,1.0,0.3,0.3,0.2,0.3,0.2,0.2,0.2};
	private static int[][] sel = new int[10][17];
	public static void findWay()
	{
		sb= new StringBuffer();
		T=Option.get_date();
		picks = Option.get_place_pick();
		for(int i=0;i<17;i++)
		{
			System.out.print(picks[i]);
			System.out.print("  ");
			System.out.println(values[i]);
		}
		for(int i=0;i<10;i++)
		{
			for(int j=0;j<17;j++)
			{
				sel[i][j]=0;
			}
		}
		//集合装包
		if(picks[5]+picks[6]+picks[7]+picks[8]>=1)
		{
			double v = 0;
			if(picks[5] == 1)	v+=values[5];
			if(picks[6] == 1)	v+=values[6];
			if(picks[7] == 1)	v+=values[7];
			if(picks[8] == 1)	v+=values[8];
			p[0]=v;
		}
		if(picks[16]==1)
			p[1] = values[16];
		if(picks[4]==1)
			p[2] = values[4];
		if(picks[2]+picks[3]+picks[13]>=1)
		{
			double v = 0;
			if(picks[2] == 1)	v+=values[2];
			if(picks[3] == 1)	v+=values[3];
			if(picks[13] == 1)	v+=values[13];
			p[3]=v;
		}
		if(picks[11]+picks[12]+picks[15]+picks[10]>=1)
		{
			double v = 0;
			if(picks[10] == 1)	v+=values[10];
			if(picks[11] == 1)	v+=values[11];
			if(picks[12] == 1)	v+=values[12];
			if(picks[15] == 1)	v+=values[15];
			
			p[4]=v;
		}		
		
		if(T<=0)
		{
			System.out.println("时间太不充裕");
		}
		else
		{
			int q = anpai(p,1);
			if(q > T)
			{
				q = anpai(p,1.1);
				if(q > T)
				{
					q = anpai(p,1.2);
					if(q > T)
					{
						System.out.printf("行程规划比较紧张,我们建议合适的旅游时间为%d天\n",q);
						sb.append("你的行程规划比较紧张,我们建议合适的旅游时间为"+q+"天：\r\n");
						
					}
					
				}
						
			}
			if(q < T)
			{
				q = anpai(p,0.9);
				if(q < T)
				{
					q = anpai(p,0.8);
					if(q < T)
					{
						System.out.printf("行程规划太过宽松,我们建议合适的旅游时间为%d天\n",q);
						sb.append("你的行程规划太过宽松,我们建议合适的旅游时间为"+q+"天：\r\n");
					}
					
				}
				
			}
			//路径结果展示
			for(int i=1;i<=q;i++)
			{
				sb.append("第"+i+"天:\r\n");
				sb.append("开始 —> ");
				if(sel[i][1] == 1)
				{
					sb.append(" 八达岭长城 —> " );
				}
				if(sel[i][2] == 1)
				{
					sb.append(" 故宫博物馆  —> ");
				}
				if(sel[i][3] == 1)
				{
					sb.append(" 天安门广场  —> ");
				}
				if(sel[i][4] == 1)
				{
					sb.append(" 鸟巢水立方  —> ");
				}
				if(sel[i][5] == 1)
				{
					sb.append(" 颐和园  —> ");
				}
				if(sel[i][6] == 1)
				{
					sb.append(" 圆明园  —> ");
				}
				if(sel[i][7] == 1)
				{
					sb.append(" 清华大学  —> ");
				}
				if(sel[i][8] == 1)
				{
					sb.append(" 北京大学  —> ");
				}
				if(sel[i][9] == 1)
				{
					sb.append(" 798艺术园区  —> ");
				}
				if(sel[i][10] == 1)
				{
					sb.append(" 南锣鼓巷  —> ");
				}
				if(sel[i][11] == 1)
				{
					sb.append(" 北海公园  —> ");
				}
				if(sel[i][12] == 1)
				{
					sb.append(" 后海  —> ");
				}
				if(sel[i][13] == 1)
				{
					sb.append(" 国家博物馆  —> ");
				}
				if(sel[i][14] == 1)
				{
					sb.append(" 明十三陵  —> ");
				}
				if(sel[i][15] == 1)
				{
					sb.append(" 恭亲王府  —> ");
				}
				if(sel[i][16] == 1)
				{
					sb.append(" 王府井  —> ");
				}
				sb.append("结束");
				sb.append("\r\n");
				System.out.println(sb.toString());
			}
			
			
			
		}
	}

	private static int anpai(double[] p,double level)
	{
		double sum = 0;
		int lap = 1;	
		//初始化
		for(int i=0;i<10;i++)
		{
			for(int j=0;j<17;j++)
			{
				sel[i][j]=0;
			}
		}
		
		if(picks[9] == 1)
		{
			
			sel[lap][9] = 1;
			lap++;
		}
		
		if(picks[14] == 1)
		{
			
			sel[lap][14] = 1;
			lap++;
		}
		
		
		for(int i=0;i<5;i++)
		{
							
			if(sum+p[i] > level && sum!=0)
			{
				lap++;
				pr(lap,i);
				sum = p[i];
			}
			else
			{
				sum += p[i];
				pr(lap,i);
			}
		}
		
		if(picks[1] == 1)
		{
			lap++;
			sel[lap][1] = 1;		
		}
		//路径优化
		
		return lap;
	}
	private static void pr(int d,int i) 
	{
		// TODO Auto-generated method stub
		if(i == 0)
		{
			if(picks[5] == 1)
			{
				sel[d][5] = 1;
			}
			if(picks[6] == 1)
			{
				sel[d][6] = 1;
			}
			if(picks[7] == 1)
			{
				sel[d][7] = 1;
			}
			if(picks[8] == 1)
			{
				sel[d][8] = 1;
			}
		}
		if(i == 1)
		{
			if(picks[16] == 1)
			{
				sel[d][16] = 1;
			}
		}
		if(i == 2)
		{
			if(picks[4] == 1)
			{
				sel[d][4] = 1;
			}
		}
		if(i == 3)
		{
			if(picks[2] == 1)
			{
				sel[d][2] = 1;
			}
			if(picks[3] == 1)
			{
				sel[d][3] = 1;
			}
			if(picks[13] == 1)
			{
				sel[d][13] = 1;
			}
		}
		if(i == 4)
		{
			if(picks[10] == 1)
			{
				sel[d][10] = 1;
			}
			if(picks[11] == 1)
			{
				sel[d][11] = 1;
			}
			if(picks[12] == 1)
			{
				sel[d][12] = 1;
			}
			if(picks[15] == 1)
			{
				sel[d][15] = 1;
			}
		}
		
	}	
	
	
}
