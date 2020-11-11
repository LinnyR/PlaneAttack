package com.game.Time;

import com.game.Panel.Main;

import javax.swing.*;

public class Time implements Runnable {
    @Override
    public void run() {
        int time = 90;
        while(true){
            try{
                Thread.sleep(1000);
            }catch (Exception e){
                e.printStackTrace();
            }
            time--;
            Main.label_Time.setText("倒计时："+time+"s");
            if(time==0){
                //游戏结束
                JOptionPane.showMessageDialog(null,"时间结束！\n玩家积分为"+Main.label_Score.getText(),"时间结束", JOptionPane.WARNING_MESSAGE);
                System.exit(0);
            }
        }
    }
}
