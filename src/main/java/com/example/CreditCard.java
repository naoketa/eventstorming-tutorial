package com.example;

import java.math.BigDecimal;
import java.util.Objects;

public class CreditCard {
  private BigDecimal limit;

  public void withdraw(int amount) {
    if(limitNotAssigned()){
      throw new IllegalStateException();
    }
  }

  private boolean limitNotAssigned(){
    return Objects.isNull(limit);
  }
}
