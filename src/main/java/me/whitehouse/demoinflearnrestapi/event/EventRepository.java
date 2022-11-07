package me.whitehouse.demoinflearnrestapi.event;

import org.springframework.data.jpa.repository.JpaRepository;
/**
 * packageName    : me.whitehouse.demoinflearnrestapi.event
 * fileName       : EventRepository
 * author         : jaeminlim
 * date           : 2022/10/30
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022/10/30        jaeminlim       최초 생성
 */
public interface EventRepository extends JpaRepository<Event, Integer> {
}
