package pricing;

import java.math.BigDecimal;

public interface PricingStrategy {
    BigDecimal apply(BigDecimal current, PricingContext ctx);
}
