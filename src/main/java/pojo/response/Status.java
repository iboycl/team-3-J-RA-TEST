package pojo.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Status {

	private String iconUrl;

	private String name;
	private String self;
	private String description;
	private String id;
	private StatusCategory statusCategory;

}
