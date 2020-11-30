package com.game.PlayerBullet;

import com.game.Panel.Main;
import com.game.Player.Player;
import com.game.Player.Player_Entity;
import com.game.Util.GameMusic;

import javax.swing.*;
import java.awt.*;

public class PlayerBulletCreate implements Runnable{
    // 子弹数量 = 等级 *2 +1
    // 飞行距离 = 等级*10+3
    // 发射间隔 = 500ms
    // 子弹移动速度 = 8ms
    public static volatile boolean isActive=true;
    public static volatile boolean isAttack=true;
    @Override
    public void run() {
        //修建图片
        ImageIcon icon1 = new ImageIcon("src/img/子弹"+Player_Entity.player_index+"_1.png");
        Image temp1 = icon1.getImage().getScaledInstance(27, 22, icon1.getImage().SCALE_DEFAULT);
        icon1 = new ImageIcon(temp1);

        ImageIcon icon2 = new ImageIcon("src/img/子弹"+Player_Entity.player_index+"_2.png");
        Image temp2 = icon2.getImage().getScaledInstance(44, 21, icon2.getImage().SCALE_DEFAULT);
        icon2 = new ImageIcon(temp2);

        ImageIcon icon3 = new ImageIcon("src/img/子弹"+Player_Entity.player_index+"_3.png");
        Image temp3 = icon3.getImage().getScaledInstance(67, 34, icon3.getImage().SCALE_DEFAULT);
        icon3 = new ImageIcon(temp3);

        int count=0;
        int count2=0;//用于延缓子弹发射音效的变量
        while(true){
            if(isActive==true){
                count++;
                //每循环10次创建一个子弹加入集合
                if(count%10==0){
                    count2++;
                    if(Main.bullets_list.size()<6){
                        //创建子弹并设置图片
                        JLabel label_bullet = new JLabel();
                        //一级单发子弹
                        if(Main.player_entity.level==1){
                            label_bullet.setIcon(icon1);
                            label_bullet.setBounds(Main.player_entity.label.getX()+28,Main.player_entity.label.getY()-20, 27, 22);
                        }else if(Main.player_entity.level==2){
                            //二级双发子弹
                            label_bullet.setIcon(icon2);
                            label_bullet.setBounds(Main.player_entity.label.getX()+20,Main.player_entity.label.getY()-20, 44, 21);
                        }else{
                            //三级三发子弹
                            label_bullet.setIcon(icon3);
                            label_bullet.setBounds(Main.player_entity.label.getX()+8,Main.player_entity.label.getY()-20, 67, 34);
                        }
                        //将子弹加入面板当中
                        Main.jp1.add(label_bullet);
                        //将子弹加入到list当中
                        Main.bullets_list.add(label_bullet);
                        if(count2%2==0){
                            //播放子弹音效
                            new Thread(()->{
                                GameMusic.Play("src\\music\\子弹射击.wav", 0.6);
                            }).start();
                            count2=0;
                        }

                        count=0;
                    }
                }
                //移动集合中的子弹
                for(int i=0;i<Main.bullets_list.size();i++){
                    //玩家处于死亡状态 跳出循环 不移动子弹
                    if(isActive==false){
                        break;
                    }

                    try{
                        Thread.sleep(1);
                    }catch (Exception e){
                        e.printStackTrace();
                    }


                    if(Main.bullets_list.size()>0&&i<Main.bullets_list.size()){ //可能这时候 已经把当前下标的子弹删除了
                         Main.bullets_list.get(i).setLocation(Main.bullets_list.get(i).getX(), Main.bullets_list.get(i).getY()-10);
                        //子弹到达指定位置
                        //玩家处于死亡状态 跳出循环 不移动子弹
                        if(isActive==false){
                            break;
                        }
                        if(i<Main.bullets_list.size()&&Main.bullets_list.get(i).getY()<0){
                            //将子弹从面板删除
                            Main.jp1.remove(Main.bullets_list.get(i));
                            //从集合中删除子弹
                            Main.bullets_list.remove(Main.bullets_list.get(i));
                            i--;
                        }
                    }
                    if(isAttack){
                        //子弹移动时攻击敌人
                        PlayerBullet_Entity.attackEnemy();
                    }

                }
                Main.jp1.repaint();//对panel1本身进行重绘
            }


        }
    }

}




//        while (true){
//            //发射间隔 = 500ms
//            try{
//                Thread.sleep(600);
//            }catch (Exception e){
//                e.printStackTrace();
//            }
//            //创建level*2+1个子弹并设置图片
//            for(int i=1;i<=Player.level*2+1;i++){
//                JLabel label_bullet = new JLabel();
//                label_bullet.setIcon(icon1);
//                label_bullet.setBounds(Main.label_Player.getX()+31,Main.label_Player.getY()-10, 5, 11);
//                //将子弹加入面板当中
//                Main.jp1.add(label_bullet);
//                //将子弹加入到list当中
//                Main.bullets_list.add(label_bullet);
//            }
//            //子弹移动
//            //飞行距离 = 等级*10+3
//            for(int i=0;i< Player.level*10+3;i=i+1){
//                for(int j=0;j<Main.bullets_list.size();j++){
//                    if(i>=j){
//                        //子弹移动速度= 8ms
//                        try{
//                            Thread.sleep(8);
//                        }catch (Exception e){
//                            e.printStackTrace();
//                        }
//                        //子弹之间间隔大，跑的远
//                        Main.bullets_list.get(j).setLocation(Main.bullets_list.get(j).getX(), Main.bullets_list.get(j).getY()-20);
//                    }
//                }
//                //碰撞检测
//            }
//            for(int i=Main.bullets_list.size()-1;i>=0;i--){
//                Main.jp1.remove(Main.bullets_list.get(i));
//            }
//            Main.jp1.repaint();//对panel1本身进行重绘
//            Main.bullets_list.clear();
//        }
