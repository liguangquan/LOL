package com.syf.lol.entity;

public class Hero
{
 public String id,name,nameE,nickname,popname; //������Ϣ ����5��
 public String damage,attackspeed,armor,attacklvl,armorlvl,radius; //������Ϣ(ģ�����) ����6��
 public String life,liferec,lifereclvl,mana,manarec,manareclvl,speed,gold,vouncher;//����������Ϣ ����9��
 public String lvl,type,guide,guideitem1,guideitem2,guideitem3,guideitem4,against,tip;//������Ϣ ����9��
 public String lifelvl,manalvl; //�����ӵ�
 public Hero()
 {  }
 public Hero(String id,String name)
 {
	 this.id=id;
	 this.name=name;
 }

}
