/** 
 * @description	: Game Manager interface
 * @author		: 黄攀
 * @created		: 2012-1-3
 */

package game.minipatapon.application;

import game.minipatapon.screen.LayeredScreen;
import game.minipatapon.screen.ProcessableScreen;

public interface ScreenManageable {

	void navigate(LayeredScreen screen);
}
