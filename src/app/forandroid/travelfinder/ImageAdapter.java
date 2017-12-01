package app.forandroid.travelfinder;

import java.util.Vector;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
public class ImageAdapter extends BaseAdapter
{
	private Context mContext; // 定义Context
	private Vector<Integer> mImageIds = new Vector<Integer>(); // 定义一个向量作为图片源
	public Vector<Boolean> mImage_bs = new Vector<Boolean>(); // 定义一个向量作为选中与否容器
	public ImageAdapter(Context c, boolean isMulti){
		mContext = c;
		// 装入资源
		mImageIds.add(R.drawable.p1);
		mImageIds.add(R.drawable.p2);
		mImageIds.add(R.drawable.p3);
		mImageIds.add(R.drawable.p4);
		mImageIds.add(R.drawable.p5);
		mImageIds.add(R.drawable.p6);
		mImageIds.add(R.drawable.p7);
		mImageIds.add(R.drawable.p8);
		mImageIds.add(R.drawable.p9);
		mImageIds.add(R.drawable.p10);
		mImageIds.add(R.drawable.p11);
		mImageIds.add(R.drawable.p12);
		mImageIds.add(R.drawable.p13);
		mImageIds.add(R.drawable.p14);
		mImageIds.add(R.drawable.p15);
		mImageIds.add(R.drawable.p16);
		
		for(int i=0; i<16; i++)
			mImage_bs.add(false);
	}
	@Override
	public int getCount() 
	{
		// TODO Auto-generated method stub
		return mImageIds.size();
	}
	@Override
	public Object getItem(int position) 
	{
		// TODO Auto-generated method stub
		return position;
	}
	@Override
	public long getItemId(int position) 
	{
		// TODO Auto-generated method stub
		return position;
	}
	@Override
	public View getView(int position, View convertView, ViewGroup parent) 
	{
		
		// TODO Auto-generated method stub
		ImageView imageView;
		int Width = (getScreenWidth(mContext)-40)/2;
		if (convertView == null)
		{
			imageView = new ImageView(mContext); // 给ImageView设置资源
			imageView.setLayoutParams(new GridView.LayoutParams(Width, Width)); // 设置布局图片
			imageView.setScaleType(ImageView.ScaleType.CENTER_CROP); // 设置显示比例类型
		}
		else
		{
			imageView = (ImageView) convertView;
		}
		imageView.setImageDrawable(makeBmp(mImageIds.elementAt(position),
		mImage_bs.elementAt(position)));
		return imageView;
	}
	
	@SuppressWarnings("deprecation")
	private LayerDrawable makeBmp(int id, boolean isChosen)
	{
		Bitmap mainBmp = ((BitmapDrawable)mContext.getResources().getDrawable(id)).getBitmap();
		// 根据isChosen来选取对勾的图片
		Bitmap seletedBmp = null;
		//		if(isChosen == true)
		//		seletedBmp = BitmapFactory.decodeResource(mContext.getResources(),);
		if(isChosen == true)
			seletedBmp = BitmapFactory.decodeResource(mContext.getResources(),R.drawable.check);
		// 产生叠加图
		Drawable[] array = new Drawable[2];
		array[0] = new BitmapDrawable(mainBmp);
		array[1] = new BitmapDrawable(seletedBmp);
		LayerDrawable la = new LayerDrawable(array);
		la.setLayerInset(0, 0, 0, 0, 0);
		la.setLayerInset(1, 0, -5, 160, 160 );
		return la; //返回叠加后的图
	}
	// 修改选中的状态
	public void changeState(int position)
	{
		mImage_bs.setElementAt(!mImage_bs.elementAt(position), position); //直接取反即可
		notifyDataSetChanged(); //通知适配器进行更新
	}
	public boolean getState(int i) 
	{
		// TODO Auto-generated method stub
		return mImage_bs.elementAt(i);
	}
	@SuppressWarnings("deprecation")
	public static int getScreenWidth(Context context) 
	{ 
	    WindowManager manager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE); 
	    Display display = manager.getDefaultDisplay(); 
	    return display.getWidth(); 
	} 
}
