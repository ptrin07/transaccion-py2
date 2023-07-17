package com.banco.movimientos.bussiness.dto.res;

import com.banco.movimientos.domain.utils.GrupoProducto;
import com.banco.movimientos.domain.utils.TipoCliente;
import com.banco.movimientos.domain.utils.TipoProducto;

import lombok.Data;

/**
 * Clase que representa la respuesta de un producto.
 */
@Data
public class ProductoRes {
  
  private String id;
  
  private GrupoProducto grupoProducto;
  
  private TipoProducto tipoProducto;
  
  private String codigoProducto;
  
  private String estado;
  
  private TipoCliente tipoCliente;
  
  private Integer maxOperacionesMes;
  
  private Integer minDiaMesOperacion;  
  

}
