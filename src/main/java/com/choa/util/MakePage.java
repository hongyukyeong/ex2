package com.choa.util;

public class MakePage {
	
	private int curBlock; //이전버튼
	private int totalBlock; 
	private int startNum; //화면블럭의 첫번째페이지 번호
	private int lastNum; //화면블럭의 마지막페이지 번호
	private int totalPage;
	
	
	public void makePage(int totalCount, int curPage, int perPage, int perBlock){
		
		if(totalCount==0) totalCount = 1; 
		
		//totalPage
		if(totalCount%perPage == 0){
			this.totalPage = totalCount/perPage;
		}else{
			this.totalPage = totalCount/perPage + 1;
		}
		
		//2. totalBlock
		if(totalPage%perBlock == 0){
			this.totalBlock = totalPage/perBlock;
		}else{
			this.totalBlock = totalPage/perBlock + 1;
		}
		
		//3. curBlock
		if(curPage%perBlock == 0){
			this.curBlock = curPage/perBlock;
		}else{
			curBlock = curPage/perBlock + 1;
		}
		
		//4. startNum, lastNum
		this.startNum = (this.curBlock-1)*perBlock + 1;
		this.lastNum = this.curBlock*perBlock;
		if(this.curBlock == this.totalBlock){
			this.lastNum = totalPage;
		}
		
	}
	
	
	public int getCurBlock() {
		return curBlock;
	}
	public int getTotalBlock() {
		return totalBlock;
	}
	public int getStartNum() {
		return startNum;
	}
	public int getLastNum() {
		return lastNum;
	}

	public int getTotalPage() {
		return totalPage;
	}
	
	
	
	

}
