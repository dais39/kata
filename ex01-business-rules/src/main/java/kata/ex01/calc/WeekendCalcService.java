package kata.ex01.calc;

import kata.ex01.model.HighwayDrive;

public class WeekendCalcService implements CalcService {

    @Override
    public long calc(HighwayDrive drive) {
        return 30;
    }
}
