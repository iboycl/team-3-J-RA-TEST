package pojo.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pojo.request.issue.Fields;

@Data
public class Issue {

	private Fields fields;

	public Issue() {
		this.fields = new Fields();
	}

}
