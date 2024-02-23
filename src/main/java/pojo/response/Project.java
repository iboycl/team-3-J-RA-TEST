package pojo.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Project {

	private AvatarUrls avatarUrls;

	private String id;

	private String key;

	private String name;

	private String self;

	private String projectTypeKey;

	private boolean simplified;

}
