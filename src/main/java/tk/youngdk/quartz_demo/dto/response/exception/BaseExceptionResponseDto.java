package tk.youngdk.quartz_demo.dto.response.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import tk.youngdk.quartz_demo.dto.response.BaseResponseDto;

@Data
public class BaseExceptionResponseDto extends BaseResponseDto {
    public BaseExceptionResponseDto() {
        setResult(false);
    }

    private String message;
}
