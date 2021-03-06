package br.com.stackx.projetoweb.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class StackXExceptionController {

	@ExceptionHandler
	public ModelAndView trataException(HttpServletRequest request, Exception exception) throws Exception {

		System.out.println("###  Entrou no StackXExceptionController ###");
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("exception", exception);
		modelAndView.setViewName("error/500");

		return modelAndView;
	}
}
