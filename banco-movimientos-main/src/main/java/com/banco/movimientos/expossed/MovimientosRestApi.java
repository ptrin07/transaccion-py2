package com.banco.movimientos.expossed;

import com.banco.movimientos.bussiness.dto.res.SaldoDiarioInfoRes;
import com.banco.movimientos.bussiness.dto.res.SaldoRes;
import com.banco.movimientos.bussiness.services.MovimientosService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.banco.movimientos.bussiness.dto.req.InfoTransaccionInternaReq;
import com.banco.movimientos.bussiness.dto.req.InfoTransacionReq;
import com.banco.movimientos.bussiness.dto.res.TransaccionRes;

import jakarta.validation.Valid;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@Validated
@RequestMapping("/v1/transacciones")
public class MovimientosRestApi {
  
  public MovimientosRestApi(MovimientosService servMovimientos) {
    super();
    this.servMovimientos = servMovimientos;
  }

  private final MovimientosService servMovimientos;
  
  
  
  /**
   * Obtiene el saldo de un producto específico.
   *
   * @param idProducto el identificador del producto
   * @return un Mono que emite el objeto SaldoRes del producto
   */
  
  @GetMapping("/{idProducto}/saldo")
  public Mono<SaldoRes> getProductBalance(
      @PathVariable(name = "idProducto") String idProducto) {
    return null;
  }
  
  /**
   * Obtiene todos los saldos relacionados a un cliente dado.
   *
   * @param idCliente el identificador del cliente
   * @return un Flux que emite objetos SaldoRes
   */
  @GetMapping("/clientes/{idCliente}/resumenes")
  public Flux<SaldoRes> getAllBalanceByClientId(
      @PathVariable(name = "idCliente") String idCliente) {
    return servMovimientos.getAllBalanceByClientId(idCliente);
  }
  
  /**
   * Crea una nueva transacción con la información proporcionada.
   *
   * @param transaccion la información de la transacción a crear
   * @return un Mono que emite el objeto TransaccionRes resultante
   */
  @PostMapping("")
  public Mono<TransaccionRes> postTransaccion(@Valid @RequestBody InfoTransacionReq transaccion) {
    return servMovimientos.postTransaccion(transaccion);
  }
  
  /**
   * Crea una nueva transacción con la información proporcionada.
   *
   * @param transaccion la información de la transacción a crear
   * @return un Mono que emite el objeto TransaccionRes resultante
   */
  @PostMapping("/internas")
  public Mono<TransaccionRes> postTransaccionInterna(
      @Valid @RequestBody InfoTransaccionInternaReq transaccion) {
    return servMovimientos.postTransaccionIntoBanck(transaccion);
  }
  
  /**
   * Obtiene todas las transacciones relacionadas a un producto dado.
   *
   * @param idProducto el identificador del producto
   * @return un Flux que emite objetos TransaccionRes
   */ 
  @GetMapping("/{idProducto}")
  public Flux<TransaccionRes> getAllTransaccionByProductId(
      @PathVariable(name = "idProducto") String idProducto) {
    return servMovimientos.getAllTransaccionByProductId(idProducto); 
  }
  
  @GetMapping("/{idProducto}/saldosdiarios")
  public Mono<SaldoDiarioInfoRes> getInformSaldosByIdProducto(
      @PathVariable(name = "idProducto") String idProducto){
    return servMovimientos.getInformSaldosByIdProducto(idProducto);    
  }

}
