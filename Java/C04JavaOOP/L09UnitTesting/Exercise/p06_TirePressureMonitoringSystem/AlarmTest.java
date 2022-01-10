package L09UnitTesting.Exercise.p06_TirePressureMonitoringSystem;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.when;

public class AlarmTest {
    private static final double LOW_PRESSURE_VALUE = 12.0;
    private static final double HIGH_PRESSURE_VALUE = 50.0;
    private static final double NORMAL_PRESSURE_VALUE = 18.0;

    @Test
    public void testAlarmTurnsForLowPressure() {
        Sensor fakeSensorForLowPressure = Mockito.mock(Sensor.class);

        when(fakeSensorForLowPressure.popNextPressurePsiValue()).thenReturn(LOW_PRESSURE_VALUE);

        Alarm alarm = new Alarm(fakeSensorForLowPressure);

        alarm.check();

        Assert.assertTrue(alarm.getAlarmOn());
    }

    @Test
    public void testAlarmTurnsForHighPressure() {
        Sensor fakeSensorForLowPressure = Mockito.mock(Sensor.class);

        when(fakeSensorForLowPressure.popNextPressurePsiValue()).thenReturn(HIGH_PRESSURE_VALUE);

        Alarm alarm = new Alarm(fakeSensorForLowPressure);

        alarm.check();

        Assert.assertTrue(alarm.getAlarmOn());
    }

    @Test
    public void testAlarmIsOffForNormalPressure() {
        Sensor fakeSensorForLowPressure = Mockito.mock(Sensor.class);

        when(fakeSensorForLowPressure.popNextPressurePsiValue()).thenReturn(NORMAL_PRESSURE_VALUE);

        Alarm alarm = new Alarm(fakeSensorForLowPressure);

        alarm.check();

        Assert.assertFalse(alarm.getAlarmOn());
    }
}
