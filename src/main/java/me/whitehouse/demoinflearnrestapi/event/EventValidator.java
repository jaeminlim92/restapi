package me.whitehouse.demoinflearnrestapi.event;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

import java.time.LocalDateTime;

/**
 * packageName    : me.whitehouse.demoinflearnrestapi.event
 * fileName       : EventValidator
 * author         : jaeminlim
 * date           : 2022/11/12
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022/11/12        jaeminlim       최초 생성
 */
@Component
public class EventValidator {

    public  void validate(EventDto eventDto, Errors errors){
        if (eventDto.getBasePrice() > eventDto.getMaxPrice() && eventDto.getMaxPrice() > 0) {
            errors.rejectValue("basePrice", "wrongValue", "basePrice is Wrong value");
            errors.rejectValue("maxPrice", "wrongValue", "basePrice is Wrong value");
        }

        LocalDateTime localEndDateTime = eventDto.getEndEventDateTime();
        if(localEndDateTime.isBefore(eventDto.getBeginEventDateTime())||
                localEndDateTime.isBefore(eventDto.getBeginEnrollmentDateTime())||
                localEndDateTime.isBefore(eventDto.getCloseEnrollmentDateTime())
        ){
            errors.rejectValue("endEventDateTime", "wrongValue", "endDateTime is Worng Value");
        }

    }

}
