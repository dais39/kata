package kata.ex01.calc;

import kata.ex01.model.HighwayDrive;

public class WeekdayCalcService implements CalcService{

    @Override
    public long calc(HighwayDrive drive) {
        if (drive.isOverTenTimesDrive()) {
            return 50;
        }
        return 30;
    }
}
