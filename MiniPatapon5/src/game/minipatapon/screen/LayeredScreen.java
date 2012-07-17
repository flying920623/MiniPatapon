/** 
 * @description	: one of the layer of a screen
 * @author		: 黄攀
 * @created		: 2012-1-4
 */

package game.minipatapon.screen;

import game.minipatapon.dataprocess.resourcemanage.LoadManage;
import game.minipatapon.datasource.assets.Assets;
import game.minipatapon.event.EventBase;
import game.minipatapon.event.EventListener;
import game.minipatapon.event.gamecmd.NavLayeredScreenStageArg;

import game.minipatapon.logger.DefaultLogger;
import game.minipatapon.logical.GameRule.GameLogic;
import game.minipatapon.logical.playControl.ControlManage;
import game.minipatapon.stage.base.BaseStage;
import game.minipatapon.stage.midground.GameStage;
import game.minipatapon.stage.midground.PrestrainStage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;

//import game.minipatapon.application.ScreenManageable;

public class LayeredScreen extends SimpleScreen implements ProcessableScreen,
		EventListener<NavLayeredScreenStageArg> {

	// ScreenManageable manager;
	public List<NavigateScreen> screens;
	InputMultiplexer processPlexer;
	
	public static boolean isInitedLoading = false;

	public LayeredScreen() {
		// this.manager = _manager;
		this.processPlexer = new InputMultiplexer();
		screens = new ArrayList<NavigateScreen>();

		// LoadManage.loadAll();
		loadScreens();
	}

	public ContentScreen getMidScreen() {
		for (NavigateScreen screen : screens) {
			if (screen.getLayer() == 0)
				return (ContentScreen) screen;
		}

		return null;
	}

	public ForegroundScreen getForeScreen() {
		for (NavigateScreen screen : screens) {
			if (screen.getLayer() == 1)
				return (ForegroundScreen) screen;
		}

		return null;
	}

	public BackgroundScreen getBackScreen() {
		for (NavigateScreen screen : screens) {
			if (screen.getLayer() == -1)
				return (BackgroundScreen) screen;
		}

		return null;
	}

	private void loadScreens() {
		this.addScreen(new ForegroundScreen());
		this.addScreen(new ContentScreen());
		this.addScreen(new BackgroundScreen());
	}

	public void addScreen(NavigateScreen screen) {
		screens.add(screen);
		Collections.sort(screens, new Comparator<NavigateScreen>() {
			public int compare(NavigateScreen o1, NavigateScreen o2) {
				return o1.getLayer() - o2.getLayer();
			}
		});
		this.processPlexer.addProcessor(screen);
	}

	public void removeScreen(NavigateScreen screen) {
		this.screens.remove(screen);
		this.processPlexer.removeProcessor(screen);
	}

	@Override
	public boolean keyDown(int arg0) {
		return processPlexer.keyDown(arg0);
	}

	@Override
	public boolean keyTyped(char arg0) {
		return processPlexer.keyTyped(arg0);
	}

	@Override
	public boolean keyUp(int arg0) {
		return processPlexer.keyUp(arg0);
	}

	@Override
	public boolean scrolled(int arg0) {
		return processPlexer.scrolled(arg0);
	}

	@Override
	public boolean touchDown(int arg0, int arg1, int arg2, int arg3) {
		return processPlexer.touchDown(arg0, arg1, arg2, arg3);
	}

	@Override
	public boolean touchDragged(int arg0, int arg1, int arg2) {
		return processPlexer.touchDragged(arg0, arg1, arg2);
	}

	@Override
	public boolean touchMoved(int arg0, int arg1) {
		return processPlexer.touchMoved(arg0, arg1);
	}

	@Override
	public boolean touchUp(int arg0, int arg1, int arg2, int arg3) {
		return processPlexer.touchUp(arg0, arg1, arg2, arg3);
	}

	@Override
	public void dispose() {
		Iterator<NavigateScreen> it = screens.iterator();
		while (it.hasNext()) {
			NavigateScreen screen = it.next();
			screen.dispose();
		}
		
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		Iterator<NavigateScreen> it = screens.iterator();
		while (it.hasNext()) {
			NavigateScreen screen = it.next();
			screen.hide();
		}
	}

	@Override
	public void pause() {
		Iterator<NavigateScreen> it = screens.iterator();
		while (it.hasNext()) {
			NavigateScreen screen = it.next();
			screen.pause();
		}
	}

	

	@Override
	public void render(float dt) {

		Iterator<NavigateScreen> it = screens.iterator();
		while (it.hasNext()) {
			NavigateScreen screen = it.next();
			screen.render(dt);
		}

	}

	@Override
	public void resize(int width, int height) {
		Iterator<NavigateScreen> it = screens.iterator();
		while (it.hasNext()) {
			NavigateScreen screen = it.next();
			screen.resize(width, height);
		}
	}

	@Override
	public void resume() {
		Iterator<NavigateScreen> it = screens.iterator();
		while (it.hasNext()) {
			NavigateScreen screen = it.next();
			screen.resume();
		}
	}

	@Override
	public void show() {
		Iterator<NavigateScreen> it = screens.iterator();
		while (it.hasNext()) {
			NavigateScreen screen = it.next();
			screen.show();
		}
	}

	@Override
	public void onEventReceived(NavLayeredScreenStageArg arg) {
		// TODO Auto-generated method stub
		for (NavigateScreen layerScreen : this.screens) {
			if (layerScreen.getLayer() == arg.m_screenLayer) {
				try {
					if (layerScreen.getLayer() == 0) {
						if (this.getMidScreen().isGameScreen == true) {
							GameStage desStage = (GameStage) arg.m_class
									.getConstructor(float.class, float.class,
											boolean.class, int.class)
									.newInstance(getWidth(), getHeight(), true,
											this.getMidScreen().level);
							ControlManage.Getinstance().playCmdCommand = desStage;
							GameLogic.Getinstance().listener = desStage;
							layerScreen.navigate(desStage);

						}

						else {

							BaseStage desStage = (BaseStage) arg.m_class
									.getConstructor(float.class, float.class,
											boolean.class).newInstance(
											getWidth(), getHeight(), true);
							layerScreen.navigate(desStage);
						}
					}
				} catch (Exception e) {
					// logger.log(0, " destination stage", e.toString());
					// TODO: handle exception
				}

			}
		}

	}
}