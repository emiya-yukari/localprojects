package com.emiya.projects.localprojects.sysdesign.the4th;

import java.util.Stack;

public class BoxGame {
	
	private Path manPath=new Path();
	private Path boxPath=new Path();
	
	public Path getManPath() {
		return manPath;
	}

	public Path getBoxPath() {
		return boxPath;
	}

	public void startGame(GameMap gameMap) throws Exception{
		try{
			gameMap.init();
			manPath.addCell(new PathCell(gameMap.getMan().getRow(),gameMap.getMan().getColumn()));
			boxPath.addCell(new PathCell(gameMap.getBox().getRow(),gameMap.getBox().getColumn()));
		}catch(Exception e){
			e.printStackTrace();
			return;	
		}
			go(null,gameMap);
	}
	
	private void go(PathCell nextPath,GameMap gameMap) throws Exception{
		
		//在这个平行世界中推了箱子
		Path manGoPath=null;
		
		if(nextPath!=null){							//第一次传入null
		
			manGoPath=this.manGetPath(gameMap.getMan(),gameMap.getBox(),gameMap,nextPath);
			if(manGoPath.isEmpty()){
				return;
			}
			manGoProcess(manGoPath,gameMap);
			pushBox(nextPath,gameMap);
			gameMap.printMap();
			if(gameMap.hasArrived()){
				//manPath.printPath();
				//boxPath.printPath();
				throw new SuccessException("has arrived");
				
			}
		}
		
		//准备进入下个平行世界
		
		Stack<PathCell> boxNextStepStack=null;
		
		boxNextStepStack=StepTool.getMiniNextStep(gameMap.getBox().getRow(), gameMap.getBox().getColumn(), gameMap.getTarget().getRow(), gameMap.getTarget().getColumn(), gameMap);

		PathCell nextStep=null;
			
		while(!boxNextStepStack.isEmpty()){
			nextStep=boxNextStepStack.pop();		//取出一个并且不为空
			go(nextStep,gameMap.clone());
		}
		
		//准备离开这个平行世界
		
		manPath.removeCell(manPath.getLastCell());
		boxPath.removeCell(boxPath.getLastCell());
		manPath.removePath(manGoPath);
	}
	
	
	private Path manGetPath(Man man,Box box,GameMap gameMap,PathCell boxNextStepCell){
		Path manGoPath=new Path();
		PathCell manTargetCell=OppositeTool.getOppositeCell(boxNextStepCell.getRow(), boxNextStepCell.getColumn(), box.getRow(), box.getColumn(), gameMap);
		
		//人不能到——这一格是墙或者边
		if(manTargetCell==null){
			return manGoPath;
		}
		
		try{
			PathTool.hasPath(man.getRow(), man.getColumn(), manTargetCell.getRow(), manTargetCell.getColumn(), gameMap, manGoPath);
		}catch(Exception e){
			;
		}
		
		return manGoPath;
	}
	
	private void manGoProcess(Path path,GameMap gameMap){
		PathCell manStartCell=path.getFirstCell();
		PathCell manEndCell=path.getLastCell();
		
		if(manStartCell.getRow()==manEndCell.getRow()&&manStartCell.getColumn()==manEndCell.getColumn())
			return;
		
		gameMap.set(manStartCell.getRow(), manStartCell.getColumn(), GameMap.EMPTY);
		gameMap.set(manEndCell.getRow(), manEndCell.getColumn(), GameMap.MAN);
		
		gameMap.getMan().setCell(manEndCell);
		
		manPath.addPath(path);
	}
	
	private void pushBox(PathCell nextStep, GameMap gameMap){
		PathCell boxStartCell=new PathCell(gameMap.getBox().getRow(),gameMap.getBox().getColumn());
		PathCell manStartCell=new PathCell(gameMap.getMan().getRow(),gameMap.getMan().getColumn());
		
		gameMap.set(nextStep.getRow(), nextStep.getColumn(), GameMap.BOX);
		gameMap.set(boxStartCell.getRow(), boxStartCell.getColumn(), GameMap.MAN);
		gameMap.set(manStartCell.getRow(), manStartCell.getColumn(), GameMap.EMPTY);
		
		gameMap.getBox().setCell(nextStep);
		gameMap.getMan().setCell(boxStartCell);
		
		manPath.addCell(gameMap.getMan().getCell());
		boxPath.addCell(gameMap.getBox().getCell());
	}
	
}
