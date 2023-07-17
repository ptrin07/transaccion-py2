package com.banco.movimientos.bussiness.client;

import org.springframework.http.HttpStatus;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Clase que encapsula las llamadas a una API utilizando WebClient.
 * Proporciona métodos para realizar solicitudes HTTP a un servicio web externo.
 */
@Slf4j
public class WebClientApi {
  
  private static final WebClient webClient  = WebClient.builder().build();

  
  /**
   * Realiza una solicitud GET a la URL especificada y devuelve un Mono que emite la respuesta 
   * esperada.
   *
   * @param url          La URL a la cual realizar la solicitud GET.
   * @param responseType El tipo de respuesta esperada.
   * @param errorId      Identificador de error personalizado para la gestión de excepciones.
   * @return Un Mono que emite la respuesta esperada.
   */  
  public static <T> Mono<T> getMono(String url, Class<T> responseType, String errorId) {
    log.info(url);
    return webClient.get()
      .uri(url)
      .retrieve()
      .bodyToMono(responseType)
      .doOnError(WebClientResponseException.class, e -> {
        HttpStatus statusCode = (HttpStatus) e.getStatusCode();
        log.error(String.format(
            "Error Api = URL: %s ,CODIGO: %s ,CONTRLID: %s", url, statusCode, errorId));
      });
  }

  
  /**
   * Realiza una solicitud GET a la URL especificada y devuelve un Flux que emite la 
   * respuesta esperada.
   *
   * @param url          La URL a la cual realizar la solicitud GET.
   * @param responseType El tipo de respuesta esperada.
   * @param errorId      Identificador de error personalizado para la gestión de excepciones.
   * @return Un Flux que emite la respuesta esperada.
   */
  public static <T> Flux<T> getFlux(String url, Class<T> responseType, String errorId) {
    log.info(url);
    return webClient.get()
      .uri(url)
      .retrieve()
      .bodyToFlux(responseType)
      .doOnError(WebClientResponseException.class, e -> {
        HttpStatus statusCode = (HttpStatus) e.getStatusCode();
        log.error(
            String.format("Error Api = URL: %s ,CODIGO: %s ,CONTRLID: %s",
                url, statusCode, errorId));
      });
  }
  

}
