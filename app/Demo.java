package app;

import common.Money;
import pricing.Region;
import pricing.PricePolicy;
import pricing.factory.RegionPricePolicyFactory;
import pricing.factory.PricePolicyFactory;

public class Demo {
    public static void main(String[] args) {
        // 데모 입력(나중에 Scanner/인자 처리로 바꿔도 됨)
        Money base = Money.of(100_000); // 기본요금 10만원
        Region[] testRegions = { Region.SEOUL, Region.BUSAN, Region.JEJU };

        PricePolicyFactory factory = new RegionPricePolicyFactory();

        for (Region region : testRegions) {
            PricePolicy policy = factory.create(region);
            Money regionalPrice = policy.applyRegionPolicy(base);

            System.out.println("== " + region + " ==");
            System.out.println("Base: " + base);
            System.out.println("Policy: " + policy.name());
            System.out.println("After Region Policy: " + regionalPrice);

            // ---------------------------
            // (미래 확장) 아래 단계에 다른 팀 모듈을 순차 적용
            // 1) 등급 전략(전략 패턴): TierPricingStrategy 적용
            //    regionalPrice = new GoldTier().apply(regionalPrice);
            // 2) 옵션(데코레이터): Coffee/Locker/Printer 데코레이터로 누적
            //    Billable b = new CoffeeOption(new LockerOption(new BaseBillable(regionalPrice)));
            //    Money withOptions = b.total();
            // 3) 예약 완료 옵저버: ReservationSubject.notifyAll();
            // 4) 결제 출력 형식(전략): 카드/간편결제 출력 포맷 처리
            // ---------------------------

            System.out.println();
        }
    }
}
