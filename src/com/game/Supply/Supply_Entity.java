package com.game.Supply;

import com.game.Panel.Main;
import com.game.Util.GameMusic;

import javax.swing.*;

public class Supply_Entity {
    int num;//1 2 两种补给
    JLabel label;//补给品图片资源
    public Supply_Entity(int num,JLabel label){
        this.num = num;
        this.label = label;
    }
    //增强玩家
    public static void supply_player(){
        for(int i=0;i< Main.supply_list.size();i++){
            if(Main.supply_list.get(i).label.getX()-Main.player_entity.label.getX()<=50&&
                    Main.player_entity.label.getY()-Main.supply_list.get(i).label.getY()<=70&&
                    Main.supply_list.get(i).label.getY()-Main.player_entity.label.getY()<=30&&
                    Main.player_entity.label.getX()-Main.supply_list.get(i).label.getX()<=50
            ){
                ////炸弹补给
                if(Main.supply_list.get(i).num==1){
                    //播放获取炸弹音效
                    new Thread(()->{
                        GameMusic.Play("src/music/get_bomb.wav", 2.0);
                    }).start();
                    //玩家炸弹数量+1
                    Main.player_entity.bomb++;
                    //重新设置炸弹数量
                    Main.label_bomb_count.setText(" X "+Main.player_entity.bomb);

                //弹药补给
                }else{
                    //播放获取弹药音效
                    new Thread(()->{
                        GameMusic.Play("src/music/upgrade.wav", 2.0);
                    }).start();
                    //玩家等级+1
                    if(Main.player_entity.level<3){
                        Main.player_entity.level++;
                    }
                }
                //从面板中删除该补给品
                Main.jp1.remove(Main.supply_list.get(i).label);
                //从集合中删除该补给品
                Main.supply_list.remove(Main.supply_list.get(i));
                //面板jpanel1重绘
                Main.jp1.repaint();



            }
        }
    }
}
