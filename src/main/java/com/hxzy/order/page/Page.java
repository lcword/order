package com.hxzy.order.page;

public class Page<T> {
	public static final int MAXCOUNT = 3;//ÿҳ���������
	private int allCount;//��������
	private int maxPage;//���ҳ��
	private int curPage;//��ǰҳ
	private int prePage;//��һҳ
	private int nextPage;//��һҳ
	private T t;//����
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
	/*��ȡ���ҳ��*/
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
	/*��һҳ*/
	public int getPrePage() {
		if(curPage > 1){
			prePage = curPage - 1;
		}else{
			prePage = curPage;
		}
		return prePage;
	}
	/*��һҳ*/
	public int getNextPage() {
		if(curPage < maxPage){
			nextPage = curPage + 1;
		}else{
			nextPage = curPage;
		}
		return nextPage;
	}
	/*��ʼλ��*/
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
