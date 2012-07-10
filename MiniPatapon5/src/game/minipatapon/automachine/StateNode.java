package game.minipatapon.automachine;

import java.util.ArrayList;

public class StateNode<T> {
	public ArrayList<SwitchArg<T>> m_argList;
	public StateNode<T> preStateNode = null; 

	

	public StateNode(StateNode node){
		this.m_argList=node.m_argList;
		this.preStateNode=node.preStateNode;
	}
	
	public StateNode(){
		m_argList = new ArrayList<SwitchArg<T>>();
		preStateNode = null;
	}
	public StateNode(StateNode<T> node,SwitchArg<T> arg){
		preStateNode = node;
		m_argList = new ArrayList<SwitchArg<T>>();
		m_argList = node.m_argList;
		m_argList.add(arg);
		
	}

	
	

}
