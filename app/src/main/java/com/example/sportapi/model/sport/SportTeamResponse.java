package com.example.sportapi.model.sport;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.SerializedName;

public class SportTeamResponse{

	@SerializedName("result")
	private ArrayList<ResultItem> result;

	@SerializedName("success")
	private int success;

	public void setResult(ArrayList<ResultItem> result){
		this.result = result;
	}

	public ArrayList<ResultItem> getResult(){
		return result;
	}

	public void setSuccess(int success){
		this.success = success;
	}

	public int getSuccess(){
		return success;
	}

	@Override
 	public String toString(){
		return 
			"SportTeamResponse{" + 
			"result = '" + result + '\'' + 
			",success = '" + success + '\'' + 
			"}";
		}
}