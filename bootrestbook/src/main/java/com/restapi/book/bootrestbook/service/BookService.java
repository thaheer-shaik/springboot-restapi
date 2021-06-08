package com.restapi.book.bootrestbook.service;

import java.util.*;
//import java.util.stream.Collectors;

import com.restapi.book.bootrestbook.Entity.Book;
import com.restapi.book.bootrestbook.dao.BookRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//@Component
@Service
public class BookService 
{
    private static List<Book> list=new ArrayList<>();

    // static 
    // {
    //     list.add(new Book(12,"The complete reference","Mcgraw hill"));
    //     list.add(new Book(14,"Head First Java","anonymous"));
    //     list.add(new Book(34,"Thinking in java","Anonymous only"));
    // }

        @Autowired
        private BookRepository bookRepository;


    //get all books
    public List getBooks()
    {
        return list; 
    }
    //get book by id
    public Book getBookById(int id)
    {
        Book book=null;
        book=list.stream().filter(e-> e.getId()==id).findFirst().get();

        return book;
    }

    public Book addBook(Book b)
    {
        // list.add(b);
        // return b;

        Book result=bookRepository.save(b);
        return result;
    } 

    public void deleteBook(int id)
    {
        // list=list.stream().filter(book->{
        //     if(book.getId()!=Id)
        //     {
        //         return true;
        //     }
        //     else
        //     {
        //         return false;
        //     }
            
        // }).collect(Collectors.toList());

        bookRepository.deleteById(id);
    }

    public void updateBook(Book book, int id)
    {
        // list=list.stream().map(b->{
        //     if(b.getId()==id)
        //     {
        //         b.setTitle(book.getTitle());
        //         b.setAuthor(book.getAuthor());
        //     }
        //     return b;
        // }).collect(Collectors.toList());

        book.setId(id);
        bookRepository.save(book);
    }

    public List<Book> getAllBooks()
    {
        List<Book> list=(List<Book>)this.bookRepository.findAll();

        return list;
    }
}
