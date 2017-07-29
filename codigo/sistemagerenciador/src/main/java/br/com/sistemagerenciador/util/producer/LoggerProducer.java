package br.com.sistemagerenciador.util.producer;


import java.util.logging.Logger;

import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;

public class LoggerProducer {

	@Produces
	public Logger produceLoger(InjectionPoint injectionPoint) {
		return	Logger.getLogger(injectionPoint.getMember().getDeclaringClass().getName());
	}
}