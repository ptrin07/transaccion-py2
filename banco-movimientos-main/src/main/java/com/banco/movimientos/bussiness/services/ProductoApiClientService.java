package com.banco.movimientos.bussiness.services;

import com.banco.movimientos.bussiness.dto.res.ClienteRes;
import com.banco.movimientos.bussiness.dto.res.ProductoRolesRes;
import com.banco.movimientos.domain.model.Producto;

import reactor.core.publisher.Mono;

/**
 * Clase que proporciona servicios para interactuar con el API de clientes de productos.
 * Esta clase se encarga de realizar llamadas HTTP al API de productos y gestionar las respuestas.
 */

public interface ProductoApiClientService {
  
  Mono<Producto> getProducto(String idProducto);
  
  Mono<ClienteRes> getCliente(String idCliente);
  
  Mono<ProductoRolesRes> getProductoRoles(String idProducto);

}
