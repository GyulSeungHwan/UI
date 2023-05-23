package com.yedam;

import lombok.Data;

@Data
public class ToDoVO {
	private int todoNo; // 번호
	private String todoTitle; // 할 일(to do)
	private String todoStatus; // 상태(취소선) 취소:Y, N
	// 목록, 등록, 삭제, 변경
}
