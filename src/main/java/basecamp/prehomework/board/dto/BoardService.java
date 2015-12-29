package basecamp.prehomework.board.dto;

import java.util.List;
import java.util.Map;

public interface BoardService {
	
	public List<Map<String, Object>> selectBoardList(Map<String,Object> map) throws Exception;
	public boolean insertBoardList(Map<String, Object> map) throws Exception;
	public void deleteBoardList(Map<String, Object> map) throws Exception;
	public void editBoardList(Map<String, Object> map) throws Exception;
	public Map<String, Object> editCheckBoardList(Map<String, Object> map) throws Exception;
	
}
