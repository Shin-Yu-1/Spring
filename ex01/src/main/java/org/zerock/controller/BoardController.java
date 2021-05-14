package org.zerock.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/board/*")
public class BoardController {
	
	@RequestMapping("")
	public void board_main() {
		log.info("board----------------");
	}
	@RequestMapping("/board/list")
	public void board_list() {
		log.info("list----------------");
	}
	@RequestMapping("/board/insert")
	public void board_insert() {
		log.info("insert----------------");
	}
}
