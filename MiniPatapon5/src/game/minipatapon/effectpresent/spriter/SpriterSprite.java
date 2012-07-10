package game.minipatapon.effectpresent.spriter;

public class SpriterSprite {
  public SpriterObjectPart objectPart;
  public float colorRed; // 0 to 1
  public float colorGreen;// 0 to 1
  public float colorBlue;// 0 to 1
  public float opacity;// 0 to 1, 1 is opaque
  public float angle;// 0 to 360 from east counterclockwise
  public float x;// left position of the sprite
  public float y;// top position of the sprite
  public float width;// width of the sprite, if differs from the texture, it gets stretched
  public float height;// heigt of the sprite, if differs from the texture, it gets stretched
  public boolean flipX;
  public boolean flipY;

  public void setValues(SpriterSprite sprite) {
    this.objectPart = sprite.objectPart;
    this.colorRed = sprite.colorRed;
    this.colorGreen = sprite.colorGreen;
    this.colorBlue = sprite.colorBlue;
    this.opacity = sprite.opacity;
    this.angle = sprite.angle;
    this.x = sprite.x;
    this.y = sprite.y;
    this.width = sprite.width;
    this.height = sprite.height;
    this.flipX = sprite.flipX;
    this.flipY = sprite.flipY;
  }

  public void setTweenedValues(SpriterSprite sprite1, SpriterSprite sprite2, float tweenFactor) {
    // if(tweenFactor < 0.5f){
    this.objectPart = sprite1.objectPart;
    // }else{
    // this.objectPart = sprite2.objectPart;
    // }
    this.objectPart = sprite1.objectPart;
    this.colorRed = sprite1.colorRed * (1 - tweenFactor) + sprite2.colorRed * tweenFactor;
    this.colorGreen = sprite1.colorGreen * (1 - tweenFactor) + sprite2.colorGreen * tweenFactor;
    this.colorBlue = sprite1.colorBlue * (1 - tweenFactor) + sprite2.colorBlue * tweenFactor;
    this.opacity = sprite1.opacity * (1 - tweenFactor) + sprite2.opacity * tweenFactor;
    this.angle = sprite1.angle;
    if (sprite2.angle > sprite1.angle) {
      if (sprite2.angle - sprite1.angle <= 180) {
        this.angle = sprite1.angle * (1 - tweenFactor) + sprite2.angle * tweenFactor;
      } else {
        this.angle = (360 + sprite1.angle) * (1 - tweenFactor) + sprite2.angle * tweenFactor;
      }
    } else {
      if (sprite1.angle - sprite2.angle <= 180) {
        this.angle = sprite1.angle * (1 - tweenFactor) + sprite2.angle * tweenFactor;
      } else {
        this.angle = sprite1.angle * (1 - tweenFactor) + (360 + sprite2.angle) * tweenFactor;
      }
    }
    this.x = sprite1.x * (1 - tweenFactor) + sprite2.x * tweenFactor;
    this.y = sprite1.y * (1 - tweenFactor) + sprite2.y * tweenFactor;
    this.width = sprite1.width * (1 - tweenFactor) + sprite2.width * tweenFactor;
    this.height = sprite1.height * (1 - tweenFactor) + sprite2.height * tweenFactor;
    if (tweenFactor < 0.5f) {
      this.flipX = sprite1.flipX;
    } else {
      this.flipX = sprite2.flipX;
    }
    if (tweenFactor < 0.5f) {
      this.flipY = sprite1.flipY;
    } else {
      this.flipY = sprite2.flipY;
    }
  }

  @Override
  public String toString() {
    return "SpriterSprite [objectPart=" + objectPart + ", colorRed=" + colorRed + ", colorGreen="
        + colorGreen + ", colorBlue=" + colorBlue + ", opacity=" + opacity + ", angle=" + angle
        + ", x=" + x + ", y=" + y + ", width=" + width + ", height=" + height + "]";
  }

}
