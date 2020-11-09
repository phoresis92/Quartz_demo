package tk.youngdk.quartz_demo.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
@AllArgsConstructor
public class BaseRequestDto {
    @NotEmpty
    private String companySeq;
    @NotEmpty
    private String hotelSeq;
}
