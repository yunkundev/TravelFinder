package app.forandroid.travelfinder;

import java.util.Vector;

public class Option 
{
	private static String start_time = new String();
	private static String end_time = new String();
	private static Vector<Boolean> place_select = new Vector<Boolean>();
	private static int money_select = 0;
	private static Vector<Boolean>other_select = new Vector<Boolean>();
	private static int date;
	private static StringBuffer out = new StringBuffer(); 
	public static void clean()
	{
		start_time = new String();
		end_time = new String();
		place_select = new Vector<Boolean>();
		money_select = 0;
		other_select = new Vector<Boolean>();
		date = 0;
		out = new StringBuffer(); 	
	}
	public static void set_date(int t)
	{
		date=t;
	}
	public static int[] get_place_pick()
	{
		int[] a = new int[17];
		a[0]=0;
		for(int i=0;i<16;i++)
		{
			if(place_select.elementAt(i))
			{
				a[i+1]=1;
			}
			else
			{
				a[i+1]=0;
			}
		}
		return a;
		
	}
	public static int get_date()
	{
		return date;
	}
	public static StringBuffer get_out()
	{
		return out;
	}
	public static void set_out(StringBuffer sb)
	{
		out=sb;
	}
	
	public static void set_start_time(String s)
	{
		start_time = s;
	}
	public static void set_end_time(String s)
	{
		end_time = s;
	}
	public static void set_place_select(Vector<Boolean> v)
	{
		place_select = v;	
	}
	public static void set_money_select(int i)
	{
		money_select = i;
	}
	public static void set_other_select(Vector<Boolean> v)
	{
		other_select = v;
	}
	
	public static void print_start_time()
	{
		System.out.println("你选择的起始时间为：");
		System.out.println(start_time);
	}
	public static void print_end_time()
	{
		System.out.println("你选择的结束时间为：");
		System.out.println(end_time);
	}
	
	public static void print_place_select()
	{
		System.out.println("你选择的景点有:");
		if(place_select.elementAt(0))
		{
			System.out.println(" 八达岭长城  ");
		}
		if(place_select.elementAt(1))
		{
			System.out.println(" 故宫博物院  ");
		}
		if(place_select.elementAt(2))
		{
			System.out.println(" 天安门广场 ");
		}
		if(place_select.elementAt(3))
		{
			System.out.println(" 鸟巢水立方  ");
		}
		if(place_select.elementAt(4))
		{
			System.out.println(" 颐和园  ");
		}
		if(place_select.elementAt(5))
		{
			System.out.println(" 圆明园   ");
		}
		if(place_select.elementAt(6))
		{
			System.out.println(" 清华  ");
		}
		if(place_select.elementAt(7))
		{
			System.out.println(" 北大 ");
		}
		if(place_select.elementAt(8))
		{
			System.out.println(" 798艺术园区 ");
		}
		if(place_select.elementAt(9))
		{
			System.out.println(" 南锣鼓巷   ");
		}
		if(place_select.elementAt(10))
		{
			System.out.println(" 北海公园   ");
		}
		if(place_select.elementAt(11))
		{
			System.out.println(" 后海   ");
		}
		if(place_select.elementAt(12))
		{
			System.out.println(" 国家博物馆 ");
		}
		if(place_select.elementAt(13))
		{
			System.out.println(" 明十三陵  ");
		}
		if(place_select.elementAt(14))
		{
			System.out.println(" 恭亲王府   ");
		}
		if(place_select.elementAt(15))
		{
			System.out.println(" 王府井   ");
		}
		
		System.out.println();
	}
	public static void print_money_select()
	{
		System.out.println("你选择的预期花费为：");
		if(money_select == 1)
			System.out.println("1000-2000");
		if(money_select == 2)
			System.out.println("2000-3000");
		if(money_select == 3)
			System.out.println("3000-5000");
		if(money_select == 4)
			System.out.println("有钱任性");
		
	}
	public static void print_other_select()
	{
		System.out.println("你的其他要求有：");
		if(other_select.elementAt(0))
		{
			System.out.println("住宿条件好，有洗浴");
		}
		if(other_select.elementAt(1))
		{
			System.out.println("安全第一，晚上不出行");
		}
		if(other_select.elementAt(2))
		{
			System.out.println("我是吃货，尝遍北京小吃");
		}
	}
	public static void print_date()
	{
		System.out.println(date);
	}
}
