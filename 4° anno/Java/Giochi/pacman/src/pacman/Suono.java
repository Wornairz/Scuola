package pacman;

import javax.sound.sampled.*;
import java.io.*;

public class Suono
{
    private Clip clip;
    private File audio;
    AudioFormat formato;
    AudioInputStream audioIS;
    Suono(String source){
        try
        {   
            audio=new File(source);
            audioIS=AudioSystem.getAudioInputStream(audio);
            formato=AudioSystem.getAudioFileFormat(audio).getFormat();
            AudioInputStream inputStream=AudioSystem.getAudioInputStream(audio);
            DataLine.Info info = new DataLine.Info(Clip.class,audioIS.getFormat(),((int) audioIS.getFrameLength() *formato.getFrameSize()));
            clip=(Clip) AudioSystem.getLine(info);
            clip.open(inputStream); 
        }
        catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex){}    
    }

    public void OpenClip() throws LineUnavailableException{
        clip.open();
    }
    public void LoopClip(int a){
        clip.loop(a);
    }
    public void StartClip(){
        clip.start();
    }
    public void StopClip(){
        clip.stop();
    }
    public boolean isRunning(){
        return clip.isRunning();
    }
    
    public int getLunghezzaBrano(){
        return clip.getFrameLength();
    }
    
    public int getPuntoEsecuzione(){
        return clip.getFramePosition();
    }
    
    public void setFrame(int posizione){
        clip.setFramePosition(posizione);  
    }
    
    public void setLoop(int start, int end)
    {
        clip.setLoopPoints(start, end);  
    }
}

