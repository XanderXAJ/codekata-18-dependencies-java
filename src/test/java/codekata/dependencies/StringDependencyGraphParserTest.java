package codekata.dependencies;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class StringDependencyGraphParserTest {
	StringDependencyGraphParser parser = new StringDependencyGraphParser();

	@Test
	void parsesSingleLineGraphWithSingleDependency() {
		Map<String, Set<String>> expectedDependencyMap = new HashMap<>();
		expectedDependencyMap.put("A", Set.of("B"));
		DependencyGraph expected = new DependencyGraph(expectedDependencyMap);

		DependencyGraph actual = parser.parse("A B");

		assertThat(actual).isEqualTo(expected);
	}
}