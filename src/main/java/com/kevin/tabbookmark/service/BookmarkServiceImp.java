package com.kevin.tabbookmark.service;

import com.kevin.tabbookmark.dao.BookmarkDao;
import com.kevin.tabbookmark.model.Bookmark;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class BookmarkServiceImp implements BookmarkService{
    
    @Autowired
    private BookmarkDao bookmarkDao;

    @Transactional
    @Override
    public int save(Bookmark bookmark) {
        return bookmarkDao.save(bookmark);
    }
    
    @Override
    public Bookmark get(int id) {
        return bookmarkDao.get(id);
    }

    @Override
    public List<Bookmark> list() {
        return bookmarkDao.list();
    }

    @Transactional
    @Override
    public void update(int id, Bookmark bookmark) {
        bookmarkDao.update(id, bookmark);
    }

    @Transactional
    @Override
    public void delete(int id) {
        bookmarkDao.delete(id);
    }
}
