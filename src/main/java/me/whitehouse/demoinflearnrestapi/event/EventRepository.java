package me.whitehouse.demoinflearnrestapi.event;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * packageName    : me.whitehouse.demoinflearnrestapi.event
 * fileName       : EventRepository
 * author         : jaeminlim
 * date           : 2022/10/03
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022/10/03        jaeminlim       최초 생성
 */
@Repository
public interface EventRepository extends JpaRepository<Event, Integer> {

}
