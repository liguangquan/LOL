package com.syf.lol.activity;
import android.app.ActivityGroup;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;
import com.syf.lol.R;
import com.syf.lol.app.App;
import com.syf.lol.customview.SlidingMenuView;
import com.syf.lol.datafactory.DataFactory;

public class MainActivity extends ActivityGroup
{
	public ViewGroup activitygroup;
	ListView slidinglist;
	Context context;
	SlidingMenuView slidingview;
	protected void onCreate(Bundle savedInstanceState)
	{	
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		context=this;
		activitygroup=(ViewGroup)findViewById(R.id.activity_body);
		slidingview=(SlidingMenuView)findViewById(R.id.sliding_view);
		loaddata();
		Intent intent=new Intent(context,NewsActivity.class);
		activitygroup.removeAllViews();
		activitygroup.addView(getLocalActivityManager().startActivity("main", intent).getDecorView());
	}
	public void changeactivity(View v)
	{
		Button btn=(Button)v;
		String name=(String)btn.getText();
		Intent intent=null;
		View rootview=null;
		if(name.equals("����ѶϢ"))         {    intent=new Intent(context,NewsActivity.class);   }
		if(name.equals("Ӣ������"))         {    intent=new Intent(context,HeroActivity.class);   }
		if(name.equals("��Ʒ����"))         {    intent=new Intent(context,ItemActivity.class);   }
		if(name.equals("��������"))         {    intent=new Intent(context,RuneActivity.class);   }
		if(name.equals("�츳����"))         {    intent=new Intent(context,TalentActivity.class);   }
		if(name.equals("Ӣ��ģ����"))      {    intent=new Intent(context,SimulatorActivity.class);   }
		if(name.equals("�������"))         {    intent=new Intent(context,ShareActivity.class);   }
		if(intent!=null)
		  {
		rootview=getLocalActivityManager().startActivity(name, intent).getDecorView();
		activitygroup.removeAllViews();
		activitygroup.addView(rootview);
		slidingview.snapToScreen(1);//1Ϊ�໬�˵�����,0Ϊ�໬�˵�չʾ,2Ϊ �Ҳ�໬
		  }
	 }
	public boolean onKeyDown(int keyCode, KeyEvent event)
	{
		String str=getLocalActivityManager().getCurrentActivity().getLocalClassName();
		if(str.equals("activity.NewsActivity"))
		{
			Toast.makeText(context, "�������˳�", Toast.LENGTH_SHORT).show();
		}
		else
		{
			Toast.makeText(context, "����������", Toast.LENGTH_SHORT).show();
			Button temp=new Button(context);
			temp.setText("����ѶϢ");
			changeactivity(temp);
		}
		return true;
	}
	public void exit(View v)
	{
		finish();
	}
	private void loaddata()
	{
		App app=(App)getApplication();
		app.setData(DataFactory.getData(context));
		app.setMainactivity(this);
	}
}
