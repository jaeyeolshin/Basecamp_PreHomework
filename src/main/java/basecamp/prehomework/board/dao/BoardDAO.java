package basecamp.prehomework.board.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import basecamp.prehomework.common.dao.CommonDAO;

@Repository("boardDAO")
public class BoardDAO extends CommonDAO{
	
	@SuppressWarnings("unchecked")
	public List<Map<String, Object>> selectBoardList(Map<String, Object> map) throws Exception{
		return (List<Map<String, Object>>)selectList("board.selectBoardList", map);
	}

	public void insertBoard(Map<String, Object> map) throws Exception{
		insert("board.insertBoard", map);
	}

	public void editBoard(Map<String, Object> map) throws Exception{
		edit("board.editBoard", map);
	}

	public void deleteBoard(Map<String, Object> map) throws Exception{
		delete("board.deleteBoard", map);
	}
	
	@SuppressWarnings("unchecked")
	public Map<String, Object> editCheckBoard(Map<String, Object> map) throws Exception{
		Map<String, Object> tempMap = new HashMap<String, Object>();
		tempMap = (Map<String, Object>) editCheck("board.editCheckBoard", map);
		return tempMap;
	}
}
