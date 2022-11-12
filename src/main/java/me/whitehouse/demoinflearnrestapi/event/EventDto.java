package me.whitehouse.demoinflearnrestapi.event;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;

/**
 * packageName    : me.whitehouse.demoinflearnrestapi.event
 * fileName       : EventDto
 * author         : jaeminlim
 * date           : 2022/10/05
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022/10/05        jaeminlim       최초 생성
 */
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class EventDto {
    @NotEmpty
    private String name;
    @NotEmpty
    private String description;
    @NotNull
    private LocalDateTime beginEnrollmentDateTime;
    @NotNull
    private LocalDateTime closeEnrollmentDateTime;
    @NotNull
    private LocalDateTime beginEventDateTime;
    @NotNull
    private LocalDateTime endEventDateTime;

    private String location; // (optional) 이게 없으면 온라인 모임
    @Min(0)
    private int basePrice; // (optional)
    @Min(0)
    private int maxPrice; // (optional)
    @Min(0)
    private int limitOfEnrollment;
}
