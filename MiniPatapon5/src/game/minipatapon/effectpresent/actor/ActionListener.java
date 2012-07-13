package game.minipatapon.effectpresent.actor;

import game.minipatapon.effectpresent.animation.HeroAnimateImage;

import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.OnActionCompleted;

public class ActionListener implements OnActionCompleted
{
	public HeroAnimateImage m_img;
	public RotateGroup m_group;
	public ActionListener(RotateGroup group,HeroAnimateImage img){
		m_img = img;
		m_group= group;
	}


	@Override
	public void completed(Action action)
	{
		//m_img.
		if(m_group.stateMap.get(m_img)==0)
		{
			m_img.indexTexture =2;
		}
		else 
			m_img.indexTexture =1;
		// TODO Auto-generated method stub
		
		
	}

}
