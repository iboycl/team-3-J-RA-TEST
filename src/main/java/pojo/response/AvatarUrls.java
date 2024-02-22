package pojo.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AvatarUrls {

	@JsonProperty("16x16")
	private String a1616;

	@JsonProperty("24x24")
	private String a2424;

	@JsonProperty("32x32")
	private String a3232;

	@JsonProperty("48x48")
	private String a4848;

}
