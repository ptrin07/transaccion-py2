package com.banco.movimientos.domain.model;


import java.beans.Transient;
import java.util.Calendar;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.banco.movimientos.domain.utils.GrupoProducto;
import com.banco.movimientos.domain.utils.ResultadoTransaccion;
import com.banco.movimientos.domain.utils.TipoOperacion;
import com.banco.movimientos.domain.utils.TipoProducto;

import lombok.Data;

/**
 * Representa una transacción.
 * La clase Transaccion es una entidad que se mapea a la
 *  colección "movimientos" en la base de datos.
 */
@Document(collection = "movimientos")
@Data
public class Transaccion {
  
  @Id
  private String id;
  
  private String codControl;
  
  private GrupoProducto grupoProducto;
  
  private TipoProducto tipoProducto;
  
  private String codPersona;
  
  private String codigoProducto;
  
  private TipoOperacion codigoOperacion;
  
  private Double montoTransaccion;
  
  private Date fechaTransaccion;
  
  private ResultadoTransaccion resultadoTransaccion;
  
  private String observacionTransaccion;
  
  private Double saldoInicial;
  
  private Double saldoFinal;
  
  @Transient
  public int getDiaTransaccion() {
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(this.getFechaTransaccion());
    return calendar.get(Calendar.DAY_OF_MONTH);
  }
  

}
