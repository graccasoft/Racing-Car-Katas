package tddmicroexercises.tirepressuremonitoringsystem;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
public class AlarmTest {

    @Test
    public void foo() {
        
        Alarm alarm = new Alarm(null);
        assertFalse(alarm.isAlarmOn());
    }

    @Test
    public void alarmShouldTurnOnWhenLow(){
        Sensor sensor = mock(Sensor.class);
        when(sensor.popNextPressurePsiValue()).thenReturn(16.0);

        Alarm alarm = new Alarm(sensor);
        alarm.check();
        assertTrue( alarm.alarmOn );
    }

    @Test
    public void alarmShouldTurnOnWhenHigh(){
        Sensor sensor = mock(Sensor.class);
        when(sensor.popNextPressurePsiValue()).thenReturn(22.0);

        Alarm alarm = new Alarm(sensor);
        alarm.check();
        assertTrue( alarm.alarmOn );
    }

    @Test
    public void alarmShouldBeOffWhenInRange(){
        Sensor sensor = mock(Sensor.class);
        when(sensor.popNextPressurePsiValue()).thenReturn(20.0);

        Alarm alarm = new Alarm(sensor);
        alarm.check();
        assertFalse( alarm.alarmOn );
    }
}
