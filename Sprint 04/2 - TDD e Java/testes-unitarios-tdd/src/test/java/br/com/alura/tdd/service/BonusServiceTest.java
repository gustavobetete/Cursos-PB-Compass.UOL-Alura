package br.com.alura.tdd.service;

import br.com.alura.tdd.modelo.Funcionario;
import br.com.alura.tdd.service.BonusService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class BonusServiceTest {
    @Test
    void bonusDeveriaSerZeroParaFuncionarComSalarioMuitoAlto(){
        BonusService bonusService = new BonusService();

// primeira opção para tratar uma exception no test

//        assertThrows(IllegalArgumentException.class,
//                () -> bonusService.calcularBonus(new Funcionario("Gustavo", LocalDate.now(), new BigDecimal("25000"))));

// Segunda opção para tratar uma exception no test

        try {
            bonusService.calcularBonus(new Funcionario("Gustavo", LocalDate.now(), new BigDecimal("25000")));
            fail("Não deu a exception");
        }catch (Exception e) {
            assertEquals("Funcionario com salario maior do que R$10.000 não pode receber bonus", e.getMessage());
        }
    }

    @Test
    void bonusDeveriaSer10PorcentoDoSalario(){
        BonusService bonusService = new BonusService();
        BigDecimal bonus = bonusService.calcularBonus(new Funcionario("Gustavo", LocalDate.now(), new BigDecimal("2500")));

        Assertions.assertEquals(new BigDecimal("250.00"), bonus);
    }

    @Test
    void bonusDeveriaSerDezPorcentroParaSalarioDeExatamento10000(){
        BonusService bonusService = new BonusService();
        BigDecimal bonus = bonusService.calcularBonus(new Funcionario("Gustavo", LocalDate.now(), new BigDecimal("10000")));

        Assertions.assertEquals(new BigDecimal("1000.00"), bonus);
    }

}
