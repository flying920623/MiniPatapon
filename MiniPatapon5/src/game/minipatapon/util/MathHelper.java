package game.minipatapon.util;

import game.minipatapon.effectpresent.spriter.SpriterObject;
import game.minipatapon.effectpresent.spriter.SpriterSprite;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class MathHelper {
	public static float getDistance(float x1, float y1, float x2, float y2) {
		return getDistance(x1 - x2, y1 - y2);
	}

	public static float getDistance(float x, float y) {
		return (float) Math.sqrt((double) (x * x) + (float) (y * y));
	}

	public static float getDistance(Vector2 v1, Vector2 v2) {
		return getDistance(v1.x - v2.x, v1.y - v2.y);
	}

	public static Vector2 getPointfDistance(Vector2 p1, Vector2 p2) {
		return new Vector2(p1.x - p2.x, p1.y - p2.y);
	}

	public static boolean isRectContainPoint(Rectangle r, Vector2 f) {
		return r.contains(f.x, f.y);
	}

	public static Rectangle getActorRect(Actor actor) {
		return new Rectangle(actor.x, actor.y, actor.width, actor.height);
	}

	public static Vector2 getQuadCurve(Vector2 startVector,
			Vector2 controlVector, Vector2 endVector, float t) {
		float x = (1 - t) * (1 - t) * startVector.x + 2 * t * (1 - t)
				* controlVector.x + t * t * endVector.x;
		float y = (1 - t) * (1 - t) * startVector.y + 2 * t * (1 - t)
				* controlVector.y + t * t * endVector.y;

		return new Vector2(x, y);
	}

	public static Vector2 getCubicCurve(Vector2 startVector, Vector2 control1,
			Vector2 control2, Vector2 endVector, float t) {
		float x = (1 - t) * (1 - t) * (1 - t) * startVector.x + 3 * t * (1 - t)
				* (1 - t) * control1.x + 3 * t * t * (1 - t) * control2.x + t
				* t * t * endVector.x;
		float y = (1 - t) * (1 - t) * (1 - t) * startVector.y + 3 * t * (1 - t)
				* (1 - t) * control1.y + 3 * t * t * (1 - t) * control2.y + t
				* t * t * endVector.y;

		return new Vector2(x, y);
	}

	public static float nMultiplication(float x, int n) {
		float value = 1f;
		for (int i = 0; i < n; i++) {
			value *= x;
		}

		return value;
	}

	public static Rectangle spriterToGdx(SpriterSprite sprite,
			SpriterObject object) {
		Rectangle rectangle = new Rectangle();

		rectangle.x = sprite.x + 1 / object.scaleX * object.x;
		rectangle.y = sprite.y - sprite.height + 1 / object.scaleY * object.y;

		rectangle.x = rectangle.x - sprite.objectPart.originX - object.initX;
		rectangle.y = rectangle.y + sprite.objectPart.originY + object.initY;

		return rectangle;
	}

	public static boolean collide(Rectangle rect1, Rectangle rect2) {

		if (containRectPoint(rect1, rect2)) {
			return true;
		} else if (containRectPoint(rect2, rect1)) {
			return true;
		}

		return false;

	}

	public static boolean containRectPoint(Rectangle rect1, Rectangle rect2) {
		if (rect1.contains(rect2.x, rect2.y)) {
			return true;
		} else if (rect1.contains(rect2.x + rect2.width, rect2.y)) {
			return true;
		} else if (rect1.contains(rect2.x, rect2.y + rect2.height)) {
			return true;
		} else if (rect1
				.contains(rect2.x + rect2.width, rect2.y + rect2.height)) {
			return true;
		}

		return false;
	}

	public static float angleOfPoints(float startX, float startY, float endX,
			float endY) {
		return (endY - startY) / (endX - startX);
	}
}
