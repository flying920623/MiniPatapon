package game.minipatapon.dataprocess.datafactory;

import game.minipatapon.automachine.StateNode;
import game.minipatapon.automachine.SwitchArg;

import java.util.ArrayList;

public class NodeState {
	public ArrayList<SwitchRythmArg> m_argList;
	//public NodeState preStateNode = null; 

	

	public NodeState(NodeState node){
		this.m_argList=node.m_argList;
	//	this.preStateNode=node.preStateNode;
	}
	
	public NodeState(){
		m_argList = new ArrayList<SwitchRythmArg>();
	//	preStateNode = null;
	}
	public static NodeState GetNextNodeState(NodeState node,SwitchRythmArg arg){
	//	preStateNode = node;
		//m_argList = new ArrayList<SwitchRythmArg>();
	//	m_argList = node.m_argList;
	//	m_argList.add(arg);
		NodeState temp =new NodeState(node);
		temp.m_argList.add(arg);
		return temp;
	}

}
