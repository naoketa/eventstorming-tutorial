package com.example;

import java.math.BigDecimal;
import java.util.Objects;

public class CreditCard {
  private BigDecimal limit;
  private BigDecimal used = BigDecimal.ZERO;

  public void withdraw(int amount) {
    if(limitNotAssigned()){
      throw new IllegalStateException();
    }
    if(notEnoughMoney(amount)){
      throw new IllegalStateException();
    }
    this.used = this.used.add(BigDecimal.valueOf(amount));
  }

  public void setLimit(BigDecimal limit){
    if(limitAlreadyAssigned()) {
      throw new IllegalStateException();
    }
    this.limit = limit;
  }

  public BigDecimal available(){
    return limit.subtract(used);
  }

  private boolean notEnoughMoney(int amount) {
    BigDecimal available = limit.subtract(used);
    return available.compareTo(BigDecimal.valueOf(amount)) < 0;
  }

  private boolean limitNotAssigned(){
    return Objects.isNull(limit);
  }

  private boolean limitAlreadyAssigned() {
    return Objects.nonNull(limit);
  }
}
