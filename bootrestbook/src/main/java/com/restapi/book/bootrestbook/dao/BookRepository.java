package com.restapi.book.bootrestbook.dao;

import com.restapi.book.bootrestbook.Entity.Book;

import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book,Integer>
{
    public Book findById(int id);
    
}
