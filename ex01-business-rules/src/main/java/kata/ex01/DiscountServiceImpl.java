package kata.ex01;

import kata.ex01.calc.CalcService;
import kata.ex01.calc.CalcServiceFactory;
import kata.ex01.model.HighwayDrive;

import java.util.List;

/**
 * @author kawasima
 */
public class DiscountServiceImpl implements DiscountService {
    @Override
    public Long calc(HighwayDrive drive) {

        CalcServiceFactory factory = new CalcServiceFactory();

        List<CalcService> calcServiceList = factory.generateCalcList(drive);

        return calcServiceList.stream()
                .map(calcService -> calcService.calc(drive))
                .max(Long::compare).get();
    }
}
