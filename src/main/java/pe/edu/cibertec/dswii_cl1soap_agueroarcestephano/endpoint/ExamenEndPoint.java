package pe.edu.cibertec.dswii_cl1soap_agueroarcestephano.endpoint;

import lombok.AllArgsConstructor;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import pe.edu.cibertec.dswii_cl1soap_agueroarcestephano.repository.ExamenRepository;
import pe.edu.cibertec.ws.objects.*;

@Endpoint
@AllArgsConstructor
public class ExamenEndPoint {

    private static final String NAMESPACE_URL = "http://www.cibertec.edu.pe/ws/objects";
    private final ExamenRepository examenRepository;

    @PayloadRoot(namespace = NAMESPACE_URL, localPart = "CalcularEstacionamientoRequest")
    @ResponsePayload
    public CalcularEstacionamientoResponse calcularEstacionamiento(@RequestPayload CalcularEstacionamientoRequest request) {
        double monto = examenRepository.calcularEstacionamiento(request.getHoras(), request.getMinutos());
        CalcularEstacionamientoResponse response = new CalcularEstacionamientoResponse();
        response.setMonto(monto);
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URL, localPart = "CalcularPromedioRequest")
    @ResponsePayload
    public CalcularPromedioResponse calcularPromedio(@RequestPayload CalcularPromedioRequest request) {
        double promedio = examenRepository.calcularPromedio(request.getNota1(), request.getNota2(), request.getNota3(), request.getNota4());
        CalcularPromedioResponse response = new CalcularPromedioResponse();
        response.setPromedio(promedio);
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URL, localPart = "VerificarDNIRequest")
    @ResponsePayload
    public VerificarDNIResponse verificarDNI(@RequestPayload VerificarDNIRequest request) {
        boolean debeSacarDNI = examenRepository.verificarDNI(request.getAnioNacimiento());
        VerificarDNIResponse response = new VerificarDNIResponse();
        response.setDebeSacarDNI(debeSacarDNI);
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URL, localPart = "NumerosParesRequest")
    @ResponsePayload
    public NumerosParesResponse obtenerNumerosPares(@RequestPayload NumerosParesRequest request) {
        int[] numeros = examenRepository.obtenerNumerosPares();
        NumerosParesResponse response = new NumerosParesResponse();
        for (int numero : numeros) {
            response.getNumeros().add(numero);
        }
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URL, localPart = "CalcularDescuentoRequest")
    @ResponsePayload
    public CalcularDescuentoResponse calcularDescuento(@RequestPayload CalcularDescuentoRequest request) {
        double montoTotal = examenRepository.calcularDescuento(request.getCantidad(), request.getPrecio());
        CalcularDescuentoResponse response = new CalcularDescuentoResponse();
        response.setMontoTotal(montoTotal);
        return response;
    }

}
