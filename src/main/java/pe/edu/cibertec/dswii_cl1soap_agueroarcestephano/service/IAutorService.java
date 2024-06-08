package pe.edu.cibertec.dswii_cl1soap_agueroarcestephano.service;

import pe.edu.cibertec.ws.objects.Autorws;

import java.util.List;

public interface IAutorService {

    List<Autorws> listarAutores();

    Autorws obtenerAutorxId(int id);

    Autorws registrarActualizarAutor(Autorws autorws);
}
