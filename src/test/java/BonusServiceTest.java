import br.com.alura.tdd.modelo.Funcionario;
import br.com.alura.tdd.service.BonusService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BonusServiceTest {

    @Test
    public void calcularBonusMaiorQueMil() {
        Funcionario funcionario = new Funcionario("jose", LocalDate.now(), new BigDecimal(10001));
        BonusService bonusService = new BonusService();
        assertThrows(IllegalArgumentException.class, () -> bonusService.calcularBonus(funcionario));
    }

    @Test
    public void calcularBonusMenorQueMil(){
        Funcionario funcionario = new Funcionario("jose", LocalDate.now(), new BigDecimal(1000));
        BonusService bonusService = new BonusService();
        BigDecimal valor = bonusService.calcularBonus(funcionario);

        assertEquals(new BigDecimal("100.0"),valor);
    }

    @Test
    public void calcularBonusIgualMil(){
        Funcionario funcionario = new Funcionario("jose", LocalDate.now(), new BigDecimal(10000));
        BonusService bonusService = new BonusService();
        BigDecimal valor = bonusService.calcularBonus(funcionario);

        assertEquals(new BigDecimal("1000.0"),valor);
    }
}
