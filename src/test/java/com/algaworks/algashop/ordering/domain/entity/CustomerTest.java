package com.algaworks.algashop.ordering.domain.entity;


import com.algaworks.algashop.ordering.domain.utility.IdGenerator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.OffsetDateTime;

class CustomerTest {

    @Test
    void given_invalidEMail_whenTryCreateCustomer_shouldGenerateException() {
        Assertions.assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    new Customer(
                IdGenerator.generatedTimeBasedUUID(),
                "Jhon De",
                LocalDate.of(1991, 7, 5),
                "invalid",
                "345234234",
                "5345345",
                OffsetDateTime.now(),
                false
        );
                });
    }

    @Test
    void given_invalidEMail_whenTryUpdatedCustomer_shouldGenerateException() {
        Customer customer = new Customer(
                IdGenerator.generatedTimeBasedUUID(),
                "Jhon De",
                LocalDate.of(1991, 7, 5),
                "juan@gmail.com",
                "345234234",
                "5345345",
                OffsetDateTime.now(),
                false
        );

        Assertions.assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    customer.changeEmail("invalid");
                });
    }
}