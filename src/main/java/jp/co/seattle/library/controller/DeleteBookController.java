package jp.co.seattle.library.controller;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import jp.co.seattle.library.service.BooksService;

@Controller
public class DeleteBookController {
	final static Logger logger = LoggerFactory.getLogger(DeleteBookController.class);

	@Autowired
	private BooksService booksService;
	
	/**
	 * 書籍情報を削除する
	 * 
	 * @param locale      ロケール情報
	 * @param bookId      書籍id
	 * @param model       モデル
	 * @return 遷移先画面
	 */
	@Transactional
	@RequestMapping(value = "/deleteBook", method = RequestMethod.POST, produces = "text/plain;charset=utf-8")
	public String deleteteBook(Locale locale, @RequestParam("bookId") int bookId,
			Model model) {

		// 書籍情報を削除する
		booksService.deleteBook(bookId);
		
		// 一覧画面に遷移する
		return "redirect:/home";
	}
}
