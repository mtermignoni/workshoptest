package workshop.api.model;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResponseJsonSuccess {
    private Boolean success;
    private String payload;
}
