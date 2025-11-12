package pricing;

import common.Money;

public interface PricePolicy {
    // 지역별 정책을 적용한 최종 요금 계산 (옵션/등급 이전의 지역 요금 단계)
    Money applyRegionPolicy(Money base);
    String name(); // 정책 설명(로그용)
}
