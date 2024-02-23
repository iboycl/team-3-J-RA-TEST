package pojo.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Creator {
    private String self;
    private String accountId;
    private String emailAddress;
    private AvatarUrls avatarUrls;
    private String displayName;
    private boolean active;
    private String timeZone;
    private String accountType;

}
