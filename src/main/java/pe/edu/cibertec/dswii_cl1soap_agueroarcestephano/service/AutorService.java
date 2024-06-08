package pe.edu.cibertec.dswii_cl1soap_agueroarcestephano.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.dswii_cl1soap_agueroarcestephano.convert.AutorConvert;
import pe.edu.cibertec.dswii_cl1soap_agueroarcestephano.model.Autor;
import pe.edu.cibertec.dswii_cl1soap_agueroarcestephano.repository.AutorRepository;
import pe.edu.cibertec.ws.objects.Autorws;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class AutorService implements IAutorService {

    private AutorRepository autorRepository;
    private AutorConvert autorConvert;

    @Override
    public List<Autorws> listarAutores() {
        return autorConvert.convertAutorToAutorws(autorRepository.findAll());
    }

    @Override
    public Autorws obtenerAutorxId(int id) {
        Optional<Autor> autor = autorRepository.findById(id);
        System.out.println(autor);
        return autor.map(value -> autorConvert.convertAutorToAutorws(value)).orElse(null);
    }

    @Override
    public Autorws registrarActualizarAutor(Autorws autorws) {
        Autor nuevoAutor = autorRepository.save(autorConvert.convertAutorwsToAutor(autorws));
        if(nuevoAutor == null){
            return null;
        }
        return autorConvert.convertAutorToAutorws(nuevoAutor);
    }
}
