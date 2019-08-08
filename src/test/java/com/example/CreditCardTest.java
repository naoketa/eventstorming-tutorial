package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.math.BigDecimal;
import org.junit.jupiter.api.Test;

public class CreditCardTest {

  @Test
  public void cannot_withdraw_when_limit_not_assigned() {
    CreditCard creditCard = new CreditCard();
    assertThrows(IllegalStateException.class, () -> creditCard.withdraw(1));
  }

  @Test
  public void cannot_withdraw_when_not_enough_money() {
    CreditCard creditCard = new CreditCard();
    creditCard.setLimit(BigDecimal.ONE);
    assertThrows(IllegalStateException.class, () -> creditCard.withdraw(2));
  }

  @Test
  public void can_withdraw1() {
    CreditCard creditCard = new CreditCard();
    creditCard.setLimit(BigDecimal.ONE);
    creditCard.withdraw(1);
    assertEquals(0, creditCard.available());
  }

  @Test
  public void can_withdraw2() {
    CreditCard creditCard = new CreditCard();
    creditCard.setLimit(BigDecimal.TEN);
    creditCard.withdraw(1);
    assertEquals(BigDecimal.valueOf(9), creditCard.available());
  }

  @Test
  public void cannot_assign_limit_when_it_was_already_assigned() {
    CreditCard creditCard = new CreditCard();
    creditCard.setLimit(BigDecimal.TEN);
    assertThrows(IllegalStateException.class, () -> creditCard.setLimit(BigDecimal.ONE));
  }

}
