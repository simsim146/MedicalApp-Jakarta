package service;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import model.Patient;
import java.util.List;

@ApplicationScoped
public class PatientService {
    @PersistenceContext(unitName = "GmPu")
    private EntityManager em;
    @Transactional
    public void ajouter(Patient patient) {
        em.persist(patient);
    }
    public List<Patient> lister() {
        return em.createQuery("SELECT p FROM Patient m", Patient.class)
                .getResultList();
    }
}
