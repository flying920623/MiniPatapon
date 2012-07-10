package game.minipatapon.util;

import game.minipatapon.application.ApplicationService;
import game.minipatapon.logger.DefaultLogger;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class FileHelper {
	public static String readAll(String path) throws Exception {
		FileInputStream is = ApplicationService.getInstance().openFileInput(
				path);
		BufferedReader reader = new BufferedReader(new InputStreamReader(is));
		StringBuilder builder = new StringBuilder();
		String line = new String();
		while ((line = reader.readLine()) != null) {
			builder.append(line);
			builder.append("\n");
		}
		is.close();
		return builder.toString();
	}

	public static void writeAll(String path, String text, boolean append)
			throws Exception {
		
		DefaultLogger.getDefaultLogger().log(path);
		FileOutputStream os = ApplicationService.getInstance().openFileOutput(
				path, append);
		OutputStreamWriter writer = new OutputStreamWriter(os, "utf-8");
		writer.write(text);
		writer.close();
		os.close();
	}

}
