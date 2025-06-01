//package com.FrontEnd.CustomerService.ControllerTests;
//
//import com.FrontEnd.CustomerService.Controllers.HomeController;
//import org.junit.jupiter.api.Test;
//import org.springframework.web.servlet.ModelAndView;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertNotNull;
//
//public class HomeControllerTest {
//    @Test
//    void testWelcome(){
//        //Arrange
//        HomeController controller=new HomeController();
//        ModelAndView mv=new ModelAndView();
//
//        //Act
//        controller.home(mv);
//
//        //Assert
//        assertNotNull(mv , "ModelAndView should not be null");
//        assertEquals("Welcome",mv.getViewName(),"View Name should be Welcome");
//        assertEquals("Welcome to Home Page!" , mv.getModel().get("message"),"Message Attribute should Match");
//
//    }
//}
