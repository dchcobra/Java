package mockito.unittesting.unittesting.spike;

import java.util.List;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;


public class JSONPathTest {

	@Test
	public void learning() {
		String responseFromService = "[" + "[\r\n"
				+ "{\"id\":1000, \"name\":Pencil, \"quantity\":15},"
				+ "{\"id\":1001, \"name\":Pen, \"quantity\":5},"
				+ "{\"id\":1002, \"name\":Eracer, \"quantity\":10}"
				+ "]";
		
		DocumentContext context = JsonPath.parse(responseFromService);
		
		int length = context.read("$.length()");
		assertThat(length).isEqualTo(3);
		
		List<Integer> ids = context.read("$..id");
		
		assertThat(ids).containsExactly(1000,1001,1002);
		
		System.out.println(context.read("$.[1]").toString());
		System.out.println(context.read("$.[0:1]").toString());
		System.out.println(context.read("$.[?(@name=='Eraser')]").toString());

	}
}
