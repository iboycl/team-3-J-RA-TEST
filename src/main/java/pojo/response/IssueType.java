package pojo.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class IssueType {
    private String self;
    private String id;
    private String description;
    private String iconUrl;
    private String name;
    private boolean subtask;
    private int avatarId;
    private String entityId;
    private int hierarchyLevel;

}
