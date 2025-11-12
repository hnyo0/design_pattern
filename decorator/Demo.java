package decorator;

// 수정 예정(객체 생성)
public class Demo {
    public static void main(String[] args) {
        int slotDuration = 5; // 예약 기간 (5시간 가정)
        double baseRate = 20000.0; // 기본 요금 시간당 20,000원
        
        System.out.println("==================================================");
        System.out.println("기본 공간: 회의실 No.305 (5시간, " + (baseRate * slotDuration) + ")");
        System.out.println("==================================================");
        
        // ---------------------------------------------------------------------
        // 1. 모니터 사용 + 사물함 사용 조합
        // ---------------------------------------------------------------------
        
        // 기본 공간 생성
        Bookable combo1 = new Room("305", 6, baseRate);
        
        // 1-1. 모니터 추가 (MonitorAddon: 5,000원)
        combo1 = new MonitorAddon(combo1);
        
        // 1-2. 사물함 추가 (LockerAddon: 대형 1개)
        // LockerAddon (대형 4000원/시간 * 1개 * 5시간 = 20,000원)
        combo1 = new LockerAddon(combo1, "LARGE", 1); 
        
        System.out.println("조합 1: 모니터 사용 + 사물함 사용");
        System.out.println("서비스 구성: " + combo1.getDescription());
        System.out.println("최종 요금: " + combo1.cost(slotDuration));
        System.out.println("--------------------------------------------------");


        
        // 2. 음료 패키지 + 프린트기 사용 조합
        
        // 기본 공간 재설정
        Bookable combo2 = new Room("305", 6, baseRate);
        
        // 음료 패키지 추가 (BeveragePackageAddon: 15,000원)
        combo2 = new CaffeAddon(combo2);
        
        // 프린트기 사용 추가 (PrinterAddon: 흑백 50장)
        // PrinterAddon (흑백 50원/장 * 50장 = 2,500원)
        combo2 = new PrinterAddon(combo2, "MONOCHROME", 50); 
        
        System.out.println("조합 2: 음료 패키지 + 프린트기 사용");
        System.out.println("서비스 구성: " + combo2.getDescription());
        System.out.println("최종 요금: " + combo2.cost(slotDuration));
    }
}