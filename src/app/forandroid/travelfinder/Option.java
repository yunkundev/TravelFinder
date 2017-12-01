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
		System.out.println("��ѡ�����ʼʱ��Ϊ��");
		System.out.println(start_time);
	}
	public static void print_end_time()
	{
		System.out.println("��ѡ��Ľ���ʱ��Ϊ��");
		System.out.println(end_time);
	}
	
	public static void print_place_select()
	{
		System.out.println("��ѡ��ľ�����:");
		if(place_select.elementAt(0))
		{
			System.out.println(" �˴��볤��  ");
		}
		if(place_select.elementAt(1))
		{
			System.out.println(" �ʹ�����Ժ  ");
		}
		if(place_select.elementAt(2))
		{
			System.out.println(" �찲�Ź㳡 ");
		}
		if(place_select.elementAt(3))
		{
			System.out.println(" ��ˮ����  ");
		}
		if(place_select.elementAt(4))
		{
			System.out.println(" �ú�԰  ");
		}
		if(place_select.elementAt(5))
		{
			System.out.println(" Բ��԰   ");
		}
		if(place_select.elementAt(6))
		{
			System.out.println(" �廪  ");
		}
		if(place_select.elementAt(7))
		{
			System.out.println(" ���� ");
		}
		if(place_select.elementAt(8))
		{
			System.out.println(" 798����԰�� ");
		}
		if(place_select.elementAt(9))
		{
			System.out.println(" �������   ");
		}
		if(place_select.elementAt(10))
		{
			System.out.println(" ������԰   ");
		}
		if(place_select.elementAt(11))
		{
			System.out.println(" ��   ");
		}
		if(place_select.elementAt(12))
		{
			System.out.println(" ���Ҳ���� ");
		}
		if(place_select.elementAt(13))
		{
			System.out.println(" ��ʮ����  ");
		}
		if(place_select.elementAt(14))
		{
			System.out.println(" ��������   ");
		}
		if(place_select.elementAt(15))
		{
			System.out.println(" ������   ");
		}
		
		System.out.println();
	}
	public static void print_money_select()
	{
		System.out.println("��ѡ���Ԥ�ڻ���Ϊ��");
		if(money_select == 1)
			System.out.println("1000-2000");
		if(money_select == 2)
			System.out.println("2000-3000");
		if(money_select == 3)
			System.out.println("3000-5000");
		if(money_select == 4)
			System.out.println("��Ǯ����");
		
	}
	public static void print_other_select()
	{
		System.out.println("�������Ҫ���У�");
		if(other_select.elementAt(0))
		{
			System.out.println("ס�������ã���ϴԡ");
		}
		if(other_select.elementAt(1))
		{
			System.out.println("��ȫ��һ�����ϲ�����");
		}
		if(other_select.elementAt(2))
		{
			System.out.println("���ǳԻ������鱱��С��");
		}
	}
	public static void print_date()
	{
		System.out.println(date);
	}
}
