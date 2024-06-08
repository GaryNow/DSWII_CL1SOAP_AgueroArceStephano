package pe.edu.cibertec.dswii_cl1soap_agueroarcestephano.convert;

import org.springframework.stereotype.Component;
import pe.edu.cibertec.dswii_cl1soap_agueroarcestephano.model.Autor;
import pe.edu.cibertec.ws.objects.Autorws;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

@Component
public class AutorConvert {

    public Autor convertAutorwsToAutor(Autorws autorws){
        Autor autor = new Autor();
        autor.setIdautor(autorws.getIdautor());
        autor.setNomautor(autorws.getNomautor());
        autor.setApeautor(autorws.getApeautor());
        // Convert XMLGregorianCalendar to Date
        XMLGregorianCalendar xmlGregCal = autorws.getFechnacautor();
        if (xmlGregCal != null) {
            GregorianCalendar gregCal = xmlGregCal.toGregorianCalendar();
            Date date = gregCal.getTime();
            autor.setFechnacautor(date);
        }
        return autor;

    }

    public List<Autor> convertAutorwsToAutor(List<Autorws> autorws){
        List<Autor> autorList = new ArrayList<>();
        autorws.forEach(aut ->{
            autorList.add(convertAutorwsToAutor(aut));
        });
        return autorList;
    }
    public Autorws convertAutorToAutorws(Autor autor){
        Autorws autorws = new Autorws();
        autorws.setIdautor(autor.getIdautor());
        autorws.setNomautor(autor.getNomautor());
        autorws.setApeautor(autor.getApeautor());

        Date fechaNacimiento = autor.getFechnacautor();
        if (fechaNacimiento != null) {
            GregorianCalendar cal = new GregorianCalendar();
            cal.setTime(fechaNacimiento);
            try {
                XMLGregorianCalendar xmlGregCal = DatatypeFactory.newInstance().newXMLGregorianCalendar(cal);
                autorws.setFechnacautor(xmlGregCal);
            } catch (DatatypeConfigurationException e) {
                e.printStackTrace();
            }
        }

        return autorws;
    }
    public List<Autorws> convertAutorToAutorws(List<Autor> autor){
        List<Autorws> autorList = new ArrayList<>();
        autor.forEach(aut ->{
            autorList.add(convertAutorToAutorws(aut));
        });
        return autorList;
    }

}
