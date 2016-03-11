package com.example.linbin_91.festival.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by linbin_91 on 2015/10/17.
 */
public class FestivalUtil {

    public static   FestivalUtil mInstance;

    private List<Festival> mFestivals = new ArrayList<Festival>();
    private List<Message> mMegs = new ArrayList<Message>();

    public FestivalUtil() {
        mFestivals.add(new Festival(1,"国庆节"));
        mFestivals.add(new Festival(2,"中秋节"));
        mFestivals.add(new Festival(3,"元旦"));
        mFestivals.add(new Festival(4,"春节"));
        mFestivals.add(new Festival(5,"端午节"));
        mFestivals.add(new Festival(6,"七夕节"));
        mFestivals.add(new Festival(7,"圣诞节"));
        mFestivals.add(new Festival(8,"儿童节"));

        mMegs.add(new Message(1,1,"国庆快乐"));
        mMegs.add(new Message(2,1,"国庆快乐"));
        mMegs.add(new Message(3,2,"中秋节快乐"));
        mMegs.add(new Message(4,2,"中秋节快乐"));
        mMegs.add(new Message(5,3,"元旦快乐"));
        mMegs.add(new Message(6,3,"元旦快乐"));
        mMegs.add(new Message(7,4,"春节快乐"));
        mMegs.add(new Message(8,4,"春节快乐"));
        mMegs.add(new Message(9,5,"端午节快乐"));
        mMegs.add(new Message(10,5,"端午节快乐"));
        mMegs.add(new Message(11,6,"七夕节快乐"));
        mMegs.add(new Message(12,6,"七夕节快乐"));
        mMegs.add(new Message(13,7,"圣诞节快乐"));
        mMegs.add(new Message(14,7,"圣诞节快乐"));
        mMegs.add(new Message(15,8,"儿童节快乐"));
        mMegs.add(new Message(16,8,"儿童节快乐"));



    }

    public  static  FestivalUtil getInstance(){
        if (mInstance == null){
            synchronized (FestivalUtil.class){
                if (mInstance == null){
                    mInstance = new FestivalUtil();
                }
            }
        }

        return  mInstance;
    }

    public  List<Festival>getFestivals(){
        return  new ArrayList<Festival>(mFestivals);
    }

    public  Festival getFestival(int id){
        for (Festival festival : mFestivals){
            if (festival.getId() == id){
                return  festival;
            }
        }

        return  null;
    }

    public  List<Message> getmMegs(int festivalId){
        List<Message> msgs = new ArrayList<>();
        for (Message msg : mMegs){
            if (msg.getFestivalId() == festivalId){
                msgs.add(msg);
            }
        }

        return  msgs;
    }
}
