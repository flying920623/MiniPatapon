package game.minipatapon.application;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import game.minipatapon.event.EventAggregator;

import game.minipatapon.logger.DefaultLogger;

public class ApplicationService {

	static Application application = null;
	static ApplicationService service = null;

	public static ApplicationService getInstance() {
		if (application == null)
			application = new DesktopApplication();
		if (service == null)
			service = new ApplicationService();
		return service;
	}

	/*public void changeBackground(String path) {
		try {
			DefaultLogger.getDefaultLogger().logWithSignature(this, "切换背景:%1$s", path);
			RequestChangeBackgroundEvent event = EventAggregator.getInstance()
					.getEvent(RequestChangeBackgroundEvent.class);
			event.publish(new RequstChangeBackgroundEventArg(path));
		} catch (Exception e) {
			DefaultLogger.getDefaultLogger().logWithSignature(
					"ApplicationService", "切换地图请求失败:%1$s", e.getMessage());
		}
	}*/

	public void exitGame() {
		DefaultLogger.getDefaultLogger().logWithSignature("ApplicationService",
				"exit");
		ApplicationService.application.exit();
	}

	public static void setApplication(
			Application application) {
		ApplicationService.application = application;
	}

	public FileOutputStream openFileOutput(String path, boolean append)
			throws Exception {
		return ApplicationService.application.openFileOutput(path, append);
	}

	public FileInputStream openFileInput(String path) throws Exception {
		return ApplicationService.application.openFileInput(path);
	}
}
