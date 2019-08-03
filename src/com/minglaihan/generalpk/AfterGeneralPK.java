package com.minglaihan.generalpk;

import com.minglaihan.sanguopk.R;
import com.minglaihan.tools.DBHelper;
import com.minglaihan.tools.Exit;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.Animation.AnimationListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


public class AfterGeneralPK extends Activity implements OnCompletionListener{
	
	private  Button chooseGeneralButton1;
	private  Button chooseGeneralButton2;
	private  Button startPKButton;
	private ImageView imageView1,imageView2,pkImageView;
	private Bundle bundle;
	private Intent intent;
	private static String name1,name2;
	private TextView victoryTextView;
	public static boolean isEnd = false;
	private SoundPool soundPool;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.generalpk);
		Exit.getInstance().addActivity(this);
		
		victoryTextView = (TextView)findViewById(R.id.victoryText);
		imageView1 = (ImageView)findViewById(R.id.generalImage1);
		imageView2 = (ImageView)findViewById(R.id.generalImage2);
		pkImageView = (ImageView)findViewById(R.id.pkImage);
		
		soundPool= new SoundPool(10,AudioManager.STREAM_SYSTEM,5);
		soundPool.load(this,R.raw.pk,1);

		intent = this.getIntent();		
		bundle = intent.getExtras();
		
		if(bundle!=null&&bundle.getString("name1")!=null){
			
			name1 = bundle.getString("name1");//需要的工作：根据name插入武将头像在“选择武将”的上方
			System.out.println(name1+"mmmm");
			InsertName1Picture(name1);
		}
		
		if(bundle!=null&&bundle.getString("name2")!=null){
			name2 = bundle.getString("name2");
			System.out.println(name1+"此时Name1是："+name2+"name2");
			
			InsertName2Picture(name2);
		}
		
	

		chooseGeneralButton1 = (Button)findViewById(R.id.chooseGeneralButton1);
		chooseGeneralButton2 = (Button)findViewById(R.id.chooseGeneralButton2);
		startPKButton = (Button)findViewById(R.id.startPKButton);
		
		chooseGeneralButton1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				//先清除bundle数据
				bundle.clear();
				// TODO Auto-generated method stub
				//加载选择武将的头像置于选择武将按钮的上方
				Intent intent = new Intent();  
	             intent.setClass(AfterGeneralPK.this, ChooseGeneral1.class);  
	             startActivity(intent);
			}
		});
		
		chooseGeneralButton2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				bundle.clear();
				// TODO Auto-generated method stub
				//加载选择武将的头像置于选择武将按钮的上方
				Intent intent = new Intent();  
	             intent.setClass(AfterGeneralPK.this, ChooseGeneral2.class);  
	             startActivity(intent);
			}
		});
		
		startPKButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
//				victoryTextView.clearComposingText();
				//判定！！！！1，必须选择两个武将；2，两个武将不能一样；3
				// TODO Auto-generated method stub
				//两个头像之间有个动态的PK效果，然后通过PK算法计算出结果
				//根据name获取武将的数据，然后加以比较
				Animation animation = AnimationUtils.loadAnimation(AfterGeneralPK.this, R.anim.scale);
        		imageView1.setAnimation(animation);
        		imageView2.setAnimation(animation);
        		pkImageView.setImageResource(R.drawable.vs);
        		pkImageView.setAnimation(animation);

        		if(name1 == null||name2 == null){
					Toast.makeText(AfterGeneralPK.this, "亲啊，武将要两名才可以打起来",Toast.LENGTH_SHORT ).show();
				}
				else if(name1.equals(name2)){
					Toast.makeText(AfterGeneralPK.this, "不要这个样子，难道你是周伯通，可以自己左手打右手？...:-D",Toast.LENGTH_SHORT ).show();
				}
				else{
					DBHelper dbHelper = new DBHelper(getApplicationContext());
					SQLiteDatabase db = dbHelper.getWritableDatabase();
					General general1 = dbHelper.queryGeneralByName(name1);
					General general2 = dbHelper.queryGeneralByName(name2);
					String victoryInfo = PKGeneral(general1,general2);
					victoryTextView.setText(victoryInfo);
				}
        		animation.setAnimationListener(new AnimationListener(){
        			
        			@Override
        			public void onAnimationEnd(Animation animation) {
        				isEnd = true;
        				// TODO Auto-generated method stub
        				imageView1.setVisibility(View.VISIBLE);
        				imageView2.setVisibility(View.VISIBLE);
        				pkImageView.setVisibility(View.VISIBLE);
        				System.out.println("isenddddddddddddd");
        				
        			}
        			
        			@Override
        			public void onAnimationRepeat(Animation animation) {
        				// TODO Auto-generated method stub
        				
        			}
        			
        			@Override
        			public void onAnimationStart(Animation animation) {
        				System.out.println("Is Start??");
        				// TODO Auto-generated method stub
        				imageView1.setVisibility(View.VISIBLE);
        				imageView2.setVisibility(View.VISIBLE);
        				pkImageView.setVisibility(View.VISIBLE);
        			}
        		});
        		imageView1.startAnimation(animation);
        		imageView2.startAnimation(animation);
        		pkImageView.startAnimation(animation);
        		soundPool.play(1,1, 1, 0, 0, 1);

				System.out.println("name1          :"+ name1);
				System.out.println("name2          :"+ name2);
								
				
			}
		});
				
	}
	
	

	public String PKGeneral(General general1,General general2){
		//PK算法：先计算统帅差距，系数为c；然后计算武力差距，系数为f，在计算智力差距，系数为i，最后统一计算，统帅占60%，武力智力各占20%
		String victoryString = null;
		int score1,score2;
		String name1 = general1.getName();
		String name2 = general2.getName();
		int captain1 = general1.getCaptain();
		int captain2 = general2.getCaptain();
		int force1 = general1.getForce();
		int force2 = general2.getForce();
		int intelligence1 = general1.getIntelligence();
		int intelligence2 = general2.getIntelligence();
		
		score1 = (int) (captain1*0.6+force1*0.2+intelligence1*0.2);
		score2 = (int) (captain2*0.6+force2*0.2+intelligence2*0.2);

		if(score1>score2){
			if(captain1>captain2){
				if(force1>force2){
					if(intelligence1>intelligence2){
						victoryString = name1 + "将军胜出！ " + "在与" + name2+"将军PK中," + name1 + "将军不愧是良才！在统帅，武力，智力方面具有压倒性优势。综合战绩:"+score1 + "，满分100分。";
					}else{
						victoryString = name1 + "将军胜出！ " + "在与" + name2+"将军PK中," + name1 + "将军不愧是勇将！在统帅，武力方面具有很强的优势，不足的是在智谋方面需要勤读兵书。综合战绩:"+score1 + "，满分100分。";
					}					
				}else{
					if(intelligence1>intelligence2){
						victoryString = name1 + "将军胜出！ " + "在与" + name2+"将军PK中," + name1 + "将军不愧是足智多谋的将才！在统帅，智力方面具有压倒性优势，美中不足的是个人武力有待提高。综合战绩:"+score1 + "，满分100分。";
					}else{
						victoryString = name1 + "将军胜出！ " + "在与" + name2+"将军PK中," + name1 + "将军不愧是难得的帅才！在统帅方面具有很强的优势，不足的是在武力和智谋方面需要勤读兵书和练习。综合战绩:"+score1 + "，满分100分。";
					}
					
				}
			}else{
				if(force1>force2){
					if(intelligence1>intelligence2){
						victoryString = name1 + "将军胜出！ " + "在与" + name2+"将军PK中," + name1 + "将军不愧是名将！在武力，智力方面具有压倒性优势。但是需要加强统帅士兵的能力。综合战绩:"+score1 + "，满分100分。";
					}else{
						victoryString = name1 + "将军胜出！ " + "在与" + name2+"将军PK中," + name1 + "将军不愧是出色的猛将！在武力方面具有压倒性的优势，不足的是在统帅和谋略方面需要加强。综合战绩:"+score1 + "，满分100分。";
					}					
				}else{
					if(intelligence1>intelligence2){
						victoryString = name1 + "将军胜出！ " + "在与" + name2+"将军PK中," + name1 + "将军不愧是出色的谋士！在智力方面具有很强的优势，不足的是在统帅和武力方面需要加强。综合战绩:"+score1 + "，满分100分。";
					}					
				}
				
			}
			
		}
		else if(score2>score1){
			if(captain2>captain1){
				if(force2>force1){
					if(intelligence2>intelligence1){
						victoryString = name2 + "将军胜出！ " + "在与" + name1+"将军PK中," + name2 + "将军不愧是良才！在统帅，武力，智力方面具有压倒性优势。综合战绩:"+score2 + "，满分100分。";
					}else{
						victoryString = name2 + "将军胜出！ " + "在与" + name1+"将军PK中," + name2 + "将军不愧是勇将！在统帅，武力方面具有很强的优势，不足的是在智谋方面需要勤读兵书。综合战绩:"+score2 + "，满分100分。";
					}					
				}else{
					if(intelligence2>intelligence1){
						victoryString = name2 + "将军胜出！ " + "在与" + name1+"将军PK中," + name2 + "将军不愧是足智多谋的将才！在统帅，智力方面具有压倒性优势，美中不足的是个人武力有待提高。综合战绩:"+score2 + "，满分100分。";
					}else{
						victoryString = name2 + "将军胜出！ " + "在与" + name1+"将军PK中," + name2 + "将军不愧是难得的帅才！在统帅方面具有很强的优势，不足的是在武力和智谋方面需要勤读兵书和练习。综合战绩:"+score2 + "，满分100分。";
					}
					
				}
			}else{
				if(force2>force1){
					if(intelligence2>intelligence1){
						victoryString = name2 + "将军胜出！ " + "在与" + name1+"将军PK中," + name2 + "将军不愧是名将！在武力，智力方面具有压倒性优势。但是需要加强统帅士兵的能力。综合战绩:"+score2 + "，满分100分。";
					}else{
						victoryString = name2 + "将军胜出！ " + "在与" + name1+"将军PK中," + name2 + "将军不愧是出色的猛将！在武力方面具有压倒性的优势，不足的是在统帅和谋略方面需要加强。综合战绩:"+score2 + "，满分100分。";
					}					
				}else{
					if(intelligence2>intelligence1){
						victoryString = name2 + "将军胜出！ " + "在与" + name1+"将军PK中," + name2 + "将军不愧是出色的谋士！在智力方面具有很强的优势，不足的是在统帅和武力方面需要加强。综合战绩:"+score2 + "，满分100分。";
					}					
				}
				
			}
			
		}
		else if(score1 == score2) {
			victoryString = name1 + "将军和 " + name2+"将军平手！" + "两位真不愧是当代良将，称得起是棋逢对手，在综合方面平分秋色，以后多多切磋交流！综合战绩:"+score1 + "，满分100分。";
		}
				
		return victoryString;
	}

	
	public void InsertName1Picture(String name){
		if(name.equals("赵云")){
			imageView1.setImageResource(R.drawable.zhaoyun);
		}
		else if(name.equals("马超")){
			imageView1.setImageResource(R.drawable.machao);
		}
		else if(name.equals("关羽")){
			imageView1.setImageResource(R.drawable.guanyu);
		}
		else if(name.equals("张飞")){
			imageView1.setImageResource(R.drawable.zhangfei);
		}
		else if(name.equals("黄忠")){
			imageView1.setImageResource(R.drawable.huangzhong);
		}
		else if(name.equals("诸葛亮")){
			imageView1.setImageResource(R.drawable.zhugeliang);
		}
		else if(name.equals("刘备")){
			imageView1.setImageResource(R.drawable.liubei);
		}
		else if(name.equals("曹操")){
			imageView1.setImageResource(R.drawable.caocao);
		}
		else if(name.equals("夏侯惇")){
			imageView1.setImageResource(R.drawable.xiahoudun);
		}
		else if(name.equals("夏侯渊")){
			imageView1.setImageResource(R.drawable.xiahouyuan);
		}
		else if(name.equals("严颜")){
			imageView1.setImageResource(R.drawable.yanyan);
		}
		else if(name.equals("魏延")){
			imageView1.setImageResource(R.drawable.weiyan);
		}
		else if(name.equals("孙坚")){
			imageView1.setImageResource(R.drawable.sunjian);
		}
		else if(name.equals("孙策")){
			imageView1.setImageResource(R.drawable.sunce);
		}
		else if(name.equals("甘宁")){
			imageView1.setImageResource(R.drawable.ganning);
		}
		else if(name.equals("周瑜")){
			imageView1.setImageResource(R.drawable.zhouyu);
		}
		else if(name.equals("孙权")){
			imageView1.setImageResource(R.drawable.sunquan);
		}
		else if(name.equals("张苞")){
			imageView1.setImageResource(R.drawable.zhangbao);
		}
		else if(name.equals("华雄")){
			imageView1.setImageResource(R.drawable.huaxiong);
		}
		else if(name.equals("关平")){
			imageView1.setImageResource(R.drawable.guanping);
		}else if(name.equals("姜维")){
			imageView1.setImageResource(R.drawable.jiangwei);
		}
		else if(name.equals("陆逊")){
			imageView1.setImageResource(R.drawable.luxun);
		}
		else if(name.equals("司马懿")){
			imageView1.setImageResource(R.drawable.simayi);
		}
		else if(name.equals("张辽")){
			imageView1.setImageResource(R.drawable.zhangliao);
		}
		else if(name.equals("周泰")){
			imageView1.setImageResource(R.drawable.zhoutai);
		}
		else if(name1.equals("法正")){
			imageView1.setImageResource(R.drawable.fazheng);
		}
		else if(name.equals("徐庶")){
			imageView1.setImageResource(R.drawable.xushu);
		}
		else if(name.equals("李严")){
			imageView1.setImageResource(R.drawable.liyan);
		}
		else if(name.equals("马岱")){
			imageView1.setImageResource(R.drawable.madai);
		}
		else if(name.equals("张巍")){
			imageView1.setImageResource(R.drawable.zhangbao);
		}
		else if(name.equals("关兴")){
			imageView1.setImageResource(R.drawable.guanxing);
		}
		else if(name.equals("陈到")){
			imageView1.setImageResource(R.drawable.chendeng);
		}
		else if(name.equals("马忠")){
			imageView1.setImageResource(R.drawable.guanping);
		}
		else if(name.equals("王平")){
			imageView1.setImageResource(R.drawable.wangping);
		}
		else if(name.equals("向宠")){
			imageView1.setImageResource(R.drawable.xiangchong);
		}
		else if(name.equals("廖化")){
			imageView1.setImageResource(R.drawable.liaohua);
		}
		else if(name.equals("关索")){
			imageView1.setImageResource(R.drawable.guansuo);
		}
		else if(name.equals("黄权")){
			imageView1.setImageResource(R.drawable.huangquan);
		}
		else if(name.equals("张翼")){
			imageView1.setImageResource(R.drawable.zhangyi);
		}
		else if(name.equals("吴班")){
			imageView1.setImageResource(R.drawable.wuban);
		}
		else if(name.equals("周仓")){
			imageView1.setImageResource(R.drawable.zhoucang);
		}
		else if(name.equals("关银屏")){
			imageView1.setImageResource(R.drawable.guanyinping);
		}
		else if(name.equals("太史慈")){
			imageView1.setImageResource(R.drawable.taishici);
		}
		else if(name.equals("陆抗")){
			imageView1.setImageResource(R.drawable.lukang);
		}
		else if(name.equals("吕蒙")){
			imageView1.setImageResource(R.drawable.lvmeng);
		}else if(name.equals("鲁肃")){
			imageView1.setImageResource(R.drawable.lusu);
		}
		else if(name.equals("徐盛")){
			imageView1.setImageResource(R.drawable.xusheng);
		}
		else if(name.equals("黄盖")){
			imageView1.setImageResource(R.drawable.huanggai);
		}
		else if(name.equals("程普")){
			imageView1.setImageResource(R.drawable.chengpu);
		}
		else if(name.equals("韩当")){
			imageView1.setImageResource(R.drawable.handang);
		}
		else if(name1.equals("凌统")){
			imageView1.setImageResource(R.drawable.lingtong);
		}
		else if(name.equals("蒋钦")){
			imageView1.setImageResource(R.drawable.jiangqin);
		}
		else if(name.equals("潘璋")){
			imageView1.setImageResource(R.drawable.panzhang);
		}
		else if(name.equals("丁奉")){
			imageView1.setImageResource(R.drawable.dingfeng);
		}
		else if(name.equals("孙尚香")){
			imageView1.setImageResource(R.drawable.sunshangxiang);
		}
		else if(name.equals("朱然")){
			imageView1.setImageResource(R.drawable.zhuran);
		}
		else if(name.equals("诸葛恪")){
			imageView1.setImageResource(R.drawable.zhugeke);
		}
		else if(name.equals("凌操")){
			imageView1.setImageResource(R.drawable.lingcao);
		}
		else if(name.equals("孙桓")){
			imageView1.setImageResource(R.drawable.sunhuan);
		}
		else if(name.equals("全琮")){
			imageView1.setImageResource(R.drawable.quancong);
		}
		else if(name.equals("吕岱")){
			imageView1.setImageResource(R.drawable.lvdai);
		}
		else if(name.equals("张昭")){
			imageView1.setImageResource(R.drawable.zhangzhao);
		}
		else if(name.equals("张紘")){
			imageView1.setImageResource(R.drawable.zhanghong);
		}
		else if(name.equals("顾雍")){
			imageView1.setImageResource(R.drawable.guyong);
		}
		else if(name.equals("步鸷")){
			imageView1.setImageResource(R.drawable.buzhi);
		}
		else if(name.equals("郭嘉")){
			imageView1.setImageResource(R.drawable.guojia);
		}
		else if(name.equals("徐晃")){
			imageView1.setImageResource(R.drawable.xuhuang);
		}
		else if(name.equals("邓艾")){
			imageView1.setImageResource(R.drawable.dengai);
		}
		else if(name.equals("曹仁")){
			imageView1.setImageResource(R.drawable.caoren);
		}
		else if(name.equals("张郃")){
			imageView1.setImageResource(R.drawable.zhanghe);
		}else if(name.equals("羊枯")){
			imageView1.setImageResource(R.drawable.yangku);
		}
		else if(name.equals("钟会")){
			imageView1.setImageResource(R.drawable.zhonghui);
		}
		else if(name.equals("司马师")){
			imageView1.setImageResource(R.drawable.simashi);
		}
		else if(name.equals("郭淮")){
			imageView1.setImageResource(R.drawable.guohuai);
		}
		else if(name.equals("郝昭")){
			imageView1.setImageResource(R.drawable.haozhao);
		}
		else if(name1.equals("杜预")){
			imageView1.setImageResource(R.drawable.duyu);
		}
		else if(name.equals("于禁")){
			imageView1.setImageResource(R.drawable.yujin);
		}
		else if(name.equals("许褚")){
			imageView1.setImageResource(R.drawable.xuchu);
		}
		else if(name1.equals("典韦")){
			imageView1.setImageResource(R.drawable.dianwei);
		}
		else if(name.equals("荀彧")){
			imageView1.setImageResource(R.drawable.xunyu);
		}
		else if(name.equals("荀攸")){
			imageView1.setImageResource(R.drawable.xunyou);
		}
		else if(name.equals("李典")){
			imageView1.setImageResource(R.drawable.lidian);
		}
		else if(name.equals("文聘")){
			imageView1.setImageResource(R.drawable.wenpin);
		}
		else if(name.equals("乐进")){
			imageView1.setImageResource(R.drawable.yuejin);
		}
		else if(name.equals("田豫")){
			imageView1.setImageResource(R.drawable.tianyu);
		}
		else if(name.equals("文鸯")){
			imageView1.setImageResource(R.drawable.wenyang);
		}
		else if(name.equals("王双")){
			imageView1.setImageResource(R.drawable.wangshuang);
		}
		else if(name.equals("曹真")){
			imageView1.setImageResource(R.drawable.caozhen);
		}
		else if(name.equals("贾诩")){
			imageView1.setImageResource(R.drawable.jiaxu);
		}
		else if(name.equals("曹洪")){
			imageView1.setImageResource(R.drawable.caohong);
		}
		else if(name.equals("曹纯")){
			imageView1.setImageResource(R.drawable.caochun);
		}
		else if(name.equals("孙礼")){
			imageView1.setImageResource(R.drawable.sunli);
		}
		else if(name.equals("满宠")){
			imageView1.setImageResource(R.drawable.manchong);
		}
		else if(name.equals("曹彰")){
			imageView1.setImageResource(R.drawable.caozhang);
		}
		else if(name.equals("陈泰")){
			imageView1.setImageResource(R.drawable.chentai);
		}
		else if(name.equals("司马昭")){
			imageView1.setImageResource(R.drawable.simazhao);
		}
		else if(name.equals("程昱")){
			imageView1.setImageResource(R.drawable.chengyu);
		}
		else if(name.equals("曹休")){
			imageView1.setImageResource(R.drawable.caoxiu);
		}else if(name.equals("陈登")){
			imageView1.setImageResource(R.drawable.chendeng);
		}
		else if(name.equals("刘晔")){
			imageView1.setImageResource(R.drawable.liuye);
		}
		else if(name.equals("高顺")){
			imageView1.setImageResource(R.drawable.gaoshun);
		}
		else if(name.equals("吕布")){
			imageView1.setImageResource(R.drawable.lvbu);
		}
		else if(name.equals("孔融")){
			imageView1.setImageResource(R.drawable.kongrong);
		}
		else if(name.equals("袁绍")){
			imageView1.setImageResource(R.drawable.yuanshao);
		}
		else if(name1.equals("颜良")){
			imageView1.setImageResource(R.drawable.yanliang);
		}
		else if(name.equals("文丑")){
			imageView1.setImageResource(R.drawable.wenchou);
		}
		else if(name.equals("田丰")){
			imageView1.setImageResource(R.drawable.tianfeng);
		}
		else if(name.equals("沮授")){
			imageView1.setImageResource(R.drawable.jushou);
		}
		else if(name.equals("袁术")){
			imageView1.setImageResource(R.drawable.yuanshu);
		}
		else if(name.equals("纪灵")){
			imageView1.setImageResource(R.drawable.jiling);
		}
		else if(name.equals("马腾")){
			imageView1.setImageResource(R.drawable.mateng);
		}
		else if(name.equals("庞德")){
			imageView1.setImageResource(R.drawable.pangde);
		}
		else if(name.equals("董卓")){
			imageView1.setImageResource(R.drawable.dongzhuo);
		}
		else if(name.equals("徐荣")){
			imageView1.setImageResource(R.drawable.xurong);
		}else if(name.equals("韩遂")){
			imageView1.setImageResource(R.drawable.hansui);
		}
		else if(name.equals("张鲁")){
			imageView1.setImageResource(R.drawable.zhanglu);
		}
		else if(name.equals("张任")){
			imageView1.setImageResource(R.drawable.zhangren);
		}
		else if(name.equals("孟获")){
			imageView1.setImageResource(R.drawable.menghuo);
		}
		else if(name.equals("皇甫嵩")){
			imageView1.setImageResource(R.drawable.huangfusong);
		}
		else if(name1.equals("朱儁")){
			imageView1.setImageResource(R.drawable.zhujun);
		}
		else if(name.equals("卢植")){
			imageView1.setImageResource(R.drawable.luzhi);
		}
		else if(name1.equals("公孙瓒")){
			imageView1.setImageResource(R.drawable.gongsunzan);
		}
	}
	
	public void InsertName2Picture(String name) {
		// TODO Auto-generated method stub
		if(name.equals("赵云")){
			imageView2.setImageResource(R.drawable.zhaoyun);
			InsertName1Picture(name1);
		}
		else if(name.equals("马超")){
			imageView2.setImageResource(R.drawable.machao);
			InsertName1Picture(name1);
		}
		else if(name.equals("关羽")){
			imageView2.setImageResource(R.drawable.guanyu);
			InsertName1Picture(name1);
		}
		else if(name.equals("张飞")){
			imageView2.setImageResource(R.drawable.zhangfei);
			InsertName1Picture(name1);
		}
		else if(name.equals("黄忠")){
			imageView2.setImageResource(R.drawable.huangzhong);
			InsertName1Picture(name1);
		}
		else if(name.equals("诸葛亮")){
			imageView2.setImageResource(R.drawable.zhugeliang);
			InsertName1Picture(name1);
		}
		else if(name.equals("刘备")){
			imageView2.setImageResource(R.drawable.liubei);
			InsertName1Picture(name1);
		}
		else if(name.equals("曹操")){
			imageView2.setImageResource(R.drawable.caocao);
			InsertName1Picture(name1);
		}
		else if(name.equals("夏侯惇")){
			imageView2.setImageResource(R.drawable.xiahoudun);
			InsertName1Picture(name1);
		}
		else if(name.equals("夏侯渊")){
			imageView2.setImageResource(R.drawable.xiahouyuan);
			InsertName1Picture(name1);
		}
		else if(name.equals("严颜")){
			imageView2.setImageResource(R.drawable.yanyan);
			InsertName1Picture(name1);
		}
		else if(name.equals("魏延")){
			imageView2.setImageResource(R.drawable.weiyan);
			InsertName1Picture(name1);
		}
		else if(name.equals("孙坚")){
			imageView2.setImageResource(R.drawable.sunjian);
			InsertName1Picture(name1);
		}
		else if(name.equals("孙策")){
			imageView2.setImageResource(R.drawable.sunce);
			InsertName1Picture(name1);
		}
		else if(name.equals("甘宁")){
			imageView2.setImageResource(R.drawable.ganning);
			InsertName1Picture(name1);
		}
		else if(name.equals("周瑜")){
			imageView2.setImageResource(R.drawable.zhouyu);
			InsertName1Picture(name1);
		}
		else if(name.equals("孙权")){
			imageView2.setImageResource(R.drawable.sunquan);
			InsertName1Picture(name1);
		}
		else if(name.equals("张苞")){
			imageView2.setImageResource(R.drawable.zhangbao);
			InsertName1Picture(name1);
		}
		else if(name.equals("华雄")){
			imageView2.setImageResource(R.drawable.huaxiong);
			InsertName1Picture(name1);
		}
		else if(name.equals("关平")){
			imageView2.setImageResource(R.drawable.guanping);
			InsertName1Picture(name1);
		}else if(name.equals("姜维")){
			imageView2.setImageResource(R.drawable.jiangwei);
			InsertName1Picture(name1);
		}
		else if(name.equals("陆逊")){
			imageView2.setImageResource(R.drawable.luxun);
			InsertName1Picture(name1);
		}
		else if(name.equals("司马懿")){
			imageView2.setImageResource(R.drawable.simayi);
			InsertName1Picture(name1);
		}
		else if(name.equals("张辽")){
			imageView2.setImageResource(R.drawable.zhangliao);
			InsertName1Picture(name1);
		}
		else if(name.equals("周泰")){
			imageView2.setImageResource(R.drawable.zhoutai);
			InsertName1Picture(name1);
		}
		else if(name1.equals("法正")){
			imageView2.setImageResource(R.drawable.fazheng);
			InsertName1Picture(name1);
		}
		else if(name.equals("徐庶")){
			imageView2.setImageResource(R.drawable.xushu);
			InsertName1Picture(name1);
		}
		else if(name.equals("李严")){
			imageView2.setImageResource(R.drawable.liyan);
			InsertName1Picture(name1);
		}
		else if(name.equals("马岱")){
			imageView2.setImageResource(R.drawable.madai);
			InsertName1Picture(name1);
		}
		else if(name.equals("张巍")){
			imageView2.setImageResource(R.drawable.zhangbao);
			InsertName1Picture(name1);
		}
		else if(name.equals("关兴")){
			imageView2.setImageResource(R.drawable.guanxing);
			InsertName1Picture(name1);
		}
		else if(name.equals("陈到")){
			imageView2.setImageResource(R.drawable.chendeng);
			InsertName1Picture(name1);
		}
		else if(name.equals("马忠")){
			imageView2.setImageResource(R.drawable.guanping);
			InsertName1Picture(name1);
		}
		else if(name.equals("王平")){
			imageView2.setImageResource(R.drawable.wangping);
			InsertName1Picture(name1);
		}
		else if(name.equals("向宠")){
			imageView2.setImageResource(R.drawable.xiangchong);
			InsertName1Picture(name1);
		}
		else if(name.equals("廖化")){
			imageView2.setImageResource(R.drawable.liaohua);
			InsertName1Picture(name1);
		}
		else if(name.equals("关索")){
			imageView2.setImageResource(R.drawable.guansuo);
			InsertName1Picture(name1);
		}
		else if(name.equals("黄权")){
			imageView2.setImageResource(R.drawable.huangquan);
			InsertName1Picture(name1);
		}
		else if(name.equals("张翼")){
			imageView2.setImageResource(R.drawable.zhangyi);
			InsertName1Picture(name1);
		}
		else if(name.equals("吴班")){
			imageView2.setImageResource(R.drawable.wuban);
			InsertName1Picture(name1);
		}
		else if(name.equals("周仓")){
			imageView2.setImageResource(R.drawable.zhoucang);
			InsertName1Picture(name1);
		}
		else if(name.equals("关银屏")){
			imageView2.setImageResource(R.drawable.guanyinping);
			InsertName1Picture(name1);
		}
		else if(name.equals("太史慈")){
			imageView2.setImageResource(R.drawable.taishici);
			InsertName1Picture(name1);
		}
		else if(name.equals("陆抗")){
			imageView2.setImageResource(R.drawable.lukang);
			InsertName1Picture(name1);
		}
		else if(name.equals("吕蒙")){
			imageView2.setImageResource(R.drawable.lvmeng);
			InsertName1Picture(name1);
		}else if(name.equals("鲁肃")){
			imageView2.setImageResource(R.drawable.lusu);
			InsertName1Picture(name1);
		}
		else if(name.equals("徐盛")){
			imageView2.setImageResource(R.drawable.xusheng);
			InsertName1Picture(name1);
		}
		else if(name.equals("黄盖")){
			imageView2.setImageResource(R.drawable.huanggai);
			InsertName1Picture(name1);
		}
		else if(name.equals("程普")){
			imageView2.setImageResource(R.drawable.chengpu);
			InsertName1Picture(name1);
		}
		else if(name.equals("韩当")){
			imageView2.setImageResource(R.drawable.handang);
			InsertName1Picture(name1);
		}
		else if(name1.equals("凌统")){
			imageView2.setImageResource(R.drawable.lingtong);
			InsertName1Picture(name1);
		}
		else if(name.equals("蒋钦")){
			imageView2.setImageResource(R.drawable.jiangqin);
			InsertName1Picture(name1);
		}
		else if(name.equals("丁奉")){
			imageView2.setImageResource(R.drawable.dingfeng);
			InsertName1Picture(name1);
		}
		else if(name.equals("孙尚香")){
			imageView2.setImageResource(R.drawable.sunshangxiang);
			InsertName1Picture(name1);
		}
		else if(name.equals("朱然")){
			imageView2.setImageResource(R.drawable.zhuran);
			InsertName1Picture(name1);
		}
		else if(name.equals("诸葛恪")){
			imageView2.setImageResource(R.drawable.zhugeke);
			InsertName1Picture(name1);
		}
		else if(name.equals("凌操")){
			imageView2.setImageResource(R.drawable.lingcao);
			InsertName1Picture(name1);
		}
		else if(name.equals("孙桓")){
			imageView2.setImageResource(R.drawable.sunhuan);
			InsertName1Picture(name1);
		}
		else if(name.equals("全琮")){
			imageView2.setImageResource(R.drawable.quancong);
			InsertName1Picture(name1);
		}
		else if(name.equals("吕岱")){
			imageView2.setImageResource(R.drawable.lvdai);
			InsertName1Picture(name1);
		}
		else if(name.equals("张昭")){
			imageView2.setImageResource(R.drawable.zhangzhao);
			InsertName1Picture(name1);
		}
		else if(name.equals("张紘")){
			imageView2.setImageResource(R.drawable.zhanghong);
			InsertName1Picture(name1);
		}
		else if(name.equals("顾雍")){
			imageView2.setImageResource(R.drawable.guyong);
			InsertName1Picture(name1);
		}
		else if(name.equals("步鸷")){
			imageView2.setImageResource(R.drawable.buzhi);
			InsertName1Picture(name1);
		}
		else if(name.equals("郭嘉")){
			imageView2.setImageResource(R.drawable.guojia);
			InsertName1Picture(name1);
		}
		else if(name.equals("徐晃")){
			imageView2.setImageResource(R.drawable.xuhuang);
			InsertName1Picture(name1);
		}
		else if(name.equals("邓艾")){
			imageView2.setImageResource(R.drawable.dengai);
			InsertName1Picture(name1);
		}
		else if(name.equals("曹仁")){
			imageView2.setImageResource(R.drawable.caoren);
			InsertName1Picture(name1);
		}
		else if(name.equals("张郃")){
			imageView2.setImageResource(R.drawable.zhanghe);
			InsertName1Picture(name1);
		}else if(name.equals("羊枯")){
			imageView2.setImageResource(R.drawable.yangku);
			InsertName1Picture(name1);
		}
		else if(name.equals("钟会")){
			imageView2.setImageResource(R.drawable.zhonghui);
			InsertName1Picture(name1);
		}
		else if(name.equals("司马师")){
			imageView2.setImageResource(R.drawable.simashi);
			InsertName1Picture(name1);
		}
		else if(name.equals("郭淮")){
			imageView2.setImageResource(R.drawable.guohuai);
			InsertName1Picture(name1);
		
		}
		else if(name.equals("郝昭")){
			imageView2.setImageResource(R.drawable.haozhao);
			InsertName1Picture(name1);
		}
		else if(name1.equals("杜预")){
			imageView2.setImageResource(R.drawable.duyu);
			InsertName1Picture(name1);
		}
		else if(name.equals("于禁")){
			imageView2.setImageResource(R.drawable.yujin);
			InsertName1Picture(name1);
		}
		else if(name.equals("许褚")){
			imageView2.setImageResource(R.drawable.xuchu);
			InsertName1Picture(name1);
		}
		else if(name1.equals("典韦")){
			imageView2.setImageResource(R.drawable.dianwei);
			InsertName1Picture(name1);
		}
		else if(name.equals("荀彧")){
			imageView2.setImageResource(R.drawable.xunyu);
			InsertName1Picture(name1);
		}
		else if(name.equals("荀攸")){
			imageView2.setImageResource(R.drawable.xunyou);
			InsertName1Picture(name1);
		}
		else if(name.equals("李典")){
			imageView2.setImageResource(R.drawable.lidian);
			InsertName1Picture(name1);
		}
		else if(name.equals("文聘")){
			imageView2.setImageResource(R.drawable.wenpin);
			InsertName1Picture(name1);
		}
		else if(name.equals("乐进")){
			imageView2.setImageResource(R.drawable.yuejin);
			InsertName1Picture(name1);
		}
		else if(name.equals("田豫")){
			imageView2.setImageResource(R.drawable.tianyu);
			InsertName1Picture(name1);
		}
		else if(name.equals("文鸯")){
			imageView2.setImageResource(R.drawable.wenyang);
			InsertName1Picture(name1);
		}
		else if(name.equals("王双")){
			imageView2.setImageResource(R.drawable.wangshuang);
			InsertName1Picture(name1);
		}
		else if(name.equals("曹真")){
			imageView2.setImageResource(R.drawable.caozhen);
			InsertName1Picture(name1);
		}
		else if(name.equals("贾诩")){
			imageView2.setImageResource(R.drawable.jiaxu);
			InsertName1Picture(name1);
		}
		else if(name.equals("曹洪")){
			imageView2.setImageResource(R.drawable.caohong);
			InsertName1Picture(name1);
		}
		else if(name.equals("曹纯")){
			imageView2.setImageResource(R.drawable.caochun);
			InsertName1Picture(name1);
		}
		else if(name.equals("孙礼")){
			imageView2.setImageResource(R.drawable.sunli);
			InsertName1Picture(name1);
		}
		else if(name.equals("满宠")){
			imageView2.setImageResource(R.drawable.manchong);
			InsertName1Picture(name1);
		}
		else if(name.equals("曹彰")){
			imageView2.setImageResource(R.drawable.caozhang);
			InsertName1Picture(name1);
		}
		else if(name.equals("陈泰")){
			imageView2.setImageResource(R.drawable.chentai);
			InsertName1Picture(name1);
		}
		else if(name.equals("司马昭")){
			imageView2.setImageResource(R.drawable.simazhao);
			InsertName1Picture(name1);
		}
		else if(name.equals("程昱")){
			imageView2.setImageResource(R.drawable.chengyu);
			InsertName1Picture(name1);
		}
		else if(name.equals("曹休")){
			imageView2.setImageResource(R.drawable.caoxiu);
			InsertName1Picture(name1);
		}else if(name.equals("陈登")){
			imageView2.setImageResource(R.drawable.chendeng);
			InsertName1Picture(name1);
		}
		else if(name.equals("刘晔")){
			imageView2.setImageResource(R.drawable.liuye);
			InsertName1Picture(name1);
		}
		else if(name.equals("高顺")){
			imageView2.setImageResource(R.drawable.gaoshun);
			InsertName1Picture(name1);
		}
		else if(name.equals("孔融")){
			imageView2.setImageResource(R.drawable.kongrong);
			InsertName1Picture(name1);
		}
		else if(name.equals("袁绍")){
			imageView2.setImageResource(R.drawable.yuanshao);
			InsertName1Picture(name1);
		}
		else if(name1.equals("颜良")){
			imageView2.setImageResource(R.drawable.yanliang);
			InsertName1Picture(name1);
		}
		else if(name.equals("文丑")){
			imageView2.setImageResource(R.drawable.wenchou);
			InsertName1Picture(name1);
		}
		else if(name.equals("田丰")){
			imageView2.setImageResource(R.drawable.tianfeng);
			InsertName1Picture(name1);
		}
		else if(name.equals("沮授")){
			imageView2.setImageResource(R.drawable.jushou);
			InsertName1Picture(name1);
		}
		else if(name.equals("袁术")){
			imageView2.setImageResource(R.drawable.yuanshu);
			InsertName1Picture(name1);
		}
		else if(name.equals("纪灵")){
			imageView2.setImageResource(R.drawable.jiling);
			InsertName1Picture(name1);
		}
		else if(name.equals("马腾")){
			imageView2.setImageResource(R.drawable.mateng);
			InsertName1Picture(name1);
		}
		else if(name.equals("庞德")){
			imageView2.setImageResource(R.drawable.pangde);
			InsertName1Picture(name1);
		}
		else if(name.equals("董卓")){
			imageView2.setImageResource(R.drawable.dongzhuo);
			InsertName1Picture(name1);
		}
		else if(name.equals("徐荣")){
			imageView2.setImageResource(R.drawable.xurong);
			InsertName1Picture(name1);
		}else if(name.equals("韩遂")){
			imageView2.setImageResource(R.drawable.hansui);
			InsertName1Picture(name1);
		}
		else if(name.equals("张鲁")){
			imageView2.setImageResource(R.drawable.zhanglu);
			InsertName1Picture(name1);
		}
		else if(name.equals("张任")){
			imageView2.setImageResource(R.drawable.zhangren);
			InsertName1Picture(name1);
		}
		else if(name.equals("孟获")){
			imageView2.setImageResource(R.drawable.menghuo);
			InsertName1Picture(name1);
		}
		else if(name.equals("皇甫嵩")){
			imageView2.setImageResource(R.drawable.huangfusong);
			InsertName1Picture(name1);
		}
		else if(name1.equals("朱儁")){
			imageView2.setImageResource(R.drawable.zhujun);
			InsertName1Picture(name1);
		}
		else if(name.equals("卢植")){
			imageView2.setImageResource(R.drawable.luzhi);
			InsertName1Picture(name1);
		}
		else if(name1.equals("公孙瓒")){
			imageView2.setImageResource(R.drawable.gongsunzan);
			InsertName1Picture(name1);
		}
	}

	@Override
	public void onCompletion(MediaPlayer mp) {
		// TODO Auto-generated method stub
		
	}
	
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		menu.add(0, 1, 1, R.string.exit);
		return super.onCreateOptionsMenu(menu);
	}
	
	
	public boolean onOptionsItemSelected(MenuItem item) {
		if(item.getItemId()==1)
		{
			Exit.getInstance().exit();
		}
		return super.onOptionsItemSelected(item);
	} 

}
