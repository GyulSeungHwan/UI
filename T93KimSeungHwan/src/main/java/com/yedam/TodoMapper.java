package com.yedam;

import java.util.List;

public interface TodoMapper {
	public List<ToDoVO> todoList();
	public int insertTodo(ToDoVO vo);
	public int deleteTodo(int todoNo);
	public int updateTodo(ToDoVO vo);
}
