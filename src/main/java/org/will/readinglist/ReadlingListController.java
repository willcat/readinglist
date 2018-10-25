package org.will.readinglist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/")
public class ReadlingListController {
    private ReadingListRepository readingListRepository;

    @Autowired
    public ReadlingListController(ReadingListRepository readingListRepository) {
        this.readingListRepository = readingListRepository;
    }

    //show reading list
    @RequestMapping(value = "/{reader}", method = RequestMethod.GET)
    public String readersBooks(
            @PathVariable("reader") String reader,
            Model model) {
        List<Book> readlingList =
                readingListRepository.findByReader(reader);

        if (readlingList != null) {
            model.addAttribute("books", readlingList);
        }

        return "readingList";
    }

    //add new book
    @RequestMapping(value = "/{reader}", method = RequestMethod.POST)
    public String addToReadingList(
            @PathVariable("reader") String reader,Book book ) {
        book.setReader(reader);
        readingListRepository.save(book);
        return "redirect:/{reader}";
    }
}
