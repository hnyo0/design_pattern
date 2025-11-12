package pricing.policies;

import common.Money;
import pricing.PricePolicy;

public class BusanPricePolicy implements PricePolicy {
    @Override
    public Money applyRegionPolicy(Money base) {
        // 예: 기본 5% 할인 + 프로모션 8% 추가
        return base.multiply(1 - 0.05 - 0.08); // 87%
    }
    @Override public String name() { return "Busan Policy (5% discount + 8% promo)"; }
}
