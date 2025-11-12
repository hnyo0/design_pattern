package pricing.tier;

import java.math.BigDecimal;

import pricing.PricingContext;
import pricing.PricingStrategy;

public interface TierPricingStrategy extends PricingStrategy {
    @Override
    BigDecimal apply(BigDecimal current, PricingContext ctx);
}
