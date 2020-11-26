package org.softwire.training.bookish.controllers;

import org.softwire.training.bookish.models.database.Book;
import org.softwire.training.bookish.models.page.CataloguePageModel;
import org.softwire.training.bookish.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/catalogue")
public class CatalogueController {

    public final BookService bookService;

    @Autowired
    public CatalogueController(BookService bookService) {
        this.bookService = bookService;
    }

    @RequestMapping("")
    ModelAndView catalogue() {

        List<Book> allBooks = bookService.getAllBooks();

        CataloguePageModel cataloguePageModel = new CataloguePageModel();
        cataloguePageModel.setBooks(allBooks);

        return new ModelAndView("catalogue", "model", cataloguePageModel);
    }
}
