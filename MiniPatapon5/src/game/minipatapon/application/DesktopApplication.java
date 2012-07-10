package game.minipatapon.application;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import com.badlogic.gdx.Gdx;

public class DesktopApplication implements Application {

	@Override
	public void exit() {
		Gdx.app.exit();
	}

	@Override
	public FileOutputStream openFileOutput(String path, boolean append)
			throws Exception {
		return new FileOutputStream(path, append);
	}

	@Override
	public FileInputStream openFileInput(String path) throws Exception {
		return new FileInputStream(path);
	}

}
