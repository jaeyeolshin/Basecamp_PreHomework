package basecamp.prehomework.board;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import basecamp.prehomework.board.dto.BoardService;
import basecamp.prehomework.common.map.CommandMap;

/**
 * Handles requests for the application home page.
 */
@Controller
public class BoardController {

	Logger logger = Logger.getLogger(BoardController.class);

	@Resource(name="boardService")
	private BoardService boardService;
	
	@RequestMapping(value = "/board/boardList.do")
	public ModelAndView boardList(CommandMap commandMap) throws Exception {
		ModelAndView mv = new ModelAndView("/board/boardList");
    	List<Map<String,Object>> list = boardService.selectBoardList(commandMap.getMap());
    	mv.addObject("list", list);
		return mv;
	}
	
	@RequestMapping(value = "/board/boardWrite.do")
	public ModelAndView boardWrite(Model model) {
		ModelAndView mv = new ModelAndView("/board/boardWrite");
		return mv;
	}
	
	@RequestMapping(value = "/board/insertBoard.do")
	public ModelAndView insertBoard(CommandMap commandMap) throws Exception{
		ModelAndView mv = new ModelAndView("redirect:/board/boardList.do");
		boardService.insertBoardList(commandMap.getMap());
		return mv;
	}
	
	@RequestMapping(value = "/board/boardCheck.do")
	public ModelAndView inputBoard(CommandMap commandMap) throws Exception {
		ModelAndView mv = new ModelAndView("/board/boardCheck");
		mv.addObject("target", commandMap.getMap());
		return mv;
	}
	
	@RequestMapping(value = "/board/boardEditCheck.do")
	public ModelAndView editCheckBoard(CommandMap commandMap) throws Exception {
		ModelAndView mv = new ModelAndView("/board/boardEdit");
		Map<String, Object> tempMap = boardService.editCheckBoardList(commandMap.getMap());
		if( tempMap != null){
			mv.addObject("edit", tempMap);
		}else{
			mv = new ModelAndView("redirect:/board/boardList.do");
		}
		return mv;			
	}

	@RequestMapping(value = "/board/boardEdit.do")
	public ModelAndView editBoard(CommandMap commandMap) throws Exception {
		ModelAndView mv = new ModelAndView("redirect:/board/boardList.do");
		boardService.editBoardList(commandMap.getMap());
		return mv;
	}
	
	@RequestMapping(value = "/board/boardDelete.do")
	public ModelAndView deleteBoard(CommandMap commandMap) throws Exception {
		ModelAndView mv = new ModelAndView("redirect:/board/boardList.do");
		boardService.deleteBoardList(commandMap.getMap());
		return mv;
	}

}
