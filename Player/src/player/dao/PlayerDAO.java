package player.dao;

import java.util.List;

import player.entity.Player;

public interface PlayerDAO {
	public List<Player> getListPlayer();
	public Player getPlayerById(int playerId);
	public boolean insertPlayer(Player player);
	public boolean updatePlayer(Player player);
	public boolean deletePlayer(int playerId);
	public List<Player> getPlayerByClubName(String clubName);
}
