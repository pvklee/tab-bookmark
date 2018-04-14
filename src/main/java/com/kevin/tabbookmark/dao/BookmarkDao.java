package com.kevin.tabbookmark.dao;

import com.kevin.tabbookmark.model.Bookmark;

import java.util.List;

public interface BookmarkDao {

    int save(Bookmark bookmark);
    Bookmark get(int id);
    List<Bookmark> list();
    void update(int id, Bookmark bookmark);
    void delete(int id);

}
