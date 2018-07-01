package javaapplication1;
import java.io.File;
import javax.media.*;
import javax.media.format.AudioFormat;
public class Suono{
    Time time;
    Player player;
    public Suono(String indirizzo){
        time= new Time(0);
        Format mp3 = new AudioFormat(AudioFormat.MPEGLAYER3);
		Format output = new AudioFormat(AudioFormat.LINEAR);
		PlugInManager.addPlugIn(
			"com.sun.media.codec.audio.mp3.JavaDecoder",
			new Format[]{mp3},
			new Format[]{output},
			PlugInManager.CODEC
		);
		try{
                    player = Manager.createPlayer(new MediaLocator(new File(indirizzo).toURI().toURL()));
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
               player.realize();
    }
    
    public void Start() {
        player.start();
    }
    
    public void setMediaTimer() {
        player.setMediaTime(time);
    }
    
    public void Stop() {
        player.stop();
    }
    
    public long getMediaTimer() {
        return (long) player.getMediaTime().getSeconds();
    }
    
    public long getDuration() {
        return (long) player.getDuration().getSeconds();
    }
    
}
