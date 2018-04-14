package com.kevin.tabbookmark.dao;

import com.kevin.tabbookmark.model.Bookmark;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class BookmarkDaoImp implements BookmarkDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public int save(Bookmark bookmark) {
        sessionFactory.getCurrentSession().save(bookmark);
        return bookmark.getId();
    }

    @Override
    public Bookmark get(int id) {
        return sessionFactory.getCurrentSession().get(Bookmark.class, id);
    }

    @Override
    public List<Bookmark> list() {
        Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Bookmark> cq = cb.createQuery(Bookmark.class);
        Root<Bookmark> root = cq.from(Bookmark.class);
        cq.select(root);
        Query<Bookmark> query = session.createQuery(cq);
        return query.getResultList();
    }

    @Override
    public void update(int id, Bookmark bookmark) {
        Session session = sessionFactory.getCurrentSession();
        Bookmark savedBookmark = session.byId(Bookmark.class).load(id);
        savedBookmark.setSongName(bookmark.getSongName());
        savedBookmark.setArtistName(bookmark.getArtistName());
        savedBookmark.setLink(bookmark.getLink());
        session.flush();

    }

    @Override
    public void delete(int id) {
        Session session = sessionFactory.getCurrentSession();
        Bookmark bookmark = session.byId(Bookmark.class).load(id);
        session.delete(bookmark);
    }
}
