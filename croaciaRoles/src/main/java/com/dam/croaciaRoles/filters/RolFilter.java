package com.dam.croaciaRoles.filters;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class RolFilter {

    private static final Logger LOG = LoggerFactory.getLogger(RolFilter.class);

    //redireccion en funcion del rol

    public void redirectByRol(String rol, HttpServletRequest request,
                              HttpServletResponse response) throws IOException{

        String uri = request.getRequestURI();

        LOG.info("uri: "+uri);

        switch(rol){

            case "USER":
                if(!uri.startsWith("/usuario")){

                    response.sendRedirect("/usuario");

                }
                break;
            case "ADMIN":
                if(!uri.startsWith("/admin")){

                    response.sendRedirect("/admin");

                }
                break;

        }
    }
}
