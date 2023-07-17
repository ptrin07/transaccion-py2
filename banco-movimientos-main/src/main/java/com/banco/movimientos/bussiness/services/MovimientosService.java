package com.banco.movimientos.bussiness.services;

import com.banco.movimientos.bussiness.dto.res.SaldoDiarioInfoRes;
import com.banco.movimientos.bussiness.dto.res.SaldoRes;
import com.banco.movimientos.bussiness.dto.req.InfoTransaccionInternaReq;
import com.banco.movimientos.bussiness.dto.req.InfoTransacionReq;
import com.banco.movimientos.bussiness.dto.res.TransaccionRes;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Interfaz que define los servicios relacionados con los movimientos.
 * Proporciona métodos para realizar operaciones y consultas relacionadas con los 
 * movimientos en el sistema.
 */
public interface MovimientosService {
  
  public Mono<SaldoRes> getProductBalance(String idProdcuto);
  
  public Flux<SaldoRes> getAllBalanceByClientId(String idCliente);
  
  public Flux<TransaccionRes> getAllTransaccionByProductId(String idProducto);  
  
  public Mono<TransaccionRes> postTransaccion(InfoTransacionReq transaccion);
  
  public Mono<TransaccionRes> postTransaccionIntoBanck(InfoTransaccionInternaReq operacionInterna);
  
  public Mono<SaldoDiarioInfoRes> getInformSaldosByIdProducto(String idProducto);
  
  
}
