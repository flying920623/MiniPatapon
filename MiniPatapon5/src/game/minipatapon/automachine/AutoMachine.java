package game.minipatapon.automachine;

import java.util.ArrayList;

public  abstract class AutoMachine<T> {

	public  StateNode<T> m_currentStateNode = null;
	

	
	public StateNode<T> m_stateNodeRoot =null;
	
	public AutoMachine(){
		
		
	}
	public  void Accept(SwitchArg<T> arg){
		
		if(AcceptArg(arg))
		{
			m_currentStateNode = new StateNode(m_currentStateNode, arg);
		/*else 
			m_currentStateNode = GetStateNode(null, arg);	
		*/
		    if(CheckEnd(m_currentStateNode))
			return ;
		}
		else {
			OnEndState();
		}
	
	}
	abstract public  boolean AcceptArg(SwitchArg<T> arg);
	
	abstract  public boolean CheckEnd(StateNode<T> node);
	
	abstract public void  OnEndState();

}
