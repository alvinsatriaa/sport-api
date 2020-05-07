package com.example.sportapi.model.sport;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class ResultItem{

	@SerializedName("coaches")
	private List<CoachesItem> coaches;

	@SerializedName("players")
	private List<PlayersItem> players;

	@SerializedName("team_key")
	private String teamKey;

	@SerializedName("team_name")
	private String teamName;

	@SerializedName("team_logo")
	private String teamLogo;

	public void setCoaches(List<CoachesItem> coaches){
		this.coaches = coaches;
	}

	public List<CoachesItem> getCoaches(){
		return coaches;
	}

	public void setPlayers(List<PlayersItem> players){
		this.players = players;
	}

	public List<PlayersItem> getPlayers(){
		return players;
	}

	public void setTeamKey(String teamKey){
		this.teamKey = teamKey;
	}

	public String getTeamKey(){
		return teamKey;
	}

	public void setTeamName(String teamName){
		this.teamName = teamName;
	}

	public String getTeamName(){
		return teamName;
	}

	public void setTeamLogo(String teamLogo){
		this.teamLogo = teamLogo;
	}

	public String getTeamLogo(){
		return teamLogo;
	}

	@Override
 	public String toString(){
		return 
			"ResultItem{" + 
			"coaches = '" + coaches + '\'' + 
			",players = '" + players + '\'' + 
			",team_key = '" + teamKey + '\'' + 
			",team_name = '" + teamName + '\'' + 
			",team_logo = '" + teamLogo + '\'' + 
			"}";
		}
}