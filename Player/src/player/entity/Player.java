package player.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="player")
public class Player {
	@Id
	@Column(name = "playerId")
	private int playerId;
	@Column(name = "playerName")
	private String playerName;
	@Column(name = "gender")
	private boolean gender;
	@Column(name = "birthday")
	private Date birthday;
	@Column(name = "address")
	private String address;
	@Column(name = "clubName")
	private String clubName;
	@Column(name = "positionPlay")
	private String positionPlay;
	@Column(name = "transportCost")
	private float transportCost;
	public int getPlayerId() {
		return playerId;
	}
	public void setPlayerId(int playerId) {
		this.playerId = playerId;
	}
	public String getPlayerName() {
		return playerName;
	}
	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}
	public boolean isGender() {
		return gender;
	}
	public void setGender(boolean gender) {
		this.gender = gender;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getClubName() {
		return clubName;
	}
	public void setClubName(String clubName) {
		this.clubName = clubName;
	}
	public String getPositionPlay() {
		return positionPlay;
	}
	public void setPositionPlay(String positionPlay) {
		this.positionPlay = positionPlay;
	}
	public float getTransportCost() {
		return transportCost;
	}
	public void setTransportCost(float transportCost) {
		this.transportCost = transportCost;
	}
	public Player(int playerId, String playerName, boolean gender, Date birthday, String address, String clubName,
			String positionPlay, float transportCost) {
		super();
		this.playerId = playerId;
		this.playerName = playerName;
		this.gender = gender;
		this.birthday = birthday;
		this.address = address;
		this.clubName = clubName;
		this.positionPlay = positionPlay;
		this.transportCost = transportCost;
	}
	public Player() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
