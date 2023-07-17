package com.banco.movimientos.bussiness.dto.res;

import com.banco.movimientos.domain.utils.TipoCliente;

import lombok.Data;

/**
 * Clase que representa la respuesta de un cliente.
 */
@Data
public class ClienteRes {
  
  private String id;
  
  private String nombres;
  
  private String apellidos;
  
  private String estado;
  
  private TipoCliente tipoCliente;
}
