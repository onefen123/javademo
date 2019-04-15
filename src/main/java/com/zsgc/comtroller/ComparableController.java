package com.zsgc.comtroller;


import com.zsgc.entity.Book;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RestController
public class ComparableController {
    @RequestMapping("/paixu")
    public void paixu(){
        Book books[]=new Book[]{
                new Book("小明",22),
                new Book("小s",21),
                new Book("小d",26)
        };
        Arrays.sort(books);
        System.out.println(Arrays.toString(books));
    }
}




