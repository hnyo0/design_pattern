package pricing;

import domain.PaymentMethod;
import domain.Tier;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

public final class BookingService {
    private List<PricingStrategy> pipeline;

    public BookingService(List<PricingStrategy> pipeline) {
        setPipeline(pipeline);
    }

    public void setPipeline(List<PricingStrategy> pipeline) {
        if (pipeline == null || pipeline.isEmpty())
            throw new IllegalArgumentException("pipeline must not be empty");
        this.pipeline = List.copyOf(pipeline);
    }

    /** 현재 전략 조합 이름(간단 표기) */
    public String currentPlanName() {
        return pipeline.stream()
                .map(s -> s.getClass().getSimpleName())
                .reduce((a, b) -> a + " + " + b)
                .orElse("NoStrategy");
    }

    /** Booking 정보를 기반으로 최종 견적 계산 */
    public BigDecimal quote(Booking b) {
        Objects.requireNonNull(b, "booking");
        BigDecimal base = b.baseAmount();                 // 시간당요금 × 시간
        Tier tier = b.tier();
        PaymentMethod method = b.payment();

        PricingEngine engine = new PricingEngine(pipeline);
        PricingContext ctx = new PricingContext(base, tier, method);
        return engine.quote(ctx);
    }
}
