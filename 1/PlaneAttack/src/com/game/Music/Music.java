package com.game.Music;

import com.game.Util.GameMusic;

public class Music implements Runnable{
    @Override
    public void run() {
        while (true){
            GameMusic.Play("src/music/飞机大战音效.wav");
            try{
                Thread.sleep(1000);
            }catch (Exception e){
                e.printStackTrace();
            }
            GameMusic.Play("src/music/飞机大战菜单音效.wav");
            try{
                Thread.sleep(1000);
            }catch (Exception e){
                e.printStackTrace();
            }
            GameMusic.Play("src/music/全民飞机大战游戏音乐.wav");
            try{
                Thread.sleep(1000);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
