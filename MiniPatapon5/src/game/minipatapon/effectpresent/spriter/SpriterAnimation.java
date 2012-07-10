package game.minipatapon.effectpresent.spriter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SpriterAnimation {
  public String name;
  public float animationLength;
  private List<SpriterAnimationFrame> frames;
  
  public SpriterAnimation(){
    this.frames = new ArrayList<SpriterAnimationFrame>();
  }
  
  public List<SpriterAnimationFrame> getFrames() {
    return Collections.unmodifiableList(frames);
  }
  public void addFrame(SpriterAnimationFrame frame) {
    this.frames.add(frame);
  }

  @Override
  public String toString() {
    return "SpriterAnimation [name=" + name + ", frames=" + frames + "]";
  }
  
  
}
