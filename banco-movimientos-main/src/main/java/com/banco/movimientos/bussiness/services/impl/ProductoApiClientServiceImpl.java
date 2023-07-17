package com.banco.movimientos.bussiness.services.impl;

import com.banco.movimientos.bussiness.client.WebClientApi;
import com.banco.movimientos.bussiness.dto.res.ClienteRes;
import com.banco.movimientos.bussiness.services.ProductoApiClientService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.banco.movimientos.bussiness.dto.res.ProductoRolesRes;
import com.banco.movimientos.domain.model.Producto;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

/**
 * Implementación de la interfaz ProductoApiClientService que proporciona 
 * servicios para interactuar con el API de clientes de productos.
 * Esta clase se encarga de realizar llamadas HTTP al API de productos 
 * y gestionar las respuestas.
 */

@Slf4j
@Service
public class ProductoApiClientServiceImpl implements ProductoApiClientService {

  @Value("${app.productosUrl}")
  private String productoUrl;
  
  @Value("${app.clientesUrl}")
  private String clientesUrl;
  
  @Value("${app.productoRolUrl}")
  private String productoRolUrl;
  
  @Override
  public Mono<Producto> getProducto(String idProducto) {
    log.info(String.format("Consultando Api Producto : %s", idProducto));
    return WebClientApi.getMono(String.format(this.productoUrl, idProducto),
        Producto.class, String.format("Error al Buscar Producto: %s", idProducto));
  }

  @Override
  public Mono<ClienteRes> getCliente(String idCliente) {
    log.info(String.format("Consultando Api Cliente : %s", idCliente));
    return WebClientApi.getMono(String.format(this.clientesUrl, idCliente), 
        ClienteRes.class, String.format("Error al Buscar Cliente : %s", idCliente));
  }

  @Override
  public Mono<ProductoRolesRes> getProductoRoles(String idProducto) {
    log.info(String.format("Consultando Api Prodcuto - Roles : %s", idProducto));
    return WebClientApi.getMono(String.format(this.productoRolUrl, idProducto), 
        ProductoRolesRes.class, String.format("Error al Buscar Producto Rol : %s", productoRolUrl));
  }
  
  

}
