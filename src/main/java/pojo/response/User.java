package pojo.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

	private String accountId;

	private String accountType;

	private boolean active;

	private AvatarUrls avatarUrls;

	private String displayName;

	private String key;

	private String name;

	private String self;

	private String locale;

	private String emailAddress;

	private String timeZone;

}
