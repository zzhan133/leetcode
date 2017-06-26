package com.leetcode.ques;

public class Problem {

	public Problem() {
	}

	public Problem(int id, int thumbUp, int thumbDown) {
		super();
		this.id = id;
		this.thumbUp = thumbUp;
		this.thumbDown = thumbDown;
	}

	private int id;
	private int thumbUp;
	private int thumbDown;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getThumbUp() {
		return thumbUp;
	}

	public void setThumbUp(int thumbUp) {
		this.thumbUp = thumbUp;
	}

	public int getThumbDown() {
		return thumbDown;
	}

	public void setThumbDown(int thumbDown) {
		this.thumbDown = thumbDown;
	}

}
