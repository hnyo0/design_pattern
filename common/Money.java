package common;

import java.math.BigDecimal;
import java.math.RoundingMode;

public final class Money {
    private final BigDecimal amount;

    public static Money of(long won) { return new Money(BigDecimal.valueOf(won)); }
    public static Money of(double won) { return new Money(BigDecimal.valueOf(won)); }

    public Money(BigDecimal amount) {
        this.amount = amount.setScale(2, RoundingMode.HALF_UP);
    }
    public Money multiply(double factor) {
        return new Money(amount.multiply(BigDecimal.valueOf(factor)));
    }
    public Money add(Money other) { return new Money(this.amount.add(other.amount)); }
    public BigDecimal asBigDecimal() { return amount; }

    @Override public String toString() { return amount.toPlainString(); }
}
