package com.example;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class CreditCardTest {

  @Test
  public void cannot_withdraw_when_limit_not_assigned() {
    CreditCard creditCard = new CreditCard();
    assertThrows(IllegalStateException.class, () -> creditCard.withdraw(1));
  }

}
