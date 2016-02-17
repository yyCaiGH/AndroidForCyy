package org.cyy.demo.service;

public interface IMusic {

	void playMusic(String path);
	void pauseMusic();
	void resetMusic(String path);
	void stopMusic();
	void callStateRinging();
	void callStateIdle(String path);
}
