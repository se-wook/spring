package com.ssafy.model.dto;

import java.io.Serializable;

public class PageBean implements Serializable {
	/**검색 조건 */
	private String key;
	/**검색 단어 */
	private String word;
	/**한 페이지에 보여줄 글의 수 */
	private int interval=5;
	/**클라이언트가 요청한 페이지 번호*/
	private int pageNo;
	/**클라이언트가 요청한 페이지의 첫 글 번호 */
	private int start = 1;
	/**클라이언트가 요청한 페이지의 끝 글 번호 */
	private int end = interval;
	/**글 수에 따른 page link 정보 */
	private String pageLink;
	public PageBean() {}
	public PageBean(String key, String word, int pageNo) {
		this.key = key;
		this.word = word;
		this.pageNo = pageNo;
	}
	public PageBean(String key, String word, String pageNo) {
		this.key = key;
		this.word = word;
		try {
			this.pageNo = Integer.parseInt(pageNo);
		} catch (Exception e) {
			this.pageNo = 1;
		}
	}
	public String getKey() {
		return key;
	}
	public String getKey(String key) {
		if(key!=null && key.equals(this.key)) {
			return "selected='selected'";
		}else {
			return "";
		}
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getWord() {
		return word;
	}
	
	public void setWord(String word) {
		this.word = word;
	}
	public int getInterval() {
		return interval;
	}
	public void setInterval(int interval) {
		this.interval = interval;
	}
	public int getPageNo() {
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	public int getStart() {
		if(pageNo>1) {
			start = (pageNo - 1) * interval + 1;
		}
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getEnd() {
		if(pageNo>1) {
			end = start+interval - 1;
		}
		return end;
	}
	public void setEnd(int end) {
		this.end = end;
	}
	public String getPageLink() {
		return pageLink;
	}
	public void setPageLink(String pageLink) {
		this.pageLink = pageLink;
	}
	
	
}




















