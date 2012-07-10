package game.minipatapon.effectpresent.actor;


import com.badlogic.gdx.scenes.scene2d.Group;

public class SynchroGroup extends Group {

	public SynchroGroup(String name, FlatImage... images) {

		super(name);

		for (int i = 0; i < images.length; i++) {
			this.addActor(images[i]);
		}

	}

	@SuppressWarnings("unused")
	public void synchronizeChildren() {
		for (int i = 0; i < children.size(); i++) {
			FlatImage image = (FlatImage) children.get(i);
			
		}
	}

}
