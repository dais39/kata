package kata.ex01.model;

import kata.ex01.util.HolidayUtils;

import java.io.Serializable;
import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.util.Arrays;

/**
 * @author kawasima
 */
public class HighwayDrive implements Serializable {
    private LocalDateTime enteredAt;
    private LocalDateTime exitedAt;
    private VehicleFamily vehicleFamily;
    private RouteType routeType;

    private Driver driver;

    public HighwayDrive() {
    }

    private LocalDateTime getEnteredAt() {
        return this.enteredAt;
    }

    private LocalDateTime getExitedAt() {
        return this.exitedAt;
    }

    private VehicleFamily getVehicleFamily() {
        return this.vehicleFamily;
    }

    private RouteType getRouteType() {
        return this.routeType;
    }

    private Driver getDriver() {
        return this.driver;
    }

    public void setEnteredAt(LocalDateTime enteredAt) {
        this.enteredAt = enteredAt;
    }

    public void setExitedAt(LocalDateTime exitedAt) {
        this.exitedAt = exitedAt;
    }

    public void setVehicleFamily(VehicleFamily vehicleFamily) {
        this.vehicleFamily = vehicleFamily;
    }

    public void setRouteType(RouteType routeType) {
        this.routeType = routeType;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public boolean canApplyWeekdayDiscount() {
        return isWeekday(this.enteredAt)
                && isWeekday(this.exitedAt)
                && !HolidayUtils.isHoliday(this.enteredAt.toLocalDate())
                && !HolidayUtils.isHoliday(this.exitedAt.toLocalDate())
                && this.routeType.equals(RouteType.RURAL)
                && ((isRange(this.enteredAt.getHour(), 6, 9) || isRange(this.exitedAt.getHour(), 6, 9))
                || (isRange(this.enteredAt.getHour(), 17, 20) || isRange(this.exitedAt.getHour(), 17, 20)));

    }

    public Boolean canApplyHolidayDiscount() {
        return Arrays.asList(VehicleFamily.STANDARD, VehicleFamily.MOTORCYCLE, VehicleFamily.MINI).contains(this.vehicleFamily)
                && this.routeType.equals(RouteType.RURAL)
                && (isWeekend(this.enteredAt) || isWeekend(this.exitedAt) ||
                HolidayUtils.isHoliday(this.enteredAt.toLocalDate()) ||
                HolidayUtils.isHoliday(this.exitedAt.toLocalDate()));

    }

    public Boolean canNotApplyMidnightDiscount() {
        return this.enteredAt.getHour() > 4 && this.exitedAt.getHour() > this.enteredAt.getHour();
    }

    public Boolean isOverTenTimesDrive() {
        return this.driver.getCountPerMonth() >= 10;
    }

    private Boolean isWeekend(LocalDateTime at) {
        return Arrays.asList(DayOfWeek.SATURDAY, DayOfWeek.SUNDAY).contains(at.getDayOfWeek());
    }

    private Boolean isWeekday(LocalDateTime at) {
        return !isWeekend(at);
    }

    private Boolean isRange(long at, long from, long to) {
        return at >= from && at <= to;
    }

    public String toString() {
        return "HighwayDrive(enteredAt=" + this.getEnteredAt() + ", exitedAt=" + this.getExitedAt() + ", vehicleFamily=" + this.getVehicleFamily() + ", routeType=" + this.getRouteType() + ", driver=" + this.getDriver() + ")";
    }
}
