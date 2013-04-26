package com.syf.lol.datafactory;

import android.content.Context;

import com.syf.lol.entity.Data;
import com.syf.lol.entity.Hero;
import com.syf.lol.entity.HeroData;
import com.syf.lol.entity.Item;
import com.syf.lol.entity.ItemData;
import com.syf.lol.entity.News;
import com.syf.lol.entity.NewsData;
import com.syf.lol.entity.RuneData;
import com.syf.lol.entity.SkillData;
import com.syf.lol.until.XMLParser;

public class DataFactory
{
 public static Data getData(Context context)
 {
	 HeroData herodata=XMLParser.getherodata(context);
	 ItemData itemdata=XMLParser.getitemdata(context);
	 SkillData skilldata=XMLParser.getskilldata(context);
	 RuneData runedata=XMLParser.getrunedata(context);
	 
	 
	 NewsData newsdata=new NewsData();
     newsdata.newsdata.add(new News("n1","����ħ����������!","����ף������ħ����������!","target1"));
	 newsdata.newsdata.add(new News("n2","������λϵͳ","s3����ӭ�����µ���λϵͳ","target2"));
	 newsdata.newsdata.add(new News("n3","��λС�����","�µ���λϵͳ֧���齨�Լ���С����Ŷ","target3"));
	 newsdata.newsdata.add(new News("n4","�°汾����!","��������°汾,��������","target4"));
	 Data data=new Data(herodata,itemdata,newsdata,skilldata,runedata);
	 return data;
	 
 }
}
