package pricing;

import domain.PaymentMethod;
import domain.Tier;
import pricing.payment.CardPaymentStrategy;
import pricing.payment.CashPaymentStrategy;
import pricing.payment.TransferPaymentStrategy;
import pricing.tier.BasicTierStrategy;
import pricing.tier.ProTierStrategy;
import pricing.tier.PremiumTierStrategy;

import java.math.BigDecimal;

public final class DemoStrategy {
    public static void main(String[] args) {
        // 객체 생성
        Booking a1 = new Booking(new BigDecimal("12000"), 2, Tier.BASIC,   PaymentMethod.CARD);
        Booking a2 = new Booking(new BigDecimal("12000"), 3, Tier.PRO,     PaymentMethod.CASH);
        Booking a3 = new Booking(new BigDecimal("12000"), 5, Tier.PREMIUM, PaymentMethod.TRANSFER);

        // 각 객체가 자기 전략을 '직접' 가진다 (setBehavior와 동일한 느낌)
        a1.setTierStrategy(new BasicTierStrategy());
        a1.setPaymentStrategy(new CardPaymentStrategy());

        a2.setTierStrategy(new ProTierStrategy());
        a2.setPaymentStrategy(new CashPaymentStrategy());

        a3.setTierStrategy(new PremiumTierStrategy());
        a3.setPaymentStrategy(new TransferPaymentStrategy());

        // 객체를 통해 바로 메서드 호출
        run(a1);
        run(a2);
        run(a3);

        // 런타임 전략 교체 예시 (오리 예제의 setFlyBehavior와 동일)
        a1.setTierStrategy(new PremiumTierStrategy());
        a1.setPaymentStrategy(new TransferPaymentStrategy());
        run(a1);
    }

    private static void run(Booking b) {
        BigDecimal total = b.quote(); // 등급별 전략 적용
        // BASIC/CARD (2h) → 24,000원
        System.out.printf("%s/%s (%dh) → %,8.0f원%n",
                b.tier(), b.payment(), b.hours(), total);
        b.pay(total); // 결제 전략 실행
        System.out.println();
    }

}
