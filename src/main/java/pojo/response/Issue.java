package pojo.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Issue {
    private String expand;
    private String id;
    private String self;
    private String key;
    private Fields fields;








}
