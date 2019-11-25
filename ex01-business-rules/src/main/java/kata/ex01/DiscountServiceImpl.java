package kata.ex01;

import kata.ex01.model.HighwayDrive;

import java.util.Arrays;
import java.util.Collections;

/**
 * @author kawasima
 */
public class DiscountServiceImpl implements DiscountService {
    @Override
    public long calc(HighwayDrive drive) {

        long weekdayDiscount = calcWeekday(drive);

        long weekendDiscount = calcWeekend(drive);

        // 深夜割引
        long midnightDiscount = calcMidNight(drive);

        return Collections.max(Arrays.asList(weekdayDiscount, weekendDiscount, midnightDiscount));
    }

    private long calcWeekday(HighwayDrive drive) {
        if (drive.canApplyWeekdayDiscount()) {
            if (drive.isOverTenTimesDrive()) {
                return 50;
            }
            return 30;
        }
        return 0;
    }

    private long calcWeekend(HighwayDrive drive) {
        if (drive.canApplyHolidayDiscount()) {
            return 30;
        }
        return 0;
    }

    private long calcMidNight(HighwayDrive drive) {
        if (drive.canNotApplyMidnightDiscount()) {
            return 0;
        }
        return 30;
    }
}
