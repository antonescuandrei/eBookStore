package ebookstore.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.OptimisticLockException;
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
    
    public List<Ebook> findBooksByTitle(String title) {
        TypedQuery q = em.createQuery("SELECT b FROM Ebook b WHERE UPPER(b.title) LIKE UPPER(:title)", Ebook.class);
        q.setParameter("title", "%" + title + "%");
                
        return q.getResultList();
    }
    
    public void removeBook(int bookId) {
        if (checkIfBookExists(bookId)) {
            Ebook bookToRemove = em.getReference(Ebook.class, bookId);
        
            em.remove(bookToRemove);
        }
    }
    
    public Ebook getBook(int bookId) {
        return em.find(Ebook.class, bookId);
    }
    
    public boolean mergeBook(Ebook ebook) {
        if (!checkIfBookExists(ebook.getId()))
            return false;
        
        try {
            em.merge(ebook);
        } catch (OptimisticLockException ex) {
            return false;
        }
        
        return true;
    }
    
    private boolean checkIfBookExists(int bookId) {
        TypedQuery<Boolean> q = em.createQuery("SELECT CASE WHEN (COUNT(b) > 0) THEN true ELSE false END FROM Ebook b WHERE b.id = :id", Boolean.class);
        q.setParameter("id", bookId);
        
        return q.getSingleResult();
    }
}