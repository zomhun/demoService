package player.service;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;

import player.dao.impl.PlayerDAOImpl;
import player.entity.Player;

@Path("/player-service")
public class PlayerService {
	@GET
	@Path("/getListPlayer")
	@Produces(MediaType.APPLICATION_JSON)
	public String getPlayer() {
		List<Player> listPlayer = new PlayerDAOImpl().getListPlayer();
		Gson son = new Gson();
		String data = son.toJson(listPlayer);
		return data;
	}
	@GET
	@Path("/getPlayerById/{playerId}")
	@Produces(MediaType.APPLICATION_JSON)
	public String getPlayerById(@PathParam("playerId")int playerId) {
		Player player = new PlayerDAOImpl().getPlayerById(playerId);
		Gson son = new Gson();
		String data = son.toJson(player);
		return data;
	}
	@POST
	@Path("/insertPlayer")
	@Consumes(MediaType.APPLICATION_JSON)
	public String insertPlayer(String dataPlayer) {
		Gson son = new Gson();
		Player player = son.fromJson(dataPlayer, Player.class);
		boolean bl = new PlayerDAOImpl().insertPlayer(player);
		String result = son.toJson(bl);
		return result;
	}
	@PUT
	@Path("/updatePlayer")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String updatePlayer(String dataPlayer) {
		Gson son = new Gson();
		Player player = son.fromJson(dataPlayer, Player.class);
		boolean bl = new PlayerDAOImpl().updatePlayer(player);
		String result = son.toJson(bl);
		return result;
	}
	@DELETE
	@Path("/deletePlayer/{playerId}")
	@Consumes(MediaType.APPLICATION_JSON)
	public String deletePlayer(@PathParam("playerId")int playerId) {
		Gson son = new Gson();
		boolean bl = new PlayerDAOImpl().deletePlayer(playerId);
		String result = son.toJson(bl);
		return result;
	}
	@GET
	@Path("/getPlayerByClubName/{clubName}")
	@Produces(MediaType.APPLICATION_JSON)
	public String getPlayerByClubName(@PathParam("clubName")String clubName) {
		List<Player> listPlayer = new PlayerDAOImpl().getPlayerByClubName(clubName);
		Gson son = new Gson();
		String data = son.toJson(listPlayer);
		return data;
	}
}
