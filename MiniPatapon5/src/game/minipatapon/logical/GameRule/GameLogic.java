package game.minipatapon.logical.GameRule;

import java.util.ArrayList;

import game.minipatapon.application.MiniPataponManager;
import game.minipatapon.dataprocess.datafactory.MusicHandle;
import game.minipatapon.dataprocess.musicprocess.MusicMatch;
import game.minipatapon.event.EventListener;
import game.minipatapon.event.gamecmd.GameState;
import game.minipatapon.event.gamecmd.GameStateArg;
import game.minipatapon.logical.playControl.ControlManage;
import game.minipatapon.logical.playControl.PlayerCommand;

public class GameLogic implements EventListener<GameStateArg>{

	private static GameLogic instance = null;
	public ArrayList<GameStateListener> listeners = null;
	public GameStateListener listener = null;
	
	public static GameLogic Getinstance(){
		if(instance == null)
			instance = new GameLogic();
		return instance;
	}

	private GameLogic(){
		listeners = new ArrayList<GameStateListener>();
		listeners.add(MiniPataponManager.getInstance().GetLayeredScreen().getForeScreen());
		listeners.add(MusicMatch.GetInstance().timer);
		//listeners.add(MiniPataponManager.getInstance().GetLayeredScreen().getMidScreen())
	}
	

	@Override
	public void onEventReceived(GameStateArg arg) {
		// TODO Auto-generated method stub
		if(arg.state==GameState.GameStart)
		{
		
		  for (GameStateListener listener : listeners) {
			  listener.OnGameStart();
		}
		  listener.OnGameStart();
		 
		}
		else if(arg.state==GameState.GameEnd)
		{
			for (GameStateListener listener : listeners) {
				  listener.OnGameEnd();
			}
			listener.OnGameEnd();
		}
		
	}
}
