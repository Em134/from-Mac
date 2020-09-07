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

public class FruitActivity extends AppCompatActivity {
    private DrawerLayout mDrawerLayout;
    //定义文章数据库
    private Fruit[] fruits={new Fruit("牙痛有5个特征，很遗憾，你的蛀牙发展到牙髓炎了！",R.drawable.kouqiang1,"http://mouth.39.net/a/190911/7460283.html"),
            new Fruit("牙痛不是病？4个常见口腔误区，误导了太多人",R.drawable.kouqinag2,"http://mouth.39.net/a/200423/7856380.html "),
            new Fruit("牙缝里黄黄的东西是什么？医生：2个方法轻松去掉，别等它变硬",R.drawable.kouqiang3,"http://mouth.39.net/a/200219/7786717.html "),
            new Fruit("缓解牙痛，临床上常见的药物有哪些？",R.drawable.kouqiang4,"http://mouth.39.net/a/181206/6667898.html "),
            new Fruit("多吃洋葱香菇有利于牙齿坚固",R.drawable.kouqiang5,"http://mouth.39.net/a/171130/5887439.html "),
            new Fruit("5个家常小妙招，防止牙齿变黄",R.drawable.kouqiang6,"http://mouth.39.net/a/170608/5438338.html "),
            new Fruit("你的口腔“衰老”了吗？口腔衰老10症状",R.drawable.kouqiang7,"http://mouth.39.net/a/170506/5352187.html "),
            new Fruit("五大症状，是牙龈炎“警告”！自查一下",R.drawable.kouqiang8,"http://mouth.39.net/a/190109/6783264.html "),
            new Fruit("口臭而不自知？自查口气，有四个小窍门",R.drawable.kouqiang9,"http://mouth.39.net/a/181227/6687263.html"),
            new Fruit("频繁使用漱口水当心四大危害",R.drawable.kouqiang10,"http://mouth.39.net/a/140916/4473840.html "),
            new Fruit("牙齿咬硬物痛怎么回事？这些原因了解一下",R.drawable.kouqiang11,"http://mouth.39.net/a/190930/7507199.html "),
            new Fruit("口腔清洁“保卫战”，你打赢了吗？ | 口腔知识科普系列（四）",R.drawable.kouqiang12,"http://mouth.39.net/a/190929/7498434.html "),
            new Fruit("不是天方夜谭！牙齿也会长肿瘤",R.drawable.kouqiang13,"http://mouth.39.net/a/171017/5764254.html "),
            new Fruit("磨牙的原因 看看你是否是这样",R.drawable.kouqiang14,"http://mouth.39.net/a/150817/4675737.html"),
            new Fruit("长智齿牙疼怎么办 需要拔牙吗",R.drawable.kouqiang15,"http://mouth.39.net/a/150817/4675808.html "),
            new Fruit("口干舌燥可能预示哪些疾病 要警惕",R.drawable.kouqiang16,"http://mouth.39.net/a/150808/4671896.html "),
            new Fruit("嘴唇干裂脱皮怎么办",R.drawable.kouqiang17,"http://mouth.39.net/a/150808/4671822.html"),
            new Fruit("“虫牙”真的是虫子咬出的坑吗？",R.drawable.kouqiang18,"http://mouth.39.net/a/171109/5826125.html "),
            new Fruit("这八大意想不到的习惯最毁牙",R.drawable.kouqiang19,"http://mouth.39.net/a/141012/4491647.html "),
            new Fruit("牙周病损害不可逆 预防是关键",R.drawable.kouqiang20,"http://mouth.39.net/a/141014/4492784.html "),
            new Fruit("这个坏习惯或引发散光！得了轻微散光，该怎么办？",R.drawable.eye1,"http://eye.39.net/a/200416/7845696.html "),
            new Fruit("无缘无故流眼泪？这些因素，希望你留意到",R.drawable.eye2,"http://eye.39.net/a/200306/7796507.html "),
            new Fruit("近视不能戴眼镜，一戴就摘不下？别误导人了！",R.drawable.eye3,"http://eye.39.net/a/200220/7787272.html "),
            new Fruit("疫情期间还在盯电脑，玩手机？注意！高度近视是导致青光眼的一大高危因素！",R.drawable.eye4,"http://eye.39.net/a/200219/7786997.html"),
            new Fruit("青光眼患者这样做有利于控制病情，你都知道吗？",R.drawable.eye5,"http://eye.39.net/a/200102/7731726.html  "),
            new Fruit("眼压高会导致青光眼？教你保护“心灵的窗户”",R.drawable.eye6,"http://eye.39.net/a/191230/7718404.html "),
            new Fruit("高中生患上青光眼晚期 专家：眼睛胀痛要当心",R.drawable.eye7,"http://eye.39.net/a/190327/6997539.html "),
            new Fruit("白内障“熟”了才能做手术？如何确定最佳时机？",R.drawable.eye8,"http://eye.39.net/a/200119/7764992.html "),
            new Fruit("眼部疾病太难缠，白内障也爱“小鲜肉”？",R.drawable.eye9,"http://eye.39.net/a/200102/7731877.html"),
            new Fruit("白内障年轻化，这些常识你了解吗？",R.drawable.eye10,"http://eye.39.net/a/191015/7539980.html "),
            new Fruit("这个坏习惯或引发散光！得了轻微散光，该怎么办？",R.drawable.eye11,"http://eye.39.net/a/200416/7845696.html"),
            new Fruit("不想削角膜？五花八门的近视手术到底有哪些？",R.drawable.eye12,"http://eye.39.net/a/200119/7765002.html"),
            new Fruit("网红护眼方法到底能不能预防近视？",R.drawable.eye13,"http://eye.39.net/a/190821/7398076.html "),
            new Fruit("怎么预防麦粒肿 有哪些方法",R.drawable.eye14,"http://jbk.39.net/mlz/160807/4922427.html "),
            new Fruit("麦粒肿是什么，需要注意哪些",R.drawable.eye15,"http://jbk.39.net/mlz/150813/4675628.html  "),
            new Fruit("麦粒肿传染吗 吃什么食物好",R.drawable.eye16,"http://jbk.39.net/mlz/150812/4677694.html "),
            new Fruit("治疗眼疖子有哪些方法",R.drawable.eye17,"http://jbk.39.net/mlz/150728/4669040.html "),
            new Fruit("伤眼竟是时髦的儿童太阳镜 挑选有技巧要记住",R.drawable.eye18,"http://eye.39.net/a/170718/5548144.html"),
            new Fruit("真菌感染引起角膜穿孔 眼外伤后感觉不适尤其要注意",R.drawable.eye19,"http://eye.39.net/a/140603/4415824.html "),
            new Fruit("谨防眼外伤让“心灵的窗户”始终明亮",R.drawable.eye20,"http://eye.39.net/a/140602/4415821.html"),
            new Fruit("夏天警惕鼻炎带来的四大危害！",R.drawable.note1,"http://ebh.39.net/a/160621/4874762.html"),
            new Fruit("睡觉打鼾遭人嫌 打鼾如何治疗",R.drawable.note2,"http://ebh.39.net/a/160524/4857217.html "),
            new Fruit("谨防眼外伤让“ 鼻尖疼常见三大症状，如何应对？",R.drawable.note3,"http://ebh.39.net/a/160504/4843798.html "),
            new Fruit("感冒嗓子疼鼻子不通气怎么办？",R.drawable.note4,"https://yisheng.9939.com/video/1819.html "),
            new Fruit(" 鼻窦炎会引起咳嗽吗？",R.drawable.note5,"https://yisheng.9939.com/video/1812.html"),
            new Fruit("感冒流眼泪流鼻涕怎么办?",R.drawable.note6,"https://yisheng.9939.com/video/569.html "),
            new Fruit("哪些患者可以做内镜经鼻微创手术?",R.drawable.note7,"https://yisheng.9939.com/video/1604.html"),
            new Fruit("内镜经鼻微创手术有哪些优势？",R.drawable.note8,"https://yisheng.9939.com/video/1639.html"),
            new Fruit("经鼻垂体瘤切除术患者要注意什么?",R.drawable.note9,"https://yisheng.9939.com/video/1510.html"),
            new Fruit("宝宝感冒咳嗽流鼻涕怎么办？",R.drawable.note10,"https://yisheng.9939.com/video/81.html"),
            new Fruit("过敏性鼻炎能治好吗？",R.drawable.note11,"https://yisheng.9939.com/video/56.html "),
            new Fruit(" 鼻子肿瘤有什么症状？",R.drawable.note12,"https://yisheng.9939.com/video/43.html "),
            new Fruit("过敏性鼻炎有什么症状？",R.drawable.note13,"https://yisheng.9939.com/video/57.html"),
            new Fruit("鼻结石是什么？",R.drawable.note14,"https://yisheng.9939.com/video/41.html  "),
            new Fruit("肝硬化鼻子出血严重吗?",R.drawable.note15,"https://yisheng.9939.com/video/13.html "),
            new Fruit("变应性鼻炎是什么意思？",R.drawable.note16,"https://yisheng.9939.com/video/45.html "),
            new Fruit("鼻中隔偏曲该手术吗？",R.drawable.note17,"https://yisheng.9939.com/video/42.html"),
            new Fruit(" 鼻炎是什么？",R.drawable.note18,"https://yisheng.9939.com/video/1357.html "),
            new Fruit("中医能治鼻甲肥大吗？",R.drawable.note19,"https://yisheng.9939.com/video/1343.html"),
            new Fruit("鼻窦炎有什么症状如何治疗？",R.drawable.note20,"https://yisheng.9939.com/video/40.html"),
            new Fruit("小儿耳朵进水需要处理吗?",R.drawable.ear1,"https://yisheng.9939.com/video/238.html "),
            new Fruit("可以给宝宝掏耳朵吗？",R.drawable.ear2,"https://yisheng.9939.com/video/61.html"),
            new Fruit("孩子半夜耳朵疼痛哭闹是怎么回事？",R.drawable.ear3,"https://yisheng.9939.com/video/58.html "),
            new Fruit("耳朵里有像心跳一样的响声怎么回事？",R.drawable.ear4,"https://yisheng.9939.com/video/48.html "),
            new Fruit("耳朵里进飞虫怎么办？",R.drawable.ear5,"https://yisheng.9939.com/video/47.html"),
            new Fruit("耳鸣患者爱吃肉怎么办 如何做好防护措施",R.drawable.ear6,"https://yisheng.9939.com/article/1389.html  "),
            new Fruit("耳鸣可能引发哪些疾病 小心这五种疾病带来的伤害",R.drawable.ear7,"https://yisheng.9939.com/article/999.html "),
            new Fruit("孩子耳朵进水了，该怎么办？",R.drawable.ear8,"https://dxy.com/column/5005?keywords=耳朵"),
            new Fruit("宝宝耳朵发炎了怎么办？",R.drawable.ear9,"https://dxy.com/column/4792?keywords=耳朵"),
            new Fruit("孩子耳朵里进了异物，该怎么办？",R.drawable.ear10,"https://dxy.com/column/5004?keywords=耳朵"),
            new Fruit("给宝宝掏耳朵这种事，还是交给医生吧",R.drawable.ear11,"https://dxy.com/column/3873?keywords=耳朵"),
            new Fruit("耳朵痒、耳屎多，你要这样做",R.drawable.ear12,"https://dxy.com/column/17665?keywords=耳朵"),
            new Fruit("飞机升降时保护耳朵的简单方法",R.drawable.ear13,"https://dxy.com/column/322?keywords=耳朵"),
            new Fruit("头晕眼花，可能和耳朵有关系！",R.drawable.ear14,"https://dxy.com/column/6715?keywords=耳朵"),
            new Fruit("来自耳屎的「叮咛」：不是你想掏就能掏",R.drawable.ear15,"https://dxy.com/column/2561?keywords=耳朵 "),
            new Fruit("公开问题 | 过敏性鼻炎，如何缓解？",R.drawable.ear16,"https://dxy.com/column/28341?keywords=耳朵 "),
            new Fruit(" 泳池的水干净吗？游泳前你不能不知道的真相！",R.drawable.ear17,"https://dxy.com/column/6409?keywords=耳朵 "),
            new Fruit(" 感觉头晕、天旋地转？ 不用担心，也不能忽视",R.drawable.ear18,"https://dxy.com/column/5643?keywords=耳朵"),
            new Fruit("公开问题 | 上下颚疼，是什么原因？",R.drawable.ear19,"https://dxy.com/column/28281?keywords=耳朵疼 "),
            new Fruit("奶爸养成记：宝宝耳朵流水？！吓死宝宝了！",R.drawable.ear20,"https://dxy.com/column/7530?keywords=耳朵 "),
            new Fruit("便便漂浮在水上意味着什么？",R.drawable.wei1,"http://wei.39.net/a/200327/7817422.html "),
            new Fruit("新冠肺炎可能并发应激性溃疡，该如何接招？",R.drawable.wei2,"http://wei.39.net/a/200302/7791320.html"),
            new Fruit(" 多少人能消化996带来的健康之痛",R.drawable.wei3,"http://wei.39.net/a/190509/7127962.html "),
            new Fruit("舌苔厚是肠胃不好吗？关于舌苔变化，医生说了4件事",R.drawable.wei4,"http://wei.39.net/a/190508/7125643.html "),
            new Fruit("为什么胃病如此偏爱我们？",R.drawable.wei5,"http://wei.39.net/a/190214/6864818.html"),
            new Fruit("春节吃吃喝喝，请打好“保胃战”！",R.drawable.wei6,"http://wei.39.net/a/190203/6855801.html "),
            new Fruit("总觉得饿？或许是胃热了”！",R.drawable.wei7,"http://wei.39.net/a/181029/6603163.html "),
            new Fruit("支架是如何放进心脏的",R.drawable.xin1,"https://dxy.com/column/2402?keywords=心脏"),
            new Fruit("得了心脏病，生活要注意哪些？",R.drawable.xin2,"https://dxy.com/column/3966?keywords=心脏"),
            new Fruit("爹妈心脏都没问题，为什么孩子会得先天性心脏病？",R.drawable.xin3,"ttps://dxy.com/column/3997?keywords=心脏 "),
            new Fruit("用力咳嗽可以挽救心脏骤停？",R.drawable.xin4,"https://dxy.com/column/5081?keywords=心脏 "),
            new Fruit("原来医生是用这些方法来诊断心脏病的",R.drawable.xin5,"https://dxy.com/column/5182?keywords=心脏"),
            new Fruit("心脏突然咯噔一下，是什么原因？",R.drawable.xin6,"https://dxy.com/column/4651?keywords=心脏"),
            new Fruit("有心脏病可以怀孕生孩子吗？",R.drawable.xin7,"https://dxy.com/column/6954?keywords=心脏 "),
            new Fruit("想要健康心脏，这 8 件事要做好",R.drawable.xin8,"https://dxy.com/column/6980?keywords=心脏"),
            new Fruit(" 心脏病患者康复，只能静养、不能活动？",R.drawable.xin9,"https://dxy.com/column/2929?keywords=心脏 "),
            new Fruit("这 3 项检查，让你知道自己的心脏有没有问题",R.drawable.xin10,"https://dxy.com/column/9546?keywords=心脏 "),
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
                Intent intent=new Intent(FruitActivity.this,ActivityWebView_forRead.class);
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
