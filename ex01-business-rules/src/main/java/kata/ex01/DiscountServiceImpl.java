package kata.ex01;

import kata.ex01.calc.CalcService;
import kata.ex01.calc.MidnightCalcService;
import kata.ex01.calc.WeekdayCalcService;
import kata.ex01.calc.WeekendCalcService;
import kata.ex01.model.HighwayDrive;

import java.util.Arrays;
import java.util.List;

/**
 * @author kawasima
 */
public class DiscountServiceImpl implements DiscountService {
    @Override
    public Long calc(HighwayDrive drive) {

        List<CalcService> calcServiceList = Arrays.asList(
                new WeekdayCalcService(),
                new WeekendCalcService(),
                new MidnightCalcService()
        );

        return calcServiceList.stream()
                .map(calcService -> calcService.calc(drive))
                .max(Long::compare).get();
    }
}
