package com.example.a.androidui;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.example.a.androidui.overlayutil.DbHelper;
import com.example.a.androidui.overlayutil.Fruit;
import com.example.a.androidui.overlayutil.FruitAdapter;
import com.example.a.androidui.overlayutil.MyOnItemClickListener;
import com.example.a.androidui.overlayutil.MyOnItemLongClickListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AVIActivity extends AppCompatActivity {
    private DrawerLayout mDrawerLayout;
    //定义视频数据库
    private Fruit[] fruits={new Fruit("中美欧医院对比：看完才知道，中国的医疗有多强大！",R.drawable.yiliao1,"https://haokan.baidu.com/v?vid=8233689982856894589&pd=bjh&fr=bjhauthor&type=video"),
            new Fruit("花几百块买“百万”医疗险，千万别以为捡了大便宜，还需擦亮双眼",R.drawable.yiliao2,"https://haokan.baidu.com/v?vid=14315960980271241925&pd=bjh&fr=bjhauthor&type=video"),
            new Fruit("龙永图大谈对看病贵的思考，不仅仅是医疗问题更是社会问题",R.drawable.yiliao4,"https://haokan.baidu.com/v?vid=17100728485907115842&pd=bjh&fr=bjhauthor&type=video"),
            new Fruit("临床医学的介绍",R.drawable.yixue1,"https://haokan.baidu.com/v?vid=9748552151973604759&pd=bjh&fr=bjhauthor&type=video"),
            new Fruit("医学知识科普：糖尿病到底是怎么回事",R.drawable.yixue2,"https://haokan.baidu.com/v?vid=16799525139383023065&pd=bjh&fr=bjhauthor&type=video"),
            new Fruit("临床医学5+3一体化是什么意思",R.drawable.yixue3,"https://haokan.baidu.com/v?vid=12368799618560215058&pd=bjh&fr=bjhauthor&type=video"),
            new Fruit("那些上了医学院的学生，后来怎么样了？",R.drawable.yixue4,"https://haokan.baidu.com/v?vid=16330260861400437527&pd=bjh&fr=bjhauthor&type=video"),
            new Fruit("焦虑症在医学上是如何治疗的呢？",R.drawable.yixue5,"https://haokan.baidu.com/v?vid=10077076971144345552"),
            new Fruit("带你参观清华医学院，小苏学姐也好奇的清华大学解剖实验室",R.drawable.yixue6,"https://haokan.baidu.com/v?vid=2099520376721244325"),
            new Fruit("医学生的聊天方式，看完以后理解医生了",R.drawable.yixue7,"https://haokan.baidu.com/v?vid=1964110023181868843"),
            new Fruit("女性宫颈癌，终于有了解决方案，医学又进一步",R.drawable.yixue8,"https://haokan.baidu.com/v?vid=13656046796879568946"),
            new Fruit("资深医师科普各种肺癌类型，随着医学发达治癌症方法越来越多",R.drawable.yixue9,"https://haokan.baidu.com/v?vid=18355860309691753111"),
            new Fruit("专家解释耳石症的形成原因！没想到医学如此奇妙，我竟完全看不懂",R.drawable.yixue10,"https://haokan.baidu.com/v?vid=9951240235242600449"),
            new Fruit("43岁妻子3次得癌症，博士丈夫苦心钻研医学，没想到竟发生奇迹",R.drawable.yixue11,"https://haokan.baidu.com/v?vid=9240577150845658470"),
            new Fruit("杨进刚：心脏猝死，现代医学挽救不了迷失的心",R.drawable.yixue12,"https://haokan.baidu.com/v?vid=14588802122959724954"),
            new Fruit("北大医学院美女硕士毕业演讲：我不是药神，我只是药师！值得收藏",R.drawable.yixue13,"https://haokan.baidu.com/v?vid=16308412964849523757\n"),
            new Fruit("得了抑郁症，该怎么自我调节？精神医学科医生说出了心里话",R.drawable.yixue14,"https://haokan.baidu.com/v?vid=7260496465819499819"),
            new Fruit("隐私部位该如何有效的消毒？专家给出一瓶溶液，经常用于医学上",R.drawable.yixue15,"https://haokan.baidu.com/v?vid=14576727591712070977"),
            new Fruit("为什么“全麻手术”是一种濒死体验呢，医学博士说出真相",R.drawable.yixue16,"https://haokan.baidu.com/v?vid=13226465995922654084"),
            new Fruit("医学教授曾新创切除法，并因此获诺贝尔奖，但它却使很多人变痴呆",R.drawable.yixue17,"https://haokan.baidu.com/v?vid=5836516309524662309"),
            new Fruit("世界顶级医学期刊在线发表：中国重组新冠疫苗Ⅱ期临床试验结果",R.drawable.yixue18,"https://haokan.baidu.com/v?vid=2000105075246417321\n"),
            new Fruit("专家现场讲解肺癌的现代医学治疗方式，让你无需害怕健康治疗",R.drawable.yixue19,"https://haokan.baidu.com/v?vid=12013571402321089827"),
            new Fruit("十人九痔，专家从医学上解释其发病原因，别等流血了才发现",R.drawable.yixue20,"https://haokan.baidu.com/v?vid=7876595139885095376"),
            new Fruit("在二十世纪，青霉素的诞生，是整个人类医学史上最伟大的里程碑",R.drawable.yixue21,"https://haokan.baidu.com/v?vid=8639247638929020415"),
            new Fruit("诺贝尔奖“污点”：让上万人失智的医生，却获得医学界的至高荣耀",R.drawable.yixue22,"https://haokan.baidu.com/v?vid=11458294296650960593"),
            new Fruit("专家分享医学小妙招，运动运动可帮助健脾",R.drawable.yixue23,"https://haokan.baidu.com/v?vid=1380979542025289845"),
            new Fruit("医学博士下病房，轮转第一站，首次腰穿失败，落寞迷茫",R.drawable.yixue24,"https://haokan.baidu.com/v?vid=8528835036520532952"),
            new Fruit("专家分享医学妙招，看舌苔区分实火跟虚火",R.drawable.yixue25,"https://haokan.baidu.com/v?vid=2001870392135800146"),
            new Fruit("临床医学研究生一天的生活，看完满满励志正能量！",R.drawable.yixue26,"https://haokan.baidu.com/v?vid=4080819666792722744"),
            new Fruit("健康有道：“肾藏精”，医学专家告诉你这个精是什么",R.drawable.yixue27,"https://haokan.baidu.com/v?vid=9212466433852565309"),
            new Fruit("小咳嗽大学问！医学博士为你详细解读三种不同的咳嗽症状",R.drawable.yixue28,"https://haokan.baidu.com/v?vid=2089297535962640434"),
            new Fruit("76岁退休医师98年曾患癌症，她讲抗癌经历，堪称“医学奇迹”！",R.drawable.yixue29,"https://haokan.baidu.com/v?vid=6299629500144945966"),
            new Fruit("余亮：当年的帝国主义如何利用医学宣传殖民合理性？",R.drawable.yixue30,"https://haokan.baidu.com/v?vid=7106484997461002402"),
            new Fruit("世界级权威医学专家指出：不尊重科学是防控不力国家的根本问题",R.drawable.yixue31,"https://haokan.baidu.com/v?vid=2637861817441291401"),
            new Fruit("哈佛大学医学院教授：新冠肺炎疫情可能有四种结局",R.drawable.yixue32,"https://haokan.baidu.com/v?vid=739146386977379286"),
            new Fruit("张雪峰：兽医学有前途吗？你参加过给猫过生日的Party就明白了！",R.drawable.yixue33,"https://haokan.baidu.com/v?vid=12412027284367775109"),
            new Fruit("医学常识课：你有过耳鸣吗？专家带你了解耳鸣的原因",R.drawable.yixue34,"https://haokan.baidu.com/v?vid=2695374435736841237"),
            new Fruit("3D科普2018诺奖医学研究 如何激活免疫系统“咬死”癌细胞？",R.drawable.yixue35,"https://haokan.baidu.com/v?vid=989452664772343372"),
            new Fruit("试管婴儿是什么？第三代的功能惊呆整个医学界!",R.drawable.yixue36,"https://haokan.baidu.com/v?vid=10103667577122928817"),
            new Fruit("祛斑产品的真有效吗？专家这样解释，医学护肤品不够！",R.drawable.yixue37,"https://haokan.baidu.com/v?vid=16743388602845618248"),
            new Fruit("水蛭还能治疗心脑血管疾病？医学专家现场讲解，快来看看吧",R.drawable.yixue38,"https://haokan.baidu.com/v?vid=12561819202772891861"),
            new Fruit("膝关节的退化过程，医学专家现场讲解，快来看看吧",R.drawable.yixue39,"https://haokan.baidu.com/v?vid=3940191933601610010"),
            new Fruit("什么是胃食管反流？具体都有哪些症状？医学专家现场解析",R.drawable.yixue40,"https://haokan.baidu.com/v?vid=16877254367714132076"),
            new Fruit("医学常识课：乙肝是如何发展成肝癌呢？专家现场解答",R.drawable.yixue41,"https://haokan.baidu.com/v?vid=13014955552502352543"),
            new Fruit("世界权威医学期刊《柳叶刀》揭秘深圳防控关键",R.drawable.yixue42,"https://haokan.baidu.com/v?vid=2872010546072117390"),
            new Fruit("针刀医学和经络学说的关系",R.drawable.yixue43,"https://haokan.baidu.com/v?vid=2356171450383417434"),
            new Fruit("肺癌早期症状都有啥？医学专家：早期基本没症状，所以体检很重要",R.drawable.yixue44,"https://haokan.baidu.com/v?vid=523923910938469247"),
            new Fruit("拯救沉默的肾衰竭，到底应该怎么做，医学专家现场讲解",R.drawable.yixue45,"https://haokan.baidu.com/v?vid=3523995579810157895"),
            new Fruit("钟南山谈疫情死亡率会再降低，传染病专家需配备重症医学专家",R.drawable.yixue46,"https://haokan.baidu.com/v?vid=11528141004655069078"),


    };

    private List<Fruit> fruitList=new ArrayList<>();
    private List<String> urlListadr=new ArrayList<>();
    private FruitAdapter adapter;
    private SwipeRefreshLayout swipeRefreshLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cardtry);

        initFruit();
        RecyclerView recyclerView =findViewById(R.id.recycler_view);
        GridLayoutManager layoutManager=new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(layoutManager);
        adapter=new FruitAdapter(fruitList);
        recyclerView.setAdapter(adapter);
        final DbHelper dbHelper=new DbHelper(this,"History.db",null,2);


//点击事件
        adapter.setOnItemClickListener(new MyOnItemClickListener() {
            @Override
            public void OnItemClickListener(View view, int position) {
                int hh=position;
                String fruitname=fruitList.get(hh).getName();
                SQLiteDatabase db=dbHelper.getWritableDatabase();
                ContentValues values=new ContentValues();
                values.put("read",fruitname);
                db.insert("ReadHistory",null,values);
                values.clear();

                Toast.makeText(getApplicationContext(), "position" + position + "被点击", Toast.LENGTH_SHORT).show();
                System.out.println("hhhhh"+ urlListadr.get(hh));//获取到了url值，进行网址的传参

                //将网址地址传递给下一个Activity
                String getUrlstring=urlListadr.get(hh);
                Intent intent=new Intent(AVIActivity.this,ActivityWebView_forsee.class);
                intent.putExtra("readurl",getUrlstring);
                startActivity(intent);


            }
        });
        /*长按事件*/
        adapter.setOnItemLongClickListener(new MyOnItemLongClickListener() {
            @Override
            public void OnItemLongClickListener(View view, int position) {
                /*长按删除*/
                fruitList.remove(position);
                adapter.notifyItemRemoved(position);
            }
        });


        swipeRefreshLayout=findViewById(R.id.swipe_refresh);
        swipeRefreshLayout.setColorSchemeResources(R.color.colorPrimary);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refreshFruit();
            }
        });

    }

    private void refreshFruit() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        initFruit();
                        adapter.notifyDataSetChanged();
                        swipeRefreshLayout.setRefreshing(false);
                    }
                });
            }
        }).start();
    }

    private void initFruit() {
        fruitList.clear();
        for(int i=0;i<12;i++){
            Random random=new Random();
            int index=random.nextInt(fruits.length);
            fruitList.add(fruits[index]);
            urlListadr.add(fruits[index].getUrlnume());
        }
    }





}
