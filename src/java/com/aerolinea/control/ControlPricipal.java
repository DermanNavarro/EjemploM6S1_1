package com.aerolinea.control;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ControlPricipal {
    
    @RequestMapping("/principal")
    public String mostrarHome(HttpServletRequest req){
       try{ 
       String usuario =  (String) req.getSession().getAttribute("usuario");
        
        if (!usuario.equals("")){
            return "principal";
        }else{
            return "index";
        }
       }catch (Exception ex){
           return "index";
       }
    }
    
    @RequestMapping("/cerrarsesion")
    public String cerrarSesion(HttpServletRequest req){
        req.removeAttribute("usuario");
        req.removeAttribute("nombre");
        req.removeAttribute("correo");
        req.removeAttribute("idrol");
        req.getSession().invalidate();//Cierra todo
        
        return "redirect:/home";
    }
}
