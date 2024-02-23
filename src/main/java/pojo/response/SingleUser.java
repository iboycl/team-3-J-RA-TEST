package pojo.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class SingleUser {

    private String accountId;

    private String accountType;

    private boolean active;

    private ApplicationRoles applicationRoles;

    private AvatarUrls avatarUrls;

    private String displayName;

    private String emailAddress;

    private Groups groups;

    private String key;

    private String name;

    private String self;

    private String timeZone;

    private String locale;

    private String expand;

}