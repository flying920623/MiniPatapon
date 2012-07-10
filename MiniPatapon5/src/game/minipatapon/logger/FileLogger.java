/** 
 * @description	: Log to file
 * @author		: 黄攀
 * @created		: 2012-1-3
 */

package game.minipatapon.logger;

import java.io.File;
import java.io.FileOutputStream;

public class FileLogger extends LoggerBase {

	public FileLogger() {
		try {
			File f = new File("EggSnake.log");
			f.delete();
		} catch (Exception e) {

		}
	}

	@Override
	public void writeMessage(String msg) {
		try {
			File f = new File("EggSnake.log");
			FileOutputStream fs = new FileOutputStream(f, true);
			fs.write(msg.getBytes("utf-8"));
			fs.write("\r\n".getBytes());
			fs.close();
		} catch (Exception e) {
			System.out
					.println(String.format("FileLogger:$1%s", e.getMessage()));
		}
	}
}
