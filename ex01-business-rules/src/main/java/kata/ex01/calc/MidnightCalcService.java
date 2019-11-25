package kata.ex01.calc;

import kata.ex01.model.HighwayDrive;

public class MidnightCalcService implements CalcService {

    @Override
    public long calc(HighwayDrive drive) {
        if(drive.canApplyMidnightDiscount()) {
            return 30;
        }
        return 0;
    }
}
