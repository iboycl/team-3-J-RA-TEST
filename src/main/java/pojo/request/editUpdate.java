package pojo.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class editUpdate {

	private List<Labels> labels;

	private List<EditSummary> editSummaries;

}
