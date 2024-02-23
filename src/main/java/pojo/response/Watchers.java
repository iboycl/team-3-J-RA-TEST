package pojo.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Watchers {

	private String accountId;

	private boolean active;

	private String displayName;

	private String self;

}
