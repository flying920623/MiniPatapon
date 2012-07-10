package game.minipatapon.dataprocess.datafactory;

import java.util.ArrayList;


import game.minipatapon.event.EventBase;
import game.minipatapon.event.EventListener;
import game.minipatapon.event.gamecmd.GameCommand;
import game.minipatapon.event.gamecmd.GameCommandArg;
import game.minipatapon.event.music.MatchMusicLevel;
import game.minipatapon.event.music.MatchMusicType;
import game.minipatapon.event.music.MusicRythm;
import game.minipatapon.event.music.MusicRythmRecArg;
import game.minipatapon.logger.DefaultLogger;


public class MusicHandle implements EventListener<MusicRythmRecArg>  {

    public  NodeState m_currentStateNode = null;
	

	
	public NodeState m_stateNodeRoot =null;
	
	
	public  void Accept(SwitchRythmArg arg){
		
		if(AcceptArg(arg))
		{
			m_currentStateNode = NodeState.GetNextNodeState(m_currentStateNode, arg);
		/*else 
			m_currentStateNode = GetStateNode(null, arg);	
		*/
		    if(CheckEnd(m_currentStateNode))
		    {
		       OnEndState();
		       
		    }
		}
		else {
			OnEndState();
		}
	
	}
	private static MusicHandle instance = null;
	
	public static MusicHandle GetInstance()
	{
		if(null==instance)
			instance=new MusicHandle();
		return instance;
		
	}
	private MusicHandle(){
		this.m_stateNodeRoot= new NodeState();
		this.m_currentStateNode=new NodeState();
		
	}
	public boolean isLevelPass(ArrayList<SwitchRythmArg> args){
		for (SwitchRythmArg switchArg : args) {			
				if(switchArg.GetArg().musicLevel==MatchMusicLevel.Perfect)
					return true;
		    		}
		return false;
	}
	
	
	
	public  boolean AcceptArg(SwitchRythmArg arg)
	{
		if(arg.GetArg().musicLevel==MatchMusicLevel.Miss)
		{
	//		DefaultLogger.getDefaultLogger().log(0, " rec miss");
			return false;
		}
		else {
	//		DefaultLogger.getDefaultLogger().log(0, " rec true");
			return true;
		}
		
		
	}
	public boolean checkForward(ArrayList<SwitchRythmArg> argList)
	{
		if(argList.get(0).GetArg().musicType==MatchMusicType.Pata
				&&argList.get(1).GetArg().musicType==MatchMusicType.Pata
				&&argList.get(2).GetArg().musicType==MatchMusicType.Pata
				&&argList.get(3).GetArg().musicType==MatchMusicType.Pon)
			return true;
		else 
			return false;
	}
	public boolean checkAttack(ArrayList<SwitchRythmArg> argList)
	{
		if(argList.get(0).GetArg().musicType==MatchMusicType.Pon
				&&argList.get(1).GetArg().musicType==MatchMusicType.Pon
				&&argList.get(2).GetArg().musicType==MatchMusicType.Pata
				&&argList.get(3).GetArg().musicType==MatchMusicType.Pon)
			return true;
		else 
			return false;
	}
	public boolean checkDefense(ArrayList<SwitchRythmArg> argList)
	{
		if(argList.get(0).GetArg().musicType==MatchMusicType.Chaka
				&&argList.get(1).GetArg().musicType==MatchMusicType.Chaka
				&&argList.get(2).GetArg().musicType==MatchMusicType.Pata
				&&argList.get(3).GetArg().musicType==MatchMusicType.Pon)
			return true;
		else 
			return false;
	}
	
	
	public boolean CheckEnd(NodeState node)
	{
		if(node.m_argList.size()==4)
		{
			if(isLevelPass(node.m_argList))
			{
				DefaultLogger.getDefaultLogger().log(0, "  command");
				if(checkAttack(node.m_argList))
				{
					GameCommandArg arg = new GameCommandArg(GameCommand.Attack);
					arg.EventArgSent();
					DefaultLogger.getDefaultLogger().log(0, " att command");
					return true;
				}
				if(checkDefense(node.m_argList))
				{
					GameCommandArg arg = new GameCommandArg(GameCommand.Defense);
					arg.EventArgSent();
					DefaultLogger.getDefaultLogger().log(0, " defense command");
					return true;
				}
				if(checkForward(node.m_argList))
				{
					GameCommandArg arg = new GameCommandArg(GameCommand.Forward);
					arg.EventArgSent();
					DefaultLogger.getDefaultLogger().log(0, " forward command");
					return true;
				}
			
			//this.m_currentStateNode =new NodeState();
			GameCommandArg arg1 = new GameCommandArg(GameCommand.Fail);
			DefaultLogger.getDefaultLogger().log(0, " fail command");
			 arg1.EventArgSent();
			 return true;
			}
				
		}

		return false;
	}
	
	
	public void  OnEndState()
	{
		this.m_currentStateNode =new NodeState();
	//	DefaultLogger.getDefaultLogger().log(0, " rec end");
	}
	
	@Override
	public  void onEventReceived(
			 MusicRythmRecArg arg) {
		// TODO Auto-generated method stub
	//	DefaultLogger.getDefaultLogger().log(0, " rec");
		MusicRythm rythm = new MusicRythm(arg);
		SwitchRythmArg arg2 = new SwitchRythmArg(rythm);
		this.Accept(arg2);
		DefaultLogger.getDefaultLogger().log(0, " rec"+String.valueOf(this.m_currentStateNode.m_argList.size()));
		
	}

	

}
