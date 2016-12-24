package com.creants.pluto.logic;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;

import com.avengers.netty.core.om.IRoom;
import com.avengers.netty.gamelib.key.NetworkConstant;
import com.avengers.netty.socket.gate.wood.Message;
import com.avengers.netty.socket.gate.wood.User;
import com.creants.pluto.util.GameCommand;
import com.creants.pluto.util.MauBinhConfig;
import com.creants.pluto.util.MessageFactory;

/**
 * @author LamHa
 *
 */
public class TournamentGame extends MauBinhGame {

	public TournamentGame(IRoom room, int moneyBet) {
		super(room, moneyBet);
	}

	@Override
	protected void startWaitingPlayer() {
		if (playerSize() < 4)
			return;

		// sau 3s trận đấu bắt đầu
		startCountDown(3);

		Message message = MessageFactory.createMauBinhMessage(GameCommand.ACTION_START_AFTER_COUNTDOWN);
		message.putInt(NetworkConstant.KEYI_TIMEOUT, MauBinhConfig.startAfterSeconds);
		message.putLong(GameCommand.KEYL_UTC_TIME, DateTime.now().toDateTime(DateTimeZone.UTC).getMillis());
		gameApi.sendAllInRoom(message);

	}

	@Override
	protected void startNewMatch() {
		// TODO remove room cho player trở lại tournament, cho các player leave room

	}

	@Override
	protected int calculateElo(int winChiNo) {
		return winChiNo * 1000;
	}

	@Override
	public void ready(User user) {
		// TODO báo cho player khác user này ready
	}

}
