package pe.edu.cibertec.dswii_cl1soap_agueroarcestephano.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.cibertec.dswii_cl1soap_agueroarcestephano.model.Autor;

@Repository
public interface AutorRepository extends JpaRepository<Autor, Integer> {
}
