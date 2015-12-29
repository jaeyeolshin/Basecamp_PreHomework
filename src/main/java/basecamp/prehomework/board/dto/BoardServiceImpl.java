package basecamp.prehomework.board.dto;

import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import basecamp.prehomework.board.dao.BoardDAO;

@Service("boardService")
public class BoardServiceImpl implements BoardService {

	private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" 
			+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	
	@Resource(name="boardDAO")
	private BoardDAO boardDAO;
	
	@Override
	public List<Map<String, Object>> selectBoardList(Map<String, Object> map) throws Exception {
		return boardDAO.selectBoardList(map);
	}

	@Override
	public boolean insertBoardList(Map<String, Object> map) throws Exception {
		Pattern pattern = Pattern.compile(EMAIL_PATTERN);
		String emailInput = map.get("EMAIL").toString();
		Matcher matcher = pattern.matcher(emailInput);

		if(!matcher.matches())
			return false;
		
		boardDAO.insertBoard(map);
		return true;
	}

	@Override
	public void deleteBoardList(Map<String, Object> map) throws Exception {
		boardDAO.deleteBoard(map);
	}

	@Override
	public void editBoardList(Map<String, Object> map) throws Exception {
		boardDAO.editBoard(map);
	}

	@Override
	public Map<String, Object> editCheckBoardList(Map<String, Object> map) throws Exception {
		Map<String, Object> tempMap = boardDAO.editCheckBoard(map);
		
		if(tempMap.get("BID").toString().equals(map.get("BID").toString()))
			if(tempMap.get("PASSWORD").toString().equals(map.get("PASSWORD").toString()))
				return tempMap;

		return null;
	}

}
