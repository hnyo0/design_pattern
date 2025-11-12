package pricing.factory;

import pricing.PricePolicy;
import pricing.Region;
import pricing.policies.BusanPricePolicy;
import pricing.policies.JejuPricePolicy;
import pricing.policies.SeoulPricePolicy;

public class RegionPricePolicyFactory extends PricePolicyFactory {
    @Override
    public PricePolicy create(Region region) {
        validate(region);
        switch (region) {
            case SEOUL: return new SeoulPricePolicy();
            case BUSAN: return new BusanPricePolicy();
            case JEJU:  return new JejuPricePolicy();
            default: throw new UnsupportedOperationException("Unsupported region: " + region);
        }
    }
}
