package com.chakray.ejemplos.jaxws.metro;


import org.blogs.ejemplos.serviciosaxis2.*;

import javax.xml.ws.BindingProvider;

public class ClienteJAXWSMetroUT {
    public static void main (String[] args) {

        String trustStore = null;
        trustStore = "wso2carbon.jks";
        System.setProperty("javax.net.ssl.trustStore", trustStore);
        System.setProperty("javax.net.ssl.trustStorePassword", "wso2carbon");

        HolamundoWSDL clientService = new HolamundoWSDL();
        HolamundoPortType port = clientService.getHolamundoHttpsSoap12Endpoint();

        BindingProvider bp = (BindingProvider) port;
        bp.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY,
                "https://localhost:9445/services/HolamundoWSDL");

        Persona persona = new Persona();
        persona.setNombre("Jorge");
        persona.setApellidos("Infante Osorio");
        try {
            PersonaRespuesta respuesta = port.holaati(persona);
            System.out.println(respuesta.getSaludo());
        } catch (HolaatiFault_Exception e) {
            e.printStackTrace();
        } catch (Exception e){
            e.printStackTrace();
        }


    }
}
