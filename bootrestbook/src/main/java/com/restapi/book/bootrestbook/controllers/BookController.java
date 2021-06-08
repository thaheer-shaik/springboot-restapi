package com.restapi.book.bootrestbook.controllers;

import java.util.List;
import java.util.Optional;

import com.restapi.book.bootrestbook.Entity.Book;
import com.restapi.book.bootrestbook.service.BookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController 
{
    //@RequestMapping(value="/books",method = RequestMethod.GET)
    @Autowired
    private BookService bookService;
    
    
    @GetMapping("/books")
    // public List<Book> getBooks()
    // {
        
    //     return this.bookService.getBooks();
    // }
    //http response handler
    public ResponseEntity<List<Book>> getBooks()
    {
        List<Book> list=this.bookService.getAllBooks();

        if(list.size()<=0)
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.of(list));
    }

    @GetMapping("/books/{id}")
    public Book getBook(@PathVariable("id") int id)
    {
        return bookService.getBookById(id);
    }
    
    @PostMapping("/books")
    public Book addBook(@RequestBody Book b)
    {
        this.bookService.addBook(b);
        return b;
    }

    @DeleteMapping("/books/{id}")
    public void deleteBook(@PathVariable("id") int id)
    {
        this.bookService.deleteBook(id);
    }
 
    @PutMapping("/books/{id}")
    public Book updateBook(@RequestBody Book book, @PathVariable("id") int id)
    {
        this.bookService.updateBook(book,id);
        return book;
    } 
}
