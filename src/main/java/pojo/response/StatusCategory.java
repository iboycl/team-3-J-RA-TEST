package pojo.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StatusCategory {
    private String self;
    private int id;
    private String key;
    private String colorName;
    private String name;

}
