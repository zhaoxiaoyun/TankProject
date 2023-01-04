package v11;

import javax.sound.sampled.*;
import java.io.IOException;

/**
 * @author: zxy
 * @date: 2023/1/2 - 18:28
 * @description: v11
 * @version: 1.0
 */
public class Audio extends Thread{
    @Override
    public void run() {
        try{
            byte[] b = new byte[1024];
            int len = 0;
            sourceDataLine.open(audioFormat, 1024);
            sourceDataLine.start();
            while((len= audioInputStream.read(b))>0){
                sourceDataLine.write(b,0,len);
            }
            audioInputStream.close();
            sourceDataLine.drain();
            sourceDataLine.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    private AudioFormat audioFormat = null;
    private SourceDataLine sourceDataLine = null;
    private DataLine.Info dataLine_info = null;

    private AudioInputStream audioInputStream = null;

    public Audio(String fileName) {
        try {
            audioInputStream = AudioSystem.getAudioInputStream(Audio.class.getClassLoader().getResource(fileName));
            audioFormat = audioInputStream.getFormat();
            dataLine_info = new DataLine.Info(SourceDataLine.class, audioFormat);
            sourceDataLine = (SourceDataLine) AudioSystem.getLine(dataLine_info);
            //FloatControl volctrl=(FloatControl)sourceDataLine.getControl(FloatControl.Type.MASTER_GAIN);
            //volctrl.setValue(-40);//
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void play() {
        try {
            byte[] b = new byte[1024*5];
            int len = 0;
            sourceDataLine.open(audioFormat, 1024*5);
            sourceDataLine.start();
            //System.out.println(audioInputStream.markSupported());
            audioInputStream.mark(12358946);
            while ((len = audioInputStream.read(b)) > 0) {
                sourceDataLine.write(b, 0, len);
            }
            // audioInputStream.reset();

            sourceDataLine.drain();
            sourceDataLine.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void close() {
        try {
            audioInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
