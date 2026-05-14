package service;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import model.Medecin;
import java.util.List;

@ApplicationScoped
public class MedecinService {
    @PersistenceContext(unitName = "GmPu")
    private EntityManager em;
    @Transactional
    public void ajouter(Medecin medecin) {
        em.persist(medecin);
    }
    public List<Medecin> lister() {
        return em.createQuery("SELECT m FROM Medecin m", Medecin.class)
                .getResultList();
    }
}
