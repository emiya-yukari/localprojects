package com.emiya.projects.localprojects.sysdesign.the4th;

public class GameStatus {
	private BoxStatus boxStatus;
	private ManStatus manStatus;
	private MapStatus mapStatus;
	
	public GameStatus(MapStatus mapStatus, BoxStatus boxStatus, ManStatus manStatus){
		this.mapStatus=mapStatus;
		this.boxStatus=boxStatus;
		this.manStatus=manStatus;
	}

	public BoxStatus getBoxStatus() {
		return boxStatus;
	}

	public ManStatus getManStatus() {
		return manStatus;
	}

	public MapStatus getMapStatus() {
		return mapStatus;
	}
	
	
}
