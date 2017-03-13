/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aerolinea.control;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ControlIndex {
    
//    @RequestMapping("/")
//    public String mostrarIndex(){
//        return "index";
//    }
//    public ModelAndView mostrarIndex(){
//        ModelAndView mv = new ModelAndView("index");
//        mv.addObject("mensaje","Hola mundo");
//        return mv;
//    }
    
    //pasamos datos por url
    @RequestMapping(value="/",method=GET)
    public ModelAndView mostrarIndex(@RequestParam("texto")String texto){
        ModelAndView mv = new ModelAndView("index");
        mv.addObject("mensaje","Hola 1 "+texto);
        return mv;
    }
    //pasamos datos por path
    @RequestMapping("/home/{texto}")
    public ModelAndView mostrarIndex2(@PathVariable("texto")String texto){
        ModelAndView mv = new ModelAndView("index");
        mv.addObject("mensaje","Hola 2 "+texto);
        return mv;
    }
    
    @RequestMapping("/home")
    public String mostrarHome(){
        return "index";
    }
    
    @RequestMapping("/")
    public String mostrarIndex2(){
        return "index";
    }
}
