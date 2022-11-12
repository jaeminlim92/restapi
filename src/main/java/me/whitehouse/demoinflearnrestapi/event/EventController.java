package me.whitehouse.demoinflearnrestapi.event;

import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.net.URI;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

/**
 * packageName    : me.whitehouse.demoinflearnrestapi.event
 * fileName       : EventController
 * author         : jaeminlim
 * date           : 2022/10/02
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022/10/02        jaeminlim       최초 생성
 */
@Controller
@RequestMapping(value = "/api/events")
@Slf4j
public class EventController {

    private final EventRepository eventRepository;

    private final ModelMapper modelMapper;

    private final EventValidator eventValidator;


    public EventController(EventRepository eventRepository, ModelMapper modelMapper, EventValidator eventValidator) {
        this.eventRepository = eventRepository;
        this.modelMapper = modelMapper;
        this.eventValidator = eventValidator;
    }


    @PostMapping
    public ResponseEntity createEvent(
            @RequestBody @Valid EventDto eventDto, Errors errors
    ) {
        if(errors.hasErrors()){
            return ResponseEntity.badRequest().build();
        }

        eventValidator.validate(eventDto, errors);
        if (errors.hasErrors()) {
            return ResponseEntity.badRequest().build();
        }

        Event event = modelMapper.map(eventDto, Event.class);
        Event newEvent = this.eventRepository.save(event);
        URI craetUri = linkTo(EventController.class).slash(newEvent.getId()).toUri();
        log.info("들어왔나요?");
        return ResponseEntity.created(craetUri).body(event);
    }

}
