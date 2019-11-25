package kata.ex01.calc;

import kata.ex01.model.HighwayDrive;

import java.util.ArrayList;
import java.util.List;

public class CalcServiceFactory {

    public List<CalcService> generateCalcList(HighwayDrive drive){
        ArrayList<CalcService> list = new ArrayList<CalcService>();
        if(drive.canApplyWeekdayDiscount()) list.add(new WeekdayCalcService());
        if(drive.canApplyWeekendDiscount()) list.add(new WeekendCalcService());
        if(drive.canApplyMidnightDiscount()) list.add(new MidnightCalcService());

        return list;
    }
}
