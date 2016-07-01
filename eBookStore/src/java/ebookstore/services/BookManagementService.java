package ebookstore.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import ebookstore.domain.Ebook;

@Stateless
public class BookManagementService {
    @PersistenceContext
    EntityManager em;
    
    public List<Ebook> getAllBooks() {
        TypedQuery q = em.createQuery("SELECT b FROM Ebook b", Ebook.class);
        
        return q.getResultList();
    }
    
    public void addBook(Ebook ebook) {
        em.persist(ebook);
    }
}