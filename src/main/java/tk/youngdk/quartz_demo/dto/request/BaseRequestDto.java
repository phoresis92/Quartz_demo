package tk.youngdk.quartz_demo.dto.request;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class BaseRequestDto {
    @NotEmpty
    private String companySeq;
    @NotEmpty
    private String hotelSeq;
}
