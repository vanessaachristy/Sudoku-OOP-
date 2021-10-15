package Sudoku;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JFrame;

public class ThemeSong extends JFrame{
	
	public Clip clip;
	boolean isRunning;
	
	  public static enum Volume {
	      MUTE, LOW, MEDIUM, HIGH
	   }
	   
	   public static Volume volume = Volume.LOW;
	ThemeSong() {
	      try {
	    	 String filePath = "src\\Sudoku\\themeSong.wav";
			File file = new File(filePath);
	         AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(file);
	         // Get a clip resource.
	         clip = AudioSystem.getClip();
	         // Open audio clip and load samples from the audio input stream.
	         clip.open(audioInputStream);
	      } catch (UnsupportedAudioFileException e) {
	         e.printStackTrace();
	      } catch (IOException e) {
	         e.printStackTrace();
	      } catch (LineUnavailableException e) {
	         e.printStackTrace();
	      }
	   }
	
	long clipTimePosition;
	public void play() {
	         clip.setMicrosecondPosition(clipTimePosition); // rewind to the beginning
	         clip.start();     // Start playing
	   }
	
	public void stop() {
		if (clip.isRunning()) {
       	 clip.stop();   // Stop the player if it is still running
       	 clipTimePosition = clip.getMicrosecondPosition();
		}   
		
	}
}