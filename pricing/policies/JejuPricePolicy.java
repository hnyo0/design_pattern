package pricing.policies;

import common.Money;
import pricing.PricePolicy;

public class JejuPricePolicy implements PricePolicy {
    @Override
    public Money applyRegionPolicy(Money base) {
        // 예: 관광지 추가요금 10%
        return base.multiply(1.10);
    }
    @Override public String name() { return "Jeju Policy (+10% surcharge)"; }
}
