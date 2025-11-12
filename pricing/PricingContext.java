package pricing;

import domain.PaymentMethod;
import domain.Tier;
import java.math.BigDecimal;

public final class PricingContext {
    public final BigDecimal baseAmount;
    public final Tier tier;
    public final PaymentMethod payment;

    public PricingContext(BigDecimal baseAmount, Tier tier, PaymentMethod payment) {
        if (baseAmount == null || baseAmount.signum() < 0)
            throw new IllegalArgumentException("baseAmount must be >= 0");
        this.baseAmount = baseAmount;
        this.tier = tier;
        this.payment = payment;
    }
}
