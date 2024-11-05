package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {
    /**
     * API -> Application programming interface
     *  metoda  -> ex: POST
     *  body -> (modalitati de trimitere a "body")
     *  ruta -> "/v1/api/..."
     *  http code response (
     *          ex: 200, 400, 500 ....
     *  )
     * daca sunt decuplate trb sa stie sa comunice in retea
     * api trb sa fie de regula stateless
     *
     *
     * @param args
     */

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}
