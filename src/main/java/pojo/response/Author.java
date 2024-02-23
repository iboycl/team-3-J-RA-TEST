package pojo.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Author {

	private String accountId;

	private String accountType;

	private boolean active;

	private String displayName;

	private String key;

	private String name;

	private String self;

	private AvatarUrls avatarUrls;

}
