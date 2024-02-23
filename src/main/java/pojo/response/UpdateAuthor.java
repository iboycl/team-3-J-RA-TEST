package pojo.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateAuthor {

	private String accountId;

	private String displayName;

	private boolean active;

	private String self;

}
