package pricing.policies;

import common.Money;
import pricing.PricePolicy;

public class SeoulPricePolicy implements PricePolicy {
    @Override
    public Money applyRegionPolicy(Money base) {
        // 예: 프로모션 10% 할인
        return base.multiply(0.90);
    }
    @Override public String name() { return "Seoul Policy (10% promotion)"; }
}
