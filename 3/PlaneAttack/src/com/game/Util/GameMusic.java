package com.game.Util;

import javax.sound.sampled.*;
import java.io.File;
import java.util.Random;

//音乐加载工具类
public class GameMusic {
    public static void Play(String fileurl,double vol) {

        try {
            AudioInputStream ais = AudioSystem.getAudioInputStream(new File(fileurl));
            AudioFormat aif = ais.getFormat();System.out.println(aif);
            final SourceDataLine sdl;
            DataLine.Info info = new DataLine.Info(SourceDataLine.class, aif);
            sdl = (SourceDataLine) AudioSystem.getLine(info);
            sdl.open(aif);
            sdl.start();
            FloatControl fc=(FloatControl)sdl.getControl(FloatControl.Type.MASTER_GAIN);
            //value可以用来设置音量，从0-2.0
            double value=vol;
            float dB = (float)
                    (Math.log(value==0.0?0.0001:value)/Math.log(10.0)*20.0);
            fc.setValue(dB);
            int nByte = 0;
            final int SIZE=1024*64;
            byte[] buffer = new byte[SIZE];
            while ((nByte = ais.read(buffer, 0, SIZE)) != -1) {
                sdl.write(buffer, 0, nByte);
            }
            sdl.stop();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }




}
