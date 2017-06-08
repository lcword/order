package com.hxzy.order.page;

public class Page<T> {
	public static final int MAXCOUNT = 15;//每页最大显示条数
	private int allCount;//总记录条数
	private int maxPage;//总页数
	private int curPage;//当前页数
	private int prePage;//前一页
	private int nextPage;//后一页
	private T t;//查询的条件
	public Page(int allCount, int curPage) {
		this.allCount = allCount;
		this.curPage = curPage;
		getMaxPage();
	}
	public void setAllCount(int allCount) {
		this.allCount = allCount;
	}
	public int getAllCount() {
		return allCount;
	}
	/*计算最大页数*/
	public int getMaxPage() {
		maxPage = allCount / MAXCOUNT;
		if(allCount % MAXCOUNT != 0){
			maxPage += 1;
		}
		return maxPage;
	}
	public int getCurPage() {
		return curPage;
	}
	public void setCurPage(int curPage) {
		this.curPage = curPage;
	}
	/*前一页*/
	public int getPrePage() {
		if(curPage > 1){
			prePage = curPage - 1;
		}else{
			prePage = curPage;
		}
		return prePage;
	}
	/*后一页*/
	public int getNextPage() {
		if(curPage < maxPage){
			nextPage = curPage + 1;
		}else{
			nextPage = curPage;
		}
		return nextPage;
	}
	/*获取开始位置*/
	public int getStartIndex() {
		return (curPage-1) * MAXCOUNT;
	}
	public T getT() {
		return t;
	}
	public void setT(T t) {
		this.t = t;
	}
}
