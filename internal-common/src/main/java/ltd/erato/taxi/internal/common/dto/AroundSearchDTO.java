package ltd.erato.taxi.internal.common.dto;

import lombok.Data;

import java.util.List;

@Data
public class AroundSearchDTO {

    private Integer count;
    private List<AroundSearchTerminal> results;

    @Data
    public static class AroundSearchTerminal {
        private String tid;
        private String name;
        private String location;
    }
}
