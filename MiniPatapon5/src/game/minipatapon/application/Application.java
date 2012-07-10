package game.minipatapon.application;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public interface Application {
	public void exit();

	public FileOutputStream openFileOutput(String path, boolean append)
			throws Exception;

	public FileInputStream openFileInput(String path) throws Exception;
}
