package me.whitehouse.demoinflearnrestapi.event;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * packageName    : me.whitehouse.demoinflearnrestapi.event
 * fileName       : EventTest
 * author         : jaeminlim
 * date           : 2022/09/25
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022/09/25        jaeminlim       최초 생성
 */
public class EventTest {

    @Test
    public void builder(){
         Event event = Event.builder().build();
        assertThat(event).isNotNull();
    }

    @Test
    public void javaBean(){
        Event event = new Event();
        String name = "Spring";
        event.setName(name);

        assertThat(event.getName()).isEqualTo(name);

    }

}