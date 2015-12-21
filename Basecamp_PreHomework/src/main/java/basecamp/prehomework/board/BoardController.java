package basecamp.prehomework.board;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	
	/**
	 * Simply selects the home view to render by returning its name.
	 * @throws Exception 
	 */
//	@RequestMapping(value = "/", method = RequestMethod.GET)
//	public String home(Locale locale, Model model) {
//		logger.info("Welcome home! The client locale is {}.", locale);
//
//		Date date = new Date();
//		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
//
//		String formattedDate = dateFormat.format(date);
//
//		model.addAttribute("serverTime", formattedDate);
//		
//		HashMap<String, String> input = new HashMap<String, String>();
//		input.put("bContent", "content");
//		List<HashMap<String, String>> outputs = sqlSession.selectList("userControlMapper.selectSample", input);
//		System.out.println(outputs.toString());
//		
//		return "home";
//	}
	
	@RequestMapping(value = "/boardList", method = RequestMethod.GET)
	public ModelAndView boardList(CommandMap commandMap) throws Exception {
		ModelAndView mv = new ModelAndView("/boardList");
    	
    	List<Map<String,Object>> list = boardService.selectBoardList(commandMap.getMap());
    	mv.addObject("list", list);
    	
		return mv;
	}
	
	@RequestMapping(value = "/boardWrite", method = RequestMethod.GET)
	public String boardWrite(Model model) {

		return "boardWrite";
	}
	
	@RequestMapping(value = "/insertBoard")
	public ModelAndView insertBoard(CommandMap commandMap) throws Exception{
		ModelAndView mv = new ModelAndView("redirect:/boardList.do");
		
		boardService.insertBoardList(commandMap.getMap());
		
		return mv;
	}
	
	@RequestMapping(value = "/boardView", method = RequestMethod.GET)
	public String boardView(Model model) {

		return "boardView";
	}
	
	@RequestMapping(value = "/boardEdit", method = RequestMethod.GET)
	public String boardEdit(Model model) {

		return "boardEdit";
	}

}
