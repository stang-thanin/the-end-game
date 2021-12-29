package audio;

import javafx.scene.media.AudioClip;

public class AudioLoader {

	public static AudioClip Mouse_Enter_Sound = new AudioClip(
			ClassLoader.getSystemResource("audio/mouse_enter_sound.wav").toString());
	public static AudioClip SHOOT = new AudioClip(
			ClassLoader.getSystemResource("audio/shoot.wav").toString());

}
