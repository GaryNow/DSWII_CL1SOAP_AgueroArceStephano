package pe.edu.cibertec.dswii_cl1soap_agueroarcestephano.configuration;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@EnableWs
@Configuration
public class WebServiceConfig extends WsConfigurerAdapter {

    @Bean
    public ServletRegistrationBean<MessageDispatcherServlet> messageDispatcherServlet
            (ApplicationContext applicationContext){
        MessageDispatcherServlet servlet = new MessageDispatcherServlet();
        servlet.setApplicationContext(applicationContext);
        servlet.setTransformWsdlLocations(true);
        return new ServletRegistrationBean<>(servlet, "/ws/*");
    }

    @Bean(name = "autores")
    public DefaultWsdl11Definition autorWsdl11Definition(@Qualifier("autoresSchema") XsdSchema autorSchema){
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("AutoresPort");
        wsdl11Definition.setLocationUri("/ws/autores");
        wsdl11Definition.setTargetNamespace("http://www.cibertec.edu.pe/ws/objects");
        wsdl11Definition.setSchema(autorSchema);
        return wsdl11Definition;
    }
    @Bean
    public XsdSchema autoresSchema(){
        return new SimpleXsdSchema(new ClassPathResource("xsd/autor.xsd"));
    }

    @Bean(name = "examen")
    public DefaultWsdl11Definition examenWsdl11Definition(XsdSchema examenSchema) {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("ExamenPort");
        wsdl11Definition.setLocationUri("/ws/examen");
        wsdl11Definition.setTargetNamespace("http://www.cibertec.edu.pe/ws/objects");
        wsdl11Definition.setSchema(examenSchema);
        return wsdl11Definition;
    }

    @Bean
    public XsdSchema examenSchema() {
        return new SimpleXsdSchema(new ClassPathResource("xsd/examen.xsd"));
    }


}
