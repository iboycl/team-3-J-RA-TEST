package pojo.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Worklog {

	private  int maxResults;
	private  int startAt;
	private  int total;
	List<Worklog> worklogs;

}
