//package com.FrontEnd.Web_InterFace.Controllers;
//import org.springframework.http.HttpStatus;
//import org.springframework.security.access.AccessDeniedException;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.ResponseStatus;
//import jakarta.servlet.http.HttpServletRequest;
//import org.springframework.web.servlet.NoHandlerFoundException;
//
//@ControllerAdvice
//public class GlobalExceptionHandler {
//
//    // Handle 403 Forbidden error
//    @ExceptionHandler(AccessDeniedException.class)
//    @ResponseStatus(HttpStatus.FORBIDDEN)
//    public String handleAccessDenied(HttpServletRequest request, Model model) {
//        model.addAttribute("errorCode", "403");
//        model.addAttribute("errorMessage", "You do not have permission to access this resource.");
//        return "error";  // Name of the JSP page (e.g., error.jsp)
//    }
//
//    // Handle generic 404 Not Found error
//    @ExceptionHandler(NoHandlerFoundException.class)
//    @ResponseStatus(HttpStatus.NOT_FOUND)
//    public String handleNotFound(HttpServletRequest request, Model model) {
//        model.addAttribute("errorCode", "404");
//        model.addAttribute("errorMessage", "Page not found.");
//        return "error";
//    }
//
//    // Handle other exceptions
//    @ExceptionHandler(Exception.class)
//    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
//    public String handleGeneralException(HttpServletRequest request, Model model, Exception ex) {
//        model.addAttribute("errorCode", "500");
//        model.addAttribute("errorMessage", "An internal error occurred.");
//        return "error";
//    }
//}
//
