package pojo.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EditBody {

	private pojo.request.editFields editFields;

	private pojo.request.editUpdate editUpdate;

}
