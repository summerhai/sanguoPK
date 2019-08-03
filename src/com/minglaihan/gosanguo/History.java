package com.minglaihan.gosanguo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;


import com.minglaihan.generalpk.ChooseGeneral1;
import com.minglaihan.sanguopk.R;
import com.minglaihan.tools.Exit;

public class History extends Activity{
	
	private Bundle bundle;
	private Intent intent;
	public int id;
	private ImageView imageView1,imageView2,imageView3;
	private TextView textView1,textView2,textView3;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.history);
		Exit.getInstance().addActivity(this);
		
		
		
		imageView1 = (ImageView)findViewById(R.id.generalImage1);
		imageView2 = (ImageView)findViewById(R.id.generalImage2);
		imageView3 = (ImageView)findViewById(R.id.imageView3);
		
		textView1 = (TextView)findViewById(R.id.generalInfo);
		textView2 = (TextView)findViewById(R.id.textView2);
		textView3 = (TextView)findViewById(R.id.textView3);
		
		intent = this.getIntent();		
		bundle = intent.getExtras();
		
		if(bundle!=null){		
			id = bundle.getInt("id");
			if(id == 1){
				imageView1.setImageResource(R.drawable.history11);
				imageView2.setImageResource(R.drawable.history12);
				imageView3.setImageResource(R.drawable.history13);
				
				textView1.setText("东汉末年，由於土地兼并越加尖锐，地主豪强拥有自己的私人武力，加上中央政府政治黑暗，皇权虚弱无力，对地方过度放权，因而造成群雄割据的局面.");
				textView2.setText("黄巾之乱，是中国东汉晚期的民变，开始于汉灵帝光和七年（184年），由张角等人领导，它对东汉朝廷的统治产生了巨大的冲击，逐步导致了东汉的灭亡与三国时期的到来。");
				textView3.setText("汉灵帝派皇甫嵩、卢植及朱隽等率中央军压制，又令地方州郡政府和豪强地主招募军队协助。最后黄巾军的主力虽然很快被击溃，不过余部仍然散布各地。随着各地山贼土匪陆续出现，汉朝的中央军精疲力竭。至此，中国历史掀开了三国的序幕");
				
			}else if(id == 2){
				imageView1.setImageResource(R.drawable.history21);
				imageView2.setImageResource(R.drawable.history22);
				imageView3.setImageResource(R.drawable.history23);
				
				textView1.setText("187年，凉州刺史耿鄙任信奸吏，导致狄道人王国以及氐、羌等少数民族造反，州郡征集勇士，欲讨伐叛乱。马腾应征，被州郡官员看重，任命为军从事。不久，耿鄙被手下杀死，马腾则联合韩遂等人，共同推举王国为主帅，在三辅作乱。");
				textView2.setText("张举本为泰山太守。187年，张纯因不获张温重用而心生不愤，与张举及乌桓丘力居等人叛乱。张举与张纯领军劫略蓟中，杀护乌桓校尉公綦稠、右北平太守刘政、辽东太守阳终等人，聚众至十余万人，屯兵肥如，掠夺幽州、冀州。张举自称天子。");
				textView3.setText("长沙贼区星自称将军，众万馀人，攻围城邑。石、周朝亦帅徒众起於桂、零，与星相应。长沙太守孙坚遂越境寻讨，三郡肃然，群雄割据的局面就此展开。");
			}else if(id == 3){
				imageView1.setImageResource(R.drawable.history31);
				imageView2.setImageResource(R.drawable.history32);
				imageView3.setImageResource(R.drawable.history33);
				
				textView1.setText("董卓为了夺权，开始铲除反对者，手段残暴，引起了诸多不满。他促使吕布杀死掌管都城禁卫的丁原夺得其军队，袁绍及曹操等原先掌握过兵权的将领纷纷逃离首都洛阳。最后董卓废除并杀死了汉少帝，改立刘协为帝，史称汉献帝，至此董卓完全掌握了朝廷。");
				textView2.setText("190年，东郡太守桥瑁诈称以京师三公之名向各地发檄文，陈述董卓的恶行，联络各地州牧、刺史及太守讨伐董卓，共有十一路地方军加入，群雄并起，共推袁绍为盟主，史称“关东军”。");
				textView3.setText("期间，还发生了历史上著名的“三英战吕布”。192年董卓最后被司徒王允和部下吕布等合谋刺杀，不久董卓属下李傕、郭汜等人率兵攻入长安，杀死王允，吕布兵败逃亡，李傕等人挟持汉献帝，专政四年。汉室天下再度危亡。");
			}else if(id == 4){
				imageView1.setImageResource(R.drawable.history41);
				imageView2.setImageResource(R.drawable.history42);
				imageView3.setImageResource(R.drawable.history43);
				
				textView1.setText("反董卓联盟解散后，袁绍先用计占据韩馥的冀州，继而打败田楷、臧洪、公孙瓒等人，掌握青、冀、幽、并四州，雄霸河北，气势强劲。");
				textView2.setText("曹操四处征战，收编黄巾军余部男女老少约十万人，择其精锐组成了著名的“青州军”，几经转折，控制了兖州。但此时曹操因为父亲在徐州被害把怒火倾向徐州，徐州太瘦陶谦请刘玄德来解围。");
				textView3.setText("面对曹操的大军，刘备先是从公孙瓒手中借来赵云及兵马，然后修书曹操陈其利害，此时曹操的老家被吕布偷袭，所以他急于回兵，顺手卖了刘备的人情。至此，徐州解围，陶谦病故后，徐州尽归刘关张，从此刘备展开了新的征程。");
			}else if(id == 5){
				imageView1.setImageResource(R.drawable.history51);
				imageView2.setImageResource(R.drawable.history52);
				imageView3.setImageResource(R.drawable.history53);
				
				textView1.setText("吕布在出长安后，在张扬处和陈宫交好，陈宫一心想辅佐吕布成就霸业，于是二人带着手下的兵将趁机占领了濮阳，谋求更大的发展");
				textView2.setText("另一方面，刘备在接手徐州后，与云长翼德及一班徐州将领把徐州治理的井井有条，刘皇叔深得人心，蓄势待发");
				textView3.setText("同时，孙策依靠玉玺从袁术手里借来了兵马，从庐江起事，在自己兄弟周瑜的细心辅佐下，先后收纳江东二张，气势正盛，重现当年江东霸王之相。从此汉室天下进入了群雄割据的局面。");
			}else if(id == 6){
				imageView1.setImageResource(R.drawable.history61);
				imageView2.setImageResource(R.drawable.history62);
				imageView3.setImageResource(R.drawable.history63);
				
				textView1.setText("实力膨胀的袁绍错失了田丰等人迎接天子的良机，在曹操势头正盛的时候发起了战争，先后派颜良文丑提大军压境");
				textView2.setText("而曹操在荀彧等人的建议下拥护天子入城，此后官拜司空，挟天子以令诸侯，面对来势汹汹的袁绍，曹操头疼不已，然而一直深受曹操大恩的关羽一直想回报于曹操，于是先后在白马延津斩了颜良文丑，威风大振");
				textView3.setText("袁绍怒而发兵，就这样，两位三国历史上雄霸一方的诸侯开始在官渡展开了大战，这场大战将决定着中原的归属及走向，");
			}else if(id == 7){
				imageView1.setImageResource(R.drawable.history71);
				imageView2.setImageResource(R.drawable.history72);
				imageView3.setImageResource(R.drawable.history73);
				
				textView1.setText("官渡之战以曹操奇袭袁军在乌巢的粮仓而获得大胜，继而击溃袁军主力。此战奠定曹操统一中国北方的基础，整顿兵马后，目标直指南方，风头更盛。");
				textView2.setText("刘备在丢失徐州后投入刘表帐下，在新野小城驻扎，空有关羽张飞赵云等猛将，却无良谋军师，遇到徐庶后本以为可以舒展雄心，却还是被曹操设计挖走，徐庶临行推荐了诸葛亮，给刘备指明了一条名录");
				textView3.setText("探知卧龙下落，刘关张三次亲身草庐求见，识大体知礼仪，终于感到了诸葛亮继而出山辅佐，在草庐之中，孔明已为刘备指明了天下三分的局面，天下大势由此展开，");
			}else if(id == 8){
				imageView1.setImageResource(R.drawable.history81);
				imageView2.setImageResource(R.drawable.history82);
				imageView3.setImageResource(R.drawable.history83);
				
				textView1.setText("曹操在收取袁绍的势力后，坐拥北方，雄兵百万，休整之后目标直指南方孙权，此时荆州刘表病故，蔡氏同蔡瑁惧怕曹操而投降，曹操唾手得荆襄九郡，刘备不得已再次逃亡");
				textView2.setText("同时，面对来势汹汹的曹操，孙权一方面积极整顿兵马，另一方面派鲁肃前往江夏探听曹操虚实，手下的谋臣逐渐分为主降派和主战派，令孙权头疼不已");
				textView3.setText("面对共同的强敌曹操，诸葛亮只身赴江东，舌战群儒陈其利害，并最终激励了孙权决心一站，孙权更大的信心来自于周瑜的肯定，这样一来，三国历史上两位出色的谋士第一次擦出了火花，也为赤壁之战留下了千古美名，");
			}else if(id == 9){
				imageView1.setImageResource(R.drawable.history91);
				imageView2.setImageResource(R.drawable.history92);
				imageView3.setImageResource(R.drawable.history93);
				
				textView1.setText("曹操的野心在赤壁的熊熊烈火下燃烧殆尽，在诸葛亮的重重包围下最后由关羽华容道逃脱，仓皇的逃回许昌，好不容易积累的实力再次跌落，曹操不得不继续休整军马，以待雪耻");
				textView2.setText("然而曹操并不是不再想去南方，因为西凉的马超趁机为父马腾兴兵雪恨，马超神勇屡胜曹操，锦马超逼得曹操割须弃袍，成就马超的英勇，但是最终还是被曹操用贾诩的反间计击败马超，马超败走投汉中，此后曹操后顾无忧，再次准备南下");
				textView3.setText("而孙刘联盟却面临危机，因为本属于江东的荆州被诸葛亮巧夺，周瑜怒不可遏，刘备借推脱之辞带兵入蜀，平定益州，纳降刘璋，入驻成都，大赏文武，还收服了马超，当时立关张赵马黄为五虎大将，刘备声威大震，");
			}else if(id == 10){
				imageView1.setImageResource(R.drawable.history101);
				imageView2.setImageResource(R.drawable.history102);
				imageView3.setImageResource(R.drawable.history103);
				
				textView1.setText("刘备自领汉中王后，担心孙权和曹操联盟来打，于是采取军师诸葛亮的计策先下手为强，让关羽在荆州起兵，攻打樊城，");
				textView2.setText("此时樊城由大将曹仁驻守，他一方面坚守不出，一方面紧急求援，曹操派于禁庞德率七路大军来解樊城之危，期间庞德是由汉中张鲁处曹操收服，庞德勇猛刚毅，为表忠心带棺材上阵，誓取关羽");
				textView3.setText("面对樊城来援，关羽一方面做好荆州的防范准备，一方面迎敌曹操的军马，关羽熟读兵书，而且熟悉当地的地理地形，借着天时地利，关羽巧妙的堵住河水，待到水涨，樊城一片汪洋，七军也不复存亡，庞德不吸水性，被周仓捕获，最终被斩，而于禁兵败投降，自此关云长威震华夏，无人敢掠其锋芒，");
			}else if(id == 11){
				imageView1.setImageResource(R.drawable.history111);
				imageView2.setImageResource(R.drawable.history112);
				imageView3.setImageResource(R.drawable.history113);
				
				textView1.setText("关羽水淹七军后，孙权越发想将荆州夺回来，孙刘联盟已然岌岌可危");
				textView2.setText("大都督吕蒙在启用陆逊的建议后，将将军的职位让给陆逊，以骄关羽之心，关羽于是尽起荆州之兵讨伐樊城，荆州空虚，吕蒙白衣渡江，攻克江陵等地，悄悄的来到关羽的背后");
				textView3.setText("关羽由于傲气十足加上错用糜芳傅士仁，失去了荆州后派廖化去上庸求救，此时的孟达刘封深知自己兵力不足，有退却之意，廖化气氛回成都，而此时关羽等人已被孙权军捕获，拒降而被斩，享年58岁。首级被送往曹操处，从此荆州归属东吴，");
			}else if(id == 12){
				imageView1.setImageResource(R.drawable.history121);
				imageView2.setImageResource(R.drawable.history122);
				imageView3.setImageResource(R.drawable.history123);
				
				textView1.setText("刘备即位称帝后，一心想要给关羽复仇，所以不顾诸葛亮和赵云等人的劝阻，执意伐吴，并且派张飞为先锋");
				textView2.setText("张飞由于二哥关羽的牺牲也是异常悲愤，他经常鞭打士卒，得知要伐吴他命手下的范疆张达三日内赶做白旗白袍等，两人为求宽限多次求情反遭毒打，二人心生毒计，趁张飞入睡将其杀害，连夜带着人头前往东吴");
				textView3.setText("孙权本来就很头疼，得知刘备来打，他主动做出很多让步，不得已后来都想归还荆州以示和好，但是刘备铁心要伐吴，孙权只好派将抵挡，岂知连连败阵并且损兵折将，正在孙权焦头烂额之际，阚泽以全家性命保举陆逊，孙权孤注一掷，任命陆逊为大都督，总领兵马，自此夷陵之战展开，");
			}else if(id == 13){
				imageView1.setImageResource(R.drawable.history131);
				imageView2.setImageResource(R.drawable.history132);
				imageView3.setImageResource(R.drawable.history133);
				
				textView1.setText("陆逊以骄兵之计骗得刘备联营驻扎，导致后来的夷陵惨败，刘备败逃白帝城，临终托孤诸葛亮，告知如果刘禅可以辅佐则辅佐，不可以辅佐的你可以自己当皇帝，诸葛亮感恩于心，发誓效忠汉室。刘禅登基，魏国司马懿建议五路伐蜀，一二路是北方羌族和南方孟获");
				textView2.setText("第三路是降将孟达从上庸起兵，第四路孙权派人从江陵永安一带进兵");
				textView3.setText("最后曹真大都督总督五路人马，从长安进兵汉中，意图使诸葛亮首位不能顾。而诸葛亮悄然化解四路人马，只待孙权这一路他在犹豫");
			}else if(id == 14){
				imageView1.setImageResource(R.drawable.history141);
				imageView2.setImageResource(R.drawable.menghuo);
				imageView3.setImageResource(R.drawable.history143);
				
				textView1.setText("刘备的大意，造就了陆逊火烧连营七百里的悲剧，蜀国精锐损失殆尽，刘备失意病倒在白帝城，临终托孤给诸葛亮，让其辅佐刘婵，情到深处发自肺腑。诸葛亮感恩先主知遇之恩，全心全力为蜀国建设");
				textView2.setText("由于南方雍凯伙同南王孟获反叛，诸葛亮深知南人野性难驯，于是不顾危险，深入不毛之地，以大智慧大勇气先后七擒七纵，一心只希望孟获心服");
				textView3.setText("孟获由最初的骄横到最后的心悦诚服，至此发誓永不再犯永守南疆，汉丞相诸葛亮攻心为上平定了南方，解决了蜀国的后顾之忧，");
			}else if(id == 15){
				imageView1.setImageResource(R.drawable.history151);
				imageView2.setImageResource(R.drawable.history152);
				imageView3.setImageResource(R.drawable.history153);
				
				textView1.setText("平定南方后，加上邓芝成功游说孙权，孙刘再次联盟，诸葛亮养精蓄锐，见时机成熟，上奏天子《出师表》，陈词慷慨激昂令人振奋，调动军马后，惹恼了老将赵云");
				textView2.setText("赵云将军戎马一生，此时五虎将也只剩他一个，军师担心赵云将军常胜将军的威名有损，所以没有派赵云任务，岂知老将军坚持要做先锋，赵云最后派邓芝为辅，赵云老将出师大捷，力斩西凉大将韩德及其四子，威风不减当年");
				textView3.setText("但是由于街亭镇守不利，诸葛亮在收取姜维后，果断退兵，挥泪斩了马谡，第一次北伐以失败告终，");
			}else if(id == 16){
				imageView1.setImageResource(R.drawable.history161);
				imageView2.setImageResource(R.drawable.simayi);
				imageView3.setImageResource(R.drawable.history163);
				
				textView1.setText("第一次北伐失败后，诸葛亮积极组织第二次三次的北伐，但是被魏国守将拖住，延误了战机，等到援兵来到，将陷入持久战，对蜀国不利，于是诸葛亮安心种田三年，粮草充足");
				textView2.setText("但是还有一个让诸葛亮很不放心的元素是司马懿，此人深知韬略，有勇有谋，和诸葛亮几番斗智斗勇，虽然几次失败，但是最终还是守住了魏国的疆土");
				textView3.setText("就这样，一场场的北伐与防守，两个人的对峙也一直在持续，可以说，魏蜀之战，在于司马懿和诸葛亮的对手之战，");
			}else if(id == 17){
				imageView1.setImageResource(R.drawable.history171);
				imageView2.setImageResource(R.drawable.jiangwei);
				imageView3.setImageResource(R.drawable.history173);
				
				textView1.setText("北伐经历很长一段时间后，在五丈原，诸葛亮知道自己的大限将至，本以镶星之法延续寿命，但是被魏延无意破坏，诸葛亮叹息一口，安排好后事，与世长辞，三军肃穆");
				textView2.setText("得知丞相归天，整个蜀国进入低潮期，刘禅痛苦不已。姜维继承了诸葛丞相的兵法策略等，一心想兴兵完成丞相的遗愿，他加紧操练人马，");
				textView3.setText("整顿好人马后，姜维也从汉中入手，准备伐魏，此时司马懿也病逝，朝政由司马师和司马昭掌控，二人谋害夏侯将军一家，夏侯霸投奔西蜀，自此以姜维、邓艾钟会为首的后三国时代到来，");
			}else if(id == 18){
				imageView1.setImageResource(R.drawable.history181);
				imageView2.setImageResource(R.drawable.history182);
				imageView3.setImageResource(R.drawable.history183);
				
				textView1.setText("邓艾钟会是魏国后起之秀，他们深具韬略，用兵有方，后三国时代的大将已经很少了，蜀国魏延被马岱所斩，只剩廖化等一班蜀将，姜维夏侯霸继续准备北伐");
				textView2.setText("魏国方面派邓艾镇守长安，抵御汉中来兵，双方战事胶着，防范了蜀国几次偷袭，成功将姜维逼回西蜀。");
				textView3.setText("而此时，魏国因为屡次遭蜀国来伐，下决心伐蜀，派邓艾和钟会从两路分兵进蜀，蜀国的最后之战即将开启，");
			}else if(id == 19){
				imageView1.setImageResource(R.drawable.history102);
				imageView2.setImageResource(R.drawable.history191);
				imageView3.setImageResource(R.drawable.history193);
				
				textView1.setText("在伐蜀前，钟会建议先打造大船，一副伐吴的姿态，然后悄悄伐蜀，等到伐蜀成功，大船已成，就可以伐吴，钟会邓艾分兵两路，两人互有争功");
				textView2.setText("钟会所指挥的东路魏军是主力，被蜀军阻拦在险要之地剑阁，无法前进。魏军西路指挥官邓艾在攻占沓中后，向钟会建议说：“如果从阴平偷越，直向涪城，剑阁守敌必定回救涪城，大军即可乘势前进；如果剑阁守敌不撤，涪城空虚，定能攻下。”钟会接受这一建议，令邓艾实施。");
				textView3.setText("阴平与剑阁相隔百余里，是氐羌民族居住区，崇山峻岭，很难行走，蜀军也没有设防。邓艾从沓中出发，通过了阴平小道，直扑涪城。涪城守将马邈面对从天而降的魏军，不战而降。魏军从此迅速连下涪城、绵竹，逼近成都，刘禅投降，蜀汉亡。");
			}else if(id == 20){
				imageView1.setImageResource(R.drawable.history201);
				imageView2.setImageResource(R.drawable.history202);
				imageView3.setImageResource(R.drawable.history143);
				
				textView1.setText("魏国由于司马懿之功使得司马家独大，等到曹芳暗弱，司马昭趁势自立大晋，自此魏国尽属晋，灭蜀之后，吴国由于孙皓的昏庸导致国力衰败，很快也被灭亡，三国自此被晋国统一");
				textView2.setText("正所谓三国演义的第一句“话说天下大势合久必分分久必合”，人才辈出的三国时代验证了这一道理，这一段历史不仅名将辈出，更让我们看到了中华民族本身具有的气质");
				textView3.setText("三国是一个与众不同的时代，它没有青楼与赌场，无论是官方还是民间都奉行儒家文化，宣扬仁、义、道、德、礼、信、忠、贞、孝、廉、善、美、真，是汉文化的再体现，体现了中华人民的伟大精神。");
			}	
		}
			

	}

	@Override
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
