package com.creants.pluto.logic.state;

import com.creants.pluto.logic.MauBinhGame;

/**
 * @author Kian
 *
 */
public interface GameState {
	void onEnter(MauBinhGame context);

	void onExit(MauBinhGame context);

}
