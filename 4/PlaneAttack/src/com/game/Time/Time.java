package com.game.Time;

import com.game.Panel.Main;

import javax.swing.*;
import java.awt.*;
import java.io.FileWriter;
import java.io.PrintWriter;

public class Time implements Runnable {
    @Override
    public void run() {
        int time = 300;
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

                //将分数写入记录.txt
                try(PrintWriter pw = new PrintWriter(new FileWriter("src/record/记录.txt",true))){
                    pw.println(Main.label_Score.getText().split(":")[1]);
                }catch (Exception e){
                    e.printStackTrace();
                }

                JOptionPane.showMessageDialog(null,"时间结束！\n玩家积分为"+Main.label_Score.getText(),"时间结束", JOptionPane.WARNING_MESSAGE);
                System.exit(0);
            }
        }
    }
}
