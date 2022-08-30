package main;

import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Sound {
	public void play() {
		// carregar o arquivo de audio
		File file = new File("som/laser5.wav");
		// tratamento de excecoes (arquivo não encontrado, formato etc)
		try {
			// relacionado ao hardware de audio do sistema
			AudioInputStream audio = AudioSystem.getAudioInputStream(file);
			// controle do audio (reprodutor, pausa,avanco etc)
			Clip clip = AudioSystem.getClip();
			clip.open(audio);
			clip.start();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
